class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
         q.offer(new Pair(beginWord,1));
         Set<String> set = new HashSet<>(wordList);
         set.remove(beginWord);
         while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();
            if(word.equals(endWord)) return steps;
            char[] chars = word.toCharArray();
            for(int i=0;i<word.length();i++){
                char original = chars[i];
                for( char ch ='a';ch<='z';ch++){
                    chars[i] =ch;
                    String newword = new String(chars);
                    if(set.contains(newword)){
                        set.remove(newword);
                        q.offer(new Pair(newword,steps+1));
                    }
                }
                chars[i] = original;
            }
         }
         return 0;
    }
}