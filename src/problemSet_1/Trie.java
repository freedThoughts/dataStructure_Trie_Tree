package problemSet_1;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prakash on 20-05-2018.
 */
public class Trie {
    private class TrieNode{
        Map<Character, TrieNode> children;
        boolean isLastCharacter;

        TrieNode(){
            this.children = new HashMap<>();
            this.isLastCharacter = false;
        }
    }

    private TrieNode root;

    Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode currentNode = root;
        for(int i = 0; i < word.length(); i++){
            TrieNode node = currentNode.children.get(word.charAt(i));

            if(node == null){
                node = new TrieNode();
                currentNode.children.put(word.charAt(i), node);
            }

            currentNode = node;
        }
        currentNode.isLastCharacter = true;
    }

    public boolean searchWord(String word){
        TrieNode currentNode = root;
        for(int i = 0; i < word.length(); i++){
            TrieNode node = currentNode.children.get(word.charAt(i));
            if(node == null)
                return false;

            currentNode = node;
        }
        return currentNode.isLastCharacter;
    }

    public void delete(String word){
        delete(word, 0, root);
    }

    // Returns if parent needs to be deleted
    private boolean delete(String word, int index, TrieNode currentNode){
        if(index == word.length()){
            if(currentNode.isLastCharacter){
                currentNode.isLastCharacter = false;
                return currentNode.children.size() == 0;
            }

            return false;
        }

        TrieNode node = currentNode.children.get(word.charAt(index));
        if(node == null) return false;

        if(delete(word, index +1 , node)){
            currentNode.children.remove(word.charAt(index));
            return currentNode.children.size() == 0;
        }

        return false;
    }
}
