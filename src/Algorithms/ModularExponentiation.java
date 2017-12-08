package Algorithms;

import java.math.BigInteger;
import java.util.Random;

public class ModularExponentiation {

    private BigInteger a;
    private BigInteger b;
    private BigInteger n;

    public ModularExponentiation(String a, String b, String n){
        this.a = new BigInteger(a);
        this.b = new BigInteger(b);
        this.n = new BigInteger(n);
    }

    public BigInteger execute(int methodIndex){
        switch (methodIndex){
            case 2:  return memoryEfficient();
            case 3:  return rightToLeftBinary();
            case 4:  return rightToLeftBinary2();
            default: return straightforward();
        }
    }

    private BigInteger straightforward(){
        long startTime = System.nanoTime();
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger i = BigInteger.ZERO;
        BigInteger answer = BigInteger.ONE;
        while(!i.equals(b)){
            answer = answer.multiply(a);
            i = i.add(BigInteger.ONE);
        }
        long endTime = System.nanoTime();
        System.out.println("SF:" + (endTime - startTime) / 1000 + " ms");
        return answer.mod(n);
    }

    private BigInteger memoryEfficient(){
        long startTime = System.nanoTime();
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger i = BigInteger.ZERO;
        BigInteger answer = BigInteger.ONE;
        while(!i.equals(b)){
            answer = (answer.multiply(a)).mod(n);
            i = i.add(BigInteger.ONE);
        }
        long endTime = System.nanoTime();
        System.out.println("ME:" + (endTime - startTime) / 1000 + " ms");
        return answer;
    }

    private BigInteger rightToLeftBinary(){
        long startTime = System.nanoTime();
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger answer = BigInteger.ONE;
        BigInteger newBase = a.mod(n);
        BigInteger tempB = new BigInteger(b.toString());
        while(tempB.max(BigInteger.ZERO).equals(tempB) && !tempB.equals(BigInteger.ZERO)){
            if (tempB.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                answer = (answer.multiply(newBase));
            }
            tempB = tempB.shiftRight(1);
            newBase = (newBase.multiply(newBase));
        }
        long endTime = System.nanoTime();
        System.out.println("RL:" + (endTime - startTime) / 1000  + " ms");
        return answer.mod(n);
    }

    private BigInteger rightToLeftBinary2(){
        long startTime = System.nanoTime();
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger answer = BigInteger.ONE;
        BigInteger newBase = a.mod(n);
        BigInteger tempB = new BigInteger(b.toString());
        while(tempB.max(BigInteger.ZERO).equals(tempB) && !tempB.equals(BigInteger.ZERO)){
            if (tempB.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                answer = (answer.multiply(newBase)).mod(n);
            }
            tempB = tempB.shiftRight(1);
            newBase = (newBase.multiply(newBase)).mod(n);
        }
        long endTime = System.nanoTime();
        System.out.println("RL2:" + (endTime - startTime) / 1000 + " ms");
        return answer;
    }

    private static BigInteger generateRandomBigInteger(int numOfdigits){
        Random rand = new Random();
        String number = "";
        for(int i=0; i<numOfdigits; i++){
            //System.out.println("it : " + Math.abs(rand.nextInt())%10);
            number += (char)(Math.abs(rand.nextInt(10))%10 + '0');
        }
        return new BigInteger(number);
    }

    public static void main(String[] args){
        BigInteger a,b,n;
        a = generateRandomBigInteger(6);
        b = generateRandomBigInteger(6);
        n = generateRandomBigInteger(6);
        System.out.println(a);
        System.out.println(b);
        System.out.println(n);

        ModularExponentiation me = new ModularExponentiation(a.toString(),b.toString(),n.toString());
        for(int i=1; i<=4; i++)
            me.execute(i);
        System.out.println("hrr2");
    }
}
