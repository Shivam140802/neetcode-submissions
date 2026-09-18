class Twitter {
    class Tweet{
        int id;
        int time;
        Tweet(int id, int time){
            this.id = id;
            this.time = time;
        }
        int gettime(){
            return time;
        }
    }
    int time=0;
    HashMap<Integer, Set<Integer>> user_follow;
    HashMap<Integer, LinkedList<Tweet>> user_tweet;
    public Twitter() {
        user_tweet=new HashMap<>();
        user_follow=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        follow(userId,userId);
        user_tweet.putIfAbsent(userId, new LinkedList<>());
        user_tweet.get(userId).addFirst(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<>();
        if(!user_follow.containsKey(userId)) return feed;

        PriorityQueue<Tweet> pq=new PriorityQueue<>(Comparator.comparingInt(Tweet::gettime).reversed());
        for(int followeeId:user_follow.get(userId)){
            if(user_follow.containsKey(followeeId)){
                pq.addAll(user_tweet.get(followeeId));
            }
        }
        while(!pq.isEmpty() && feed.size()<10){
            feed.add(pq.poll().id);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        user_follow.putIfAbsent(followerId,new HashSet<>());
        user_follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(user_follow.containsKey(followerId) && followerId!=followeeId){
            user_follow.get(followerId).remove(followeeId);
        }
    }
}
