package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> AL = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();

        for (int i = 0; i < 3; i++) {
            AL.addLast(i+4);
            BL.addLast(i+4);
            assertEquals(AL.getLast(), BL.getLast());
        }

        for (int i = 0; i < 3; i++) {
            int a = AL.removeLast();
            int b = BL.removeLast();
            assertEquals(a, b);
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> AL = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int opNum =  StdRandom.uniform(0, 4);
            if(opNum == 0){
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                AL.addLast(randVal);
                BL.addLast(randVal);
            }else if (opNum == 1){
                // size
                int size = AL.size();
                assertEquals(AL.size(), BL.size());
            }else if(opNum == 2){
                // getLast
                if(AL.size() == 0) continue;
                int a = AL.getLast();
                int b = BL.getLast();
                assertEquals(a, b);
            }else if(opNum == 3){
                // removeLast
                if(AL.size() == 0) continue;
                int a = AL.removeLast();
                int b = BL.removeLast();
                assertEquals(a, b);
            }
        }
    }

}
