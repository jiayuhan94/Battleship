package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;

/**
 * Created by michaelhilton on 1/4/17.
 */
public class BattleshipModel {

    private Ship aircraftCarrier = new Ship("AircraftCarrier",5, new Coordinate(0,0),new Coordinate(0,0));
    private StealthShip battleship = new StealthShip("Battleship",4, new Coordinate(0,0),new Coordinate(0,0));
    private StealthShip submarine = new StealthShip("Submarine",3, new Coordinate(0,0),new Coordinate(0,0));
    private Civilian clipper = new Civilian("Clipper", 3, new Coordinate(0, 0), new Coordinate(0, 0));
    private Civilian dinghy = new Civilian("Dinghy", 1, new Coordinate(0,0), new Coordinate(0, 0));

    private Ship computer_aircraftCarrier = new Ship("Computer_AircraftCarrier",5, new Coordinate(2,2),new Coordinate(2,6));
    private StealthShip computer_battleship = new StealthShip("Computer_Battleship",4, new Coordinate(2,8),new Coordinate(5,8));
    private StealthShip computer_submarine = new StealthShip("Computer_Submarine",3, new Coordinate(9,6),new Coordinate(9,8));
    private Civilian computer_clipper = new Civilian("Computer_Clipper", 3, new Coordinate(5, 1), new Coordinate(5, 3));
    private Civilian computer_dinghy = new Civilian("Computer_Dinghy", 1, new Coordinate(1,1), new Coordinate(1, 1));

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

    public boolean ezmode = false;
    public boolean lasthit = false;
    public Coordinate nextpoint;


    public BattleshipModel() {
        playerHits = new ArrayList<>();
        playerMisses= new ArrayList<>();
        computerHits = new ArrayList<>();
        computerMisses= new ArrayList<>();
    }

    public static BattleshipModel ofStatus(String statusStr) {
        System.out.println("STRING");
        return null;
    }

    public Ship getShip(String shipName) {
        if (shipName.equalsIgnoreCase("aircraftcarrier")) {
            return aircraftCarrier;
        } if(shipName.equalsIgnoreCase("battleship")) {
            return battleship;
        } if(shipName.equalsIgnoreCase("clipper")) {
            return clipper;
        } if(shipName.equalsIgnoreCase("dinghy")) {
            return dinghy;
        }if(shipName.equalsIgnoreCase("submarine")) {
            return submarine;
        } else {
            return null;
        }
    }

