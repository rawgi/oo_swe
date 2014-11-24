package oo_swe;

class Quersumme{
    static int quersumme(int n){
        int quersumme = 0;
        
        while(n!=0){
            quersumme = quersumme+n%10;
            n = n/10;
        }
        return quersumme;
    }
}
