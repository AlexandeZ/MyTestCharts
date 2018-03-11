package mytest.showanalyse;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;

import mytest.analyse.AnalyseFileMonths;



public class CreateListForChartPt0001MonthCommand implements Command{
	
	String fileName = "pt0001_standart.pgr";
	
	private int[] valueX;
	private int[] valueY;

	@Override
	public void execute() {
		fillDataForMonthGraphic();
		
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	private void  fillDataForMonthGraphic(){
		

		ArrayList<String> nameXAxie = new ArrayList<>();
		
	    ArrayList<String> monthYearValueList = new ArrayList<String>();
	
		AnalyseFileMonths analyseFileMonths = new AnalyseFileMonths(fileName);
		try {
			monthYearValueList =analyseFileMonths.findValuesPerMohth() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	      int[] dy = new int[monthYearValueList.size() ];
	      int[] dx = new int[dy.length];
	      
		
		  int i=0;	
		
		for( String s:monthYearValueList){
		    String[] sPart =new  String[3];
		    sPart= s.split(",");
		  	nameXAxie.add(sPart[1]);
		  	
		  double  dtime = (Double.parseDouble(sPart[2]))/1000;
		  int time = (int) dtime;
		  	out.println(" int time "+i+"=" + time+ "month"+nameXAxie.get(i));
		    dy[i]= time;
		    dx[i] = i;
		    i++;
		}
		
		valueX = dx;
		valueY = dy;		

	}
	
	public int[] getValueX(){
		return valueX;
	}
	
	public int[] getValueY(){
		return valueY;
	}
}
