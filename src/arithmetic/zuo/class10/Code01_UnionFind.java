package arithmetic.zuo.class10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 并查集
 * <p>
 * 判断是否同意个set，和连接两个set的时间复杂度为O(1)!!!!
 */
public class Code01_UnionFind {

    public static class Node<V> {
        V value;

        public Node(V v) {
            this.value = v;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;//记录所有节点，及其对应的包装节点，后续不在减少
        public HashMap<Node<V>, Node<V>> parents;//记录父节点
        public HashMap<Node<V>, Integer> sizeMap;//记录一个集合的数量

        public UnionSet(List<V> list) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V v : list) {
                Node<V> cruNode = new Node<>(v);
                nodes.put(v, cruNode);
                parents.put(cruNode, cruNode);
                sizeMap.put(cruNode, 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }

            Node aHead = findFather(nodes.get(a));
            Node bHead = findFather(nodes.get(b));

            if (aHead != bHead) {
                Integer aSize = sizeMap.get(aHead);
                Integer bSize = sizeMap.get(bHead);
                if (aSize > bSize) {
                    parents.put(bHead, aHead);
                    sizeMap.put(aHead, aSize + bSize);
                    sizeMap.remove(bHead);
                } else {
                    parents.put(aHead, bHead);
                    sizeMap.put(bHead, aSize + bSize);
                    sizeMap.remove(aHead);
                }
            }
            //如果相等，在同一个set，不做处理

        }

        public Integer getSize() {
            return sizeMap.size();
        }

        private Node findFather(Node<V> vNode) {
            LinkedList<Node<V>> list = new LinkedList<>();

            while (vNode != parents.get(vNode)) {
                list.add(vNode);
                vNode = parents.get(vNode);
            }
            while (!list.isEmpty()) {
                parents.put(list.pop(), vNode);
            }
            return vNode;
        }


    }

    // (1,10,13) (2,10,37) (400,500,37)
    // 如果两个user，a字段一样、或者b字段一样、或者c字段一样，就认为是一个人
    // 请合并users，返回合并之后的用户数量

    public static class User {
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


    public static Integer getUserNum(List<User> list) {

        UnionSet<User> userUnionSet = new UnionSet<>(list);

        HashMap<String, User> aMap = new HashMap<>();
        HashMap<String, User> bMap = new HashMap<>();
        HashMap<String, User> cMap = new HashMap<>();

        for (User user : list) {
            if (aMap.containsKey(user.a)) {
                userUnionSet.union(user, aMap.get(user.a));
            } else {
                aMap.put(user.a, user);
            }
            if (bMap.containsKey(user.b)) {
                userUnionSet.union(user, aMap.get(user.b));
            } else {
                bMap.put(user.b, user);
            }
            if (cMap.containsKey(user.c)) {
                userUnionSet.union(user, cMap.get(user.c));
            } else {
                cMap.put(user.c, user);
            }
        }
        return userUnionSet.getSize();
    }
}
