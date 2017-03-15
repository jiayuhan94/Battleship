package edu.oregonstate.cs361.battleship;

/**
 * Created by michaelhilton on 1/5/17.
 */
public class Ship {
    protected String name;
    protected int length;
    protected Coordinate start;
    protected Coordinate end;
    protected int health;

    public Ship() {
        name = "null";
        length = -1;
        start = start;
        end = end;
    }

    public Ship(String n, int l, Coordinate s, Coordinate e) {
        name = n;
        length = l;
        start = s;
        end = e;
        health = l;
    }

    public void setLocation(Coordinate s, Coordinate e) {
        start = s;
        end = e;
    }

    public boolean covers(Coordinate test) {
        //horizontal
        if (start.getAcross() == end.getAcross()) {
            if (test.getAcross() == start.getAcross()) {   //This is a bit hard to follow, some comments could be helpfull. -Stewart
                if ((test.getDown() >= start.getDown()) &&
                        (test.getDown() <= end.getDown()))
                    return true;
            } else {
                return false;
            }
        }
        //vertical
        else {
            if (test.getDown() == start.getDown()) {  //Same as previous. -Stewart
                if ((test.getAcross() >= start.getAcross()) &&
                        (test.getAcross() <= end.getAcross()))
                    return true;
            } else {
                return false;
            }

        }
        return false;
    }

    public boolean shipScan(Coordinate test) {
        return covers(test);
    }
    public void shipHit(){
        health -= 1;
    }
}
