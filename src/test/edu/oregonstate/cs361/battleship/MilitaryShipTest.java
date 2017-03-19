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
public class MilitaryShipTest {
    protected MilitaryShip aircraftCarrier = new MilitaryShip("AircraftCarrier", 5, new Coordinate(1, 1), new Coordinate(1, 6), false);
    protected MilitaryShip battleship = new MilitaryShip("Battleship", 4, new Coordinate(5, 5), new Coordinate(8, 5), true);
    @Test
    public void testMiltaryShip() {
        String name = aircraftCarrier.name;
        assertEquals("AircraftCarrier", name);
    }
    @Test
    public void testshipScan(){
        //test military ship without stealth
        boolean scanResult = aircraftCarrier.shipScan(new Coordinate(1,1));
        assertEquals(true, scanResult);

        //test military ship with stealth
        boolean scanResult2 = battleship.shipScan(new Coordinate(5,5));
        assertEquals(false, scanResult2);
    }
}
