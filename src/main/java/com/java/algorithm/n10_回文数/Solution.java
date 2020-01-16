package com.java.algorithm.n10_回文数;

public class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            int num = 0;
            int y = x;
            while (x!=0){
                int pop = x%10;
                num = num*10 + pop;
                x = x/10;
            }
            if(num==y){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }


}
