class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String st:wordList){
            set.add(st);
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        set.add(beginWord);
        int count=1;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String curr=q.poll();
                if(curr.equals(endWord)) return count;
                char[] ch=curr.toCharArray();
                for(int j=0;j<ch.length;j++){
                    char temp=ch[j];
                    for(char c='a';c<='z';c++){
                        ch[j]=c;
                        if(set.contains(new String(ch))){
                            q.offer(new String(ch));
                            set.remove(curr);
                        }
                    }
                    ch[j]=temp;
                }
            }
            count+=1;
        }
        return 0;
    }
}
