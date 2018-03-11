package mytest.analyse;

import java.util.ArrayList;

public class ToPt001Standart extends ToStandartFileConverting{

	String dirName = "user_1";
	String fileName = "pt0001.pgr";
	
	public ToPt001Standart(){	
	}
	
	public void setUserDir(String dirName){
		this.dirName = dirName;
	}
	
	public void createStandartPt001() {
		try {
			ArrayList <String> standartList = createStandartList (createListFromFile(dirName,fileName));
			createStandartFile(dirName,fileName,standartList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList <String> createStandartList (ArrayList<String>  linesList){
		ArrayList <String> standartList = new ArrayList <String>();
		
		standartList.add(linesList.get(0));
		
		for (int i=1;i<linesList.size(); i++){
			 String lineSring= linesList.get(i);
			    if (checkString(lineSring)) {
	    	
			    	String [] lineStringPart = lineSring.split("[,]");
			    
			    	String[] timeSringPart =lineStringPart[2].split("#");
			    	
			    	standartList.add(lineStringPart[0]+","+lineStringPart[1]+","+ timeSringPart[48]);
			    }
		}
		
		return standartList;
	}

	public static boolean checkString(String string){
		 boolean checkFlag = false;
		 String [] lineStringPart = string.split("[,]");
		 
		 if ( lineStringPart.length ==3){
			 String [] stringParthThree = lineStringPart[2].split("#");
			 if ( stringParthThree.length ==50){
				 checkFlag = true;
			 }
		 }
		 
		 return checkFlag;
	}
	
}
