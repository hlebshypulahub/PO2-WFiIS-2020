import java.util.ArrayList;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) {
    
    int p = 397;
    int q = 103;

    int n = p * q;
    int f_n = (p - 1) * (q - 1);

    int e = Euclid(f_n);
    // System.out.println(e);
    int d = extendedEuclid(f_n, e);
    // System.out.println(d);

    String testStr = args[0];
    System.out.println("Input : " + testStr);

    ArrayList<Integer> arrEnc = new ArrayList<>();
      for (int i = 0; i < testStr.length(); i++) {
        arrEnc.add((int) testStr.charAt(i));
        // System.out.println(arrEnc.get(i));
      }

    ArrayList<BigInteger> c = new ArrayList<>();
      for (int i = 0; i < testStr.length(); i++) {
        c.add(powMod(arrEnc.get(i), e, n));
          //  System.out.println(c.get(i));
      }

    int[] arrDec = new int[testStr.length()];
      for (int i = 0; i < testStr.length(); i++) {
        arrDec[i] = (powMod(c.get(i).intValue(), d, n).intValue());
          //  System.out.println(arrDec[i]);
      }

    StringBuilder outStr = new StringBuilder("");
      for (int i = 0; i < testStr.length(); i++) {
        outStr.append((char) arrDec[i]);
      }

    System.out.println("Output: " + outStr.toString());

  }

  public static int Euclid(int f_n) {
      BigInteger e = new BigInteger(String.valueOf(3));
      BigInteger big_f_n = new BigInteger(String.valueOf(f_n));
      while (!(big_f_n.gcd(e).intValue() == 1)) {
          e = e.add(BigInteger.valueOf(2));
      }
      return e.intValue();
    }

  public static int extendedEuclid(int f_n, int e){
    int x0 = 1, x = 0;
    int b0 = f_n;

    while(f_n != 0){
      int q = e / f_n;
      int temp = x;
      x = x0 - q * x;
      x0 = temp;
      temp = e % f_n;
      e = f_n;
      f_n = temp;
    }

    if(x0 < 0){
      x0 = x0 + b0;
    }

    return x0;
  }

  public static BigInteger powMod(int t, int e, int n) {
    BigInteger y = new BigInteger(String.valueOf(t)).modPow(BigInteger.valueOf(e),
      BigInteger.valueOf(n));
    return y;
    }
}