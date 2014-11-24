package oo_swe;

class Karo{
    static String karo(int columns,int rows){
        String karo="";
        String reihe_X="";
        String reihe_O="";
        
        for(int i=1; i<=columns;i++){
            if(i%2!=0){
                reihe_X = reihe_X + "X";
            }else{
                reihe_X = reihe_X + "O";
            }
        }

        for(int i=0; i<columns;i++){
            if(i%2!=0){
                reihe_O = reihe_O + "X";
            }else{
                reihe_O = reihe_O + "O";
            }
        }

        for(int j=1;j<=rows;j++){
            if(j%2!=0){
                karo = karo + reihe_X + "\n";
            }else{
                karo = karo + reihe_O + "\n";
            }
        }
        return karo;
    }
}
