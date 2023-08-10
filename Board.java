import java.util.*;
import java.lang.Math;
import java.io.*;

public class Board {
    
    public static boolean eSearch (ArrayList<Peg> code, Peg []guess) {
        ArrayList<Character> pins = new ArrayList<Character>();
        boolean cracked = false;
        
        //check for red pins
        for(int i = 0; i < 4; i++) {
            if(code.get(i).getColor() == guess[i].getColor()) {
                code.get(i).Count();
                guess[i].Count();
                pins.add('R');
            }
        }
        //returns code is cracked if all 4 pins are red
        if(pins.size() == 4) {
            cracked = true;
        }
        
        //checks for white pins
        for(int i = 0; i < 4; i++) {
            //^ iterator for code
            for(int j = 0; j < 4; j++) {
                //^ iterator for guess
                if(i != j) {
                    if(!code.get(i).getCounted() && !guess[j].getCounted()) {
                        if(code.get(i).getColor() == guess[j].getColor()) {
                            pins.add('W');
                            code.get(i).Count();
                            guess[j].Count();
                        }
                    }
                }
            }
        }
        
        //clears counted for next check
        code.get(0).clearCount();
        code.get(1).clearCount();
        code.get(2).clearCount();
        code.get(3).clearCount();
        guess[0].clearCount();
        guess[1].clearCount();
        guess[2].clearCount();
        guess[3].clearCount();
        
        //randomizes output of pins
        
        if(pins.size() == 0) {
            System.out.println("\nThere are no pins to output");
        }
        else {
            System.out.println("\nPins:");
            while(pins.size() > 0) {
                int rand = (int)(Math.random() * pins.size());
                System.out.println(pins.get(rand));
                pins.remove(rand);
            }
        }
        return cracked;
    }

    public static boolean mSearch (ArrayList<Peg> code, Peg []guess) {
        ArrayList<Character> pins = new ArrayList<Character>();
        boolean cracked = false;
        
        //check for red pins
        for(int i = 0; i < 4; i++) {
            if(code.get(i).getColor() == guess[i].getColor()) {
                code.get(i).Count();
                guess[i].Count();
                pins.add('R');
            }
        }
        //returns code is cracked if all 4 pins are red
        if(pins.size() == 4) {
            cracked = true;
        }
        
        //checks for white pins
        for(int i = 0; i < 4; i++) {
            //^ iterator for code
            for(int j = 0; j < 4; j++) {
                //^ iterator for guess
                if(i != j) {
                    if(!code.get(i).getCounted() && !guess[j].getCounted()) {
                        if(code.get(i).getColor() == guess[j].getColor()) {
                            pins.add('W');
                            code.get(i).Count();
                            guess[j].Count();
                        }
                    }
                }
            }
        }
        
        //clears counted for next check
        code.get(0).clearCount();
        code.get(1).clearCount();
        code.get(2).clearCount();
        code.get(3).clearCount();
        guess[0].clearCount();
        guess[1].clearCount();
        guess[2].clearCount();
        guess[3].clearCount();
        
        //randomizes output of pins
        
        if(pins.size() == 0) {
            System.out.println("\nThere are no pins to output");
        }
        else {
            System.out.println("\nPins:");
            while(pins.size() > 0) {
                int rand = (int)(Math.random() * pins.size());
                System.out.println(pins.get(rand));
                pins.remove(rand);
            }
        }
        return cracked;
    }
    
    public static boolean hSearch (ArrayList<Peg> code, Peg []guess) {
        ArrayList<Character> pins = new ArrayList<Character>();
        boolean cracked = false;
        
        //check for red pins
        for(int i = 0; i < 6; i++) {
            if(code.get(i).getColor() == guess[i].getColor()) {
                code.get(i).Count();
                guess[i].Count();
                pins.add('R');
            }
        }
        //returns code is cracked if all 4 pins are red
        if(pins.size() == 6) {
            cracked = true;
        }
        
        //checks for white pins
        for(int i = 0; i < 6; i++) {
            //^ iterator for code
            for(int j = 0; j < 6; j++) {
                //^ iterator for guess
                if(i != j) {
                    if(!code.get(i).getCounted() && !guess[j].getCounted()) {
                        if(code.get(i).getColor() == guess[j].getColor()) {
                            pins.add('W');
                            code.get(i).Count();
                            guess[j].Count();
                        }
                    }
                }
            }
        }
        
        //clears counted for next check
        code.get(0).clearCount();
        code.get(1).clearCount();
        code.get(2).clearCount();
        code.get(3).clearCount();
        code.get(4).clearCount();
        code.get(5).clearCount();
        guess[0].clearCount();
        guess[1].clearCount();
        guess[2].clearCount();
        guess[3].clearCount();
        guess[4].clearCount();
        guess[5].clearCount();
        
        //randomizes output of pins
        
        if(pins.size() == 0) {
            System.out.println("\nThere are no pins to output");
        }
        else {
            System.out.println("\nPins:");
            while(pins.size() > 0) {
                int rand = (int)(Math.random() * pins.size());
                System.out.println(pins.get(rand));
                pins.remove(rand);
            }
        }
        return cracked;
    }
    
