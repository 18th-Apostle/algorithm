package com.java.algorithm.n6_Z字形变换;

public class Solution {
    public static String convert(String s, int numRows) {
        if(s.length()<numRows || numRows<2){
            return s;
        }
        String[] split = s.split("|");
        String[] arrS = new String[numRows];
        int l = 0;
        boolean right = true;
        for (String str : split) {
            if (right && l == numRows) {
                right = false;
                l = l - 2;
            }
            if (!right && l < 0) {
                right = true;
                l = l + 2;
            }
            if (right && l < numRows) {
                String arr = arrS[l] == null ? "" : arrS[l];
                arrS[l] = arr + str;
                l++;
                continue;
            }
            if (!right && l >= 0) {
                String arr = arrS[l] == null ? "" : arrS[l];
                arrS[l] = arr + str;
                l--;
                continue;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String str : arrS){
            builder.append(str);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
