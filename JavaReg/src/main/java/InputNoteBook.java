import java.util.Scanner;

public class InputNoteBook implements ConstantString{
    private View view;
    private Scanner sc;

    private User user = new User();

    public InputNoteBook(View view, Scanner sc){
        this.sc = sc;
        this.view = view;
    }
    public void InputNote() {
        UtilityController utilityController
                = new UtilityController(sc, view);
        user.setFirst_name(utilityController.InputStringValueWithScanner
                (FIRST_NAME, view.bundle.getString(REGEX_NAME)));
        user.setLast_name(utilityController.InputStringValueWithScanner
                (LAST_NAME, view.bundle.getString(REGEX_LAST_NAME)));
        user.setPatronymic(utilityController.InputStringValueWithScanner
                (PATRONYMIC, view.bundle.getString(REGEX_PATRONYMIC)));
        user.setNick(utilityController.InputStringValueWithScanner
                (NICK, view.bundle.getString(REGEX_NICK)));
        user.setGroup(utilityController.InputStringValueWithScanner
                (GROUP));
        user.setComment(utilityController.InputStringValueWithScanner
                (COMMENT, view.bundle.getString(REGEX_COMMENT)));
        user.setMobPhone(utilityController.InputStringValueWithScanner
                (FIRST_MOBILE_PHONE, view.bundle.getString(REGEX_FIRST_MOBILE_PHONE)));
        user.setE_mail(utilityController.InputStringValueWithScanner
                (E_MAIL, view.bundle.getString(REGEX_EMAIL)));
        user.setSkype(utilityController.InputStringValueWithScanner
                (SKYPE, view.bundle.getString(REGEX_SKYPE)));
        user.setFull_name(user.getLast_name() + " " + user.getFirst_name().substring(0, 1) + ".");
    }

        public void InputLogin(){
            UtilityController utilityController
                    = new UtilityController(sc, view);
       while(true){
           try {
               user.setLogin(utilityController.InputStringValueWithScanner
                       (LOGIN, view.bundle.getString(REGEX_LOGIN)));
               break;
           } catch (NotUniqueLoginException e){
               e.printStackTrace();
               view.PrintNotUniqueString(LOGIN);
               InputLogin();
               break;
           }
       }
    }
}
