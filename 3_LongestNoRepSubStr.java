class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++)
            for(int j = i+1; j <= n; j++)
                if(UniqueChar(s, i, j)) ans = Math.max(ans, j-i);
        return ans;        
    }
    
    public boolean UniqueChar(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)) return false;
            else set.add(ch);
        }
        return true;
    }
}