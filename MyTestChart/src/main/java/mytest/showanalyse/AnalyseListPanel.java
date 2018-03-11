package mytest.showanalyse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mytest.analyse.*;
import mytest.chartbuilder.*;


public class AnalyseListPanel extends JPanel{
	
	private JButton  buttonEng= new JButton("Tect Струпа");
	
	public AnalyseListPanel(){
		add(buttonEng);
		buttonEng.addActionListener(new addButtonEngListener());
	}

	  class addButtonEngListener implements ActionListener
	    {
	        public void actionPerformed(ActionEvent a) 
	        {
	        	ToPt001Standart toPt001Standart = new ToPt001Standart();

		      CreateListForChartPt0001MonthCommand createListForChartPt0001MonthCommand = new CreateListForChartPt0001MonthCommand();
		      createListForChartPt0001MonthCommand.execute();
		      int [] dxA = createListForChartPt0001MonthCommand.getValueX();
		      int[] dyA = createListForChartPt0001MonthCommand.getValueY();
		      
	            SwingUtilities.invokeLater(() -> {
	                LineChartEx ex = new LineChartEx("Зависимость времени выполнения теста от срока испытания","месяц","время теста, сек",dxA,dyA);
	                ex.setVisible(true);
	            });	
	        	
	        }
	    }
	
	
	public void paint (Graphics g){

		super.paint(g);
		g.setColor(Color.blue);
		g.fillRect(0, 0, this.getWidth(),this.getHeight());
		
		
		
		g.setColor(Color.green);
		g.fillOval(5, 5, 20, 20);
		g.drawString("Методы анализа", 50, 50);
	}
	
}
