package oo_swe;

public class Datum{
    int day;
    int month;
    int year;

    public Datum(int day, int month, int year){
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public String toString(){
        return day+"."+month+"."+year;
    }

    public String monthToString(){
        String string = "";
        //Datumsobjekt, dass das atuelle Objekt nicht veraendert werden muss
        Datum date = this;
        for(int i = 1; i <= getDaysInMonth(); i++){
            date.setDay(i);
            if(i!=1){
            string = string+"\n";
            }
            string = string+date.wochenTagAlsString()+", der "+date.toString();
        }
        return string;
    }
    
    public String monthAsHTML(){
        String string = "<table>\n<tr><th>Mo</th><th>Di</th><th>Mi</th><th>Do</th><th>Fr</th><th>Sb</th><th>So</th></tr>\n";
        //Datumsobjekt, damit das aktuelle Objekt nicht veraendert werden muss
        Datum dateToIterate = this;
	dateToIterate.setDay(1);
        boolean monthEnd = false;
	int neededRows = 5;
	int daysInMonth = dateToIterate.getDaysInMonth();
	if(this.month == 2 && isLeapYear() && new Datum(28,2,this.year).wochentag() == 0){
		neededRows = 4;
	}
        for(int row = 1; row <= neededRows; row++){
            string = string+"<tr>";
            for(int column = 1; column <= 7; column++){
                string = string+"<td>";
                if(dateToIterate.wochentag() == column-1 && !monthEnd){
		    if(dateToIterate.getDay() == this.getDay()){
		    	string = string+"<b style=\"color:red\">"+dateToIterate.getDay()+"</b>";
                    }else{
			string = string+dateToIterate.getDay();
		    }
                    if(dateToIterate.getDay()+1 <= daysInMonth){
                        dateToIterate.setDay(dateToIterate.getDay()+1);
                    }else{
                        monthEnd = true;
                    }
                };
                string = string+"</td>";
            }
             string = string+"</tr>\n";
        }
        return string+"</table>";
    }
    
    //ist dieses datum frueher als "that"?
    public boolean isEarlierThan(Datum that){
        if(this.year < that.year
	|| this.year == that.year && this.month < that.month
	|| this.year == that.year && this.month == that.month && this.day < that.day){
            return true;
        }
        return false;
    }

    //ist dieses datum spaeter als "that"?
    public boolean isLaterThan(Datum that){
	return that.isEarlierThan(this);
    }

    //ist dieses Datum das selbe Datum, wie "that"?
    public boolean sameDay(Datum that){
        return this.year == that.year && this.month == that.month && this.day == that.day; 
    }

    //liegt das Datum in einem Schaltjahr?
    public boolean isLeapYear(){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    //gibt die Anzahl der Tage des Jahres zurueck
    public int getAbsoluteDaysInYear(){
        return isLeapYear() ? 366 : 365;
    }

    //gibt die Anzahl der Tage in dem Monat des Datums zurueck
    public int getDaysInMonth(){
        switch(this.month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 2: return isLeapYear() ? 29 : 28;
            default: return 30;
        }
    }

    //gibt die Tagesziffer zurueck
    private int tagesziffer(){
        return day % 7;
    }

    //gibt die Monatsziffer zurueck
    private int monatsziffer(){
        switch(this.month){
            case 1: case 10: return 0;
            case 5: return 1;
            case 8: return 2;
            case 2: case 3: case 11: return 3;
            case 6: return 4;
            case 9: case 12: return 5;
            default: return 6;
        }
    }

    //berechnet die Jahresziffer zurueck
    private int jahresziffer(){
        int jz = this.year%100;
        return (jz+jz/4)%7;
    }

    //gibt die Jahrhundertziffer zurueck
    private int jahrhundertziffer(){
        return (3-(year/100)%4)*2;
    }

    //gibt die Schaltjahrkorrektur zurueck
    private int schaltjahrKorrektur(){
        if(isLeapYear() && (month==1 || month==2)){
            return -1;
        }
        return 0;
    }

    //gibt den Tag in der Woche als int zurueck
    private int wochentag(){
        return (tagesziffer()+monatsziffer()+jahresziffer()+jahrhundertziffer()+schaltjahrKorrektur()) % 7;
    }

    //gibt den Tag in der Woche als String zurueck
    public String wochenTagAlsString(){
        int wtag = wochentag();
        switch(wtag){
            case 0 : return "Sonntag";
            case 1 : return "Montag";
            case 2 : return "Dienstag";
            case 3 : return "Mittwoch";
            case 4 : return "Donnerstag";
            case 5 : return "Freitag";
            default : return "Sonnabend";
        }
    }

    //berechnet das Osterdatum im Jahr des Datums
    public Datum getEasterDay(){
    	int k = year / 100;			
        int m = 15+(3*k+3)/4-(8*k+13)/25;	
        int s = 2-(3*k+3)/4;			
        int a = year%19;			
        int d =(19*a+m)%30;			
        int r =(d+a/11)/29;			
        int og = 21+d-r;			
        int sz = 7-(year+year/4+s)%7;		
        int oe = 7-(og-sz)%7;			
        int os = og+oe;				

        int osmo;
        //Anpassung des Datums, weil os ein "Maerzdatum" ausgibt 
        if(os>31){
            os-=31;
            osmo=4;
        }else{
            osmo=3;
        }
        Datum ostersonntag = new Datum(os,osmo,year);
        return ostersonntag;
    }


    /*Getter*/
    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }


    /*Setter*/
    public void setDay(int day){
        if(day > 0 && day <= getDaysInMonth()){
            this.day = day;
        }else{
            if(day < 0){
                throw new IllegalArgumentException( "There is no day <= 0." );
            }else{
                throw new IllegalArgumentException( "The given month only got "+getDaysInMonth()+" days.");
            }
        }
    }

    public void setMonth(int month){
        if(month > 0 && month <= 12){
            this.month = month;
        }else{
            if(month > 12){
                throw new IllegalArgumentException( "There are only 12 month in a year!" );
            }else{
                throw new IllegalArgumentException( "There is no month <= 0." );
            }
        }
    }

    public void setYear(int year){
    		this.year = year;
    }
}
