package oo_swe;

import de.hsrm.cs.oose13.Circle;
import de.hsrm.cs.oose13.Ellipse;
import de.hsrm.cs.oose13.GeometricObject;
import de.hsrm.cs.oose13.GeometricObjectsScene;
import de.hsrm.cs.oose13.ScenePanel;
import de.hsrm.cs.oose13.ShowMoveable;
import de.hsrm.cs.oose13.Star;
import de.hsrm.cs.oose13.StartStopScenePanel;
import de.hsrm.cs.oose13.Vertex;
import name.panitz.oose13.dialogue.ButtonLogicEasterDay;
import name.panitz.oose13.dialogue.ButtonLogicIncludesDepp;
import name.panitz.oose13.dialogue.ButtonLogicLength;
import name.panitz.oose13.dialogue.ButtonLogicLowercase;
import name.panitz.oose13.dialogue.Dialogue;

class Test{
	public static void main(String[]args){
//	//Datum
//	System.out.println("<-----Test Datum----->");
//		Datum d1 = new Datum(1,3,2014);
//		Datum d2 = new Datum(17,12,1993);
//		Datum d3 = new Datum(9,11,2054);
//		Datum d4 = new Datum(21,6,2004);
//		Datum d5 = new Datum(4,11,2014);
//		
//		System.out.println("1.3.2014 als String");
//		System.out.println(d1.toString());
//
//		System.out.println("März 2014 als String");
//		System.out.println(d1.monthToString());
//
//		System.out.println("März 2014 als html");
//		System.out.println(d1.monthAsHTML());
//
//		System.out.println("1.3.2014 früher als 17.12.1993? (false)");
//		System.out.println(d1.isEarlierThan(d2));
//
//		System.out.println("1.3.2014 später als 17.12.1993? (true)");
//		System.out.println(d1.isLaterThan(d2));
//
//		System.out.println("1.3.2014 früher als 9.11.2054? (true)");
//		System.out.println(d1.isEarlierThan(d3));
//
//		System.out.println("1.3.2014 später als 9.11.2054? (false)");
//		System.out.println(d1.isLaterThan(d3));
//
//		System.out.println("17.12.1993 ist der 17.12.1993? (true)");
//		System.out.println(d2.sameDay(d2));
//
//		System.out.println("17.12.1993 ist der 9.11.2054? (false)");
//		System.out.println(d2.sameDay(d3));
//
//		System.out.println("Tage im Jahr 2004 (Schaltjahr)");
//		System.out.println(d4.getAbsoluteDaysInYear());
//
//		System.out.println("Tage im Jahr 2014 (kein Schaltjahr)");
//		System.out.println(d1.getAbsoluteDaysInYear());
//
//		System.out.println("Tage im Monat November (30)");
//		System.out.println(d3.getDaysInMonth());
//
//		System.out.println("Der Wochentag des 4.11.2014 als String (Dienstag)");
//		System.out.println(d5.wochenTagAlsString());
//
//		System.out.println("Ostersonntag im Jahr 1993 (11.4.)");
//		System.out.println(d2.getEasterDay());
//		
//
//	//Karo
//	System.out.println("<-----Test Karo----->");
//		System.out.println("Karo mit 20, 15");
//        	System.out.println(Karo.karo(20,15));
//
//
//    //Quersumme
//	System.out.println("<-----Test Quersumme----->");
//		System.out.println("Quersumme von 57832");
//		System.out.println(Quersumme.quersumme(57832));
//	
//	//Fib
//	System.out.println("<-----Test Fib----->");
//		System.out.println("Fib von 9 (sollte 34 sein)");
//		System.out.println(Fib.fib(9));
//		Fib fib = new Fib();
//		System.out.println("Fib ein paar mal erhoehen:");
//		System.out.println("1?");
//		System.out.println(fib.nextFib()+"!");
//		System.out.println("2?");
//		System.out.println(fib.nextFib()+"!");
//		System.out.println("3?");
//		System.out.println(fib.nextFib()+"!");
//		System.out.println("5?");
//		System.out.println(fib.nextFib()+"!");
//		System.out.println("8?");
//		System.out.println(fib.nextFib()+"!");
//		System.out.println("13?");
//		System.out.println(fib.nextFib()+"!");
//		System.out.println("21?");
//		System.out.println(fib.nextFib()+"!");
//		System.out.println("34?");
//		System.out.println(fib.nextFib()+"!");
//		
//	//Vertex
//	System.out.println("<-----Test Vertex----->");
//		Vertex vertex = new Vertex(4,5);
//		System.out.println("Vertex:"+vertex);
//		System.out.println("Vertex um x:6 und y:3 verschieben (dann: x:10 y:8)");
//		vertex.move(new Vertex(6,3));
//		System.out.println("Vertex:"+vertex);
//		System.out.println("Vertex auf x:8 und y:22 setzen");
//		vertex.moveTo(new Vertex(8,22));
//		System.out.println("Vertex"+vertex);
//		
//	//GeometricObject
//	System.out.println("<-----Text GeometricObject----->");
//		GeometricObject geo1 = new GeometricObject(new Vertex(4,5), 6, 4);
//		GeometricObject geo2 = new GeometricObject(new Vertex(3,2), new Vertex(1,2), 8, 2);
//		System.out.println("corner:4,5; width:6; height:4");
//		System.out.println(geo1);
//		System.out.println("corner:3,2; movement:1,2; width:8; height:2");
//		System.out.println(geo2);
//		geo2.move();
//		System.out.println("corner:4,4; movement:1,2; width:8; height:2");
//		System.out.println(geo2);
//		geo2.move();
//		System.out.println("corner:5,6; movement:1,2; width:8; height:2");
//		System.out.println(geo2);
//		geo2.move(new Vertex(1,-4));
//		System.out.println("corner:6,2; movement:1,2; width:8; height:2");
//		System.out.println(geo2);
//		
//		if(geo2.isLargerThan(geo1))
//			System.out.println("geo2 sollte kleiner als geo1 sein!");
//		
//		if(geo2.isAbove(geo1))
//			System.out.println("geo2 solte nicht ueber geo1 sein!");
//		
//		if(geo2.isLeftOf(geo1))
//			System.out.println("geo2 sollte nicht links von geo1 sein!");
//		
//		if(geo2.isRightOf(geo1))
//			System.out.println("geo2 sollte nicht rechts von geo1 sein!");
//		
//		if(!geo2.isUnderneeth(geo1))
//			System.out.println("geo2 sollte unter geo1 sein!");
//		
//		if(geo2.touches(geo1))
//			System.out.println("geo2 und geo1 ber�hren sich nicht!");
//		
//		//ButtonLogic und Dialogue
//		Dialogue dia1 = new Dialogue(new ButtonLogicIncludesDepp());
//		Dialogue dia2 = new Dialogue(new ButtonLogicLength());
//		Dialogue dia3 = new Dialogue(new ButtonLogicLowercase());
//		Dialogue dia4 = new Dialogue(new ButtonLogicEasterDay());
//		
//		ShowMoveable shmv = new ShowMoveable(new Star(new Vertex(100,100), new Vertex(1,2), 10, 20, 50));
//		shmv.show();
		GeometricObject[] geos = new GeometricObject[12];
		geos[0] = new GeometricObject(new Vertex(1,1),new Vertex(2,2), 40, 50);
		geos[1] = new Ellipse(new Vertex(350,1),new Vertex(2,2), 40, 50);
		geos[2] = new Circle(new Vertex(1,210),new Vertex(2,2), 40);
		geos[3] = new Star(new Vertex(50,123),new Vertex(2,2), 12, 40, 50);
		geos[4] = new GeometricObject(new Vertex(600,300),new Vertex(2,2), 40, 50);
		geos[5] = new Ellipse(new Vertex(350,500),new Vertex(2,2), 40, 50);
		geos[6] = new Circle(new Vertex(400,210),new Vertex(2,2), 40);
		geos[7] = new Star(new Vertex(500,123),new Vertex(2,2), 12, 40, 50);
		
		geos[8] = new Star(new Vertex(10,70),new Vertex(8,4), 8, 20, 50);
		geos[9] = new Star(new Vertex(100,400),new Vertex(3,9), 5, 30, 50);
		geos[10] = new Star(new Vertex(50,470),new Vertex(2,2), 15, 60, 80);
		geos[11] = new Star(new Vertex(600,100),new Vertex(2,2), 10, 40, 50);
		StartStopScenePanel sp = new StartStopScenePanel(new GeometricObjectsScene(geos, 800, 600));
		sp.show();
	}
}
