package com.java.algorithm.n9_盛最多水的容器;

public class Solution {

    /**
     * 找出所有的容器求出最大的面积
     *
     * O(n^2)
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int area = 0;
        for(int i=0; i<height.length; i++){
            for (int j=i+1; j<height.length; j++){
                int product = Math.min(height[i], height[j]) * (j-i);
                if(product>area){
                    area = product;
                }
            }
        }
        return area;
    }

    /**
     * 双指针法
     *
     * O(n)
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int area = 0;
        int l = 0;
        int r = height.length-1;
        while (l<r){
            int product = Math.min(height[l], height[r])*(r-l);
            if(product>area){
                area = product;
            }
            if(height[l]>height[r]){
                r--;
            }else {
                l++;
            }
        }
        return area;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(height));
    }

}
