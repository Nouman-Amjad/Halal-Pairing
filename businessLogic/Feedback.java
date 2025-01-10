package businessLogic;

import java.util.HashMap;

import database.FeedbackDBhandler;

public class Feedback 
{
	private String CNIC;
    private HashMap<String, String> feedbacks;

    // Constructor
    public Feedback(String cnic) 
    {
    	this.CNIC = cnic;
        this.feedbacks = FeedbackDBhandler.getReviewsByCNIC(cnic);
    }

    // Add a review to the feedbackMap
    public void addReview(String giverName, String review) 
    {
        feedbacks.put(giverName, review);
        FeedbackDBhandler.addReview(this.CNIC, giverName, review);
    }

    // Get a review based on giverName
    public HashMap<String, String> getReviews() 
    {
        return feedbacks;
    }
}

