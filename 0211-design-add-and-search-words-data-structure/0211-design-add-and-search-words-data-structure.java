class WordDictionary {
    private Node root;

    public WordDictionary() {
         root = new Node();
    }

    class Node{
    private Node[] links;
    boolean flag;

    Node(){
            this.links = new Node[26];
            flag = false;
        }

    public Node nextNode(char c) {
        return links[c - 'a'];
    }

    public boolean constains(char c) {
        return links[c - 'a'] != null;
    }
    public void put(char c){
        links[c-'a'] = new Node();
    }
    public void setEnd() {
        this.flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

    }

    public void addWord(String word) {
          Node temp = this.root;
          int len = word.length();
          word = word.replace("[.]","a");
          for(int i = 0; i < len; i++){
            char c = word.charAt(i);
            if (!temp.constains(c)){
                temp.put(c);
            }
            temp = temp.nextNode(c);
          }
          temp.setEnd();
    }
    public boolean search(String word){
        return searchs(word,root,0);
    }
    public boolean searchs(String word, Node node, int index) {

        if (node == null)
            return false;

        if (index >= word.length()){
            if (node.isEnd())
                 return true;
            else return false;
        }


        char c = word.charAt(index);
        boolean ans = false;
        if (c == '.') {
                 for (int i = 0 ; i < 26; i++){
                     char t = (char)('a' + i);
                     if (node.constains(t)){
                         ans = searchs(word,node.nextNode(t),index + 1);
                         if (ans)
                               return ans;
                     }
                 }
        } else if (node.constains(c)) {
            ans = searchs(word, node.nextNode(c), index + 1);
            if (ans)
                return ans;
        } else
            return false;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */