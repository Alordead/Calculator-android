package com.example.speal.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
    19.09.18
    Неправильно написан код работы калькулятора в принципе. Переписать.
 */

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView info;
    private TextView result;
    private TextView textwa;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;
    private int counter = 0;

    private boolean isOperation = false, isDot = false, isZero = false;
    private String value = "",
                   value_old = "0";
    Double Result;
    private char operationType = 'x';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setupUIViews();

        //ActionBar actionBar = getActionBar();
        //actionBar.hide();

    }

    private void setupUIViews(){
        info = (TextView)findViewById(R.id.txResult);
        result = (TextView)findViewById(R.id.txControl);
        textwa = (TextView)findViewById(R.id.text_wa);
    }

    public void buttonOnClick(View v) {
        result.setVisibility(View.VISIBLE);
        info.setVisibility(View.VISIBLE);
        textwa.setVisibility(View.VISIBLE);
        switch (v.getId()) {
            case R.id.button0:

                if (info.getText().toString().isEmpty()) { result.setText(""); }
                if (isDot == false && value == "0") {

                } else if (isDot == false && info.getText().toString().isEmpty() ) {
                    info.setText(info.getText().toString() + "0");
                    value = value + "0";
                    if (operationType != 'x') {
                        result.setText(operation(operationType, result.getText().toString(), value));
                        value_old = value;
                    } else {
                        result.setText(value);
                    }
                    isOperation = false;
                } else  {
                    info.setText(info.getText().toString() + "0");
                    value = value + "0";
                    if (operationType != 'x') {
                        result.setText(operation(operationType, result.getText().toString(), value));
                        value_old = value;
                    } else {
                        result.setText(value);
                    }
                    isOperation = false;
                }

                break;
            case R.id.button1:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "1");
                value = value + "1";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button2:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "2");
                value = value + "2";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button3:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "3");
                value = value + "3";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button4:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "4");
                value = value + "4";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button5:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "5");
                value = value + "5";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button6:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "6");
                value = value + "6";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button7:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "7");
                value = value + "7";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button8:
                if (info.getText().toString().isEmpty()) { result.setText(""); }
                info.setText(info.getText().toString() + "8");
                value = value + "8";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;
            case R.id.button9:
                if (info.getText().toString()=="") { result.setText(""); }
                info.setText(info.getText().toString() + "9");
                value = value + "9";
                if (operationType != 'x') {
                    result.setText(operation(operationType, result.getText().toString(), value));
                    value_old = value;
                } else {
                    result.setText(value);
                }
                isOperation = false;
                break;

            case R.id.buttonwa:
                info.setText("");
                operationType='x';
                value="";
                isOperation = false;
                isDot = false;
                isZero = false;
                break;
            case R.id.buttonpoint:
                if(isDot == false && value.length() != 0) {
                    info.setText(info.getText().toString() + ".");
                    value += ".";
                    isDot = true;
                } else if (isDot == false && value.length() == 0)
                {
                    info.setText(info.getText().toString() + "0" + ".");
                    value += "0.";
                    isDot = true;
                }
                break;

            case R.id.buttonplus:
                if (info.getText().toString().isEmpty()) {
                    if (result.getText().toString().isEmpty()) {
                        info.setText(info.getText().toString()+'0');
                    } else {
                        info.setText(info.getText().toString()+result.getText().toString());
                    }
                    value = value + "0";
                    value_old = value;
                    isDot = false;
                    isOperation = false;
                }
                if (isOperation == false) {
                    info.setText(info.getText().toString() + "+");
                   // Result = Double.parseDouble(result.getText().toString()) + Double.parseDouble(value);
                   // result.setText(Result.toString());
                    value = "";
                    isOperation = true;
                    operationType = '+';
                    value_old = "0";
                    isDot = false;
                } else if (isOperation == true && operationType != '+') {
                    String str_oper = info.getText().toString();
                    String str_oper2 = str_oper.substring(0,str_oper.length()-1)+'+';
                    info.setText(str_oper2);

                    value = "";
                    isOperation = true;
                    operationType = '+';
                    value_old = "0";
                    isDot = false;
                }
                break;
            case R.id.buttonmin:
                if (info.getText().toString().isEmpty()) {
                    if (result.getText().toString().isEmpty()) {
                        info.setText(info.getText().toString()+'0');
                    } else {
                        info.setText(info.getText().toString()+result.getText().toString());
                    }
                    value = value + "0";
                    value_old = value;
                    isDot = false;
                    isOperation = false;
                }
                if (isOperation == false) {
                    info.setText(info.getText().toString() + "-");
                  //  Result = Double.parseDouble(result.getText().toString()) - Double.parseDouble(value);
                    // result.setText(Result.toString());
                    value = "";
                    isOperation = true;
                    operationType = '-';
                    value_old = "0";
                    isDot = false;
                } else if (isOperation == true && operationType != '-') {
                    String str_oper = info.getText().toString();
                    String str_oper2 = str_oper.substring(0,str_oper.length()-1)+'-';
                    info.setText(str_oper2);

                    value = "";
                    isOperation = true;
                    operationType = '-';
                    value_old = "0";
                    isDot = false;
                }
                break;
            case R.id.buttonumn:
                if (info.getText().toString().isEmpty()) {
                    if (result.getText().toString().isEmpty()) {
                        info.setText(info.getText().toString()+'0');
                    } else {
                        info.setText(info.getText().toString()+result.getText().toString());
                    }
                    value = value + "0";
                    value_old = value;
                    isDot = false;
                    isOperation = false;
                }
                if (isOperation == false) {
                    info.setText(info.getText().toString() + "*");
                   // Result = Double.parseDouble(result.getText().toString()) * Double.parseDouble(value);
                  //  result.setText(Result.toString());
                    value = "";
                    isOperation = true;
                    operationType = '*';
                    value_old = "0";
                    isDot = false;
                } else if (isOperation == true && operationType != '*') {
                    String str_oper = info.getText().toString();
                    String str_oper2 = str_oper.substring(0,str_oper.length()-1)+'*';
                    info.setText(str_oper2);

                    value = "";
                    isOperation = true;
                    operationType = '*';
                    value_old = "0";
                    isDot = false;
                }
                break;
            case R.id.buttondel:
                if (info.getText().toString().isEmpty()) {
                    if (!result.getText().toString().isEmpty()) {
                        info.setText(info.getText().toString()+result.getText().toString());
                    } else {
                    info.setText(info.getText().toString()+'0');
                }
                    value = value + "0";
                    value_old = value;
                    isDot = false;
                    isOperation = false;
                }
                if (isOperation == false) {
                    info.setText(info.getText().toString() + "/");
                   // Result = Double.parseDouble(result.getText().toString()) / Double.parseDouble(value);
                  //  result.setText(Result.toString());
                    value = "";
                    isOperation = true;
                    operationType = '/';
                    value_old = "0";
                    isDot = false;
                } else if (isOperation == true && operationType != '/') {
                    String str_oper = info.getText().toString();
                    String str_oper2 = str_oper.substring(0,str_oper.length()-1)+'/';
                    info.setText(str_oper2);

                    value = "";
                    isOperation = true;
                    operationType = '/';
                    value_old = "0";
                    isDot = false;
                }
                break;
        }
    }
    private String operation(char  operationType, String value1, String value2) {
        Double db = Double.NaN;
        switch (operationType) {
            case '+':
                db = Double.parseDouble(value1) + Double.parseDouble(value2) - Double.parseDouble(value_old);
                break;
            case '-':
                db = Double.parseDouble(value1) - Double.parseDouble(value2) + Double.parseDouble(value_old);
                break;
            case '*':
                db = Double.parseDouble(value1) * Double.parseDouble(value2);
                if (Double.parseDouble(value_old)>0) {
                    db = db / Double.parseDouble(value_old);
                }
                break;
            case '/':
                db = Double.parseDouble(value1) / Double.parseDouble(value2);
                if (Double.parseDouble(value_old)>0) {
                    float getfloat =  db.floatValue() * Float.parseFloat(value_old);
                    db =(double)getfloat;
                }
                break;
        } /*
        Integer db_strlast = db.toString().indexOf(".0");
        String dbstr = db.toString();
        boolean zerostring = false;
        for (int i = db_strlast; i<=dbstr.length();i++)
        {
            if (dbstr.charAt(i) == 0) {
                zerostring = true;
            }
            else {
                zerostring = false;
                break;
            }
        }
        if (zerostring) {
            Integer idb = db.intValue();
            return idb.toString();
        }
        */
        if (db % 1 == 0) {
            Integer idb = db.intValue();
            return idb.toString();
        } else {
            if (db.toString().length()>15) {
                String db_str = db.toString().substring(0,15);
                db = Double.parseDouble(db_str);
                return db.toString();
            } else {
                return db.toString();
            }
        }
    }
    void button0_onclick() {


    }
}