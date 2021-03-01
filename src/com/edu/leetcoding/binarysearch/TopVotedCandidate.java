package com.edu.leetcoding.binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 *  911. Online Election
 *
 *  In an election, the i-th vote was cast for persons[i] at time times[i].
 *  Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number
 *  of the person that was leading the election at time t.
 *  Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.
 *
 *  Example 1:
 *      Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 *      Output: [null,0,1,1,0,0,1]
 *  Explanation:
 *      At time 3, the votes are [0], and 0 is leading.
 *      At time 12, the votes are [0,1,1], and 1 is leading.
 *      At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 *      This continues for 3 more queries at time 15, 24, and 8.
 *  Note:
 *      1 <= persons.length = times.length <= 5000
 *      0 <= persons[i] <= persons.length
 *      times is a strictly increasing array with all elements in [0, 10^9].
 *      TopVotedCandidate.q is called at most 10000 times per test case.
 *      TopVotedCandidate.q(int t) is always called with t >= times[0].
 *
 * */
public class TopVotedCandidate {

    private Map<Integer, Integer> timeToPerson;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.timeToPerson = new HashMap<>();
        this.times = times;
        init(persons);
    }

    private void init(int[] persons) {
        Map<Integer, Integer> personToCount = new HashMap<>();
        int currentWinner = -1;
        for(int timeId = 0; timeId < times.length; timeId++) {
            int currentPerson = persons[timeId];
            personToCount.putIfAbsent(currentPerson, 0);
            int count = personToCount.get(currentPerson) + 1;
            personToCount.put(currentPerson, count);
            if(currentWinner == -1) {
                currentWinner = currentPerson;
            } else {
                int currentWinnerCount = personToCount.get(currentWinner);
                if(currentWinnerCount <= count) {
                    currentWinner = currentPerson;
                }
            }
            timeToPerson.put(times[timeId], currentWinner);
        }
    }

    /**
     *  O(log(n)) - time | O(N) - space
     */
    public int q(int t) {
        return timeToPerson.get(times[searchId(t)]);
    }

    private int searchId(int t) {
        int left = 0;
        int right = times.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(times[mid] == t) {
                return mid;
            } else if(times[mid] > t) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
