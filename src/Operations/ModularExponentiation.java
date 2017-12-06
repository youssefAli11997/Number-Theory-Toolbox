package Operations;

import java.math.BigInteger;

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
            case 4:  return leftToRightBinary();
            default: return straightforward();
        }
    }

    private BigInteger straightforward(){
        System.out.println("sf");
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger i = BigInteger.ZERO;
        BigInteger answer = BigInteger.ONE;
        while(!i.equals(b)){
            answer = answer.multiply(a);
            i = i.add(BigInteger.ONE);
        }
        return answer.mod(n);
    }

    private BigInteger memoryEfficient(){
        System.out.println("me");
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger i = BigInteger.ZERO;
        BigInteger answer = BigInteger.ONE;
        while(!i.equals(b)){
            answer = (answer.multiply(a)).mod(n);
            i = i.add(BigInteger.ONE);
        }
        return answer;
    }

    private BigInteger rightToLeftBinary(){
        System.out.println("rl");
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger answer = BigInteger.ONE;
        BigInteger newBase = a.mod(n);
        BigInteger tempB = new BigInteger(b.toString());
        while(tempB.max(BigInteger.ZERO).equals(tempB) && !tempB.equals(BigInteger.ZERO)){
            System.out.println(answer);
            if (tempB.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                answer = (answer.multiply(newBase)).mod(n);
            }
            tempB = tempB.shiftRight(1);
            newBase = (newBase.multiply(newBase)).mod(n);
        }
        return answer;
    }

    private BigInteger leftToRightBinary(){
        System.out.println("---------------\nlr");
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ZERO;
        }
        BigInteger answer = BigInteger.ONE;
        BigInteger newBase = a.mod(n);
        BigInteger tempB = new BigInteger(b.toString());
        int bitLength = tempB.bitLength();
        BigInteger i = BigInteger.valueOf(bitLength-2);
        System.out.println("HHH: " + tempB.testBit(bitLength-1));
        while(!i.equals(BigInteger.valueOf(-1))){
            System.out.println(tempB.testBit(i.intValue()));
            System.out.println(answer);
            if (tempB.testBit(i.intValue())) {
                answer = (answer.multiply(newBase)).mod(n);
            }
            i = i.subtract(BigInteger.ONE);
            newBase = (newBase.multiply(newBase)).mod(n);
        }
        return answer;
    }

    public static void main(String[] args){
        ModularExponentiation me = new ModularExponentiation("3","11","55");
        for(int i=1; i<5; i++){
            System.out.println(me.execute(i));
        }
    }
}
