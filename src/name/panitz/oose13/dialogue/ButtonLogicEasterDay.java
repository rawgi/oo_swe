package name.panitz.oose13.dialogue;

import oo_swe.Datum;

public class ButtonLogicEasterDay extends ButtonLogic{
	
	@Override
	public String getDescription(){
		return "Ostersonntag";
	}
	
	@Override
	public String eval(String x){		
		int year = Integer.parseInt(x);
		return new Datum(1,1,year).getEasterDay()+"";
	}
}
