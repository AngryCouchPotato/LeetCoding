package com.edu.leetcoding.string;

import java.util.ArrayList;
import java.util.List;

/*
    1324. Print Words Vertically

    Given a string s. Return all the words vertically in the same order in which they appear in s.
    Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
    Each word would be put on only one column and that in one column there will be only one word.

    Example 1:
        Input: s = "HOW ARE YOU"
        Output: ["HAY","ORO","WEU"]
        Explanation: Each word is printed vertically.
         "HAY"
         "ORO"
         "WEU"
    Example 2:
        Input: s = "TO BE OR NOT TO BE"
        Output: ["TBONTB","OEROOE","   T"]
        Explanation: Trailing spaces is not allowed.
        "TBONTB"
        "OEROOE"
        "   T"
    Example 3:
        Input: s = "CONTEST IS COMING"
        Output: ["CIC","OSO","N M","T I","E N","S G","T"]
    Constraints:
        1 <= s.length <= 200
        s contains only upper case English letters.
        It's guaranteed that there is only one space between 2 words.

    */
public class PrintWordsVertically {

    public List<String> printVertically(String s) {
        if(s.length() == 1) {
            return List.of(s);
        }
        String[] splitted = s.split(" ");

        int length = maxLength(splitted);
        List<String> res = new ArrayList(length);
        for(int i = 0; i < length; i++) {
            res.add(createWord(splitted, i));
        }
        return res;
    }

    private String createWord(String[] arr, int idx) {
        StringBuilder sb = new StringBuilder();
        int whiteSpaces = 0;
        for(String str : arr) {
            if(idx < str.length()) {
                if(whiteSpaces > 0) {
                    for(int i = 0; i < whiteSpaces; i++) {
                        sb.append(" ");
                    }
                    whiteSpaces = 0;
                }
                sb.append(str.charAt(idx));
            } else {
                whiteSpaces++;
            }
        }
        return sb.toString();
    }

    private int maxLength(String[] arr) {
        int maxLength = 0;
        for(String str : arr) {
            if(str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }
}
