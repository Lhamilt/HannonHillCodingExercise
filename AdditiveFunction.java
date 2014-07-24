/*
 * Lauren Hamilton
 * Hannon Hill Coding Exercise for employment
 * 7/23/14
 * 
 * This program takes in user input, an integer N, and calculates all prime numbers less than N. 
 * It then takes 2 element combinations of each prime number found and puts them through the secret function.  
 * Proving the additive property secret(a+b)=secret(a)+secret(b).
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;


public class AdditiveFunction {
  public static void  main(String [] args){
    Scanner scan = new Scanner(System.in);
    //what's N
    System.out.println("Please enter an integer:");
    int N= scan.nextInt();
    if(N<=3){
      System.out.println("Please enter an integer greater than 3:");
      N= scan.nextInt();
    }
    //find prime numbers less than N
    ArrayList<Integer> primes = new ArrayList<Integer>() ;
    
    //find 2 element combos
    primes= primeNumber(N);
    ArrayList<Integer> primesCombos=primes;
    if(primes.size()>1){//make sure there is more than one prime
      //put it through secret
      for(int i = 0; i<=primes.size()-1; i++){
        int a = primes.get(i);
        int fa=secret(a);
        for(int j=i+1;j<=primesCombos.size()-1;j++){
          System.out.println("********************************");
          int b = primesCombos.get(j);
          System.out.println("a="+a+" b="+b);
          System.out.println("f("+a+")="+fa);
          int fb=secret(b);
          System.out.println("f("+b+")="+fb);
          System.out.println("f("+a+")+f("+b+")="+(fa+fb));

          int ab=a+b;
          System.out.println("a+b="+ab);
                    
          int fab=secret(ab);
          System.out.println("f("+ab+")="+fab);    
          if(fab==(fa+fb)){
            System.out.println("It's Additive!!!");
          }else{
            System.out.println("Not Additive :(");
          }
        }
      }
    }
  }
  

  public static ArrayList<Integer> primeNumber(int N){
    ArrayList<Integer> primes = new ArrayList<Integer>() ;
    int n =2;
    System.out.println("Prime numbers less than N:"+N);
    while(N>2){
      if(isPrime(n)){ 
        primes.add(n);
      } 
      n++;
      N--;
    }
    System.out.println(primes.toString());
    return primes;
  }
  public static boolean isPrime(int n) {
    for(int i=2;i<n;i++) {
      if(n%i==0){
        return false;
      }
    }
    return true;
  }

  public static int secret(int value){
    int answer = 3*value;
    return answer;
    
  }

}
