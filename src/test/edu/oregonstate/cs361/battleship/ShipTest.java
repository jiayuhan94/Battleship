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
public class ShipTest {
    protected Ship aircraftCarrier = new Ship("AircraftCarrier", 5, new Coordinate(1, 1), new Coordinate(1, 6));
    protected Ship battleship = new Ship("Battleship", 4, new Coordinate(5, 5), new Coordinate(8, 5));
    protected Ship broken = new Ship("Broken", 4, new Coordinate(5, 6), new Coordinate(7, 8));
    @Test
    public void testShip(){
        String name = battleship.name;
        assertEquals("Battleship", name);
    }
    @Test
    public void testSetLocation(){
        battleship.setLocation(new Coordinate(6,6), new Coordinate(9,6));

        //verfiy that start and end coordinates have been changed
        Coordinate start = new Coordinate(6,6);
        Coordinate end = new Coordinate(9,6);

        int startAcross = battleship.start.Across;
        int startDown = battleship.start.Down;

        assertEquals(start.Across, startAcross);
        assertEquals(start.Down, startDown);

        int endAcross = battleship.end.Across;
        int endDown = battleship.end.Down;
        assertEquals(end.Across, endAcross);
        assertEquals(end.Down, endDown);

    }
    @Test
    public void testcovers(){
        //test for horizontally placed ship covered
        boolean covered = aircraftCarrier.covers(new Coordinate(1,1));
        assertEquals(true, covered);

        //test for horizontally placed ship not covered
        boolean covered2 = aircraftCarrier.covers(new Coordinate(10,10));
        assertEquals(false, covered2);

        //test for vertically placed ship covered
        boolean covered3 = battleship.covers(new Coordinate(10,10));
        assertEquals(false, covered3);

        //test for vertically placed ship not covered
        boolean covered4 = battleship.covers(new Coordinate(7,5));
        assertEquals(true, covered4);

        //test ship that's neither horizontal nor vertical
        boolean covered5 = broken.covers(new Coordinate(10,10));
        assertEquals(false, covered5);

    }
    @Test
    public void testshipScan(){
        boolean scanned = aircraftCarrier.shipScan(new Coordinate(1,5));
        assertEquals(true, scanned);

        boolean scanned2  = aircraftCarrier.shipScan(new Coordinate(2,9));
        assertEquals(false, scanned2);
    }
    @Test
    public void testshipHit(){
        //check health before hit
        int b4health = battleship.health;
        assertEquals(4, b4health);

        //check health after hit
        battleship.shipHit();
        int afterhealth = battleship.health;
        assertEquals(3, afterhealth);
    }
}
