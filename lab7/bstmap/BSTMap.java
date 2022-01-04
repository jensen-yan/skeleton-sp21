package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private int size = 0;
    private class BSTNode {
        K key;
        V value;
        BSTNode left;
        BSTNode right;
        BSTNode(K key, V value){
            this.key    = key;
            this.value  = value;
            size += 1;
        }
    }
    private BSTNode root;

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key, root) != null;
    }

    @Override
    public V get(K key) {
        BSTNode t = get(key, root);
        if(t == null)
            return null;
        return t.value;
    }

    // search， return node
    private BSTNode get(K key, BSTNode T){
        if (T == null)
            return null;
        if (key.equals(T.key))  // 字符串比较必须用equals！！！
            return T;
        else if (key.compareTo(T.key) < 0)
            return get(key, T.left);
        else
            return get(key, T.right);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
    }

    private BSTNode put(K key, V value, BSTNode T){
        if(T == null)
            return new BSTNode(key, value);
        if (key.compareTo(T.key) < 0)
            T.left = put(key, value, T.left);
        else if(key.compareTo(T.key) > 0)
            T.right = put(key, value, T.right);
        return T;
    }

    public void printInOrder(){
        printInOrder(root);
    }

    private void printInOrder(BSTNode T){
        if(T == null) return;
        printInOrder(T.left);
        System.out.println("key: " + T.key + " value: " + T.value);
        printInOrder(T.right);
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
