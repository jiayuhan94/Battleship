package edu.oregonstate.cs361.battleship;

/**
 * Created by Noda Dragon on 3/1/2017.
 */
public class MilitaryShip extends Ship{
    protected boolean stealth;
    public MilitaryShip(String n, int l, Coordinate s, Coordinate e, boolean st) {
        name = n;
        length = l;
        start = s;
        end = e;
        stealth = st;
        health = l;
    }
}