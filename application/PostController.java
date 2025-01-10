package application;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import businessLogic.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class PostController implements Initializable {
	 	@FXML
	    private Label ProfileName;

	    @FXML
	    private Label caption;

	    @FXML
	    private Label date;

	    @FXML
	    private ImageView image;

	    @FXML
	    private ImageView imgHaha;

	    @FXML
	    private ImageView imgLike;

	    @FXML
	    private ImageView imgLove;

	    @FXML
	    private ImageView imgProfile;

	    @FXML
	    private ImageView imgSad;

	    @FXML
	    private ImageView imgWow;

	    @FXML
	    private HBox likecontainer;

	    @FXML
	    private Label noreactions;

	    @FXML
	    private HBox reactioncontainer;
	    @FXML
	    private long startTime;
	    @FXML
	    private ImageView imgReaction;
	    @FXML
	    private Label reactionName;
	    @FXML
	    private reactions curReaction = reactions.NON;
	    @FXML
	    private Post post;
	    @FXML
	    public void onLikeContainerPressed(MouseEvent me) 
	    {
	    	startTime = System.currentTimeMillis();
	    }
	    
	    @FXML
	    public void onLikeContainerReleased(MouseEvent me)
	    {
	    	if(System.currentTimeMillis() - startTime > 500 )
	    		reactioncontainer.setVisible(true);
	    	else
	    	{
	    		if(reactioncontainer.isVisible())
	    			reactioncontainer.setVisible(false);
	    		if(curReaction == reactions.NON)
	    			setReaction(reactions.LIKE);
	    		else
	    			setReaction(reactions.NON);
	    	}
	    }
	    
	    @FXML
	    public void setReaction(reactions me)
	    {
	    	reactioncontainer.setVisible(false);
	    	Image img;
			try {
				img = new Image(new FileInputStream(me.imgSrc));
				imgReaction.setImage(img);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		    
		    reactionName.setText(me.name);
		    if(me == reactions.NON)
		    	reactionName.setTextFill(Color.web("#000000"));
		    else if(me.name == "Love" || me.name == "Like")
		    	reactionName.setTextFill(Color.web("#E12C4A"));
		    else
		    	reactionName.setTextFill(Color.web("#EAA823"));
		    
		    if(curReaction == reactions.NON)
		    	post.totalReactions = post.totalReactions + 1;
		    
		    curReaction = me;
		    
		    if(curReaction == reactions.NON)
		    	post.totalReactions = post.totalReactions - 1;
		    
		    noreactions.setText(String.valueOf(post.totalReactions));
	    }
	    @FXML
	    public void onReactionImagePressed(MouseEvent me)
	    {
	    	switch(((ImageView) me.getSource()).getId())
	    	{
	    	case "imgLove":
	    		setReaction(reactions.LOVE);
	    		break;
	    	case "imgHaha":
	    		setReaction(reactions.HAHA);
	    		break;
	    	case "imgLike":
	    		setReaction(reactions.LIKE);
	    		break;
	    	case "imgSad":
	    		setReaction(reactions.SAD);
	    		break;
	    	case "imgWow":
	    		setReaction(reactions.WOW);
	    		break;
	    	default:
	    		setReaction(reactions.NON);
	    		break;
	    	}
	    }
	    
	    @FXML
	    public void setData(Content p) {
	    	
	        User u = HalalPairing.getUser(p.getCNIC());
	        
	        ProfileName.setText(u.getName());
	        date.setText(p.getUploadDateAsString());

	        try {
	            if (u.getProfilePictureName() != null) {
	            	//System.out.print(u.getProfilePictureName());
	                Image profileImage = new Image(new FileInputStream(u.getProfilePictureName()));
	                imgProfile.setImage(profileImage);
	            } else {
	                imgProfile.setVisible(false);
	                imgProfile.setManaged(false);
	            }

	            if (p.getText() != null) {
	                caption.setText(p.getText());
	            } else {
	                caption.setVisible(false);
	                caption.setManaged(false);
	            }

	            if (p.getPicturePath() != null ) {
	            	//System.out.print(p.getPicturePath());
	                Image postImage = new Image(new FileInputStream(p.getPicturePath()));
	                image.setImage(postImage);
	            } else {
	                image.setVisible(false);
	                image.setManaged(false);
	            }
	            Random rand = new Random();
	            int n = rand.nextInt(1000);
	            noreactions.setText(String.valueOf(n));
	            curReaction = reactions.NON;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    @FXML
	    public Post getPost()
	    {
	    	Post post = new Post();
	    	Account a = new Account();
	    	a.name = "Nouman Amjad";
	    	a.profileImg = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\Nomi.png";
	    	post.account = a;
	    	post.date = "1st Dec 2023";
	    	post.caption = "Moye Moye";
	    	post.image = "C:\\Users\\Nomi\\eclipse-workspace\\javafxproj\\src\\application\\images\\Nomi.png";
	    	post.totalReactions = 101;
	    	return post;
	    }
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
		}
		
		
}
