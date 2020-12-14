/*
Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/
class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return list;
    }
    
    private void dfs(String s, int start, List<String> curL){
        if(start >= s.length()) list.add(new ArrayList<>(curL));
        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                curL.add(s.substring(start, end + 1));
                dfs(s, end + 1, curL);
                curL.remove(curL.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}