package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class RequestController implements Initializable {
    @FXML
    private VBox postContainer;
    
    List<Account> account;

    public List<Account> getAccount() {
        List<Account> list = new ArrayList<>();

        
        for (int i = 0; i < 0; i++) {
            
            Account a = new Account();
            a.name = "Nouman Amjad";
            a.profileImg = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\Nomi.png";
            a.age = "24 years";
            list.add(a);
        }
        return list;
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	account = getAccount();
        try {
           for (Account a : account) {
                FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("showProfile.fxml"));
                AnchorPane anchorPane= fxmlloader.load();
                ShowProfileController postController = fxmlloader.getController();
                //postController.setData();
                
                postContainer.getChildren().add(anchorPane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    @FXML
	private void userSignUp(ActionEvent event) throws IOException
	{
		System.out.print("Hello");
		Main m = new Main();
		m.changeScene("createAcc.fxml");
	}
	@FXML
	private void userLogOut(ActionEvent event) throws IOException
	{
		System.out.print("Hello");
		Main m = new Main();
		m.changeScene("Login.fxml");
	}
	@FXML
	private void home(ActionEvent event) throws IOException
	{
		System.out.print("FindPartner");
		Main m = new Main();
		m.changeScene("MainPage.fxml");
	}
	@FXML
	private void findPartner(ActionEvent event) throws IOException
	{
		System.out.print("FindPartner");
		Main m = new Main();
		m.changeScene("Find.fxml");
	}
	@FXML
	private void Request(ActionEvent event) throws IOException
	{
		System.out.print("FindPartner");
		Main m = new Main();
		m.changeScene("Request.fxml");
	}
	@FXML
	private void halalEvent(ActionEvent event) throws IOException
	{
		System.out.print("HalalEvents");
		Main m = new Main();
		m.changeScene("HalalEvents.fxml");
	}
	@FXML
	private void inviteFriend(ActionEvent event) throws IOException
	{
		System.out.print("inviteFriend");
		Main m = new Main();
		m.changeScene("InviteFriend.fxml");
	}
	@FXML
	private void Membership(ActionEvent event) throws IOException
	{
		System.out.print("Membership");
		Main m = new Main();
		m.changeScene("Membership.fxml");
	}
	@FXML
	private void Messages(ActionEvent event) throws IOException
	{
		System.out.print("Messages");
		Main m = new Main();
		m.changeScene("Messages.fxml");
	}
	@FXML
	private void updateProfile(ActionEvent event) throws IOException
	{
		System.out.print("updateProfile");
		Main m = new Main();
		m.changeScene("UpdateProfile.fxml");
	}
	@FXML
	private void editInterests(ActionEvent event) throws IOException
	{
		System.out.print("updateProfile");
		Main m = new Main();
		m.changeScene("EditInterests.fxml");
	}
}
