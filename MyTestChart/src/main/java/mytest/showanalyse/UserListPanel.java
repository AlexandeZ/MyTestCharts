package mytest.showanalyse;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UserListPanel extends JPanel{
	
	JTextArea textArea = new JTextArea(100,100);
	static private  UserList userList;
	static private String stringUserList = "***";
	public 	UserListPanel(){
	
	
	}
	
	public void run(){
		UserListPanel  panel =new UserListPanel();
		panel.add(textArea);
		textArea.setText("Hello");
		userList = new UserList();
		String[] s = userList.getUserList();
		stringUserList = s[0];
				
	}
	
	public void paint (Graphics g){

		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		
		
		
		g.setColor(Color.red);
		g.fillOval(5, 5, 20, 20);
		g.drawString(stringUserList, 50, 50);
	}
	

}
