package battleship;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Created with IntelliJ IDEA.
 * User: Martin Martin
 * Date: 03/02/13
 * Time: 17:33
 * To change this template use File | Settings | File Templates.
 */
public class ShipTest {

        public Ship testEmptySea = new EmptySeaImpl();
        public Ship testSubmarine = new SubmarineImpl();
        public Ship testDestroyer = new DestroyerImpl();
        public Ship testCruiser = new CruiserImpl();
        public Ship testBattleship = new BattleshipImpl();

        public final int UPPER_TEST = 9;


    @Test
    public void test_setBowColumn_and_getBowColumn_min() throws Exception {
        testBattleship.setBowColumn(0);
        assertEquals("Ships bow is in column", 0, testBattleship.getBowColumn());
    }

    @Test
    public void test_setBowRow_and_getBowRow_min() throws Exception {
        testBattleship.setBowRow(0);
        assertEquals("Ships bow is in row", 0, testBattleship.getBowRow());
    }

    @Test
    public void test_setBowColumn_and_getBowColumn_max() throws Exception {
        testBattleship.setBowColumn(UPPER_TEST);
        assertEquals("Ships bow is in column", UPPER_TEST, testBattleship.getBowColumn());
    }

    @Test
    public void test_setBowRow_and_getBowRow_max() throws Exception {
        testBattleship.setBowRow(UPPER_TEST);
        assertEquals("Ships bow is in row", UPPER_TEST, testBattleship.getBowRow());
    }

    //

    @Test
    public void test_setBowColumn_and_getBowColumn_out_of_bounds_negative() throws Exception {
        testBattleship.setBowColumn(-1);
        assertEquals("Ships bow is in column", -1, testBattleship.getBowColumn());
    }

    @Test
    public void test_setBowRow_and_getBowRow_out_of_bounds_negative() throws Exception {
        testBattleship.setBowRow(-1);
        assertEquals("Ships bow is in row", -1, testBattleship.getBowRow());
    }

    @Test
    public void test_setBowColumn_and_getBowColumn_out_of_bounds_positive() throws Exception {
        testBattleship.setBowColumn(UPPER_TEST + 1);
        assertEquals("Ships bow is in column", UPPER_TEST + 1, testBattleship.getBowColumn());
    }

    @Test
    public void test_setBowRow_and_getBowRow_out_of_bounds_positive() throws Exception {
        testBattleship.setBowRow(UPPER_TEST + 1);
        assertEquals("Ships bow is in row", UPPER_TEST + 1, testBattleship.getBowRow());
    }

    //

    @Test
    public void test_setHorizontal_and_isHorizontal_true() throws Exception {
        testBattleship.setHorizontal(true);
        assertTrue("Ship is horizontally aligned", testBattleship.isHorizontal());
    }

    @Test
    public void test_setHorizontal_and_isHorizontal_false() throws Exception {
        testBattleship.setHorizontal(false);
        assertFalse("Ship is horizontally aligned", testBattleship.isHorizontal());
    }

    //

    @Test
     public void test_getLength_submarine() throws Exception {
        assertEquals("Length of Submarine is", 1, testSubmarine.getLength());
    }

    @Test
    public void test_getLength_destroyer() throws Exception {
        assertEquals("Length of Destroyer is", 2, testDestroyer.getLength());
    }

    @Test
    public void test_getLength_cruiser() throws Exception {
        assertEquals("Length of Cruiser is", 3, testCruiser.getLength());
    }

    @Test
    public void test_getLength_battleship() throws Exception {
        assertEquals("Length of Battleship is", 4, testBattleship.getLength());
    }

    //

    @Test
     public void test_toPrint_submarine() throws Exception {
        assertEquals("Single character for Submarine is", "s", testSubmarine.toString());
    }

    @Test
    public void test_toPrint_destroyer() throws Exception {
        assertEquals("Single character for Destroyer is", "d", testDestroyer.toString());
    }

    @Test
    public void test_toPrint_cruiser() throws Exception {
        assertEquals("Single character for Cruiser is", "c", testCruiser.toString());
    }

    @Test
    public void test_toPrint_battleship() throws Exception {
        assertEquals("Single character for Battleship is", "b", testBattleship.toString());
    }

    //

    @Test
    public void test_getShipType_submarine() throws Exception {
        assertEquals("Ship type for Submarine is", "submarine", testSubmarine.getShipType());
    }

    @Test
    public void test_getShipType_destroyer() throws Exception {
        assertEquals("Ship type for Destroyer is", "destroyer", testDestroyer.getShipType());
    }

    @Test
    public void test_getShipType_cruiser() throws Exception {
        assertEquals("Ship type for Cruiser is", "cruiser", testCruiser.getShipType());
    }

