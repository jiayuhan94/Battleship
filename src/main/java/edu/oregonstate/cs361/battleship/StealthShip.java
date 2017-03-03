package edu.oregonstate.cs361.battleship;

/**
 * Created by Noda Dragon on 3/1/2017.
 */
public class StealthShip extends Ship{
    public StealthShip(String n, int l,Coordinate s, Coordinate e) {
        name = n;
        length = l;
        start = s;
        end = e;
        Stealth = true;
    }
}
