import java.util.Scanner;

public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }
     public void User(){
         Scanner sc = new Scanner(System.in);
         InputNoteBook inputNoteBook = new InputNoteBook(view, sc);
         inputNoteBook.InputLogin();
     }
}
