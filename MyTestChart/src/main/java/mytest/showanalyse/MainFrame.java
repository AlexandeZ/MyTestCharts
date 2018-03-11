package mytest.showanalyse;

import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;



public class MainFrame extends JFrame{
	
	static private UserListPanel userListPanel;
	static private AnalyseListPanel analyseListPanel; 
	
	 public void  runPgrafMain ()
	    {
	    	EventQueue.invokeLater(new Runnable(){
	    		public void run(){
	    			
	    			MainFrame frame = new MainFrame();
	    	        frame.setTitle("MyTestAnalyse");
	    	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	        	
	    	        createPanelUI(frame.getContentPane()); 

	    	        
	    	        frame.setBounds(200, 200, 780, 500);
	    	        frame.setVisible(true);
	    		
	
	    	        
//	    	        frame.getContentPane().add(BorderLayout.CENTER,userListPanel);
//	    	        frame.getContentPane().add(BorderLayout.EAST,analyseListPanel);
	    	        
	    		}
	    		
	    		
	    	});
	    	
	    	

	 
	    }

	 public static void createPanelUI (Container container){ 
		 
		 container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); 
		 
	        container.setLayout(new GridBagLayout()); 
	        GridBagConstraints constraints = new GridBagConstraints(); 
	         
	        // По умолчанию натуральная высота, максимальная ширина 
	        constraints.fill = GridBagConstraints.HORIZONTAL; 
	        constraints.ipady     = 345; 
	        constraints.weightx = 3;
//	        constraints.gridwidth = 3; 
	        constraints.gridy   = 0  ;  // нулевая ячейка таблицы по вертикали   
	        userListPanel = new UserListPanel();
	        userListPanel.run();
	        constraints.fill = GridBagConstraints.HORIZONTAL; 
	        constraints.gridx = 1;      // первая ячейка таблицы по горизонтали
	        container.add(userListPanel,constraints);
	        
	        analyseListPanel = new AnalyseListPanel();
	        constraints.fill = GridBagConstraints.HORIZONTAL; 
	        constraints.gridx = 0;      // нулевая ячейка таблицы по горизонтали
	        container.add(analyseListPanel,constraints);
		 
	    }
	 
	 
}
