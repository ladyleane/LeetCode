class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }

        for(int i = 0; i < haystack.length(); i++){
            if(i + needle.length() > haystack.length()){
                return -1;
            }
            String s = haystack.substring(i, i + needle.length());
            if(s.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
