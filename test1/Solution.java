package test1;

import java.util.Objects;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// Crop a message by removing only whole words, such that it will contain at most K characters.
class Solution {
    public String solution(String message, int K) {
        // write your code in Java SE 8
        Objects.requireNonNull(message);
        if(K < 1 || K > 500)
            throw new IllegalArgumentException("K should be in range [1, 500], value of K = "+K);

        if(message.length() <= K)
            return message;
        int maxStrEnd = K;
        if(Character.isWhitespace(message.charAt(K)))
            maxStrEnd++;
        
        int strEnd = 0;
        for (int i = 0; i < maxStrEnd; i++) {
            if(Character.isWhitespace(message.charAt(i)))
                strEnd = i;            
        }
        return message.substring(0, strEnd);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("The quick brown fox jumps over the lazy dog", 5));
    }
}
