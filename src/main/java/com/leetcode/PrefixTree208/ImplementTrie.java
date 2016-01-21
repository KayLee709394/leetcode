package com.leetcode.PrefixTree208;

import java.util.LinkedList;

/**
 * Created by ksy on 2016/1/11.
 */
public class ImplementTrie {

    class TrieNode {
            private LinkedList<TrieNode> children;
            private char letter;
            private boolean isEnd;
            // Initialize your data structure here.
            public TrieNode(char letter) {
                this.letter = letter;
                children = new LinkedList<TrieNode>();
                this.isEnd = false;
            }

            public TrieNode scan(char letter){
            if(children != null){
                for(TrieNode child: children){
                    if(child.letter == letter){
                        System.out.print(letter);
                        return child;
                    }
                }
            }
            return null;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public LinkedList<TrieNode> getChildren() {
            return children;
        }

        public void setChildren(LinkedList<TrieNode> children) {
            this.children = children;
        }

        public char getLetter() {
            return letter;
        }

        public void setLetter(char letter) {
            this.letter = letter;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode currentNode = root;
            char[] letters = word.toCharArray();
            for(int n = 0; n < letters.length; n++){
                char letter = letters[n];
                TrieNode child = currentNode.scan(letter);
                if(child != null){
                    currentNode = child;
                    continue;
                }else{
                    currentNode.getChildren().add(new TrieNode(letter));
                    currentNode = currentNode.scan(letter);
                }
            }

            currentNode.isEnd = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            char[] letters = word.toCharArray();
            TrieNode currentNode = root;
            for(int n = 0; n < letters.length; n++){
                TrieNode child = currentNode.scan(letters[n]);
                if(child != null){
                    currentNode = child;
                }else{
                    return false;
                }
            }
            return currentNode.isEnd;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            char[] letters = prefix.toCharArray();
            TrieNode currentNode = root;
            for(int n = 0; n < letters.length; n++){
                TrieNode child = currentNode.scan(letters[n]);
                if(child != null){
                    currentNode = child;
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] str){
        ImplementTrie it = new ImplementTrie();
        Trie t = it.new Trie();
        t.insert("ab");
        System.out.println(t.search("a"));
        System.out.println(t.startsWith("a"));
    }
}
