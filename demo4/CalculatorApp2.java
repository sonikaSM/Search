package com.example.demo4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class CalculatorApp2 extends Application {
    //label for displaying result
    @FXML
    private Label lb;
    //checkers for testing
    @FXML
    private Label checker;
    @FXML
    private Label checker2;
    //String a;
    double c,b;
    // indicator for operations
    int indicator;
    //indicator (for not duplicating ++//--**)
    int indp=0;
    int indm=0;
    int indmt=0;
    int indd=0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calc-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 482, 655);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    //checking if the first char of string is 0
    private boolean check(){
        if (lb.getText().equals("0")){
            return true;
        }else return false;

    }
    private void SetText(String str) {
        if(check()){
            //lb.setText("");
            lb.setText(str);
        }else {
            String str2 = lb.getText();
            lb.setText(str2 + str);
        }
    }
    public void OnClick1(){
        SetText("1");
    }

    public void OnClick2(){
        SetText("2");
    }
    public void OnClick3(){
        SetText("3");
    }
    public void OnClick4(){
        SetText("4");
    }
    public void OnClick5(){
        SetText("5");
    }
    public void OnClick6(){
        SetText("6");
    }
    public void OnClick7(){
        SetText("7");
    }
    public void OnClick8(){
        SetText("8");
    }
    public void OnClick9(){
        SetText("9");
    }
    public void OnClick0(){
        SetText("0");
    }

    //getting value of the variable (string is converting into double, and become clean)
    private double getValue(){
        double g;
        g=Double.parseDouble(lb.getText());
        lb.setText("");
        return g;
    }

    public void OnClick_plus() {
        indm = 0;
        indmt = 0;
        indd = 0;

        if(indp==0) {
            indp++;
            c = getValue();
            SetText("+");
            indicator = 1;
        }else {Call();}
    }
    public void OnClick_minus() {
        indp = 0;
        indmt = 0;
        indd = 0;

        if(indm==0) {
            indm++;
            c = getValue();
            SetText("-");
            indicator = 1;
        }else {Call();}
    }

    private void Call() {
        System.out.println("Stop!");
    }

    public void OnClick_div() {
        indm=0;
        indp=0;
        indmt=0;

        if(indd==0) {
            indd++;
            c = getValue();
            indicator = 2;
        }else {Call();}
    }
    public void OnClick_mult() {
        indm=0;
        indp=0;
        indd=0;

        if(indmt==0) {
            indmt++;
            c = getValue();
            indicator = 3;
        }else {Call();}
    }
    public void OnClick_pt() {
        if(lb.getText().isEmpty()) SetText("0.") ;
        else if ( !lb.getText().contains(".")) {
            SetText(".");
        }else{ System.out.println("Error. Invalid input");}
    }
    public void OnClick_eq() {
        checker.setText(String.valueOf(c));

        indm=0;
        indp=0;
        indmt=0;
        indd = 0;

        if(!lb.getText().isEmpty()) {

            b = getValue();
            checker2.setText(String.valueOf(b));

            double result;

            switch (indicator) {
                case 1: {
                    result = plus(c, b);
                    lb.setText(String.valueOf(result));
                    break;
                }
                case (2): {
                    result = div(c, b);
                    lb.setText(String.valueOf(result));
                    break;
                }
                case (3): {
                    result = mult(c, b);
                    lb.setText(String.valueOf(result));
                    break;
                }
                default:
                    lb.setText("Something wrong!");
            }

        }
    }
    public void OnClickBack(){

        if(!lb.getText().isEmpty()){
            StringBuilder str = new StringBuilder(lb.getText());
            str.deleteCharAt(str.length()-1);
            lb.setText(str.toString());
        }else{ lb.setText("Error. Empty! ");}
    }
    private double plus(double x,double y) {
        //System.out.println(x+y);
        return x+y;
    }
    private double div(double x,double y) {
        //System.out.println(x/y);
        if(y!=0) return x/y;
        else {lb.setText("Division by NULL");return 1;}
    }
    private double mult(double x,double y) {
        //System.out.println(x*y);
        return x*y;
    }
    public void onClickClear(){
        indm=0;
        indp=0;
        indmt=0;
        indd = 0;

        lb.setText("");
    }


}