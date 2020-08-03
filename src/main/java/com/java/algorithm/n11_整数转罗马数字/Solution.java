package com.java.algorithm.n11_整数转罗马数字;

/**
 * Solution
 *
 * @author zewen.wang
 * @date 2020/8/3
 */
public class Solution {

    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        if(num==4){
            return "IV";
        }else if(num==9){
            return "IX";
        }else if(num==40){
            return "XL";
        }else if(num==90){
            return "XC";
        }else if(num==400){
            return "CD";
        }else if(num==900){
            return "CM";
        }else{
            calculation(builder, num, 1000, "M");
            num = num % 1000;
            calculation(builder, num, 900, "CM");
            num = num % 900;
            calculation(builder, num, 500, "D");
            num = num % 500;
            calculation(builder, num, 400, "CD");
            num = num % 400;
            calculation(builder, num, 100, "C");
            num = num % 100;
            calculation(builder, num, 90, "XC");
            num = num % 90;
            calculation(builder, num, 50, "L");
            num = num % 50;
            calculation(builder, num, 40, "XL");
            num = num % 40;
            calculation(builder, num, 10, "X");
            num = num % 10;
            calculation(builder, num, 9, "IX");
            num = num % 9;
            calculation(builder, num, 5, "V");
            num = num % 5;
            calculation(builder, num, 4, "IV");
            num = num % 4;
            calculation(builder, num, 1, "I");
        }
        return builder.toString();
    }

    public static void calculation(StringBuilder builder, int num, int index, String symbol){
        int n = num / index;
        for (int i=0; i<n; i++){
            builder.append(symbol);
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

}
