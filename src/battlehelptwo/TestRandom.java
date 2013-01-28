/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battlehelptwo;

import java.util.Random;

/**
 *
 * @author keith
 */
public class TestRandom {

    public static void main(String[] args) {
        final int TEN = 10;
        Random m = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(m.nextInt(TEN));
        }
    }
}
