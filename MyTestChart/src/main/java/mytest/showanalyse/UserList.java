package mytest.showanalyse;

import java.io.File;

public class UserList {
	
	public String[]  getUserList(){
		
		String[] userList = {"1","2"};
		File  fileOne = new File("user_1");
		if (fileOne.exists()){
			userList[0]= "user_1";
		}
		return userList;
	}

}
