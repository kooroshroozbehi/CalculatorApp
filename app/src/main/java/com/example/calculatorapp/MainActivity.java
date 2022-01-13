package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultsTV;
    boolean continues;
    boolean clr;
    Double result = null;
    String workings = "";
    int opcounter = 0;
    Character operators[] = {'+', '-', 'x', '/', '^'};
    int pos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();

    }

    private void initTextViews() {
        /*workingsTV = (TextView)findViewById(R.id.workingsTextView);*/
        resultsTV = (TextView)findViewById(R.id.resultTextView);
        continues = false;
        clr = false;
    }

    private void setWorkings(String givenValue){

        workings = workings + givenValue;
        /*workingsTV.setText(workings);*/
        resultsTV.setText(workings);

            if(continues){
                workings = result + givenValue;
                resultsTV.setText(workings);
            }
        continues = false;

    }

    public void equalsOnClick(View view) {
        for(int i = 0; i < workings.length(); i++){
            for(int j = 0; j < operators.length; j++){
                if(workings.charAt(i) == operators[j]){
                  pos = i;
                }
            }
        }
        String int1Str = workings.substring(0,pos);
        String int2Str = workings.substring(pos + 1,workings.length());
        double double1 = Double.parseDouble(int1Str);
        double double2 = Double.parseDouble(int2Str);

        switch (workings.charAt(pos)){
            case '+':
                result = double1 + double2;
                break;
            case '-':
                result = double1 - double2;
                break;
            case 'x':
                result = double1 * double2;
                break;
            case '/':
                result = double1 / double2;
                break;
            case '^':
                result = Math.pow(double1, double2);
                break;


        }
        resultsTV.setText(result + "");
        continues = true;
        clr = true;
        opcounter = 0;



    }




    public void clearOnClick(View view){
        workings = "";
        resultsTV.setText("");
        continues = false;
        result = null;
        opcounter = 0;
    }



    public void percentOnClick(View view) {
        for(int i = 0; i < workings.length(); i++){
            for(int j = 0; j < operators.length; j++){
                if(workings.charAt(i) == operators[j]){
                    opcounter ++;
                    pos = i;
                }
            }
        }
        if(opcounter == 0){
            setWorkings("%");
            Double percent = null;
            for(int i = 0; i < workings.length(); i++){
                if(workings.charAt(i) == '%')
                    pos = i;
            }
            String numStr = workings.substring(0,pos);
            double num = Double.parseDouble(numStr);
            result = num / 100;
            resultsTV.setText(result + "");
            continues = true;
            clr = true;
        }
        else{
            String int1Str = workings.substring(0,pos);
            String int2Str = workings.substring(pos + 1,workings.length());
            double double1 = Double.parseDouble(int1Str);
            double double2 = Double.parseDouble(int2Str);

            switch (workings.charAt(pos)){
                case '+':
                    result = double1 + double2;
                    break;
                case '-':
                    result = double1 - double2;
                    break;
                case 'x':
                    result = double1 * double2;
                    break;
                case '/':
                    result = double1 / double2;
                    break;
                case '^':
                    result = Math.pow(double1, double2);
                    break;


            }

            result = result / 100;
            continues = true;
            setWorkings("");
            clr = true;
        }

    }

    public void powerOfOnClick(View view) {
        for(int i = 0; i < workings.length(); i++){
            for(int j = 0; j < operators.length; j++){
                if(workings.charAt(i) == operators[j]){
                    opcounter ++;
                    pos = i;
                }
            }
        }
        if(opcounter == 0){
            setWorkings("^");
            clr = false;
        }
        else{
            String int1Str = workings.substring(0,pos);
            String int2Str = workings.substring(pos + 1,workings.length());
            double double1 = Double.parseDouble(int1Str);
            double double2 = Double.parseDouble(int2Str);

            switch (workings.charAt(pos)){
                case '+':
                    result = double1 + double2;
                    break;
                case '-':
                    result = double1 - double2;
                    break;
                case 'x':
                    result = double1 * double2;
                    break;
                case '/':
                    result = double1 / double2;
                    break;
                case '^':
                    result = Math.pow(double1, double2);
                    break;


            }
            continues = true;
            setWorkings("^");
            clr = false;
        }
    }

    public void divisionOnClick(View view) {
        for(int i = 0; i < workings.length(); i++){
            for(int j = 0; j < operators.length; j++){
                if(workings.charAt(i) == operators[j]){
                    opcounter ++;
                    pos = i;
                }
            }
        }
        if(opcounter == 0){
            setWorkings("/");
            clr = false;
        }
        else{
            String int1Str = workings.substring(0,pos);
            String int2Str = workings.substring(pos + 1,workings.length());
            double double1 = Double.parseDouble(int1Str);
            double double2 = Double.parseDouble(int2Str);

            switch (workings.charAt(pos)){
                case '+':
                    result = double1 + double2;
                    break;
                case '-':
                    result = double1 - double2;
                    break;
                case 'x':
                    result = double1 * double2;
                    break;
                case '/':
                    result = double1 / double2;
                    break;
                case '^':
                    result = Math.pow(double1, double2);
                    break;


            }
            continues = true;
            setWorkings("/");
            clr = false;
        }
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
        if(clr){
            workings = "7";
            resultsTV.setText("7");
            clr = false;
        }

    }

    public void eightOnClick(View view) {
        setWorkings("8");
        if(clr){
            workings = "8";
            resultsTV.setText("8");
            clr = false;
        }
    }

    public void nineOnClick(View view) {
        setWorkings("9");
        if(clr){
            workings = "9";
            resultsTV.setText("9");
            clr = false;
        }
    }

    public void timesOnClick(View view) {
        for(int i = 0; i < workings.length(); i++){
            for(int j = 0; j < operators.length; j++){
                if(workings.charAt(i) == operators[j]){
                    opcounter ++;
                    pos = i;
                }
            }
        }
        if(opcounter == 0){
            setWorkings("x");
            clr = false;
        }
        else{
            String int1Str = workings.substring(0,pos);
            String int2Str = workings.substring(pos + 1,workings.length());
            double double1 = Double.parseDouble(int1Str);
            double double2 = Double.parseDouble(int2Str);

            switch (workings.charAt(pos)){
                case '+':
                    result = double1 + double2;
                    break;
                case '-':
                    result = double1 - double2;
                    break;
                case 'x':
                    result = double1 * double2;
                    break;
                case '/':
                    result = double1 / double2;
                    break;
                case '^':
                    result = Math.pow(double1, double2);
                    break;


            }
            continues = true;
            setWorkings("x");
            clr = false;
        }

    }

    public void fourOnClick(View view) {
        setWorkings("4");
        if(clr){
            workings = "4";
            resultsTV.setText("4");
            clr = false;
        }
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
        if(clr){
            workings = "5";
            resultsTV.setText("5");
            clr = false;
        }
    }

    public void sixOnClick(View view) {
        setWorkings("6");
        if(clr){
            workings = "6";
            resultsTV.setText("6");
            clr = false;
        }
    }

    public void minusOnClick(View view) {
        for(int i = 0; i < workings.length(); i++){
            for(int j = 0; j < operators.length; j++){
                if(workings.charAt(i) == operators[j]){
                    opcounter ++;
                    pos = i;
                }
            }
        }
        if(opcounter == 0){
            setWorkings("-");
            clr = false;
        }
        else{
            System.out.println(workings);
            String int1Str = workings.substring(0,pos);
            String int2Str = workings.substring(pos + 1,workings.length());
            double double1 = Double.parseDouble(int1Str);
            double double2 = Double.parseDouble(int2Str);

            switch (workings.charAt(pos)){
                case '+':
                    result = double1 + double2;
                    break;
                case '-':
                    result = double1 - double2;
                    break;
                case 'x':
                    result = double1 * double2;
                    break;
                case '/':
                    result = double1 / double2;
                    break;
                case '^':
                    result = Math.pow(double1, double2);
                    break;


            }
            continues = true;
            setWorkings("-");
            clr = false;
        }
    }

    public void oneOnClick(View view) {
        setWorkings("1");
        if(clr){
            workings = "1";
            resultsTV.setText("1");
            clr = false;
        }
    }

    public void twoOnClick(View view) {
        setWorkings("2");
        if(clr){
            workings = "2";
            resultsTV.setText("2");
            clr = false;
        }
    }

    public void threeOnClick(View view) {
        setWorkings("3");
        if(clr){
            workings = "3";
            resultsTV.setText("3");
            clr = false;
        }
    }

    public void plusOnClick(View view) {
        for(int i = 0; i < workings.length(); i++){
            for(int j = 0; j < operators.length; j++){
                if(workings.charAt(i) == operators[j]){
                    opcounter ++;
                    pos = i;
                }
            }
        }
        if(opcounter == 0){
            setWorkings("+");
            clr = false;
        }
        else{
            String int1Str = workings.substring(0,pos);
            String int2Str = workings.substring(pos + 1,workings.length());
            double double1 = Double.parseDouble(int1Str);
            double double2 = Double.parseDouble(int2Str);

            switch (workings.charAt(pos)){
                case '+':
                    result = double1 + double2;
                    break;
                case '-':
                    result = double1 - double2;
                    break;
                case 'x':
                    result = double1 * double2;
                    break;
                case '/':
                    result = double1 / double2;
                    break;
                case '^':
                    result = Math.pow(double1, double2);
                    break;


            }
            continues = true;
            setWorkings("+");
            clr = false;
        }
    }

    public void decimalOnClick(View view) {
        setWorkings(".");
        if(clr){
            workings = "0.";
            resultsTV.setText("0.");
            clr = false;
        }
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
        if(clr){
            workings = "0";
            resultsTV.setText("0");
            clr = false;
        }
    }
}