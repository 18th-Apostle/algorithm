package com.java.algorithm.n7_整数反转;

public class Solution {
    public static int reverse(int x) {
        int symbol = 1;
        if(x<0){
            symbol = -1;
        }else if(x==0){
            return 0;
        }
        String s = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        for (int i=s.length()-1; symbol==-1?i>0:i>=0; i--){
            builder.append(s.charAt(i));
        }
        int result = 0;
        try {
            result = Integer.parseInt(builder.toString())*symbol;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static int reverse2(int x) {
        int rev = 0;
        while (x!=0){
            int pop = x%10;
            x = x/10;
            if(rev>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && pop<-8)) return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {
        System.out.println(reverse2(-123));
    }
}