    @Test
    public void test_getShipType_battleship() throws Exception {
        assertEquals("Ship type for Battleship is", "battleship", testBattleship.getShipType());
    }

    //

    @Test
    public void test_Submarine_isSunk_false() throws Exception {
        Ship submarineTarget = new SubmarineImpl();
        assertFalse("Submarine is not sunk", submarineTarget.isSunk());
    }

    @Test
    public void test_Destroyer_isSunk_false() throws Exception {
        Ship destroyerTarget = new DestroyerImpl();
        assertFalse("Destroyer is not sunk", destroyerTarget.isSunk());
    }

    @Test
    public void test_Cruiser_isSunk_false() throws Exception {
        Ship cruiserTarget = new CruiserImpl();
        assertFalse("Cruiser is not sunk", cruiserTarget.isSunk());
    }

    @Test
    public void test_Battleship_isSunk_false() throws Exception {
        Ship battleshipTarget = new BattleshipImpl();
        assertFalse("Battleship is not sunk", battleshipTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Submarine_without_testing_isSunk_horizontal() throws Exception {
        Ship submarineTarget = new SubmarineImpl();
        submarineTarget.setBowColumn(0);
        submarineTarget.setBowRow(0);
        submarineTarget.setHorizontal(true);
        assertTrue("Shot hit", submarineTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Submarine_and_isSunk_horizontal() throws Exception {
        Ship submarineTarget = new SubmarineImpl();
        submarineTarget.setBowColumn(0);
        submarineTarget.setBowRow(0);
        submarineTarget.setHorizontal(true);
        submarineTarget.shootAt(0,0);
        assertTrue("Submarine sunk", submarineTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Destroyer_without_testing_isSunk_horizontal() throws Exception {
        Ship destroyerTarget = new DestroyerImpl();
        destroyerTarget.setBowColumn(0);
        destroyerTarget.setBowRow(0);
        destroyerTarget.setHorizontal(true);
        assertTrue("Shot hit", destroyerTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Destroyer_and_isSunk_true_horizontal() throws Exception {
        Ship destroyerTarget = new DestroyerImpl();
        destroyerTarget.setBowColumn(0);
        destroyerTarget.setBowRow(0);
        destroyerTarget.setHorizontal(true);
        destroyerTarget.shootAt(0,0);
        destroyerTarget.shootAt(0,1);
        assertTrue("Destroyer is sunk", destroyerTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Cruiser_without_testing_isSunk_horizontal() throws Exception {
        Ship cruiserTarget = new CruiserImpl();
        cruiserTarget.setBowColumn(0);
        cruiserTarget.setBowRow(0);
        cruiserTarget.setHorizontal(true);
        assertTrue("Shot hit", cruiserTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Cruiser_and_isSunk_true_horizontal() throws Exception {
        Ship cruiserTarget = new CruiserImpl();
        cruiserTarget.setBowColumn(0);
        cruiserTarget.setBowRow(0);
        cruiserTarget.setHorizontal(true);
        cruiserTarget.shootAt(0,0);
        cruiserTarget.shootAt(0,1);
        cruiserTarget.shootAt(0,2);
        assertTrue("Cruiser is sunk", cruiserTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Battleship_without_testing_isSunk_horizontal() throws Exception {
        Ship battleshipTarget = new BattleshipImpl();
        battleshipTarget.setBowColumn(0);
        battleshipTarget.setBowRow(0);
        battleshipTarget.setHorizontal(true);
        assertTrue("Shot hit", battleshipTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Battleship_and_isSunk_true_horizontal() throws Exception {
        Ship battleshipTarget = new BattleshipImpl();
        battleshipTarget.setBowColumn(0);
        battleshipTarget.setBowRow(0);
        battleshipTarget.setHorizontal(true);
        battleshipTarget.shootAt(0,0);
        battleshipTarget.shootAt(0,1);
        battleshipTarget.shootAt(0,2);
        battleshipTarget.shootAt(0,3);
        assertTrue("Battleship is sunk", battleshipTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Submarine_without_testing_isSunk_not_horizontal() throws Exception {
        Ship submarineTarget = new SubmarineImpl();
        submarineTarget.setBowColumn(0);
        submarineTarget.setBowRow(0);
        submarineTarget.setHorizontal(false);
        assertTrue("Shot hit", submarineTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Submarine_and_isSunk_not_horizontal() throws Exception {
        Ship submarineTarget = new SubmarineImpl();
        submarineTarget.setBowColumn(0);
        submarineTarget.setBowRow(0);
        submarineTarget.setHorizontal(false);
        submarineTarget.shootAt(0,0);
        assertTrue("Submarine sunk", submarineTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Destroyer_without_testing_isSunk_not_horizontal() throws Exception {
        Ship destroyerTarget = new DestroyerImpl();
        destroyerTarget.setBowColumn(0);
        destroyerTarget.setBowRow(0);
        destroyerTarget.setHorizontal(false);
        assertTrue("Shot hit", destroyerTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Destroyer_and_isSunk_true_not_horizontal() throws Exception {
        Ship destroyerTarget = new DestroyerImpl();
        destroyerTarget.setBowColumn(0);
        destroyerTarget.setBowRow(0);
        destroyerTarget.setHorizontal(false);
        destroyerTarget.shootAt(0,0);
        destroyerTarget.shootAt(1,0);
        assertTrue("Destroyer is sunk", destroyerTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Cruiser_without_testing_isSunk_not_horizontal() throws Exception {
        Ship cruiserTarget = new CruiserImpl();
        cruiserTarget.setBowColumn(0);
        cruiserTarget.setBowRow(0);
        cruiserTarget.setHorizontal(false);
        assertTrue("Shot hit", cruiserTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Cruiser_and_isSunk_true_not_horizontal() throws Exception {
        Ship cruiserTarget = new CruiserImpl();
        cruiserTarget.setBowColumn(0);
        cruiserTarget.setBowRow(0);
        cruiserTarget.setHorizontal(false);
        cruiserTarget.shootAt(0,0);
        cruiserTarget.shootAt(1,0);
        cruiserTarget.shootAt(2,0);
        assertTrue("Cruiser is sunk", cruiserTarget.isSunk());
    }

    //

    @Test
    public void test_shootAt_hit_Battleship_without_testing_isSunk_not_horizontal() throws Exception {
        Ship battleshipTarget = new BattleshipImpl();
        battleshipTarget.setBowColumn(0);
        battleshipTarget.setBowRow(0);
        battleshipTarget.setHorizontal(false);
        assertTrue("Shot hit", battleshipTarget.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Battleship_and_isSunk_true_not_horizontal() throws Exception {
        Ship battleshipTarget = new BattleshipImpl();
        battleshipTarget.setBowColumn(0);
        battleshipTarget.setBowRow(0);
        battleshipTarget.setHorizontal(false);
        battleshipTarget.shootAt(0,0);
        battleshipTarget.shootAt(1,0);
        battleshipTarget.shootAt(2,0);
        battleshipTarget.shootAt(3,0);
        assertTrue("Battleship is sunk", battleshipTarget.isSunk());
    }


    //

    @Test
    public void test_shootAt_EmptySea_horizontal() throws Exception {
        Ship emptySeaTarget = new EmptySeaImpl();
        emptySeaTarget.setBowColumn(UPPER_TEST);
        emptySeaTarget.setBowRow(UPPER_TEST);
        emptySeaTarget.setHorizontal(true);
        assertFalse("Shot missed and hit Empty Sea", emptySeaTarget.shootAt(UPPER_TEST,UPPER_TEST));
    }

    @Test
    public void test_shootAt_EmptySea_not_horizontal() throws Exception {
        Ship emptySeaTarget = new EmptySeaImpl();
        emptySeaTarget.setBowColumn(UPPER_TEST);
        emptySeaTarget.setBowRow(UPPER_TEST);
        emptySeaTarget.setHorizontal(false);
        assertFalse("Shot missed and hit Empty Sea", emptySeaTarget.shootAt(UPPER_TEST,UPPER_TEST));
    }

    //

    // TODO the below test methods

    @Test
    public void testOkToPlaceShipAt() throws Exception {

    }

    @Test
    public void testPlaceShipAt() throws Exception {
        // create ocean class
        // call method
        // test for effect on ocean class? or maybe ships object array

    }

    //

    /*@Test
    public void test_shootAt_after_submarine_is_sunk() throws Exception {
        assertTrue("Hit Submarine but Submarine is already sunk", testSubmarine.shootAt(0,0) && testSubmarine.isSunk());
    }

    @Test
    public void test_shootAt_after_destroyer_is_sunk() throws Exception {
        assertTrue("Hit Destroyer but Destroyer is already sunk", testDestroyer.shootAt(0,0) && testDestroyer.isSunk());
    }

    @Test
    public void test_shootAt_after_cruiser_is_sunk() throws Exception {
        assertTrue("Hit Cruiser but Cruiser is already sunk", testCruiser.shootAt(0,0) && testCruiser.isSunk());
    }

    @Test
    public void test_shootAt_after_battleship_is_sunk() throws Exception {
        assertTrue("Hit Battleship but Battleship is already sunk", testBattleship.shootAt(0,0) && testBattleship.isSunk());
    }*/

    //
}
