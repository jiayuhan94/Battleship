package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;
import static spark.Spark.get;

/**
 * Created by Noda Dragon on 3/3/2017.
 */
public class BattleshipModelTest {
    BattleshipModel model = new BattleshipModel();

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
    public void testsetEzmode(){
        model = model.setEzmode(0, model);
        boolean ez = model.ezmode;
        assertEquals(true, ez);

        model = model.setEzmode(1, model);
        boolean ez1 = model.ezmode;
        assertEquals(false, ez1);
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
        Coordinate coor = model.getnextpoint(new Coordinate(1,1),new Coordinate(1,1));
        assertEquals(1, coor.Across);
        assertEquals(2, coor.Down);

        Coordinate coor2 = model.getnextpoint(new Coordinate(1,1),new Coordinate(2,1));
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
