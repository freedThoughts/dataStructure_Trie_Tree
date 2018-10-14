package problemSet_1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by Prakash on 20-05-2018.
 */
public class Operation {
    public static void main(String[] s){
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("abce");
        System.out.println(trie.searchWord("abce"));
        trie.delete("abce");
        System.out.println(trie.searchWord("abce"));
    }
}
