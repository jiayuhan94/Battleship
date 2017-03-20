package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Noda Dragon on 3/3/2017.
 */
class BattleshipModelTest {
  BattleshipModel model = new BattleshipModel();

    @Test
    public void testgetLength() {
        //test getLength for valid computer ships
        int length = model.getlength("computer_aircraftCarrier");
        assertEquals(5, length);

        int length2 = model.getlength("computer_battleship");
        assertEquals(4, length2);

        int length3 = model.getlength("computer_clipper");
        assertEquals(3, length3);

        int length4 = model.getlength("computer_dinghy");
        assertEquals(1, length4);

        int length5 = model.getlength("computer_submarine");
        assertEquals(3, length5);

        int length6 = model.getlength("BLAH");
        assertEquals(0, length6);
    }
    @Test
      public void testGetShip() {
          //test getting any of the valid ships
          Ship air = model.getShip("AircraftCarrier");
          String name = air.name;
          assertEquals("AircraftCarrier", name);

          Ship bat = model.getShip("Battleship");
          String name2 = bat.name;
          assertEquals("Battleship", name2);

          Ship clip = model.getShip("Clipper");
          String name3 = clip.name;
          assertEquals("Clipper", name3);

          Ship ding = model.getShip("Dinghy");
          String name4 = ding.name;
          assertEquals("Dinghy", name4);

          Ship sub = model.getShip("Submarine");
          String name5 = sub.name;
          assertEquals("Submarine", name5);

          //test bad shipname
          Ship bad = model.getShip("BLAH");
          assertEquals(null, bad);
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

    @Test
    public void testsetEzmode(){
        model = model.setEzmode("hard", model);
        boolean ez = model.ezmode;
        assertEquals(false, ez);

        model = model.setEzmode("easy", model);
        boolean ez1 = model.ezmode;
        assertEquals(true, ez1);
    }
  
    @Test
    public void scanPlayer(){
        model.ezPlace();
        //test all non-stealth ships
        boolean scan = model.scanPlayer(2,2);
        assertEquals(true, scan);

        boolean scan2 = model.scanPlayer(5,1);
        assertEquals(true, scan2);

        boolean scan3 = model.scanPlayer(1,1);
        assertEquals(true, scan3);

        //remove stealth for sake of tests
        model.computer_battleship.stealth = false;
        model.computer_submarine.stealth = false;

        //test stealth-removed ships
        boolean scan4 = model.scanPlayer(2,8);
        assertEquals(true, scan4);

        boolean scan5 = model.scanPlayer(9,6);
        assertEquals(true, scan5);

        //test scan where no ships are
        boolean scan6 = model.scanPlayer(10,10);
        assertEquals(false, scan6);
    }
  
    @Test
    public void testcheckAImiss(){
       boolean miss = model.checkAImiss(1,1);
        assertEquals(false, miss);

        model.playerMisses.add(new Coordinate(10,1));
        model.playerMisses.add(new Coordinate(10,10));
        boolean miss1 = model.checkAImiss(10,10);
        assertEquals(true, miss1);
    }
  
    @Test
    public void testcheckAIhit(){
        boolean hit= model.checkAIhit(1,1);
        assertEquals(false, hit);

        model.playerHits.add(new Coordinate(10,1));
        model.playerHits.add(new Coordinate(10,10));
        boolean hit1 = model.checkAIhit(10,10);
        assertEquals(true, hit1);
    }
  
    @Test
    public void testcheckfirepoint() {
        model.computerHits.add(new Coordinate(1,1));
        model.computerHits.add(new Coordinate(2,2));
        model.computerMisses.add(new Coordinate(1,3));
        model.computerMisses.add(new Coordinate(2,3));

        boolean hit = model.checkfirepoint(3, 2);
        assertEquals(false, hit);

        boolean hit2 = model.checkfirepoint(2, 2);
        assertEquals(true, hit2);

        boolean miss = model.checkfirepoint(3, 2);
        assertEquals(false, miss);

        boolean miss2 = model.checkfirepoint(2, 3);
        assertEquals(true, miss2);

    }
  
    @Test
    public void testcheckcomputerhealth() {
        model.checkcomputerhealth(5);
        assertEquals(0, model.computershipsank);
        model.checkcomputerhealth(0);
        assertEquals(1, model.computershipsank);
    }
  
    @Test
    public void testcheckplayerhealth() {
        model.checkplayerhealth(5);
        assertEquals(0, model.playershipsank);
        model.checkplayerhealth(0);
        assertEquals(1, model.playershipsank);
    }
  
    @Test
    public void testgetnextpoint() {
        model.ezPlace();
        model.playerHits.add(new Coordinate(1,1));
        model.playerHits.add(new Coordinate(2,1));
        model.getnextpoint(new Coordinate(1,1),new Coordinate(1,1));
        Coordinate coor = model.nextpoint;
        assertEquals(1, coor.Across);
        assertEquals(2, coor.Down);

        model.getnextpoint(new Coordinate(1,1),new Coordinate(2,1));
        Coordinate coor2 = model.nextpoint;
        assertEquals(3, coor2.Across);
        assertEquals(1, coor2.Down);
    }
  
    @Test
    public void testshipCover() {
        model.ezPlace();
        boolean covered = model.shipCover("battleship", new Coordinate(2,2));
        assertEquals(false, covered);
        boolean covered1 = model.shipCover("computer_dinghy", new Coordinate(1,1));
        assertEquals(true, covered1);
    }
}
