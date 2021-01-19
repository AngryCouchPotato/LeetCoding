package com.edu.leetcoding.string;

/*
    8. String to Integer (atoi)

    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

    The algorithm for myAtoi(string s) is as follows:
        1.  Read in and ignore any leading whitespace.
        2.  Check if the next character (if not already at the end of the string) is '-' or '+'.
            Read this character in if it is either. This determines if the final result is negative or positive respectively.
            Assume the result is positive if neither is present.
        3.  Read in next the characters until the next non-digit charcter or the end of the input is reached.
            The rest of the string is ignored.
        4.  Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
            Change the sign as necessary (from step 2).
        5.  If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range.
            Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
        6.  Return the integer as the final result.
    Note:
        Only the space character ' ' is considered a whitespace character.
        Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

    Constraints:
        0 <= s.length <= 200
        s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
public class StringToIntegerAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int sign = 1;
        int i = 0;
        while (str.length() > i && str.charAt(i) == ' ') {
            i++;
        }
        if (str.length() > i && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+' ? 1 : -1);
        }
        int total = 0;
        if (str.length() > i && !Character.isDigit(str.charAt(i))) {
            return total;
        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                return total * sign;
            }
            if (!Character.isDigit(str.charAt(i))
                    || str.charAt(i) == ' ') {
                return total * sign;
            }
            int cur = Character.getNumericValue(str.charAt(i));
            if ((Integer.MAX_VALUE / 10) < total) {
                return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            } else if ((Integer.MAX_VALUE / 10) == total) {
                if (sign == 1 && Integer.MAX_VALUE % 10 < cur) {
                    return Integer.MAX_VALUE;
                } else if (sign == -1 && ((Integer.MIN_VALUE % 10) * (-1)) < cur) {
                    return Integer.MIN_VALUE;
                }
            }
            total = total * 10 + cur;
        }
        return total * sign;
    }
}
