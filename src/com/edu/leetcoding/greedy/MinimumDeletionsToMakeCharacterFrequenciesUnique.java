package com.edu.leetcoding.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  1647. Minimum Deletions to Make Character Frequencies Unique
 *
 *  A string s is called good if there are no two different characters in s that have the same frequency.
 *
 *  Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 *  The frequency of a character in a string is the number of times it appears in the string.
 *  For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 *
 *  Example 1:
 *      Input: s = "aab"
 *      Output: 0
 *      Explanation: s is already good.
 *  Example 2:
 *      Input: s = "aaabbbcc"
 *      Output: 2
 *      Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 *      Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 *  Example 3:
 *      Input: s = "ceabaacb"
 *      Output: 2
 *      Explanation: You can delete both 'c's resulting in the good string "eabaab".
 *      Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 *
 *  Constraints:
 *      1 <= s.length <= 105
 *      s contains only lowercase English letters.
 *
 * */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    /**
     *  O(n*log(n)) - time | O(1) - space (we always use array and priorityQueue with length 26)
     */
    public int minDeletions(String s) {
        int[] freqs = new int[26];
        for(char ch : s.toCharArray()) {
            freqs[ch - 'a'] = freqs[ch - 'a'] + 1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Comparator.reverseOrder());
        for(int freq : freqs) {
            if(freq == 0) {
                continue;
            }
            queue.add(freq);
        }
        if(queue.size() == 1) {
            return 0;
        }
        int result = 0;
        int previous = queue.poll();
        int current;
        while(!queue.isEmpty()) {
            current = queue.poll();
            if(current == previous) {
                result += 1;
                previous = current - 1;
            } else if (current > previous) {
                int diff = current - previous;
                if(previous > 0) {
                    result += diff + 1;
                    previous = current - diff - 1;
                } else {
                    result += diff;
                    previous = current - diff;
                }
                if(previous == 0) {
                    break;
                }
            } else {
                previous = current;
            }
        }
        if(previous == 0 && !queue.isEmpty()) {
            while(!queue.isEmpty()) {
                result += queue.poll();
            }
        }
        return result;
    }
}
