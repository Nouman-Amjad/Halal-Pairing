package businessLogic;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import database.ContentDBhandler;
import database.CredentialsDBhandler;
import database.HalalEventDBhandler;
import database.PaymentDBhandler;
import javafx.util.Pair;

public class HalalPairing
{
	private static UserList users;
	private static LinkedList<HalalEvent> events;
	private static Admin admin;
	private static User currentUser;
	private static Credentials credentials;
	private static LinkedList<Content> posts;
	private static User currentOpenChat;
	
	  public HalalPairing() 
	  { 
		  users = new UserList(); events = new
		  LinkedList<HalalEvent>(); admin = new Admin(); 
		  setCurrentUser(null);
		  credentials = new Credentials();   
	  }
	 
	
	public static void Initialize()
	{
		users = new UserList();
		events = new LinkedList<HalalEvent>();
		admin = new Admin();
		setCurrentUser(null);
		credentials = new Credentials();
		posts = ContentDBhandler.getAllContent();
	}
	
	public static boolean addUser(User user)
	{
		if(users.addUser(user))
		{
			HalalPairing.LogIN(user.getCNIC());
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	
	public static boolean upgradeUserToPremium(String userCNIC)
	{
		return users.upgradeUserToPremium(userCNIC);
	}
	
	public static void restrictUser(String userCNIC)
	{
		users.restrictUser(userCNIC);
	}
	public static User getUser(String CNIC)
	{
		return users.getUser(CNIC);
	}
	public static boolean isUserRestricted(String userCNIC)
	{
		return users.isUserRestricted(userCNIC);
	}
	
	public static void addComplainToUser(String userCNIC, String complaineeCNIC, String complain)
	{
		users.addComplainToUser(userCNIC, complaineeCNIC, complain);
	}
	
	public static boolean addCredentials(String CNIC, String password)
    {
        if(credentials.addCredentials(CNIC, password))
        {
        	CredentialsDBhandler.addCredentials(CNIC, password);
        	return true;
        }
        
        return false;
    }
	
	public static int getUserWarningCount(String userCNIC)
	{
		return users.getUserWarningCount(userCNIC);
	}
	
	public static void addUserWarning(String userCNIC)
	{
		users.addUserWarning(userCNIC);
	}
	
	public static void addUserReview(String userCNIC, String giverName, String review)
	{
		users.addUserReview(userCNIC, giverName, review);
	}
	
	public static HashMap<String, String> getUserReviews(String userCNIC)
	{
		return users.getUserReviews(userCNIC);
	}
	
	public static void addUserInterest(String userCNIC, String interest)
	{
		users.addUserInterest(userCNIC, interest);
	}
	public static void changePassword(String CNIC, String password)
	{
		credentials.changePassword(CNIC, password);
	}
	public static void addPayment(String cnic, Payment payment)
	{
		PaymentDBhandler.addPayment(cnic, payment);
	}
	public static void removeUserInterest(String userCNIC, String interest)
	{
		users.removeUserInterest(userCNIC, interest);
	}
	public static Set<String> getAllInterests(String CNIC)
    {
    	return users.getUser(CNIC).getAllInterests();
    }
	public static void addUserMatch(String userCNIC, String partnerCNIC, double similarityIndex)
	{
		users.addUserMatch(userCNIC, partnerCNIC, similarityIndex);
	}
	public static void deleteUser()
    {
    	users.removeUser(currentUser.getCNIC());
    	credentials.removeCredentials(currentUser.getCNIC());
    	currentUser = null;
    }
	public static HashMap<String, Double> getAllMatches(String userCNIC)
	{
		return users.getAllMatches(userCNIC);
	}
	
	public static void findMatch(String CNIC)
	{
		HalalPairing.users.findAndStoreMatches(CNIC);
	}
	
	
	public static void createEvent(String Title, String description, char gender, String venue, Date eventDate, int capacity, User organizer) 
    {
        HalalEvent event = new HalalEvent(Title, description, gender, venue, eventDate, capacity, organizer);
        events.add(event);
    }

    
    public static LinkedList<Pair<String, String>> getComplainsToReview()
    {
        return admin.getComplainsToReview();
    }
    
    public static LinkedList<HalalEvent> getAllMaleEvents()
    {
    	return HalalEventDBhandler.getAllMaleEvents();
    }
    
    public static LinkedList<HalalEvent> getAllFemaleEvents()
    {
    	return HalalEventDBhandler.getAllFemaleEvents();
    }

    public static void reviewComplaint(String CNIC, boolean isValid)
    {
        admin.reviewComplaint(CNIC, isValid, users.getUsers());
    }
    
  

    public static boolean checkCNIC(String CNIC)
    {
        return credentials.checkCNIC(CNIC);
    }

    public static boolean verifyPassword(String CNIC, String password)
    {
        return credentials.verifyPassword(CNIC, password);
    }
    
    public static void LogIN(String CNIC)
    {
    	setCurrentUser(users.getUser(CNIC));
    }

	public static User getCurrentChat()
	{
		return currentOpenChat;
	}
	public static User getCurrentUser()
	{
		return currentUser;
	}

	public static void setCurrentUser(User currentUser)
	{
		HalalPairing.currentUser = currentUser;
	}
	
	public static void addPost(Content C)
	{
		posts.add(C);
		ContentDBhandler.addContent(C);
	}
	
	public static void setCurrentChat(User U)
	{
		currentOpenChat = U;
	}
	
	public static void closeChat() 
	{
		currentOpenChat = null;
	}
	public static LinkedList<Content> getAllPosts()
	{
		return posts;
	}
	public static void addPayment(String cnic, double amount, String method, Date date)
	{
		if(method.equals("Credit Card"))
		{
			Payment P = new CreditCard(amount, date);
			PaymentDBhandler.addPayment(cnic, P);
		}
		else 
		{
			Payment P = new MicroFinance(amount, date);
			PaymentDBhandler.addPayment(cnic, P);
		}
	}
}
