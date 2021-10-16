package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    private class ArrayDequeIterator implements Iterator<T>{
        private int index;

        ArrayDequeIterator(){
            index = 0;
        }
        public boolean hasNext(){
            return index < size;
        }
        public T next(){
            T item = get(index);
            index += 1;
            return item;
        }
    }

    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private int plusOne(int index){
        return (index + 1) % items.length;
    }

    private int minusOne(int index){
        // 这里和python不同，可能出现负数！
        return (index - 1 + items.length) % items.length;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        // 复制到最开头那里
        for (int newIndex = 0; newIndex < size; newIndex++) {
            a[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = a;
        nextFirst = capacity - 1;   // 从0开始
        nextLast = size;

    }

    public void addFirst(T item) {
        if(size == items.length) resize(size*2);
        size += 1;
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
    }

    /** Inserts X into the back of the list. */
    public void addLast(T item) {
        if(size == items.length) resize(size*2);
        size += 1;
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
    }

    /** Gets the ith T in the list (0 is the front). */
    public T get(int i) {
        if(i >= size || i < 0) return null;
        int idx = (i+nextFirst+1)%items.length;
        return items[idx];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public void printDeque() {
        int idx = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[idx] + " ");
            idx = plusOne(idx);
        }
        System.out.println();
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        if((size < items.length / 4) && (size > 4)) resize(items.length / 4);
        size -= 1;
        nextFirst = plusOne(nextFirst);
        T first = items[nextFirst];
        items[nextFirst] = null;
        return first;
    }

    /** Deletes T from back of the list and
     * returns deleted T. */
    public T removeLast() {
        if(isEmpty()) return null;
        if((size < items.length / 4) && (size > 4)) resize(items.length / 4);
        size -= 1;
        nextLast = minusOne(nextLast);
        T last = items[nextLast];
        items[nextLast] = null;
        return last;
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof ArrayDeque)) return false;
        ArrayDeque<?> ad = (ArrayDeque<?>) o;
        if(ad.size() != size()) return false;
        for (int i = 0; i < size; i++) {
            if(ad.get(i) != get(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayDeque<Character> L = new ArrayDeque<>();
        L.addLast('a');
        L.addLast('b');
        L.addFirst('c');
        L.addLast('d');
        L.addLast('e');
        L.addFirst('f');
        L.addLast('g');
        L.addLast('h');
        L.addLast('i');
        System.out.println(L.get(9));
        L.printDeque();
        L.removeFirst();
        L.removeLast();
        L.printDeque();
    }
}


