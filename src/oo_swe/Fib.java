package oo_swe;

class Fib{
	private int n1 = 1;
	private int n2 = 0;
	
	public static int fib(int n){
		if(n<=1){
			return n;
		}else{
			return fib(n-1)+fib(n-2);
		}
	}
	
	public int nextFib(){
		int result = fib(n1)+fib(n2);
		n1++;
		n2++;
		return result;
	}
}
