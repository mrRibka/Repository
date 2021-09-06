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
    Group InputStringValueWithScanner(String massage) {
        String input;
        Group[] groups = Group.values();
        view.PrintInputString(massage);
        while (sc.hasNext()) {
            input = sc.next();
            for (Group s : groups) {
                if (input.matches(s.getGroup())) {
                    return s;
                }
            }
            view.PrintWrongInput(massage);
        }
        return Group.DEFAULT;
    }
}
