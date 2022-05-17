package problemSet_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static void main(String[] arg) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet","code")));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String str : wordDict)
            trie.insert(str, 0);

        return trie.search(s, s.length(), 0);
    }

    static class Trie {

        Node root;

        Trie(){
            root = new Node();
        }

        void insert(String str, int i) {
            Node node = root;
            while(i != str.length()) {
                if (node.children.containsKey(str.charAt(i))) {
                    node = node.children.get(str.charAt(i));
                    i++;
                    continue;
                }
                Node node1 = new Node(i == str.length()-1, new HashMap<Character, Node>());
                node.children.put(str.charAt(i), node1);
                node = node1;
                i++;
            }
            node.end = true;
        }

        boolean search(String str) {
            Node node = root;
            for(int i = 0; i < str.length(); i++) {
                if (!node.children.containsKey(str.charAt(i))) return false;
                node = node.children.get(str.charAt(i));
            }
            return node.end;
        }

        boolean search(String str) {

        }

        boolean search(String str, int strLen, int i) {
            Node node = root;
            while(i <= strLen) {
                Node node1 = node.children.get(str.charAt(i));
                if (node1 == null) return false;
                if (node1.end && i == str.length()-1) return true;
                if (node1.end && search(str.substring(i+1), strLen, i+1)) return true;

                node = node1;
                i++;
            }

            return node.end && i == str.length();
        }


        class Node {
            boolean end;
            Map<Character, Node> children;

            Node() {
                this.end = false;
                this.children = new HashMap<Character, Node>();
            }

            Node(boolean end, Map<Character, Node> children) {
                this.end = false;
                this.children = new HashMap<Character, Node>();
            }
        }
    }
}
