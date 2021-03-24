class WordDictionary {

    /** Initialize your data structure here. */
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    //construct Trie
   public void addWord(String word) {
        Trie pointer = root;
        for(char c : word.toCharArray()) {
            if (pointer.children[c - 'a'] == null) {
                pointer.children[c - 'a'] = new Trie();
            }
            pointer = pointer.children[c - 'a'];
        }
        pointer.isWord = true;
    }    
 
    
    public boolean search(String word) {
        return dfs(word,root,0);
    }
    //itertate Trie
    private boolean dfs(String word, Trie node, int index){
        //when index = word.length, check if current Trie is word.
        if(index == word.length())return node.isWord;
        char currentCharacter = word.charAt(index);
        if(currentCharacter != '.'){
            //currentCharacter can be found in current node
            return node.children[currentCharacter - 'a'] != null && dfs(word, node.children[currentCharacter - 'a'], index + 1);
        }else{
            for(int i = 0; i < 26; i++){
                //find any nonnull Trie to see if the word could be found 
                if(node.children[i] != null && dfs(word,node.children[i],index+1)){
                    return true;
                }
            }
        }
        return false;
    }
    private class Trie{
        Trie[]children = new Trie[26];
        boolean isWord;
     
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
