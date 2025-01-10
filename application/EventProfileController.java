package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.HalalEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class EventProfileController implements Initializable{

    @FXML
    private Label EventName;

    @FXML
    private Text desp;
    
    public void setData(HalalEvent a) {

    	EventName.setText(a.getTitle());
    	desp.setText(a.getDescription());
    }
    public Event getEvent()
    {
    	Event a = new Event();
    	a.Title = "I am Nouman";
    	a.Description = "I am Nouman";
    	
    	return a;
    }
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		//setData(getEvent());
		
	}
}
