class Solution {
    public String firstPalindrome(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(isPalindromic(words[i])){
                return words[i];
            }
        }
        return "";
    }
    boolean isPalindromic(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    } 
}
