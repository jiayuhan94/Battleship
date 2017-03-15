package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by michaelhilton on 1/4/17.
 */
public class BattleshipModel {

    private MilitaryShip aircraftCarrier = new MilitaryShip("AircraftCarrier", 5, new Coordinate(0, 0), new Coordinate(0, 0), false);
    private MilitaryShip battleship = new MilitaryShip("Battleship", 4, new Coordinate(0, 0), new Coordinate(0, 0), true);
    private MilitaryShip submarine = new MilitaryShip("Submarine", 3, new Coordinate(0, 0), new Coordinate(0, 0), true);
    private CivilianShip clipper = new CivilianShip("Clipper", 3, new Coordinate(0, 0), new Coordinate(0, 0));
    private CivilianShip dinghy = new CivilianShip("Dinghy", 1, new Coordinate(0, 0), new Coordinate(0, 0));

    private MilitaryShip computer_aircraftCarrier = new MilitaryShip("Computer_AircraftCarrier", 5, new Coordinate(0, 0), new Coordinate(0, 0), false);
    private MilitaryShip computer_battleship = new MilitaryShip("Computer_Battleship", 4, new Coordinate(0, 0), new Coordinate(0, 0), true);
    private MilitaryShip computer_submarine = new MilitaryShip("Computer_Submarine", 3,  new Coordinate(0, 0), new Coordinate(0, 0), true);
    private CivilianShip computer_clipper = new CivilianShip("Computer_Clipper", 3,  new Coordinate(0, 0), new Coordinate(0, 0));
    private CivilianShip computer_dinghy = new CivilianShip("Computer_Dinghy", 1,  new Coordinate(0, 0), new Coordinate(0, 0));

    public ArrayList<Coordinate> playerHits;
    public ArrayList<Coordinate> playerMisses;
    public ArrayList<Coordinate> computerHits;
    public ArrayList<Coordinate> computerMisses;

    public boolean scan_result;
    public String error_message;
    //playershipsank = 5, player lose
    //computershipsank = 5, player win
    public int playershipsank = 0;
    public int computershipsank = 0;
    public int rowShoot = 0;
    public int colShoot = 1;
    public String AI_win = "You lose...T_T";
    public String Player_win = "You WIN!!! ^_^";

    public boolean ezmode = true;
    public boolean lasthit = false;
    public Coordinate nextpoint;


    public BattleshipModel() {
        playerHits = new ArrayList<>();
        playerMisses = new ArrayList<>();
        computerHits = new ArrayList<>();
        computerMisses = new ArrayList<>();
    }

    public static BattleshipModel ofStatus(String statusStr) {
        System.out.println("STRING");
        return null;
    }

    public Ship getShip(String shipName) {
        if (shipName.equalsIgnoreCase("aircraftcarrier")) {
            return aircraftCarrier;
        }
        if (shipName.equalsIgnoreCase("battleship")) {
            return battleship;
        }
        if (shipName.equalsIgnoreCase("clipper")) {
            return clipper;
        }
        if (shipName.equalsIgnoreCase("dinghy")) {
            return dinghy;
        }
        if (shipName.equalsIgnoreCase("submarine")) {
            return submarine;
        } else {
            return null;
        }
    }

