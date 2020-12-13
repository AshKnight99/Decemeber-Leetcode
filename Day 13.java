/*
Burst Balloons
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ? n ? 500, 0 ? nums[i] ? 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/
class Solution {
    public int maxCoins(int[] nums) {
      int length = nums.length;
      if(length == 0)
          return 0;
        int arr[] = new int[length + 2];
        for(int i = 1;i <= length;i ++)
            arr[i] = nums[i - 1];
        
        arr[0] = arr[length + 1] = 1;
        int dp[][] = new int[length + 2][length + 2];
         for(int j = 1; j <= length; j++) {
        for(int i = j; i >= 1; i--) {
            for(int k = i; k <= j; k++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j + 1]);
            }
        }
    }
            
        return dp[1][length];
    }
}