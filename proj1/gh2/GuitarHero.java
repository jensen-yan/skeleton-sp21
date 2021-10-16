package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static int size = keyboard.length();

    public static void main(String[] args) {
        GuitarString[] strings = new GuitarString[size];
        for (int i = 0; i < size; i++) {
            double freq = 440.0 * Math.pow(2, (i - 24) / 12.0);
            strings[i] = new GuitarString(freq);
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int idx = keyboard.indexOf(key);

                if(idx != -1){
                    strings[idx].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (int i = 0; i < size; i++) {
                sample += strings[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for(GuitarString s : strings){
                s.tic();
            }
        }
    }
}
