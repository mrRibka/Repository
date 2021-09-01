import java.util.ArrayList;

public class Model {
    private static int value = (int) (Math.random()*100);
    private int guessNumber;
    private boolean gameIsOver = false;
    private int upperBound = 100;
    private int lowerBound = 0;
    private int attemptsInRange = 0;
    private int attemptsNotInRange = 0;
    private ArrayList<Integer> attempts = new ArrayList<Integer>();

    // The Program log
    public void SetValue(int value){
        Model.value = value;
    }
    public int GetAttemptsInRange(){
        return attemptsInRange;
    }
    public ArrayList<Integer> GetAttempts(){
        return attempts;
    }
    public int GetAttemptsNotInRange(){
        return attemptsNotInRange;
    }
    public int GetValue(){
        return value;
    }
    public int GetUpperBound(){
        return upperBound;
    }
    public int GetLowerBound(){
        return lowerBound;
    }
    public boolean GetGameStatus(){
        return gameIsOver;
    }
    public void SetGuessNumber(int guessNumber){
        this.guessNumber = guessNumber;
    }
    public boolean NumberIsInRange(){
        if (guessNumber >= lowerBound && guessNumber <= upperBound) {
            attemptsInRange++;
            attempts.add(guessNumber);
            return true;
        } else {
            attemptsNotInRange++;
            attempts.add(guessNumber);
            return false;
        }
    }
    public String Compare(){
        if(value == guessNumber){
            gameIsOver = true;
        }
        else if(value < guessNumber){
            upperBound = guessNumber - 1;
            return "less";
        }
        else if(value > guessNumber){
            lowerBound = guessNumber;
            return "greater";
        }
        return "equal";
    }
}