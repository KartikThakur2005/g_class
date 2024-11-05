import java.util.*;;
public class MostFrequentWordBST {

    static class Node {
        String key;
        Integer value;
        Node left;
        Node right;

        Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        BinarySearchTree() {
            this.root = null;
        }

        public Integer get(String key) {
            return get(root, key);
        }

        private Integer get(Node x, String key) {
            if (x == null) return null;
            if (key.equals(x.key)) return x.value;
            else if (key.compareTo(x.key) < 0) return get(x.left, key);
            else return get(x.right, key);
        }

        public void put(String key, Integer value) {
            root = put(root, key, value);
        }

        private Node put(Node x, String key, Integer value) {
            if (x == null) return new Node(key, value);

            if (key.equals(x.key)) x.value = value;
            else if (key.compareTo(x.key) < 0) x.left = put(x.left, key, value);
            else x.right = put(x.right, key, value);

            return x;
        }
    }

    public static String mostFrequentWord(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        BinarySearchTree bst = new BinarySearchTree();
        String[] words = text.split("\\s+"); 

        String mostFrequentWord = "";
        int maxCount = 0;

        for (String word : words) {
            if (word.length() > 10) {
                Integer count = bst.get(word);
                if (count == null) {
                    bst.put(word, 1);
                } else {
                    bst.put(word, count + 1);
                }

                if (bst.get(word) > maxCount) {
                    maxCount = bst.get(word);
                    mostFrequentWord = word;
                }
            }
        }

        return mostFrequentWord;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String mostFrequent = mostFrequentWord(text);
        System.out.println("Most frequent word (length > 10): " + mostFrequent);
    }
}
