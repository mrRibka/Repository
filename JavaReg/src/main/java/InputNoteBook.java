import java.util.Scanner;

public class InputNoteBook implements ConstantString{
    private View view;
    private Scanner sc;

    private String firstName;

    public InputNoteBook(View view, Scanner sc){
        this.sc = sc;
        this.view = view;
    }
    public void InputNote(){
        UtilityController utilityController
                = new UtilityController(sc, view);
        this.firstName = utilityController.InputStringValueWithScanner(FIRST_NAME, REGEX_NAME);
    }
}
