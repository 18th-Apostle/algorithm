package com.java.algorithm.n5_最长回文子串;

public class Solution {

    /**
     * 截取所有的子串，判断是否是回文串。纪录最长的回文串并返回
     *
     * 时间复杂度O(n^3)，相当耗时
     * 空间复杂度O(1)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        String maxStr = "";
        for (int i=0; i<len; i++){
            for (int j=i+1; j<=len; j++){
                String str = s.substring(i, j);
                if(isPalindrome(str) && str.length()>max){
                    max = str.length();
                    maxStr = str;
                }
            }
        }
        return maxStr;
    }

    public static boolean isPalindrome(String s){
        if(s==null || s.equals("")){
            return false;
        }
        int len = s.length();
        for (int i=0; i<len/2; i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }


    /**
     * 中心扩展法
     *
     * 时间复杂度O(n^3)，相当耗时
     * 空间复杂度O(1)
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if(s==null || s.length()<1){
            return "";
        }
        int start=0, end=0;
        for (int i=0; i<s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len> (end-start)){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while (L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }


    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
