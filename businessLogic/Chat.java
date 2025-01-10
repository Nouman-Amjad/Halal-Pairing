package businessLogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Chat 
{
    private User user1;
    private User user2;
    private String basePath = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\chats\\";
    private static Integer chatNumber = 1;
    private String filePath;

    LinkedList<Message> chats;
    
    public User getUser1()
    {
    	return user1;
    }
    public User getUser2()
    {
    	return user2;
    }
    public Chat(User user1, User user2) 
    {
        this.user1 = user1;
        this.user2 = user2;

        if (user1.getChatNumber(user2.getCNIC()) == 0) 
        {
            String fileName = chatNumber.toString() + ".txt";
            filePath = basePath + fileName;

            try 
            {
                // Create the file
                Path path = Path.of(filePath);
                Files.write(path, new byte[0], StandardOpenOption.CREATE);

                System.out.println("New chat file created at: " + path.toAbsolutePath());

                user1.addChat(user2.getCNIC(), chatNumber);
                user2.addChat(user1.getCNIC(), chatNumber);

                chatNumber++;
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        } 
        else 
        {
            // Open existing chat file
            String fileName = user1.getChatNumber(user2.getCNIC()) + ".txt";
            filePath = basePath + fileName;
        }
    }

    public void user1SendsMessage(String content) 
    {
        sendMessage(user1, user2, content);
    }

    public void user2SendsMessage(String content) 
    {
        sendMessage(user2, user1, content);
    }

    private void sendMessage(User sender, User receiver, String content) 
    {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath), StandardOpenOption.APPEND)) 
        {
            // Format the current date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy, h:mm a");
            String formattedDate = dateFormat.format(new Date());

            // Write the message to the file
            String message = String.format("%s - %s: %s%n", formattedDate, sender.getName(), content);
            writer.write(message);

            // Update the in-memory chat
            if (chats == null) 
            {
                chats = new LinkedList<>();
            }
            chats.add(new Message(sender.getName(), receiver.getName(), content, formattedDate));

            //System.out.println(sender.getName() + " sent a message: " + content);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public LinkedList<Message> getChatHistory() 
    {
        LinkedList<Message> chatHistory = new LinkedList<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                // Assuming each line follows the format: "30/11/23, 9:29 am - Sender Name: Message content"
                String[] parts = line.split(" - ", 2);
                String[] senderInfo = parts[1].split(": ", 2);

                String senderName = senderInfo[0];
                String receiverName = senderName.equals(user1.getName()) ? user2.getName() : user1.getName();

                Message message = new Message(senderName, receiverName, senderInfo[1], parts[0]);
                chatHistory.add(message);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        return chatHistory;
    }
}

