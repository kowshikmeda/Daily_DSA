public class Twitter {

    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[] { count, tweetId });
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        count--;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]) // Max-heap by tweet time
        );

        // Ensure the user follows themself
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        // Push all tweets (up to 10 per followee) into max-heap
        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId))
                continue;
            for (int[] tweet : tweetMap.get(followeeId)) {
                maxHeap.offer(tweet);
            }
        }

        // Retrieve top 10 tweets
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll()[1]); // Add tweetId to result
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}