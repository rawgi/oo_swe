package name.panitz.oose13.dialogue;


public class ButtonLogicLength extends ButtonLogic{
	
	@Override
	public String getDescription(){
		return "l�nge";
	}
	
	@Override
	public String eval(String x){ return ""+x.length(); }
}
