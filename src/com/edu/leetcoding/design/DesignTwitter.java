package com.edu.leetcoding.design;

import java.util.*;

/**
 *  355. Design Twitter
 *
 *  Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 *  and is able to see the 10 most recent tweets in the user's news feed.
 *
 *  Implement the Twitter class:
 *      Twitter() Initializes your twitter object.
 *      void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to
 *      this function will be made with a unique tweetId.
 *      List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item
 *      in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered
 *      from most recent to least recent.
 *      void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID
 *      followeeId.
 *      void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with
 *      ID followeeId.
 *
 *  Example 1:
 *      Input
 *      ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
 *      [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 *      Output
 *      [null, null, [5], null, null, [6, 5], null, [5]]
 *
 *  Explanation
 *      Twitter twitter = new Twitter();
 *      twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
 *      twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
 *      twitter.follow(1, 2);    // User 1 follows user 2.
 *      twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
 *      twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 *                                  Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 *      twitter.unfollow(1, 2);  // User 1 unfollows user 2.
 *      twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5],
 *                                  since user 1 is no longer following user 2.
 *
 *  Constraints:
 *      1 <= userId, followerId, followeeId <= 500
 *      0 <= tweetId <= 104
 *      All the tweets have unique IDs.
 *      At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
 *
 * */
public class DesignTwitter {

    private Map<Integer, List<Tweet>> userToTweetsMap;
    private Map<Integer, Set<Integer>> userToFolloweesMap;

    /**
     * Initialize your data structure here.
     */
    public DesignTwitter() {
        userToTweetsMap = new HashMap<>();
        userToFolloweesMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userToTweetsMap.containsKey(userId)) {
            userToTweetsMap.put(userId, new ArrayList<Tweet>());
        }
        List<Tweet> tweets = userToTweetsMap.get(userId);
        tweets.add(new Tweet(tweetId));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!userToTweetsMap.containsKey(userId) && !userToFolloweesMap.containsKey(userId)) {
            return List.of();
        }
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(10, (a1, a2) -> a2.time.compareTo(a1.time));
        if (userToTweetsMap.containsKey(userId)) {
            queue.addAll(userToTweetsMap.get(userId));
        }

        Set<Integer> followees = userToFolloweesMap.get(userId);
        if (followees != null) {
            for (int followeeId : followees) {
                if (userToTweetsMap.containsKey(followeeId)) {
                    queue.addAll(userToTweetsMap.get(followeeId));
                }
            }
        }
        List<Integer> result = new ArrayList<>(10);
        int size = Math.min(10, queue.size());
        for (int i = 0; i < size; i++) {
            result.add(queue.poll().id);
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userToFolloweesMap.containsKey(followerId)) {
            userToFolloweesMap.put(followerId, new HashSet<Integer>());
        }
        Set<Integer> followees = userToFolloweesMap.get(followerId);
        followees.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userToFolloweesMap.containsKey(followerId)) {
            return;
        }
        Set<Integer> followees = userToFolloweesMap.get(followerId);
        followees.remove(followeeId);
    }

    static class Tweet {
        private static int timeCounter = 0;

        public int id;
        public Integer time;

        Tweet(int id) {
            this.id = id;
            this.time = timeCounter++;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */