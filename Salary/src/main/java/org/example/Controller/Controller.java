package org.example.Controller;

import org.example.View.*;
import org.example.Model.*;
import java.util.Scanner;

public class Controller {
    private View view = new View();
    private Salary salary = new Salary();

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        view.printInput();
        salary.setFund(sc.nextInt());
    }
}
