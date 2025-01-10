package businessLogic;

import java.util.LinkedList;

public class NADRA
{
	private LinkedList<String> CNIC_database;
	
	public NADRA()
	{
		CNIC_database = new LinkedList<String>();
	}
	
	public boolean verifyUser()
	{
		// To be verified using a NADRA Verification API
		return true;
	}
}
