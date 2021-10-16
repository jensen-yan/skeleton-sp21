package deque;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void IntMaxTest(){
        MaxArrayDeque<Integer> L = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        L.addLast(3);
        L.addLast(5);
        L.addLast(2);
        int max = L.max();
        assertEquals(5, max);
    }

    @Test
    public void IntMaxTest2(){
        MaxArrayDeque<Integer> L = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        L.addLast(3);
        L.addLast(5);
        L.addLast(2);
        int max = L.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;     // 和惯例相反，求最小值
            }
        });
        assertEquals(2, max);
    }

    @Test
    public void StringMaxTest(){
        MaxArrayDeque<String> L = new MaxArrayDeque<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        L.addLast("asd");
        L.addLast("dsdf");
        L.addLast("asdfg");
        assertEquals("dsdf", L.max());
    }


}
