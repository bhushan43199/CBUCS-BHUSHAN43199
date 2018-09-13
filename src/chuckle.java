import java.util.Scanner;
import java.util.Random;

public class chuckle
{
    private static final Random randomNumber = new Random();
    private static final Scanner input = new Scanner( System.in );
    public static int s1; //declaring the variables that will be used in the
    //selecting which dice to re-roll
    public static int rollPerTurn; //declaring variable to keep track of rolls per turn
    private static int [] dice = new int [1]; //declaring an int array representing the 1 dice
    public static void main( String args[] )
    {
        while (true){
            //creating a menu
            System.out.println("********Menu********");
            System.out.println("1. Play Yahtzee");
            System.out.println("2. Help");
            System.out.println("3. Quit");
            System.out.println("********************");
            int selection = input.nextInt();
            if ( selection == 1){
                firstRoll();
                break; //if 1 is selected start game and end the menu
            }
            else if ( selection == 2){
                yahtzeeHelp(); // if 2 display "help" screen and go back to menu
            }
            else if ( selection == 3 ){
                break; //end game
            }
            else{
                System.out.println("No such selection");
            }
        }
        while ( rollPerTurn < 3 ){
            System.out.println();
            s1 = input.nextInt();//obtaining input to determine which dice to re-roll
            reRoll();
        }
    }

    public static int firstRoll() //method to roll 5 dice
    {
        for ( int i = 0; i < dice.length; i++){
            dice[i] = rollDice();
        }
        System.out.println("Select which dice to reroll.");
        for ( int a = 0; a < dice.length; a++ ){
            System.out.print(dice[a] + " " );
        }
        rollPerTurn = 1; //indicating this is the first roll
        return rollPerTurn;
    }
    public static int [] reRoll() //method to re-roll certain dice
    {
        if ( s1 == 1 ){
            dice[0] = rollDice(); //re-roll Die 1
        }
        rollPerTurn++;
        for ( int b = 0; b < dice.length; b++ ){
            System.out.print(dice[b] + " " ); //displaying the dice after re-roll
        }
        return dice;
    }
    public static int rollDice() //method to roll a die
    {
        int die = 1 + randomNumber.nextInt( 6 );
        return die;
    }
    public static void yahtzeeHelp() //the "help" screen
    {
        System.out.println("Your dice will show up and you will input a 1 or a 0");
        System.out.println("under each die.  A 1 indicates you wish to re-roll");
        System.out.println("that particular die, and a 0 means you wish to keep it.");
    }
}