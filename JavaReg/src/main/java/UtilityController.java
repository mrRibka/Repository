import java.util.Scanner;

public class UtilityController {
    private View view;
    private Scanner sc;


    public UtilityController(Scanner sc, View view){
        this.sc = sc;
        this.view = view;
    }
    String InputStringValueWithScanner(String massage, String regex){
        String res;
        view.PrintInputString(massage);
        while( !(sc.hasNext() && (res = sc.next()).matches(regex))){
            view.PrintWrongInput(massage);
        }

        return res;
    }
}
