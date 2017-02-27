package edu.oregonstate.cs361.battleship;

/**
 * Created by Jake on 2/27/2017.
 */
public class Civilian extends Ship {

    public Civilian(String n, int l,Coordinate s, Coordinate e) {
        name = n;
        length = l;
        start = s;
        end = e;
    }
}
