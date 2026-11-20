
class Trie {

    class Node {
        Node[] links = new Node[26];
        boolean flag = false;
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (node.links[index] == null) {
                node.links[index] = new Node();
            }

            node = node.links[index];
        }

        node.flag = true;
    }

    public boolean search(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (node.links[index] == null) {
                return false;
            }

            node = node.links[index];
        }

        return node.flag;
    }

    public boolean startsWith(String prefix) {

        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {

            int index = prefix.charAt(i) - 'a';

            if (node.links[index] == null) {
                return false;
            }

            node = node.links[index];
        }

        return true;
    }
}
