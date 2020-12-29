/*
Jump Game IV
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You don't need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
Example 4:

Input: arr = [6,1,9]
Output: 2
Example 5:

Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
Output: 3
 

Constraints:

1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8
*/
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1)
            return 0;
        
        Map <Integer,List<Integer>> map = new HashMap<>();
        int steps = 0;
         //Fill the map
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        Queue <Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            steps ++;
            int size = queue.size();
            for(int i = 0;i < size; i++){
                int j = queue.poll();
                // Jump to j - 1
                if(j - 1 >= 0 && map.containsKey(arr[j - 1]))
                    queue.offer(j - 1);                
                
                // Jump to j + 1
                 if(j + 1 < n && map.containsKey(arr[j + 1])){
                     if(j + 1 == n - 1)
                         return steps;
                    queue.offer(j + 1);
                 }
                
                // Jump to k --> arr[j] == arr[k] 
                
                if(map.containsKey(arr[j])){
                    for(int k : map.get(arr[j])){
                        if(k != j){
                           if(k == n - 1)
                         return steps;
                    queue.offer(k);
                        }
                    }
                }
                map.remove(arr[j]);
            }          
        }        
        return steps;        
    }
}