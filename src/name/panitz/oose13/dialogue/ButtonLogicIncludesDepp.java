package name.panitz.oose13.dialogue;


public class ButtonLogicIncludesDepp extends ButtonLogic{
	
	@Override
	public String getDescription(){
		return "includes depp?";
	}
	
	@Override
	public String eval(String x){
//		for(int i = 1; i<x.length()-3; i++){
//			if(x.substring(i, i+3).equals("depp")){
//				return "depp ist enthalten";
//			}
//		}
		if(x.contains("depp")){
			return "depp ist enthalten";
		}
		return "kein depp enthalten";
	}
}