    public BattleshipModel placeShip(String shipName, String row, String col, String orientation, BattleshipModel currModel) {
        int rowint = Integer.parseInt(row);
        int colInt = Integer.parseInt(col);
        error_message = null;
        if(orientation.equals("horizontal")){
            if (shipName.equalsIgnoreCase("aircraftcarrier")) {
                if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+4))){
                currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+4));
                } else{
                    error_message = "Ship is overlapping.\n Please pick another location.";
                }
            } if(shipName.equalsIgnoreCase("battleship")) {
                if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+3))){
                currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+3));
                } else{
                    error_message = "Ship is overlapping.\n Please pick another location.";
                }
            } if(shipName.equalsIgnoreCase("clipper")) {
                if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+2))){
                    currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+2));
                } else{
                    error_message = "Ship is overlapping.\n Please pick another location.";
                }
            } if(shipName.equalsIgnoreCase("dinghy")) {
                if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt))){
                    currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt));
                } else{
                    error_message = "Ship is overlapping.\n Please pick another location.";
                }
            }if(shipName.equalsIgnoreCase("submarine")) {
                if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+2))){
                    currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt+2));
                } else{
                    error_message = "Ship is overlapping.\n Please pick another location.";
                }
            }
        }else{
            //vertical
                if (shipName.equalsIgnoreCase("aircraftcarrier")) {
                    if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint+4,colInt))){
                        currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint+4,colInt));
                    } else{
                        error_message = "Ship is overlapping.\n Please pick another location.";
                    }
                } if(shipName.equalsIgnoreCase("battleship")) {
                    if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint+3,colInt))){
                        currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint+3,colInt));
                    } else{
                        error_message = "Ship is overlapping.\n Please pick another location.";
                    }
                } if(shipName.equalsIgnoreCase("clipper")) {
                    if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint+2,colInt))){
                        currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint+2,colInt));
                    } else{
                        error_message = "Ship is overlapping.\n Please pick another location.";
                    }
                } if(shipName.equalsIgnoreCase("dinghy")) {
                    if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt))){
                        currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint,colInt));
                    } else{
                        error_message = "Ship is overlapping.\n Please pick another location.";
                    }
                }if(shipName.equalsIgnoreCase("submarine")) {
                    if (checkplayeroverlap(new Coordinate(rowint,colInt),new Coordinate(rowint+2,colInt))){
                        currModel.getShip(shipName).setLocation(new Coordinate(rowint,colInt),new Coordinate(rowint+2,colInt));
                    } else{
                        error_message = "Ship is overlapping.\n Please pick another location.";
                    }
                }
        }
        return currModel;
    }

    public boolean checkplayeroverlap(Coordinate start, Coordinate end){
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
            if (x == m){
                if (aircraftCarrier.covers(coor)|| battleship.covers(coor)|| submarine.covers(coor)|| clipper.covers(coor)|| dinghy.covers(coor)){
                    return false;
                }else{
                    return true;
                }
            }else{
                while(x < m){
                    if (aircraftCarrier.covers(coor)|| battleship.covers(coor)|| submarine.covers(coor)|| clipper.covers(coor)|| dinghy.covers(coor)){
                        return false;
                    }else{
                        x += 1;
                    }
                }
            }
        }
        return true;
    }

    public void shootAtComputer(int row, int col) {
        Coordinate coor = new Coordinate(row,col);
        if(computer_aircraftCarrier.covers(coor)){
            computerHits.add(coor);
            computer_aircraftCarrier.health -= 1;
            checkcomputerhealth(computer_aircraftCarrier.health);
        }else if (computer_battleship.covers(coor)){
            computerHits.add(coor);
            computer_battleship.health -= 1;
            checkcomputerhealth(computer_battleship.health);
        }else if (computer_clipper.covers(coor)){
            computerHits.add(coor);
            computer_clipper.health -= 1;
            checkcomputerhealth(computer_clipper.health);
        }else if (computer_dinghy.covers(coor)){
            computerHits.add(coor);
            computer_dinghy.health -= 1;
            checkcomputerhealth(computer_dinghy.health);
        }else if (computer_submarine.covers(coor)){
            computerHits.add(coor);
            computer_submarine.health -= 1;
            checkcomputerhealth(computer_submarine.health);
        } else {
            computerMisses.add(coor);
        }
    }

    public void shootAtPlayer() {
        int max = 10;
        int min = 1;
        if(rowShoot < 10) {
            rowShoot += 1;
        }
        else if(rowShoot == max) {
            rowShoot = min;
            colShoot += 2;
            if(colShoot > max)
            {
                colShoot = 2;
            }
        }


        Coordinate coor = new Coordinate(rowShoot, colShoot);
        if(checkAIhit(rowShoot, colShoot) || checkAImiss(rowShoot, colShoot)){
            // check if random shot is repeated, if yes, recurse, if no, continue
            shootAtPlayer();
        }else{
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
            aircraftCarrier.health -= 1;
            checkplayerhealth(aircraftCarrier.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean BScover(Coordinate coor){
        if (battleship.covers(coor)){
            battleship.health -= 1;
            checkplayerhealth(battleship.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean CLcover(Coordinate coor){
        if (clipper.covers(coor)){
            clipper.health -= 1;
            checkplayerhealth(clipper.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean DHcover(Coordinate coor){
        if (dinghy.covers(coor)){
            dinghy.health -= 1;
            checkplayerhealth(dinghy.health);
            lasthit = true;
            return true;
        }else{
            return false;
        }
    }

    public boolean SMcover(Coordinate coor){
        if (submarine.covers(coor)){
            submarine.health -= 1;
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
            shootAtPlayer();
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

    public boolean scanPlayer(int row, int col ) {
        Coordinate coor = new Coordinate(row,col);
        if((computer_aircraftCarrier.covers(coor)) && (computer_aircraftCarrier.getStealth()==false)){
            return true;
        }else if ((computer_battleship.covers(coor))&& (computer_battleship.getStealth()==true)){
            return false;
        }else if ((computer_clipper.covers(coor)) && (computer_clipper.getStealth()==false)){
            return true;
        }else if ((computer_dinghy.covers(coor)) && (computer_dinghy.getStealth()==false)){
            return true;
        }else if ((computer_submarine.covers(coor))  && (computer_submarine.getStealth()==true)){
            return false;
        } else {
            return false;
        }
    }
}