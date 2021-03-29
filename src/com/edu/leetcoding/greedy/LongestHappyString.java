package com.edu.leetcoding.greedy;

/**
 *  1405. Longest Happy String
 *
 *  A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.
 *
 *  Given three integers a, b and c, return any string s, which satisfies following conditions:
 *      s is happy and longest possible.
 *      s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b'
 *      and at most c occurrences of the letter 'c'.
 *      s will only contain 'a', 'b' and 'c' letters.
 *      If there is no such string s return the empty string "".
 *
 *  Example 1:
 *      Input: a = 1, b = 1, c = 7
 *      Output: "ccaccbcc"
 *      Explanation: "ccbccacc" would also be a correct answer.
 *  Example 2:
 *      Input: a = 2, b = 2, c = 1
 *      Output: "aabbc"
 *  Example 3:
 *      Input: a = 7, b = 1, c = 0
 *      Output: "aabaa"
 *      Explanation: It's the only correct answer in this case.
 *
 *  Constraints:
 *      0 <= a, b, c <= 100
 *      a + b + c > 0
 *
 * */
public class LongestHappyString {

    /**
     *  O(n) - time | O(1) - space
     */
    public String longestDiverseString(int A, int B, int C) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int length = A + B + C;
        StringBuilder result = new StringBuilder();
        while(length-- > 0) {
            if((A >= B && A >= C && countA < 2)
                    || A > 0 && (countB == 2 || countC == 2)) {
                result.append('a');
                A--;
                countA++;
                countB = 0;
                countC = 0;
            } else if((B >= A && B >= C && countB < 2)
                    || B > 0 && (countA == 2 || countC == 2)) {
                result.append('b');
                B--;
                countB++;
                countA = 0;
                countC = 0;
            } else if ((C >= A && C >= B && countC < 2)
                    || C > 0 && (countA == 2 || countB == 2)){
                result.append('c');
                C--;
                countC++;
                countA = 0;
                countB = 0;
            } else {
                break;
            }
        }
        return result.toString();
    }
}
