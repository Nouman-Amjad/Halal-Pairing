package businessLogic;

import java.util.HashMap;

import database.ComplainDBhandler;
import database.UserDBhandler;

public class Complain
{
	private String CNIC;
	private int warningCount;
	HashMap<String, String> complains;
	
	public Complain(String cnic)
	{
		this.CNIC = cnic;
		warningCount = 0;  // TO be read from DB
		complains = ComplainDBhandler.getComplaintsByCNIC(cnic);
	}
	
	public void addComplain(String complain, String giverCNIC)
	{
		complains.put(giverCNIC, complain);
		warningCount++;
		
		ComplainDBhandler.addComplaint(this.CNIC, giverCNIC, complain);
	}
	
	public int getWarningCount()
	{
		return warningCount;
	}
	
	public void addWarningCount()
	{
		this.warningCount++;
		UserDBhandler.addWarningCount(CNIC);
	}
	
	public void setWarningCount(int count)
	{
		this.warningCount = count;
	}
}
