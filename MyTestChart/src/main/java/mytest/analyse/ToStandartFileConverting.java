package mytest.analyse;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ToStandartFileConverting {

	public static ArrayList <String> createListFromFile(String dirName,String fileName) throws IOException{
		ArrayList <String>  linesList = new ArrayList <String>();
		String convertingFileName = dirName+"//"+fileName;
		File convertingFile= new File(convertingFileName);
		try (Scanner fileReader = new Scanner(convertingFile);){
			while ( fileReader.hasNext()){
				String lineString=fileReader.nextLine();
				linesList.add(lineString);
			}
		}
		
		return linesList;
	}
	
	public abstract ArrayList <String> createStandartList (ArrayList<String>  linesList);
		
	
	public static void createStandartFile (String dirName,String fileName, ArrayList<String>  standartList ) throws Exception{
		String convertedFileName = createStandartName ( fileName );
		File standartDir = new File ("Standart");
		standartDir.mkdir();
		File standartUserDir = new File ("Standart"+"//"+dirName);
		standartUserDir.mkdir();
		File convertedFile= new File(standartUserDir+"//"+convertedFileName);
		convertedFile.createNewFile();
		try (PrintStream diskwriter=new PrintStream(convertedFile);){
			for (int i=0;i<standartList.size(); i++){
				diskwriter.print(standartList.get(i)+"\r\n");
			}
			
		}
	}
	
	
	
	public static String createStandartName(String fileName){
		int indexDot = fileName.indexOf(".");
		String standartFileName = fileName.substring(0,indexDot) + "_standart.pgr";
		
		return standartFileName;
	}
	

	
}
