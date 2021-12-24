package arrays;

class WordDictionary {


    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    public void addWord(String word) {
        int length = word.length();
        Trie curr = root;
        int index = 0;
        for(int i=0; i<length; i++){
            index = word.charAt(i)-'a';
           Trie contains = curr.trieArr[index];
            if(contains==null){
                curr.trieArr[index] = new Trie();
            }
            curr = curr.trieArr[index];
        }
        curr.trieArr[index].endOfWord = true;
    }

    public boolean search(Trie root, String word, int i) {
        Trie curr = root;
        int index;
        if(word.charAt(i)!='.'){
            index = word.charAt(i)-'a';
            // matching the end char
            if(curr.trieArr[index]!=null && curr.trieArr[index].endOfWord==true && i==word.length()-1)
                return true;
            else if(curr.trieArr[index]==null)
                return false;
            else
                return search(curr.trieArr[index], word, i+1);
        }  else {

            for(int j=0; j<26; j++){
                if(curr.trieArr[j]!=null && curr.trieArr[j].endOfWord==true && i==word.length()-1)
                    return true;
                else if(curr.trieArr[j]!=null){
                    if(search(curr.trieArr[j], word, i+1) )
                        return true;
                }
            }
            return false;
        }
    }
}


 class Trie {
    Trie [] trieArr;
    boolean endOfWord ;

    public Trie(){
        trieArr = new Trie[26];
        endOfWord = false;
    }
}