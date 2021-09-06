import java.util.Scanner;

public class InputNoteBook implements ConstantString{
    private View view;
    private Scanner sc;

    private String first_name;
    private String last_name;
    private String patronymic;
    private String nick;
    private String comment;
    private Group group;
    private String mobPhone;
    private String e_mail;
    private String skype;
    private String full_name;

    public InputNoteBook(View view, Scanner sc){
        this.sc = sc;
        this.view = view;
    }
    public void InputNote(){
        UtilityController utilityController
                = new UtilityController(sc, view);
       first_name = utilityController.InputStringValueWithScanner
                (FIRST_NAME, view.bundle.getString(REGEX_NAME));
        last_name = utilityController.InputStringValueWithScanner
                (LAST_NAME, view.bundle.getString(REGEX_LAST_NAME));
        patronymic = utilityController.InputStringValueWithScanner
                (PATRONYMIC, view.bundle.getString(REGEX_PATRONYMIC));
        nick = utilityController.InputStringValueWithScanner
                (NICK, view.bundle.getString(REGEX_NICK));
        group = utilityController.InputStringValueWithScanner
                (GROUP);
        comment = utilityController.InputStringValueWithScanner
                (COMMENT, view.bundle.getString(REGEX_COMMENT));
        mobPhone = utilityController.InputStringValueWithScanner
                (FIRST_MOBILE_PHONE, view.bundle.getString(REGEX_FIRST_MOBILE_PHONE));
        e_mail = utilityController.InputStringValueWithScanner
                (E_MAIL, view.bundle.getString(REGEX_EMAIL));
        skype = utilityController.InputStringValueWithScanner
                (SKYPE, view.bundle.getString(REGEX_SKYPE));
        full_name = last_name + " " + first_name.substring(0, 1) + ".";

    }
}
