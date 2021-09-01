import java.util.Locale;
import java.util.ResourceBundle;

public class View implements ConstantString{
    static String MESSAGE_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME,
                    new Locale("en"));
                    //new Locale ("ua", "UA"));

    public void printMassage(String massage){System.out.println(massage);}
    public String concatenationString(String... massage){
        StringBuilder concatString = new StringBuilder();
        for(String v : massage){
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }
    public void PrintWrongInput(String massage){
        printMassage(concatenationString(
                bundle.getString(WRONG_INPUT_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(massage)
        ));
    }
    public void PrintInputString(String massage){
        printMassage(concatenationString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(massage)
        ));
    }
}
