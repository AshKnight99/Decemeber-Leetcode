/*
Spiral Matrix II
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 Constraints:

1 <= n <= 20
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int dir = 0 ;    // 0 -> l to r, 1 -> t to b, 2 -> r to l, 3 -> b to t
        int count = 1; //starting value
        
        while(top <= bottom && left <= right){
            //1 => left to right
            if(dir == 0){
                for(int i = left; i <= right; i ++){
                    arr[top][i] = count ++;
                }
                top ++;
            }
            else if(dir == 1){
                for(int i = top; i <= bottom; i ++){
                    arr[i][right] = count ++;
                }
                right --;
            }
            else if(dir == 2){
                for(int i = right; i >= left; i --){
                    arr[bottom][i] = count ++;
                }
                bottom --;
            }
            else if(dir == 3){
                for(int i = bottom; i >= top; i --){
                    arr[i][left] = count ++;
                }
                left ++;
            }
            dir = (dir + 1) % 4;
        }
        return arr;
    }
}