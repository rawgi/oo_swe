package name.panitz.oose13.dialogue;


public class ButtonLogicLowercase extends ButtonLogic{
	  
	@Override
	public String getDescription(){
		return "in Kleinbuchstaben umwandeln";
	}
	
	@Override
	public String eval(String x){return x.toLowerCase();}
}
