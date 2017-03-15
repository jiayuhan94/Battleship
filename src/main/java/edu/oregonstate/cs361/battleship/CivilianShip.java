package edu.oregonstate.cs361.battleship;

/**
 * Created by Jake on 2/27/2017.
 */
public class CivilianShip extends Ship {

    public CivilianShip(String n, int l, Coordinate s, Coordinate e) {
        name = n;
        length = l; //Does this affect only the dingy? The Clipper is suposed to be size 3. We can bring it up on Wednesday's meeting. -Stewart
        start = s;
        end = e;
        health = l;
    }
    //overrides shipHit() in Ship object
    public void shipHit(){
        //one hit will sink a Civilian Ship
        health = 0;
    }
}
