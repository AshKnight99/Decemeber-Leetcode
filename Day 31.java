/*
Largest Rectangle in Histogram
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0)
            return 0;
        return helper(heights,heights.length);
    }
    
    public int helper(int h[],int n){
        Stack <Integer> sl = new Stack<>();
        Stack<Integer> sr = new Stack<>();
        int left[] = new int[n];
        int right [] = new int[n];
        for(int i = 0;i < n;i++){
            if(sl.isEmpty())
                left[i] = -1;
            else if(h[sl.peek()] >= h[i]){
                while(!sl.isEmpty() && h[sl.peek()] >= h[i])
                    sl.pop();
                if(sl.isEmpty())
                    left[i] = -1;
                else
                    left[i] = sl.peek();
            }
            else
                left[i] = sl.peek();
            sl.push(i);
        }
        for(int i = n - 1;i >= 0; i--){
            if(sr.isEmpty())
                right[i] = n;
            else if(!sr.isEmpty() && h[sr.peek()] >= h[i])
            {
                while(!sr.isEmpty() && h[sr.peek()] >= h[i])
                    sr.pop();
                if(sr.isEmpty())
                    right[i] = n;
                else
                    right[i] = sr.peek();
            }
            else
                right[i] = sr.peek();
            sr.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            max = Math.max(max, (right[i] - left[i] - 1 ) * h[i]);
        }
        return max;
    }
}