package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Noda Dragon on 3/3/2017.
 */
public class CivilianShipTest {
    protected CivilianShip clipper = new CivilianShip("Clipper", 3, new Coordinate(1, 1), new Coordinate(4, 1));
    @Test
    public void testshipHit(){

        //check health before hit
        int b4Hit = clipper.health;
        assertEquals(3, 3);

        //check health of Civilian Ship after hit
        clipper.shipHit();
        int afterHit = clipper.health;
        assertEquals(0, 0);
    }
}
