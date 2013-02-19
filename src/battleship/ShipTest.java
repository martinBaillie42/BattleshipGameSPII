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
    public void testOkToPlaceShipAt() throws Exception {

    }

    @Test
    public void testPlaceShipAt() throws Exception {

    }

    //

    @Before
    public void before_test_shootAt_hit_Submarine_without_testing_isSunk() {
        testSubmarine.setBowColumn(0);
        testSubmarine.setBowRow(0);
        testSubmarine.setHorizontal(true);
    }
    @Test
    public void test_shootAt_hit_Submarine_without_testing_isSunk() throws Exception {
        assertTrue("Shot hit", testSubmarine.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Submarine_and_isSunk() throws Exception {
        assertTrue("Shot hit", testSubmarine.shootAt(0,0) && !testSubmarine.isSunk());
    }

    //

    @Before
    public void before_test_shootAt_hit_Destroyer_without_testing_isSunk() {
        testDestroyer.setBowColumn(0);
        testDestroyer.setBowRow(0);
        testDestroyer.setHorizontal(true);
    }
    @Test
    public void test_shootAt_hit_Destroyer_without_testing_isSunk() throws Exception {
        assertTrue("Shot hit", testDestroyer.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Destroyer_and_isSunk() throws Exception {
        assertTrue("Shot hit", testDestroyer.shootAt(0,0) && !testDestroyer.isSunk());
    }

    //

    @Before
    public void before_test_shootAt_hit_Cruiser_without_testing_isSunk() {
        testCruiser.setBowColumn(0);
        testCruiser.setBowRow(0);
        testCruiser.setHorizontal(true);
    }
    @Test
    public void test_shootAt_hit_Cruiser_without_testing_isSunk() throws Exception {
        assertTrue("Shot hit", testCruiser.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Cruiser_and_isSunk() throws Exception {
        assertTrue("Shot hit", testCruiser.shootAt(0,0) && !testCruiser.isSunk());
    }

    //

    @Before
    public void before_test_shootAt_hit_Battleship_without_testing_isSunk() {
        testBattleship.setBowColumn(0);
        testBattleship.setBowRow(0);
        testBattleship.setHorizontal(true);
    }
    @Test
    public void test_shootAt_hit_Battleship_without_testing_isSunk() throws Exception {
        assertTrue("Shot hit", testBattleship.shootAt(0,0));
    }

    @Test
    public void test_shootAt_hit_Battleship_and_isSunk() throws Exception {
        assertTrue("Shot hit", testBattleship.shootAt(0,0) && !testBattleship.isSunk());
    }

    //

    @Before
    public void before_test_isSunk_EmptySea_is_sunk() {
        testEmptySea.setBowColumn(UPPER_TEST);
        testEmptySea.setBowRow(UPPER_TEST);
        testEmptySea.setHorizontal(true);
        testEmptySea.shootAt(UPPER_TEST,UPPER_TEST);
    }
    @Test
    public void test_shootAt_EmptySea() throws Exception {
        assertFalse("Shot missed and hit Empty Sea", testEmptySea.shootAt(UPPER_TEST,UPPER_TEST));
    }

    //

    @Test
     public void test_isSunk_Submarine_is_not_sunk() throws Exception {
        assertFalse("Submarine is not sunk", testSubmarine.isSunk());
    }

    @Before
    public void before_test_isSunk_Submarine_is_sunk_horizontal() {
        testSubmarine.setBowColumn(0);
        testSubmarine.setBowRow(0);
        testSubmarine.setHorizontal(true);
        testSubmarine.shootAt(0,0);
    }
    @Test
    public void test_isSunk_Submarine_is_sunk_horizontal() throws Exception {
        assertTrue("Submarine Sunk", testSubmarine.isSunk());
    }

    //

    @Test
    public void test_isSunk_Destroyer_is_not_sunk() throws Exception {
        assertFalse("Destroyer is not sunk", testDestroyer.isSunk());
    }

    @Before
    public void before_test_isSunk_Destroyer_is_sunk_horizontal() {
        testDestroyer.setBowColumn(0);
        testDestroyer.setBowRow(0);
        testDestroyer.setHorizontal(true);
        testDestroyer.shootAt(0,0);
        testDestroyer.shootAt(0,1);
    }
    @Test
    public void test_isSunk_Destroyer_is_sunk_horizontal() throws Exception {
        assertTrue("Destroyer Sunk", testDestroyer.isSunk());
    }

    //

    @Test
    public void test_isSunk_Cruiser_is_not_sunk() throws Exception {
        assertFalse("Cruiser is not sunk", testCruiser.isSunk());
    }

    @Before
    public void before_test_isSunk_Cruiser_is_sunk_horizontal() {
        testCruiser.setBowColumn(0);
        testCruiser.setBowRow(0);
        testCruiser.setHorizontal(true);
        testCruiser.shootAt(0,0);
        testCruiser.shootAt(0,1);
        testCruiser.shootAt(0,2);
    }
    @Test
    public void test_isSunk_Cruiser_is_sunk_horizontal() throws Exception {
        assertTrue("Cruiser Sunk", testCruiser.isSunk());
    }

    //

    @Test
    public void test_isSunk_Battleship_is_not_sunk() throws Exception {
        assertFalse("Battleship is not sunk", testBattleship.isSunk());
    }

    @Before
    public void before_test_isSunk_Battleship_is_sunk_horizontal() {
        testBattleship.setBowColumn(0);
        testBattleship.setBowRow(0);
        testBattleship.setHorizontal(true);
        testBattleship.shootAt(0,0);
        testBattleship.shootAt(0,1);
        testBattleship.shootAt(0,2);
        testBattleship.shootAt(0,3);
    }
    @Test
    public void test_isSunk_Battleship_is_sunk_horizontal() throws Exception {
        assertTrue("Battleship Sunk", testBattleship.isSunk());
    }

    // TODO Create vertical test classes

    //

    @Test
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
    }

    //
}
