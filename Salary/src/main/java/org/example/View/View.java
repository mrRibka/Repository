package org.example.View;

public class View {

    private String INPUT_MESSAGE = "Input ";
    private  String FUND_BUDGET = "Fund budget";

    public void printMessage(String msg){
        System.out.println(msg);
    }
    public String concatenationString(String... massage){
        StringBuilder concatString = new StringBuilder();
        for(String v : massage){
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }
    public void printInput(){
        printMessage(concatenationString(INPUT_MESSAGE, FUND_BUDGET));
    }
}
