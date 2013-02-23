package battleship;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 03/02/13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class OceanTest {

    public static Ocean oc;

    @BeforeClass
    public static void beforeClass () {
         oc = new OceanImpl();
    }

    @Test
    public void test_initial_value_of_shots_fired () {
        assertEquals("The initial value of shotFired is", 0, oc.getShotsFired());
    }

    @Test
    public void test_initial_value_of_hit_count () {
        assertEquals("The initial value of hitCount is", 0, oc.getHitCount());
    }

    @Test
    public void test_initial_value_of_ships_sunk () {
        assertEquals("The initial value of shipsSunk is", 0, oc.getShipsSunk());
    }

    @Test
    public void test_size_of_ocean_and_fleet () {
        assertEquals("The size of the ocean (UPPER) is incorrect", 10, oc.getUPPER());
    }

    @Test
    public void test_initial_value_of_ships_array () {
        Ship emptySea = new EmptySeaImpl();
        Ship[][] ships = oc.getShipArray();
        boolean isEmptySea = true;
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                if(ships[i][j].toString() !=  emptySea.toString()) {
                    isEmptySea = false;
                }
            }
        }
        assertTrue("The initial values of shipsArray are EmptySea", isEmptySea);
    }

    @Test
    public void test_initial_value_of_is_game_over () {
        assertFalse("The initial value of isGameOver is", oc.isGameOver());
    }


    @Test
    public void test_place_all_ships_randomly() throws Exception {
        // this can test if the placing of the ships is indeed random
        // also that 10 ships are placed each time.
        oc.placeAllShipsRandomly();
    }

    @Test
    public void test_is_occupied_is_false() throws Exception {
        Ocean ocean = new OceanImpl();
        assertFalse("Co-ordinates (0,0) are occupied",ocean.isOccupied(0,0));
    }

    @Test
    public void test_is_occupied_is_true() throws Exception {
        Ocean ocean = new OceanImpl();
        Ship submarine = new SubmarineImpl();
        submarine.placeShipAt(0,0,true,ocean);
        assertTrue("Co-ordinates (0,0) are not occupied",ocean.isOccupied(0,0));
    }

    @Test
    public void testShootAt() throws Exception {

    }

    @Test
    public void testGetShotsFired() throws Exception {

    }

    @Test
    public void testGetHitCount() throws Exception {

    }

    @Test
    public void testGetShipsSunk() throws Exception {

    }

    @Test
    public void testIsGameOver() throws Exception {

    }

    @Test
    public void testGetShipArray() throws Exception {

    }

    @AfterClass
    public static void after() {
        Ocean ocean = new OceanImpl();
        ocean.placeAllShipsRandomly();
        System.out.println(ocean.toString());
    }
}
