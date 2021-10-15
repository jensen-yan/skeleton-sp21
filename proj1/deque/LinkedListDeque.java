package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private TNode sentinel;   // 哨兵节点，一直存在
    private int size;

    private class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private class LinkedListDequeIterator implements Iterator<T>{
        private TNode p;
        LinkedListDequeIterator(){
            p = sentinel.next;
        }
        public boolean hasNext(){
            return p != sentinel;
        }
        public T next(){
            T item = p.item;
            p = p.next;
            return item;
        }
    }

    /** create an empty list */
    public LinkedListDeque(){
        sentinel = new TNode(sentinel,null, sentinel); // data 无用
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x){
        sentinel = new TNode(sentinel, null, sentinel);
        sentinel.next = sentinel.prev = sentinel;

        TNode p = new TNode(sentinel, x, sentinel);
        sentinel.next = sentinel.prev = p;
        size = 1;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        TNode p = sentinel.next;
        while (p.item != null){
            System.out.print(p.item+" ");
            p = p.next;
        }
        System.out.println();
    }

    public T get(int index){
        TNode p = sentinel.next;
        while (p.item != null){
            if(index == 0)
                return p.item;
            p = p.next;
            index--;
        }
        return null;
    }

    private T getHelper(TNode p, int index){
        if(index == 0) return p.item;
        return getHelper(p.next, index-1);
    }

    public T getRecursive(int index){
        return getHelper(sentinel.next, index);
    }

    /** adds x to front of List */
    public void addFirst(T x){
        size += 1;
        TNode p = new TNode(sentinel, x, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        size -= 1;
        T item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return item;
    }

    public T getFirst(){
        return sentinel.next.item;
    }

    /** adds an item to the end of last */
    public void addLast(T x){
        size += 1;

        TNode p = new TNode(sentinel.prev, x, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
    }

    public T removeLast(){
        if(isEmpty()) return null;
        size -= 1;
        T item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return item;
    }

    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof LinkedListDeque)) return false;
        LinkedListDeque<?> Lo = (LinkedListDeque<?>) o;
        if(this.size() != Lo.size()) return false;
        for (int i = 0; i < this.size(); i++) {
            if(Lo.get(i) != get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.printDeque();
        System.out.println(L.getRecursive(3));
        L.removeFirst();
        L.removeLast();
//        System.out.println(L.getFirst());
//        System.out.println(L.size);
    }
}

