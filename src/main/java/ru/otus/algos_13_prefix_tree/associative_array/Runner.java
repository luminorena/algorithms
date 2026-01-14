package ru.otus.algos_13_prefix_tree.associative_array;

public class Runner {
    public static void main(String[] args) {
        PrefixTree trie = new PrefixTree();
        String[] words = new String[]{"book", "game", "time", "tree", "bird", "door", "star"};
        String[] values = new String[]{"книга", "игра", "время", "дерево", "птица", "дверь", "звезда"};

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], values[i]);
        }

        String[] searches = new String[]{"book", "ga", "bir", "door", "star"};
        for (String s : searches) {
            Node v = trie.search(s);
            if (v != null) {
                System.out.println(s + " - " + v.value);
            } else {
                System.out.println(s + " --- ");
            }
        }

        trie.delete("book");

        System.out.println("------------------------------------------------------");

        for (String s : searches) {

            Node v = trie.search(s);
            if (v != null) {
                System.out.println(s + " - " + v.value);
            } else {
                System.out.println(s + " --- ");
            }
        }
    }
}