    public BattleshipModel placeShip(String shipName, String row, String col, String orientation, BattleshipModel currModel) {
        int rowint = Integer.parseInt(row);
        int colInt = Integer.parseInt(col);
        if (orientation.equals("horizontal")) {
            if (shipName.equalsIgnoreCase("aircraftcarrier")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint, colInt + 4));
            }
            if (shipName.equalsIgnoreCase("battleship")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint, colInt + 3));
            }
            if (shipName.equalsIgnoreCase("clipper")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint, colInt + 2));
            }
            if (shipName.equalsIgnoreCase("dinghy")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint, colInt));
            }
            if (shipName.equalsIgnoreCase("submarine")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint, colInt + 2));
            }
        } else {
            //vertical
            if (shipName.equalsIgnoreCase("aircraftcarrier")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint + 4, colInt));
            }
            if (shipName.equalsIgnoreCase("battleship")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint + 3, colInt));
            }
            if (shipName.equalsIgnoreCase("clipper")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint + 2, colInt));
            }
            if (shipName.equalsIgnoreCase("dinghy")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint, colInt));
            }
            if (shipName.equalsIgnoreCase("submarine")) {
                currModel.getShip(shipName).setLocation(new Coordinate(rowint, colInt), new Coordinate(rowint + 2, colInt));
            }
        }
        return currModel;
    }

    public void shootAtComputer(int row, int col) {
        Coordinate coor = new Coordinate(row, col);
        if (computer_aircraftCarrier.covers(coor)) {
            computerHits.add(coor);
            computer_aircraftCarrier.shipHit();
            checkcomputerhealth(computer_aircraftCarrier.health);
        } else if (computer_battleship.covers(coor)) {
            computerHits.add(coor);
            computer_battleship.shipHit();
            checkcomputerhealth(computer_battleship.health);
        } else if (computer_clipper.covers(coor)) {
            computerHits.add(coor);
            computer_clipper.shipHit();
            checkcomputerhealth(computer_clipper.health);
        } else if (computer_dinghy.covers(coor)) {
            computerHits.add(coor);
            computer_dinghy.shipHit();
            checkcomputerhealth(computer_dinghy.health);
        } else if (computer_submarine.covers(coor)) {
            computerHits.add(coor);
            computer_submarine.shipHit();
            checkcomputerhealth(computer_submarine.health);
        } else {
            computerMisses.add(coor);
        }
    }

    public void ezFire() {
        int max = 10;
        int min = 1;

        //Pattern for easy firing shoots down odd columns(Starting at row 1 column 1) and then changes to even columns
        if (rowShoot < 10) {
            rowShoot += 1;
        }
        //When end of the row is reached skip to next column and start back at the first row
        else if (rowShoot == max) {
            rowShoot = min;
            colShoot += 2;

            //Switches to even cols when end of odd ones are reached
            if (colShoot > max) {
                colShoot = 2;
            }
        }

        Coordinate coor = new Coordinate(rowShoot, colShoot);

        //check if computers fire hits any player ship, if it does add to player hits. Otherwise add to player misses
        if (ACcover(coor) || BScover(coor) || CLcover(coor) || DHcover(coor) || SMcover(coor)) {
            playerHits.add(coor);
        } else {
            playerMisses.add(coor);
        }

    }

    public void ezPlace() {
        computer_aircraftCarrier.start = new Coordinate(2,2);
        computer_aircraftCarrier.end = new Coordinate(2,6);

        computer_battleship.start = new Coordinate(2,8);
        computer_battleship.end = new Coordinate(5,8);

        computer_submarine.start = new Coordinate(9,6);
        computer_submarine.end = new Coordinate(9,8);

        computer_clipper.start = new Coordinate(5,1);
        computer_clipper.end = new Coordinate(5,3);

        computer_dinghy.start = new Coordinate(1,1);
        computer_dinghy.end = new Coordinate(1,1);
    }

    public void randFire() {  //should this be ranamed to hardFire to match the ezFire? -Stewart
        int max = 10;
        int min = 1;
        Random random = new Random();
        int randRow = random.nextInt(max - min + 1) + min;
        int randCol = random.nextInt(max - min + 1) + min;

        Coordinate coor = new Coordinate(randRow,randCol);
        if(checkAIhit(randRow, randCol) || checkAImiss(randRow, randCol)){
            // check if random shot is repeated, if yes, recurse, if no, continue
            randFire();
        }else{
            //check if computers fire hits any player ship, if it does add to player hits. Otherwise add to player misses
            if(ACcover(coor) || BScover(coor) || CLcover(coor) || DHcover(coor) || SMcover(coor)){
                playerHits.add(coor);
            } else {
                playerMisses.add(coor);
                lasthit = false;
            }
        }
    }


    //each ship has a boolean to check whether the shot hits or misses, if hit, modify the game state
    public boolean ACcover(Coordinate coor){
        if(aircraftCarrier.covers(coor)){
            aircraftCarrier.shipHit();
            checkplayerhealth(aircraftCarrier.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean BScover(Coordinate coor){
        if (battleship.covers(coor)){
            battleship.shipHit();
            checkplayerhealth(battleship.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean CLcover(Coordinate coor){
        if (clipper.covers(coor)){
            clipper.shipHit();
            checkplayerhealth(clipper.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean DHcover(Coordinate coor){
        if (dinghy.covers(coor)){
            dinghy.shipHit();
            checkplayerhealth(dinghy.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean SMcover(Coordinate coor){
        if (submarine.covers(coor)){
            submarine.shipHit();
            checkplayerhealth(submarine.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public void hardfire(){
        if(aircraftCarrier.health != 0 || aircraftCarrier.health != 5){
            getnextpoint(aircraftCarrier.start, aircraftCarrier.end);
            if (ACcover(nextpoint)) {
                playerHits.add(nextpoint);
            }else{
                playerMisses.add(nextpoint);
                lasthit = false;
            }
        }else if(battleship.health != 0 || battleship.health != 4){
            getnextpoint(battleship.start, battleship.end);
            if (BScover(nextpoint)){
                playerHits.add(nextpoint);
            }else{
                playerMisses.add(nextpoint);
                lasthit = false;
            }
        }else if(submarine.health != 0 || submarine.health != 3){
            getnextpoint(submarine.start, submarine.end);
            if (SMcover(nextpoint)){
                playerHits.add(nextpoint);
            }else{
                playerMisses.add(nextpoint);
                lasthit = false;
            }
        }else{
            randFire();
        }
    }

    public Coordinate getnextpoint(Coordinate start, Coordinate end){
        nextpoint = null;
        int x = 0;
        int y = 0;
        if(start.Across == end.Across){
            x = start.Across;
            y = start.Across;
            while(checkAIhit(x, y) == true){
                y += 1;
            }
            nextpoint = new Coordinate(x, y);
            return nextpoint;
        }else{
            x = start.Across;
            y = start.Across;
            while (checkAIhit(x,y) == true){
                x += 1;
            }
            nextpoint = new Coordinate(x, y);
            return nextpoint;
        }
    }

    public void checkplayerhealth(int health){
        if(health == 0){
            playershipsank += 1;
        }else{}
    }

    public void checkcomputerhealth(int health){
        if(health == 0){
            computershipsank += 1;
        }else{}
    }


    public boolean checkfirepoint(int row, int col){
        int hitsize = computerHits.size();
        int missize = computerMisses.size();
        int i = 0;
        int j = 0;
        while( i < hitsize) {
            Coordinate z = computerHits.get(i);
            int xhit = z.Across;
            int yhit = z.Down;
            if (row == xhit && col == yhit){
                return true;
            }else{
                i += 1;
            }
        }
        while( j < missize){
            Coordinate m = computerMisses.get(j);
            int xmiss = m.Across;
            int ymiss = m.Down;
            if(row == xmiss && col == ymiss){
                return true;
            }else{
                j += 1;
            }
        }
        return false;
    }

    public boolean checkAIhit(int row, int col){
        int hitsize = playerHits.size();
        int i = 0;
        while( i < hitsize) {
            Coordinate z = playerHits.get(i);
            int xhit = z.Across;
            int yhit = z.Down;
            if (row == xhit && col == yhit){
                return true;
            }else{
                i += 1;
            }
        }
        return false;
    }

    public boolean checkAImiss(int row, int col){
        int missize = playerMisses.size();
        int j = 0;
        while( j < missize){
            Coordinate m = playerMisses.get(j);
            int xmiss = m.Across;
            int ymiss = m.Down;
            if(row == xmiss && col == ymiss){
                return true;
            }else{
                j += 1;
            }
        }
        return false;
    }

    public boolean scanPlayer(int row, int col ) { // Shouldn't the battleship and sub return false? Something for wednesday's meeting -Stewart
        Coordinate coor = new Coordinate(row,col);
        if((computer_aircraftCarrier.shipScan(coor))){
            return true;
        }else if ((computer_battleship.shipScan(coor))){
            return true;
        }else if ((computer_submarine.shipScan(coor))){
            return true;
        }else if ((computer_clipper.shipScan(coor))){
            return true;
        }else if ((computer_dinghy.shipScan(coor))){
            return true;
        } else {
            return false;
        }
    }
}
