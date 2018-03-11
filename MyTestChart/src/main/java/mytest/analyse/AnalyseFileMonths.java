package mytest.analyse;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnalyseFileMonths {

	String currentMonth="A";
	String currentYear="A";
	String valueString;
	String alldatefile;
	
	File alldate= null;

    String[] lineStringPart = new String[3];
	double middleValue;
	

    ArrayList<String> dataList = new ArrayList<String>();
    ArrayList<String> monthYearValueList = new ArrayList<String>();
    
    public AnalyseFileMonths(){
    	alldatefile="Standart//user_1//pt0001_standart.pgr";
    }
    
    public AnalyseFileMonths(String fileName){
    	alldatefile="Standart//user_1//" + fileName;
    }
    
//   ���������� ������ 
    public ArrayList<String> findValuesPerMohth() throws IOException{
    	monthYearValueList=findValuePerOneMohth(alldatefile); 

    	return monthYearValueList;
    }
    
//  ���������� �������� �� ������     
    public ArrayList<String> findValuePerOneMohth(String faleName) 
        throws IOException{
    	alldate= new File(faleName);
    	String[] dataDayMonthYearPart = new String[3];
    	
// delete first line
	    Scanner FileReader = new Scanner( alldate);
	    String FirstLineSring=FileReader.nextLine();

	        
		while ( FileReader.hasNext()){
// find  year and month  in a line dd.mm.yyyy
		    String lineSring=FileReader.nextLine();

		    lineStringPart = lineSring.split("[,]");
		    String dataDayMonthYear = lineStringPart[0];
		    dataDayMonthYearPart = dataDayMonthYear.split("[.]");
		    out.println("YEAR"+ dataDayMonthYearPart[2] +"month" + dataDayMonthYearPart[1]);
		    
		    if( dataDayMonthYearPart[2].equals(currentYear)&&dataDayMonthYearPart[1].equals(currentMonth)){
		    	valueString = lineStringPart[2];
		    	dataList.add(valueString);
		    	out.println("DATALIST"+ dataList.get((dataList.size()-1)));
		    }  else {

				if(!currentYear.equals("A")){
					middleValue = calculateMiddleValue(dataList);
					monthYearValueList.add(currentYear+","+currentMonth+","+middleValue);
					out.println("_MIDDLE_"+ middleValue);
					while ( 0!=dataList.size()){
						dataList.remove(0);
					}
				}
				currentYear = dataDayMonthYearPart[2];
				currentMonth = dataDayMonthYearPart[1];
				
		    }

		}
		

		FileReader.close();	
		
		middleValue = 0;
		middleValue = calculateMiddleValue(dataList);
		out.println("MIDDLE end"+ middleValue);
		monthYearValueList.add(currentYear+","+currentMonth+","+middleValue);
		for( String s:monthYearValueList){
			out.println("ENDSUM"+ s);
		}

		return monthYearValueList;
	}
    
    private double calculateMiddleValue(ArrayList<String> dataListLocal ){
    	double localMiddleValue=0;
    	int sumTime=0;
		int n=1;
		for (int i=0; i<dataListLocal.size();i++){
			sumTime=sumTime+Integer.parseInt(dataListLocal.get(i));
			out.println("SUM"+ sumTime+" N-"+n);
			n++ ;		
			}
		if((n-1)!=0){
			localMiddleValue = sumTime/(n-1);
			}	
		out.println("MIDDLE local"+ localMiddleValue);		
    	
    	return localMiddleValue;
    }
}
