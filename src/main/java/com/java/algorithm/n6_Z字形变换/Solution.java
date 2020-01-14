package com.java.algorithm.n6_Z字形变换;

import java.util.ArrayList;
import java.util.List;

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

    public static String convert2(String s, int numRows) {
        if(s.length()==1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i=0; i<Math.max(numRows, s.length()); i++){
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char str : s.toCharArray()){
            list.get(curRow).append(str);
            if(curRow==0 || curRow==numRows-1){
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder string = new StringBuilder();
        for (StringBuilder builder : list){
            string.append(builder);
        }
        return string.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert2("AB", 1));
    }
}
