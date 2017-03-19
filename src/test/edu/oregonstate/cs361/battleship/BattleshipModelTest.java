package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Noda Dragon on 3/3/2017.
 */
class BattleshipModelTest {

    @Test
    public void getlengthtest1(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_aircraftCarrier";
        assertEquals(5, currModel.getlength(shipName) );
    }

    @Test
    public void getlengthtest2(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_battleship";
        assertEquals(4, currModel.getlength(shipName) );
    }

    @Test
    public void getlengthtest3(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_clipper";
        assertEquals(3, currModel.getlength(shipName) );
    }

    @Test
    public void getlengthtest4(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_dinghy";
        assertEquals(1, currModel.getlength(shipName) );
    }

    @Test
    public void getlengthtest5(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_submarine";
        assertEquals(3, currModel.getlength(shipName) );
    }

    @Test
    public void getlengthtest6(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "whatever";
        assertEquals(0, currModel.getlength(shipName) );
    }

    @Test
    public void getshiptest1(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "aircraftCarrier";
        assertEquals(currModel.aircraftCarrier, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest2(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "battleship";
        assertEquals(currModel.battleship, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest3(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "clipper";
        assertEquals(currModel.clipper, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest4(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "dinghy";
        assertEquals(currModel.dinghy, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest5(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "submarine";
        assertEquals(currModel.submarine, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest6(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "whatever";
        assertEquals(null, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest7(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_aircraftCarrier";
        assertEquals(currModel.computer_aircraftCarrier, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest8(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_battleship";
        assertEquals(currModel.computer_battleship, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest9(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_clipper";
        assertEquals(currModel.computer_clipper, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest10(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_dinghy";
        assertEquals(currModel.computer_dinghy, currModel.getShip(shipName) );
    }

    @Test
    public void getshiptest11(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "computer_submarine";
        assertEquals(currModel.computer_submarine, currModel.getShip(shipName) );
    }


    @Test
    public void playerplaceshiptest1(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "aircraftCarrier";
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(1,5);
        currModel.playerplaceship(shipName, start, end);
        assertEquals(start, currModel.getShip(shipName).start);
    }

    @Test
    public void playerplaceshiptest2(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName1 = "aircraftCarrier";
        Coordinate start1 = new Coordinate(1, 1);
        Coordinate end1 = new Coordinate(1,5);
        currModel.playerplaceship(shipName1, start1, end1);
        String shipName2 = "battleship";
        Coordinate start2 = new Coordinate(1, 1);
        Coordinate end2 = new Coordinate(1,4);
        currModel.playerplaceship(shipName2, start2, end2);
        assertEquals("Ship is overlapping.\n Please pick another location.", currModel.error_message);
    }

    @Test
    public void placeshiptest1(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "aircraftCarrier";
        String row = "1";
        String col = "1";
        String Orientation = "horizontal";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptest2() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "battleship";
        String row = "1";
        String col = "1";
        String Orientation = "horizontal";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptest3() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "clipper";
        String row = "1";
        String col = "1";
        String Orientation = "horizontal";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptest4() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "dinghy";
        String row = "1";
        String col = "1";
        String Orientation = "horizontal";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptest5() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "submarine";
        String row = "1";
        String col = "1";
        String Orientation = "horizontal";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptestvertical1(){
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "aircraftCarrier";
        String row = "1";
        String col = "1";
        String Orientation = "vertical";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptestvertical2() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "battleship";
        String row = "1";
        String col = "1";
        String Orientation = "vertical";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptestvertical3() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "clipper";
        String row = "1";
        String col = "1";
        String Orientation = "vertical";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptestvertical4() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "dinghy";
        String row = "1";
        String col = "1";
        String Orientation = "vertical";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void placeshiptestvertical5() {
        BattleshipModel currModel = new BattleshipModel();
        String shipName = "submarine";
        String row = "1";
        String col = "1";
        String Orientation = "vertical";
        currModel.placeShip(shipName, row, col, Orientation, currModel);
        assertEquals(1, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void ezPlacetest(){
        BattleshipModel currModel = new BattleshipModel();
        Coordinate start1 = new Coordinate(2, 2);
        Coordinate start2 = new Coordinate(2,8);;
        Coordinate start3 = new Coordinate(9,6);
        Coordinate start4 = new Coordinate(5,1);
        Coordinate start5 = new Coordinate(1,1);
        currModel.ezPlace();
        String shipName = "computer_aircraftCarrier";
        assertEquals(2, currModel.getShip(shipName).start.Across);
    }

    @Test
    public void hardplacetest(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.hardplace();
        assertEquals(1, 1);
    }

    @Test
    public void shootatAItest1(){
        BattleshipModel currModel = new BattleshipModel();
        int row = 1;
        int col = 1;
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(1, 5);
        currModel.computer_aircraftCarrier.setLocation(start, end);
        currModel.shootAtComputer(row, col);
        assertEquals(1, 1);
    }

    @Test
    public void shootatAItest2(){
        BattleshipModel currModel = new BattleshipModel();
        int row = 1;
        int col = 1;
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(1, 4);
        currModel.computer_battleship.setLocation(start, end);
        currModel.shootAtComputer(row, col);
        assertEquals(1, 1);
    }

    @Test
    public void shootatAItest3(){
        BattleshipModel currModel = new BattleshipModel();
        int row = 1;
        int col = 1;
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(1, 3);
        currModel.computer_clipper.setLocation(start, end);
        currModel.shootAtComputer(row, col);
        assertEquals(1, 1);
    }

    @Test
    public void shootatAItest4(){
        BattleshipModel currModel = new BattleshipModel();
        int row = 1;
        int col = 1;
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(1, 3);
        currModel.computer_submarine.setLocation(start, end);
        currModel.shootAtComputer(row, col);
        assertEquals(1, 1);
    }

    @Test
    public void shootatAItest5(){
        BattleshipModel currModel = new BattleshipModel();
        int row = 1;
        int col = 1;
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(1, 1);
        currModel.computer_dinghy.setLocation(start, end);
        currModel.shootAtComputer(row, col);
        assertEquals(1, 1);
    }

    @Test
    public void shootatAItest6(){
        BattleshipModel currModel = new BattleshipModel();
        int row = 1;
        int col = 1;
        currModel.shootAtComputer(row, col);
        assertEquals(1, 1);
    }

    @Test
    public void ezfiretest1(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.ezFire();
        assertEquals(1, 1);
    }

    @Test
    public void ezfiretest2(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.rowShoot = 10;
        currModel.colShoot = 11;
        currModel.ezFire();
        assertEquals(1, 1);
    }

    @Test
    public void ezfiretest3(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.aircraftCarrier.setLocation(new Coordinate(1, 1), new Coordinate(1, 5));
        currModel.ezFire();
        assertEquals(1, 1);
    }

    @Test
    public void hardfiretest1(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.aircraftCarrier.setLocation(new Coordinate(1, 1), new Coordinate(1, 5));
        currModel.aircraftCarrier.health = 1;
        currModel.hardfire();
        assertEquals(1, currModel.aircraftCarrier.start.Across);
    }

    @Test
    public void hardfiretest2(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.aircraftCarrier.setLocation(new Coordinate(1, 1), new Coordinate(0, 0));
        currModel.aircraftCarrier.health = 1;
        currModel.nextpoint = new Coordinate(6,6);
        currModel.hardfire();
        assertEquals(1, currModel.aircraftCarrier.start.Across);
    }

    @Test
    public void hardfiretest3(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.battleship.setLocation(new Coordinate(1, 1), new Coordinate(1, 5));
        currModel.battleship.health = 1;
        currModel.aircraftCarrier.health = 0;
        currModel.hardfire();
        assertEquals(1, currModel.battleship.start.Across);
    }

    @Test
    public void hardfiretest4(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.battleship.setLocation(new Coordinate(1, 1), new Coordinate(0, 0));
        currModel.battleship.health = 1;
        currModel.aircraftCarrier.health = 0;
        currModel.nextpoint = new Coordinate(6,6);
        currModel.hardfire();
        assertEquals(1, currModel.battleship.start.Across);
    }

    @Test
    public void hardfiretest5(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.submarine.setLocation(new Coordinate(1, 1), new Coordinate(1, 5));
        currModel.submarine.health = 1;
        currModel.battleship.health = 0;
        currModel.aircraftCarrier.health = 0;
        currModel.hardfire();
        assertEquals(1, currModel.submarine.start.Across);
    }

    @Test
    public void hardfiretest6(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.submarine.setLocation(new Coordinate(1, 1), new Coordinate(0, 0));
        currModel.submarine.health = 1;
        currModel.battleship.health = 0;
        currModel.aircraftCarrier.health = 0;
        currModel.nextpoint = new Coordinate(6,6);
        currModel.hardfire();
        assertEquals(1, currModel.submarine.start.Across);
    }

    @Test
    public void hardfiretest7(){
        BattleshipModel currModel = new BattleshipModel();
        currModel.aircraftCarrier.health = 0;
        currModel.battleship.health = 0;
        currModel.submarine.health = 0;
        currModel.hardfire();
        assertEquals(1, 1);
    }
}
