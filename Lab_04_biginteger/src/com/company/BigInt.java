package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public final class BigInt {

    private final byte[] byteArray;
    public static final BigInt maxLong = new BigInt(Long.MAX_VALUE);

    public BigInt(String str) {
        byteArray = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            byteArray[i] = (byte) (str.charAt(i) - '0');
        }
    }

    public BigInt(byte[] byteArr) {
        byteArray = byteArr;
    }

    public BigInt(long l) {
        this(String.valueOf(l));
    }

    public BigInt(BigInt val) {
        byteArray = new byte[val.getNum().length];
        System.arraycopy(val.getNum(), 0, getNum(), 0, getNum().length);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b : getNum()) {
            sb.append(b);
        }
        return sb.toString();
    }

    public final boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof BigInt)) {
            return false;
        }

        BigInt bi = (BigInt) o;

        return Arrays.equals(bi.getNum(), getNum());
    }


    public final byte[] getNum() {
        return byteArray;
    }

    public final boolean bigger(BigInt bi) {
        int len1 = getNum().length;
        int len2 = bi.getNum().length;

        if (equals(bi)) {
            return false;
        } else if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (getNum()[i] < bi.getNum()[i])
                    return false;
            }
        } else return len2 <= len1;

        return true;
    }

    public final BigInt add(BigInt bi) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = getNum().length - 1;
        int j = bi.getNum().length - 1;
        int carry = 0;
        int temp;

        while (i >= 0 && j >= 0) {
            temp = getNum()[i] + bi.getNum()[j] + carry;
            carry = check(temp, result);
            i--;
            j--;
        }

        if (j >= 0) {
            while (j >= 0) {
                temp = bi.getNum()[j] + carry;
                carry = check(temp, result);
                j--;
            }
        } else {
            while (i >= 0) {
                temp = getNum()[i] + carry;
                carry = check(temp, result);
                i--;
            }
        }

        if (carry == 1) {
            result.add(0, carry);
        }

        byte[] sumArr = new byte[result.toArray().length];
        for (i = 0; i < result.toArray().length; i++) {
            sumArr[i] = (byte) ((int) (result.get(i)));
        }

        return (new BigInt(sumArr));
    }

    public final int check(int temp, ArrayList<Integer> result) {
        int carry;
        if (temp >= 10) {
            result.add(0, temp % 10);
            carry = temp / 10;
        } else {
            result.add(0, temp);
            carry = 0;
        }
        return carry;
    }

    public static BigInt checkAdd(long l1, long l2) throws Exception {
        BigInt bi1 = new BigInt(l1);
        BigInt bi2 = new BigInt(l2);
        BigInt sum = new BigInt(bi1.add(bi2));
        if (sum.bigger(BigInt.maxLong)) {
            throw new Exception("Long overflow!");
        }
        return new BigInt(bi1.add(bi2));
    }

    public static void tryCatch(Long l1, Long l2, int i) {
        try {
            BigInt bi = checkAdd(l1, l2);
            System.out.println("(" + i + ")Longs : " + l1 + " + " + l2 + " = " + (l1 + l2));
            System.out.println("(" + i + ")BigInt: " + l1 + " + " + l2 + " = " + bi + "\n");
        } catch (Exception e) {
            System.out.println("(" + i + ")Longs : " + l1 + " + " + l2 + " = " + e.getMessage());
            System.out.println("(" + i + ")BigInt: " + l1 + " + " + l2 + " = " + (new BigInt(new BigInt(l1).add(new BigInt(l2)))) + "\n");
        }
    }
}
