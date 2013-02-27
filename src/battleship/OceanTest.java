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
        Ocean ocean = new OceanImpl();
        Ship[][] ships = ocean.getShipArray();
        boolean isEmptySea = true;
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                if(ships[i][j].toString(i,j) !=  emptySea.toString(i,j)) {
                    isEmptySea = false;
                }
            }
        }
        assertTrue("The initial values of shipsArray should be EmptySea", isEmptySea);
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
    public void test_shoot_at_submarine() throws Exception {
        Ocean ocean = new OceanImpl();
        Ship submarine = new SubmarineImpl();
        submarine.placeShipAt(0,0,true,ocean);
        assertTrue("ocean.shootAt(0,0) returned false, should be true",ocean.shootAt(0,0));
    }

    @Test
    public void test_shoot_at_battleship_horizontal() throws Exception {
        Ocean ocean = new OceanImpl();
        Ship battleship = new BattleshipImpl();
        boolean shot = true;
        battleship.placeShipAt(0,ocean.getUPPER() - battleship.getLength(),true,ocean);
        for (int i = ocean.getUPPER() - battleship.getLength(); i < ocean.getUPPER(); i++) {
            if (!ocean.shootAt(0,i)) {
                shot = false;
            }
        }
        assertTrue("ocean.shootAt Battleship returned false, should be true",shot);
    }

    @Test
    public void test_shoot_at_battleship_vertical() throws Exception {
        Ocean ocean = new OceanImpl();
        Ship battleship = new BattleshipImpl();
        boolean shot = true;
        battleship.placeShipAt(ocean.getUPPER() - battleship.getLength(),0,false,ocean);
        for (int i = ocean.getUPPER() - battleship.getLength(); i < ocean.getUPPER(); i++) {
            if (!ocean.shootAt(i,0)) {
                shot = false;
            }
        }
        assertTrue("ocean.shootAt Battleship returned false, should be true",shot);
    }

    @Test
    public void test_get_shots_fired_after_one_shot() throws Exception {
        Ocean ocean = new OceanImpl();
        ocean.shootAt(0,0);
        assertEquals("The value of shotFired should be 1", 1, ocean.getShotsFired());
    }

    @Test
    public void test_get_hit_count_after_one_hit() throws Exception {
        Ocean ocean = new OceanImpl();
        Ship submarine = new SubmarineImpl();
        submarine.placeShipAt(0,0,true,ocean);
        ocean.shootAt(0,0);
        assertEquals("hitCount should equal 1", 1, ocean.getHitCount());
    }

    @Test
    public void test_get_hit_count_after_one_hit_and_one_miss() throws Exception {
        Ocean ocean = new OceanImpl();
        Ship submarine = new SubmarineImpl();
        submarine.placeShipAt(0,0,true,ocean);
        ocean.shootAt(0, 0);
        ocean.shootAt(0,1);
        assertEquals("hitCount should equal 1",1,ocean.getHitCount());
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

    @Test
    public void test_display_shot_damage() throws Exception {
        Ocean ocean = new OceanImpl();
        Ship battleship = new BattleshipImpl();
        battleship.placeShipAt(0, 2, true, ocean);
        ocean.shootAt(0,2);
        System.out.println(ocean.toString());
    }

    @AfterClass
    public static void after() {
/*        Ocean ocean = new OceanImpl();
        ocean.placeAllShipsRandomly();
        Ship battleship = new BattleshipImpl();
        battleship.placeShipAt(0, 0, true, ocean);
        System.out.println(ocean.toString());*/
    }
}
