package mytest.showanalyse;

public class CommonData {
	
	private static CommonData instanceCommonData;
	
	
	private CommonData(){
		
	}
	
	public static CommonData getInstance(){
		
		if(instanceCommonData==null){
			instanceCommonData = new CommonData();
		}
		return instanceCommonData;
		
	}
	
	public void setX(){
		
	}
	
}
