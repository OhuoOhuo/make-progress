package arithmetic.zuo.class05;



import java.util.HashMap;
import java.util.Map;

/**
 * 字典树
 */
public class Code02_TrieTree {

    public static class Node {
        public int pass;
        public int end;
        public Map<Integer, Node> nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new HashMap<Integer, Node>();
        }

    }


    public static class TrieTree {
        public Node root;

        public TrieTree() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            node.pass++;
            int key = 0;
            for (int i = 0; i < chars.length; i++) {
                key = (int) chars[i];
                if (!node.nexts.containsKey(key)) {
                    node.nexts.put(key, new Node());
                }
                node = node.nexts.get(key);
                node.pass++;
            }
            node.end++;
        }


        public void delete(String word) {
            //只有加入过才删除
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node node = root;
                node.pass--;
                int key;
                for (int i = 0; i < chars.length; i++) {
                    key = (int) chars[i];
                    if (--node.nexts.get(key).pass == 0) { //当删除完毕时时，需要清理内存
                        node.nexts.remove(key);
                        return;
                    }
                    node = node.nexts.get(key);
                }
                node.end--;
            }

        }

        /**
         * 查找该字符串加入了几次
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            int key;
            for (int i = 0; i < chars.length; i++) {
                key = (int) chars[i];
                if (!node.nexts.containsKey(key)) {
                    return 0;
                }
                node = node.nexts.get(key);
            }
            return node.end;
        }

        /**
         * 查找已该字符串为前缀的字符串，有几个
         */
        public int prefixNum(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            int key;
            for (int i = 0; i < chars.length; i++) {
                key = (int) chars[i];
                if (!node.nexts.containsKey(key)) {
                    return 0;
                }
                node = node.nexts.get(key);
            }
            return node.pass;
        }


    }

    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            TrieTree trie1 = new TrieTree();
            Right right = new Right();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie1.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie1.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie1.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1  != ans3) {
                        System.out.println("Oops!");
                    }
                } else {
                    int ans1 = trie1.prefixNum(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1  != ans3) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("finish!");

    }


    public static class Right {

        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if (!box.containsKey(word)) {
                box.put(word, 1);
            } else {
                box.put(word, box.get(word) + 1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {
                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (!box.containsKey(word)) {
                return 0;
            } else {
                return box.get(word);
            }
        }

        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count += box.get(cur);
                }
            }
            return count;
        }
    }

    // for test
    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }
}
