package com.edu.leetcoding.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *  1100. Find K-Length Substrings With No Repeated Characters
 *
 *  Given a string S, return the number of substrings of length K with no repeated characters.
 *
 *  Example 1:
 *      Input: S = "havefunonleetcode", K = 5
 *      Output: 6
 *      Explanation:
 *      There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 *  Example 2:
 *      Input: S = "home", K = 5
 *      Output: 0
 *      Explanation:
 *      Notice K can be larger than the length of S. In this case is not possible to find any substring.
 *
 *  Note:
 *      1 <= S.length <= 10^4
 *      All characters of S are lowercase English letters.
 *      1 <= K <= 10^4
 *
 * */
public class FindKLengthSubstringsWithNoRepeatedCharacters {

    /**
     *  O(n) - time | O(1) - space, maximum can be 26 buckets in the map
     */
    public int numKLenSubstrNoRepeats(String S, int K) {
        if(S.length() < K) {
            return 0;
        }
        Map<Character, Integer> cache = new HashMap<>();
        int start = 0;
        int result = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(cache.containsKey(ch) && start <= cache.get(ch)) {
                start = cache.get(ch) + 1;
            }
            cache.put(ch, i);
            if(i - start + 1 == K) {
                result++;
                start++;
            }
        }
        return result;
    }
}
