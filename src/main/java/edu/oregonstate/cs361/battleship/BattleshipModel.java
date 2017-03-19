package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by michaelhilton on 1/4/17.
 */
public class BattleshipModel {

    protected MilitaryShip aircraftCarrier = new MilitaryShip("AircraftCarrier", 5, new Coordinate(0, 0), new Coordinate(0, 0), false);
    protected MilitaryShip battleship = new MilitaryShip("Battleship", 4, new Coordinate(0, 0), new Coordinate(0, 0), true);
    protected MilitaryShip submarine = new MilitaryShip("Submarine", 3, new Coordinate(0, 0), new Coordinate(0, 0), true);
    protected CivilianShip clipper = new CivilianShip("Clipper", 3, new Coordinate(0, 0), new Coordinate(0, 0));
    protected CivilianShip dinghy = new CivilianShip("Dinghy", 1, new Coordinate(0, 0), new Coordinate(0, 0));

    protected MilitaryShip computer_aircraftCarrier = new MilitaryShip("Computer_AircraftCarrier", 5, new Coordinate(0, 0), new Coordinate(0, 0), false);
    protected MilitaryShip computer_battleship = new MilitaryShip("Computer_Battleship", 4, new Coordinate(0, 0), new Coordinate(0, 0), true);
    protected MilitaryShip computer_submarine = new MilitaryShip("Computer_Submarine", 3,  new Coordinate(0, 0), new Coordinate(0, 0), true);
    protected CivilianShip computer_clipper = new CivilianShip("Computer_Clipper", 3,  new Coordinate(0, 0), new Coordinate(0, 0));
    protected CivilianShip computer_dinghy = new CivilianShip("Computer_Dinghy", 1,  new Coordinate(0, 0), new Coordinate(0, 0));

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

    public int getlength(String shipName) {
        if (shipName.equalsIgnoreCase("computer_aircraftCarrier")) {
            return computer_aircraftCarrier.length;
        }
        if (shipName.equalsIgnoreCase("computer_battleship")) {
            return computer_battleship.length;
        }
        if (shipName.equalsIgnoreCase("computer_clipper")) {
            return computer_clipper.length;
        }
        if (shipName.equalsIgnoreCase("computer_dinghy")) {
            return computer_dinghy.length;
        }
        if (shipName.equalsIgnoreCase("computer_submarine")) {
            return computer_submarine.length;
        } else {
            return 0;
        }
    }

    public void playerplaceship(String shipName, Coordinate start, Coordinate end){
        if (checkplayeroverlap(start,end)){
            getShip(shipName).setLocation(start,end);
        } else{
            error_message = "Ship is overlapping.\n Please pick another location.";
        }
    }

