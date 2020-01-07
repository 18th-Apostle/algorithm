package com.java.algorithm.n3_无重复字符的最长字串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * 使用list循环嵌套
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        List<List<String>> lists = new ArrayList<List<String>>();
        String[] split = s.split("|");
        if(split.length==1){
            return 1;
        }
        for (int i=0; i<split.length-1; i++){
            List<String> strings = new ArrayList<String>();
            strings.add(split[i]);
            for (int j=i+1; j<split.length; j++){
                if(!strings.contains(split[j])){
                    strings.add(split[j]);
                }else {
                    break;
                }
            }
            lists.add(strings);
        }
        int max = 0;
        for (List<String> strings : lists){
            if(strings.size()>max){
                max = strings.size();
            }
        }
        return max;
    }

    /**
     * 使用set就可以减少 strings.contains(split[j]) 时寻找时间
     * 但依然采用的是循环嵌套，时间复杂度还是很高
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        Set<Set<String>> lists = new HashSet<Set<String>>();
        String[] split = s.split("|");
        if(split.length==1){
            return 1;
        }
        for (int i=0; i<split.length-1; i++){
            Set<String> strings = new HashSet<String>();
            strings.add(split[i]);
            for (int j=i+1; j<split.length; j++){
                if(!strings.contains(split[j])){
                    strings.add(split[j]);
                }else {
                    break;
                }
            }
            lists.add(strings);
        }
        int max = 0;
        for (Set<String> strings : lists){
            if(strings.size()>max){
                max = strings.size();
            }
        }
        return max;
    }



    /**
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        String[] split = s.split("|");
        if(split.length==1) return 1;
        StringBuilder builder = new StringBuilder();
        for (String str : split){
            if(builder.indexOf(str)==-1){
                builder.append(str);
            }
        }
        int max = 0;
        for (int i=0; i<builder.length()-1; i++){
            String substring = builder.substring(i, builder.length());
            if(s.indexOf(substring)>-1){
                if(substring.length()>max){
                    max = substring.length();
                }
            }
        }
        for (int i=builder.length(); i>0; i--){
            String substring = builder.substring(0, i);
            if(s.indexOf(substring)>-1){
                if(substring.length()>max){
                    max = substring.length();
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("dvdf"));
    }
}
