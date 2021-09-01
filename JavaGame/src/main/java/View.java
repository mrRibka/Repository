import java.util.ArrayList;

public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Make your guess in range: ";
    public static final String WINNER_MASSAGE = "Winner winner chicken dinner!!!";
    public static final String WRONG_INPUT = "Number is not in range, try again!";
    public static final String WRONG_INPUT_DATA = "Input integer number";
    public static final String COMPARE_RESULT = "Our number is ";

    public static void PrintInputMassage(int lowerBound, int upperBound){
        System.out.println(INPUT_INT_DATA + lowerBound + "-" + upperBound);
    }
    public static void WinnerMassage(){
        System.out.println(WINNER_MASSAGE);
    }
    public static void PrintWrongInput(){
        System.out.println(WRONG_INPUT);
    }
    public static void PrintCompareResult(String result){
        System.out.println(COMPARE_RESULT + result);
    }
    public static void PrintWrongInputData(){
        System.out.println(WRONG_INPUT_DATA);
    }
    public static void PrintStatistic(int attemptsInRange, int attemptsNotInRange, ArrayList<Integer> attempts){
        System.out.println("Stats:");
        System.out.print("Attempts: ");
        for (int i = 0; i <= attempts.size() - 1; i++){
            System.out.print(attempts.get(i) + " ");
        }
        System.out.println(" ");
        System.out.println("Total attempts:" + (attemptsInRange + attemptsNotInRange));
        System.out.println("Attempts in range:" + attemptsInRange);
        System.out.println("Attempts not in range:" + attemptsNotInRange);
    }
}