    public static void main(String[] args) {
        //mastermind game with difficulty settings
        //easy - 4 pegs, 4 colors, 10 guesses
        //medium (normal) - 4 pegs, 6 colors, 10 guesses
        //hard - 6 pegs, 8 colors. 16 guesses
        Scanner Kb = new Scanner (System.in);
        String prompt_ans = "";
        
        //Prompt introduces rules if necessary
        System.out.println("This is mastermind.");
        System.out.println("Do you need the rules to this game (Y/N)");
        prompt_ans = Kb.next();
        if(prompt_ans.equals("Y") || prompt_ans.equals("Yes")) {
            System.out.println("The computer will determine a random code made out of a given amount of colors");
            System.out.println("Your will have a given amount of tries to guess this code (# of guesses changes with difficulty)");
            System.out.println("You will get a (W)hite pin for every color that is present in the computer's code but in the wrong position");
            System.out.println("You will get a (R)ed pin for every color that is in the same position as the computer's code.");
            System.out.println("The order these pins are outputted has no relation to which spots are right/wrong");
        }
        
        //Explains difficulties if required
        System.out.println("\nThere are 3 difficulties: easy, medium(normal), hard.");
        System.out.println("Would you like desrciptions of these difficulties (Y/N)");
        prompt_ans = Kb.next();
        if(prompt_ans.equals("Y") || prompt_ans.equals("Yes")) {
            System.out.println("\nEasy:");
            System.out.println("You will have 10 guesses\n4 pegs in a row/code\n4 colors to choose from");
            System.out.println("\nMedium:");
            System.out.println("This is the standard board game version");
            System.out.println("You will have 10 guesses\n4 pegs in a row/code\n6 colors to choose from");
            System.out.println("\nHard:");
            System.out.println("You will have 16 guesses\n6 pegs in a row/code\n8 colors to choose from");
        }
        
        //Difficulty selection
        boolean typo = true;
        do {
            System.out.println("\nPlease select your difficulty.");
            System.out.println("Type in \"Easy\", \"Medium\", or \"Hard\".");
            prompt_ans = Kb.next();
            if(prompt_ans.equals("Easy")) {
                typo = false;
            }
            else if(prompt_ans.equals("Medium")) {
                typo = false;
            }
            else if(prompt_ans.equals("Hard")) {
                typo = false;
            }
            else {
                System.out.println("You made a typo, please type it in based on what is inside the quotation marks (This is Case Sensitive).");
            }
        } while(typo);
        
        char difficulty = prompt_ans.charAt(0);
        
        //Arraylist for computer's code
        ArrayList<Peg> code = new ArrayList<Peg>();
        
        //turn counter
        int turn = 1;
        //checks if code has been broken
        boolean cracked = false;
        
        //main looped process, each conditional is different difficulty
        
        if(difficulty == 'E') {
            //easy difficulty
            
            //output colors
            System.out.println("\nColors (Input as capital first letter of word):");
            System.out.println("Red (R)");
            System.out.println("Blue (B)");
            System.out.println("Green (G)");
            System.out.println("Yellow (Y)");
            
            //create code
            for(int i = 0; i < 4; i++) {
                int rand = (int)(Math.random() * 4);
                if(rand == 0) {
                    Peg pegR = new Peg('R');
                    code.add(pegR);
                }
                else if(rand == 1) {
                    Peg pegB = new Peg('B');
                    code.add(pegB);
                }
                else if(rand == 2) {
                    Peg pegG = new Peg('G');
                    code.add(pegG);
                }
                else {
                    Peg pegY = new Peg('Y');
                    code.add(pegY);
                }
            }
            
            //goes through turns
            int turnsL = 10;
            while(turn <= 10 && !cracked) {
                System.out.println("\nTurn " + turn + ":");
                System.out.println("You have " + turnsL + " turns left");
                System.out.println("\nType in your code, leave no spaces between each Character");
                prompt_ans = Kb.next();
                prompt_ans = prompt_ans.toUpperCase();
                Peg[] guess = new Peg[4];
                for(int i = 0; i < 4; i++) {
                    Peg pegGuess = new Peg(prompt_ans.charAt(i));
                    guess[i] = pegGuess;
                }
                cracked = eSearch(code, guess);
                turn++;
                turnsL--;
            }
            
            //output for when game is over
            if(cracked) {
                System.out.println("\nGood job you cracked the code.\nThe Code: ");
                for(int i = 0; i < 4; i++) {
                    System.out.println(code.get(i).getColor() + " ");
                }
                System.out.println("\nYou had " + turnsL + " turns left. Good Job");
            }
            else {
                System.out.println("\nYou could not crack the code in enough turns.");
                System.out.println("\nThe Code: ");
                for(int i = 0; i < 4; i++) {
                    System.out.print(code.get(i).getColor() + " ");
                }
            }
        }
        else if(difficulty == 'M') {
            //medium difficulty
            
            //output colors
            System.out.println("\nColors (Input as capital first letter of word):");
            System.out.println("Red (R)");
            System.out.println("Blue (B)");
            System.out.println("Green (G)");
            System.out.println("Yellow (Y)");
            System.out.println("Pink (P)");
            System.out.println("Orange (O)");
            
            //create code
            for(int i = 0; i < 4; i++) {
                int rand = (int)(Math.random() * 6);
                if(rand == 0) {
                    Peg pegR = new Peg('R');
                    code.add(pegR);
                }
                else if(rand == 1) {
                    Peg pegB = new Peg('B');
                    code.add(pegB);
                }
                else if(rand == 2) {
                    Peg pegG = new Peg('G');
                    code.add(pegG);
                }
                else if(rand == 3) {
                    Peg pegY = new Peg('Y');
                    code.add(pegY);
                }
                else if(rand == 4) {
                    Peg pegP = new Peg('P');
                    code.add(pegP);
                }
                else {
                    Peg pegO = new Peg('O');
                    code.add(pegO);
                }
            }
            
            //goes through turns
            int turnsL = 10;
            while(turn <= 10 && !cracked) {
                System.out.println("\nTurn " + turn + ":");
                System.out.println("You have " + turnsL + " turns left");
                System.out.println("\nType in your code, leave no spaces between each Character");
                prompt_ans = Kb.next();
                prompt_ans = prompt_ans.toUpperCase();
                Peg[] guess = new Peg[4];
                for(int i = 0; i < 4; i++) {
                    Peg pegGuess = new Peg(prompt_ans.charAt(i));
                    guess[i] = pegGuess;
                }
                cracked = mSearch(code, guess);
                turn++;
                turnsL--;
            }
            
            //output for when game is over
            if(cracked) {
                System.out.println("\nGood job you cracked the code.\nThe Code: ");
                for(int i = 0; i < 4; i++) {
                    System.out.println(code.get(i).getColor() + " ");
                }
                System.out.println("\nYou had " + turnsL + " turns left. Good Job");
            }
            else {
                System.out.println("\nYou could not crack the code in enough turns.");
                System.out.println("\nThe Code: ");
                for(int i = 0; i < 4; i++) {
                    System.out.print(code.get(i).getColor() + " ");
                }
            }
        }
        else {
            //hard difficulty
            
            //output colors
            System.out.println("\nColors (Input as capital first letter of word):");
            System.out.println("Red (R)");
            System.out.println("Blue (B)");
            System.out.println("Green (G)");
            System.out.println("Yellow (Y)");
            System.out.println("Pink (P)");
            System.out.println("Orange (O)");
            System.out.println("Violet (V)");
            System.out.println("White (W)");
            
            //create code
            for(int i = 0; i < 6; i++) {
                int rand = (int)(Math.random() * 8);
                if(rand == 0) {
                    Peg pegR = new Peg('R');
                    code.add(pegR);
                }
                else if(rand == 1) {
                    Peg pegB = new Peg('B');
                    code.add(pegB);
                }
                else if(rand == 2) {
                    Peg pegG = new Peg('G');
                    code.add(pegG);
                }
                else if(rand == 3) {
                    Peg pegY = new Peg('Y');
                    code.add(pegY);
                }
                else if(rand == 4) {
                    Peg pegP = new Peg('P');
                    code.add(pegP);
                }
                else if(rand == 5) {
                    Peg pegO = new Peg('O');
                    code.add(pegO);
                }
                else if(rand == 6) {
                    Peg pegB = new Peg('V');
                    code.add(pegB);
                }
                else {
                    Peg pegW = new Peg('W');
                    code.add(pegW);
                }
            }
            
            //goes through turns
            int turnsL = 16;
            while(turn <= 16 && !cracked) {
                System.out.println("\nTurn " + turn + ":");
                System.out.println("You have " + turnsL + " turns left");
                System.out.println("\nType in your code, leave no spaces between each Character");
                prompt_ans = Kb.next();
                prompt_ans = prompt_ans.toUpperCase();
                Peg[] guess = new Peg[6];
                for(int i = 0; i < 6; i++) {
                    Peg pegGuess = new Peg(prompt_ans.charAt(i));
                    guess[i] = pegGuess;
                }
                cracked = hSearch(code, guess);
                turn++;
                turnsL--;
            }
            
            //output for when game is over
            if(cracked) {
                System.out.println("\nGood job you cracked the code.\nThe Code: ");
                for(int i = 0; i < 6; i++) {
                    System.out.println(code.get(i).getColor() + " ");
                }
                System.out.println("\nYou had " + turnsL + " turns left. Good Job");
            }
            else {
                System.out.println("\nYou could not crack the code in enough turns.");
                System.out.println("\nThe Code: ");
                for(int i = 0; i < 6; i++) {
                    System.out.print(code.get(i).getColor() + " ");
                }
            }
        }
    }
}