package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.HalalPairing;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class selectProfile implements Initializable{
	 @FXML
	    private ImageView pic1;

	    @FXML
	    private ImageView pic2;

	    @FXML
	    private ImageView pic3;

	    @FXML
	    private ImageView pic4;

	    @FXML
	    void saveProfile1(ActionEvent event) {
	    	if(HalalPairing.getCurrentUser().getGender() == 'm')
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man1.png");
	    	else
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman1.png");
	    	Main m = new Main();
			try {
				m.changeScene("MainPage.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    @FXML
	    void saveProfile2(ActionEvent event) {
	    	if(HalalPairing.getCurrentUser().getGender() == 'm')
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man2.png");
	    	else
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman2.png");
	    	Main m = new Main();
			try {
				m.changeScene("MainPage.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void saveProfile3(ActionEvent event) {
	    	if(HalalPairing.getCurrentUser().getGender() == 'm')
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man3.png");
	    	else
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman3.png");
	    	Main m = new Main();
			try {
				m.changeScene("MainPage.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void saveProfile4(ActionEvent event) {
	    	if(HalalPairing.getCurrentUser().getGender() == 'm')
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man4.png");
	    	else
	    		HalalPairing.getCurrentUser().setProfilePictureName("C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman4.png");
	    	Main m = new Main();
			try {
				m.changeScene("MainPage.fxml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    
	    @FXML
	    void userLogOut(ActionEvent event) throws IOException{
	    	Main m = new Main();
			m.changeScene("Login.fxml");
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			try {
				if(HalalPairing.getCurrentUser().getGender() == 'm')
				{
				
					String s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man1.png";
					Image pic = new Image(new FileInputStream(s));
					
					this.pic1.setImage(pic);
					s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man2.png";
					pic = new Image(new FileInputStream(s));
					this.pic2.setImage(pic);
					s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man3.png";
					pic = new Image(new FileInputStream(s));
					this.pic3.setImage(pic);
					s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\man4.png";
					pic = new Image(new FileInputStream(s));
					this.pic4.setImage(pic);
					
				}
				else
				{
					String s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman1.png";
					Image pic = new Image(new FileInputStream(s));
					this.pic1.setImage(pic);
					s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman2.png";
					pic = new Image(new FileInputStream(s));
					this.pic2.setImage(pic);
					s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman3.png";
					pic = new Image(new FileInputStream(s));
					this.pic3.setImage(pic);
					s = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\woman4.png";
					pic = new Image(new FileInputStream(s));
					this.pic4.setImage(pic);
				}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			
		}
	    
}
