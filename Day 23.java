/*
Next Greater Element III
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 

Constraints:

1 <= n <= 231 - 1
*/
class Solution {
    public int nextGreaterElement(int m) {
        long n = m;
        int count[] = new int[10];
        int currRem = -1;
        int prevRem = -1;
        
        while(n > 0){
            currRem = (int) n % 10;
            n = n / 10;
            count[currRem]++;
            if(currRem < prevRem){
              int num = currRem + 1;
                while(count[num] == 0) num ++;
                count[num] --;
                n = n * 10 + num;
                //System.out.print(n);
                
                for(int i = 0;i < 10; i++){
                    while(count[i] -- > 0){
                        n = n * 10 + i;
                    }
                }
                return n > Integer.MAX_VALUE ? -1 : (int) n;
            }
            prevRem = currRem;
        }
        return -1;
    }
}