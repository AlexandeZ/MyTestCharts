package mytest.showanalyse;

import mytest.analyse.ToPt001Standart;

public class ToPt0001StandartCommand implements Command{

	ToPt001Standart toPt001Standart;
	
	public ToPt0001StandartCommand (String dirName){
		toPt001Standart = new ToPt001Standart();
		toPt001Standart.setUserDir(dirName);
	}
	
	@Override
	public void execute() {
		
		toPt001Standart.createStandartPt001();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
