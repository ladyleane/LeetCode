// Brute Force, O(n^3)
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


//Sliding Window, O(2n)
class Solution{
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n){
			//Extend [i, j]
			if (!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}
			else{
				set.remove(s.charAt(i++));
			}
		}
		return ans;
    }
}


//Slinding Window Optimized, O(n)
class Solution{
	public int lengthOfLongestSubstring(String s){
		int n = s.length(), ans = 0;
		//Create Map window[i, j]
		Map<Character, Integer> map = new HashMap<>();
		//Extend [i, j]
		for (int j = 0, i = 0; j < n; j++){
			//If window contains current char
			if (Map.containsKey(s.charAt(j))){
				//Move left boundary to max(next location of repeating char, i), preventing i from moving to left
				i = Math.max(map.get(s.charAt(j)), i);
			}
			//Why j-i+1? j is the non-repeat index, length of [i, j]
			ans = Math.max(ans, j - i + 1);
			
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
}