    public BattleshipModel placeShip(String shipName, String row, String col, String orientation, BattleshipModel currModel) {
        int rowint = Integer.parseInt(row);
        int colInt = Integer.parseInt(col);
        error_message = null;
        if(orientation.equals("horizontal")){
            if (shipName.equalsIgnoreCase("aircraftcarrier")) {
                playerplaceship("aircraftcarrier", new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+4));
            } if(shipName.equalsIgnoreCase("battleship")) {
                playerplaceship("battleship", new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+3));
            } if(shipName.equalsIgnoreCase("clipper")) {
                playerplaceship("clipper", new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+2));
            } if(shipName.equalsIgnoreCase("dinghy")) {
                playerplaceship("dinghy", new Coordinate(rowint,colInt),new Coordinate(rowint,colInt));
            }if(shipName.equalsIgnoreCase("submarine")) {
                playerplaceship("submarine", new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+2));
            }
        } else {
            //vertical
            if (shipName.equalsIgnoreCase("aircraftcarrier")) {
                playerplaceship("aircraftcarrier", new Coordinate(rowint,colInt),new Coordinate(rowint+4,colInt));
            } if(shipName.equalsIgnoreCase("battleship")) {
                playerplaceship(    "battleship", new Coordinate(rowint,colInt),new Coordinate(rowint+3,colInt));
            } if(shipName.equalsIgnoreCase("clipper")) {
                playerplaceship("clipper", new Coordinate(rowint,colInt),new Coordinate(rowint+2,colInt));
            } if(shipName.equalsIgnoreCase("dinghy")) {
                playerplaceship("dinghy", new Coordinate(rowint,colInt),new Coordinate(rowint,colInt));
            }if(shipName.equalsIgnoreCase("submarine")) {
                playerplaceship("submarine", new Coordinate(rowint,colInt),new Coordinate(rowint+2,colInt));
            }
        }
        return currModel;
    }

    //easy mode computer ships placement
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

    //hard mode computer ships placement
    public void hardplace(){
        hardgenerate("computer_aircraftCarrier");
        hardgenerate("computer_battleship");
        hardgenerate("computer_submarine");
        hardgenerate("computer_aircraftC");
        hardgenerate("computer_aircraftCarrier");
    }

    private void hardgenerate(String shipName){
        int max = 10;
        int min = 1;
        Random random = new Random();
        int randRow = random.nextInt(max - min + 1) + min;
        int randCol = random.nextInt(max - min + 1) + min;
        int x = randRow;
        int y = randCol;
        int orientation = random.nextInt(max - min +1) + min;
        int l =  getlength(shipName);
        Coordinate start = new Coordinate(randRow,randCol);
        if(orientation <= 5){//horizontal
            x = randRow + l - 1;}
        else{//vertical
            y = randCol + l - 1;}
        Coordinate end = new Coordinate(x, y);
        if(checkAIplace(start, end)){
            getShip(shipName).setLocation(start, end);
        }else{hardgenerate(shipName);}
    }

    private boolean checkplayeroverlap(Coordinate start, Coordinate end){
        int x = start.Across;
        int y = start.Down;
        int m = end.Across;
        int n = end.Down;
        Coordinate coor = new Coordinate(x,y);

        if(x == m){
            //vertical
            if (y == n){
                if (aircraftCarrier.covers(coor)|| battleship.covers(coor)|| submarine.covers(coor)|| clipper.covers(coor)|| dinghy.covers(coor)){
                    return false;
                }else{
                    return true;
                }
            }else{
                while(y < n){
                    if (aircraftCarrier.covers(coor)|| battleship.covers(coor)|| submarine.covers(coor)|| clipper.covers(coor)|| dinghy.covers(coor)){
                        return false;
                    }else{
                        y += 1;
                    }
                }
            }
        }else{
            //horizontal
            while(x < m){
                if (aircraftCarrier.covers(coor)|| battleship.covers(coor)|| submarine.covers(coor)|| clipper.covers(coor)|| dinghy.covers(coor)){
                    return false;
                }else{
                    x += 1;
                }
            }
        }
        return true;
    }

    private boolean checkAIplace(Coordinate start, Coordinate end){
        int x = start.Across;
        int y = start.Down;
        int m = end.Across;
        int n = end.Down;
        Coordinate coor = new Coordinate(x,y);

        if(x == m){
            //vertical
            if (y == n){
                if (computer_aircraftCarrier.covers(coor)|| computer_battleship.covers(coor)|| computer_submarine.covers(coor)|| computer_clipper.covers(coor)|| computer_dinghy.covers(coor)){
                    return false;
                }else{
                    return true;
                }
            }else{
                while(y < n){
                    if (computer_aircraftCarrier.covers(coor)|| computer_battleship.covers(coor)|| computer_submarine.covers(coor)|| computer_clipper.covers(coor)|| computer_dinghy.covers(coor)){
                        return false;
                    }else{
                        y += 1;
                    }
                }
            }
        }else{
            //horizontal
            while(x < m){
                if (computer_aircraftCarrier.covers(coor)|| computer_battleship.covers(coor)|| computer_submarine.covers(coor)|| computer_clipper.covers(coor)|| computer_dinghy.covers(coor)){
                    return false;
                }else{
                    x += 1;
                }
            }
        }
        return true;
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
        if (shipCover("aircraftCarrier",coor) || shipCover("battleship",coor) || shipCover("submarine", coor) || shipCover("clipper", coor) || shipCover("dinghy", coor)) {
            playerHits.add(coor);
        } else {
            playerMisses.add(coor);
        }

    }

    public void hardfire(){
        if(aircraftCarrier.health != 0 || aircraftCarrier.health != 5){
            getnextpoint(aircraftCarrier.start, aircraftCarrier.end);
            if (shipCover("aircraftCarrier",nextpoint)) {
                playerHits.add(nextpoint);
            }else{
                playerMisses.add(nextpoint);
                lasthit = false;
            }
        }else if(battleship.health != 0 || battleship.health != 4){
            getnextpoint(battleship.start, battleship.end);
            if (shipCover("battleship",nextpoint)){
                playerHits.add(nextpoint);
            }else{
                playerMisses.add(nextpoint);
                lasthit = false;
            }
        }else if(submarine.health != 0 || submarine.health != 3){
            getnextpoint(submarine.start, submarine.end);
            if (shipCover("submarine",nextpoint)){
                playerHits.add(nextpoint);
            }else{
                playerMisses.add(nextpoint);
                lasthit = false;
            }
        }else{
            randFire();
        }
    }

    public void randFire() {
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
            if(shipCover("aircraftCarrier",coor) || shipCover("battleship",coor) || shipCover("submarine", coor) || shipCover("clipper", coor) || shipCover("dinghy", coor)){
                playerHits.add(coor);
            } else {
                playerMisses.add(coor);
                lasthit = false;
            }
        }
    }


    //each ship has a boolean to check whether the shot hits or misses, if hit, modify the game state
    private boolean shipCover(String shipName, Coordinate coor){
        if(getShip(shipName).covers(coor)){
            getShip(shipName).shipHit();
            checkplayerhealth(getShip(shipName).health);
            lasthit = true;
            return true;
        }else{
            return false;
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

    public BattleshipModel setEzmode(String type, BattleshipModel currModel){
        if(type.equalsIgnoreCase("easy")){
            ezmode = true;
            ezPlace();
        }else{
            ezmode = false;
            hardplace();
        }
        return currModel;
    }
}
