package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowProfileController implements Initializable{

    @FXML
    private Label ProfileName;

    @FXML
    private Label age;

    @FXML
    private ImageView imgProfile;
    
    public void setData(User a) {

        ProfileName.setText(a.getName());

        try {
            if (a.getProfilePictureName() != null) {
                Image profileImage = new Image(new FileInputStream(a.getProfilePictureName()));
                imgProfile.setImage(profileImage);
            } else {
                imgProfile.setVisible(false);
                imgProfile.setManaged(false);
            }
            age.setText(String.valueOf(a.getAge()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//setData(getAccount());
		
	}
    
}
