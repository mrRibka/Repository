import java.util.Scanner;


public class Controller {
    // The Constants
    public static final String HELLO = "Hello";

    // The Regex
    // «nick@mail.com»
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // «http://www.my-site.com»
    public static final String REGEX_URL = "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$";
    // «+38(044)555-55-55»
    public static final String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";

    // Constructor
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        while(!model.GetGameStatus()){
            View.PrintInputMassage(model.GetLowerBound(), model.GetUpperBound());
             if (!sc.hasNextInt()){
                 View.PrintWrongInputData();
                 sc.next();
                 continue;
             }
            model.SetGuessNumber(sc.nextInt());

            if(model.NumberIsInRange()){
                View.PrintCompareResult(model.Compare());
            }
            else{
                View.PrintWrongInput();
            }
            if (model.GetGameStatus()){
                View.WinnerMassage();
            }
        }
        View.PrintStatistic(model.GetAttemptsInRange(), model.GetAttemptsNotInRange(), model.GetAttempts());
    }

    public View getView() {
        return view;
    }
}
