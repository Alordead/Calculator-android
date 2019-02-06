package com.example.speal.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Now this code is better than it was I think, but sure it's not enough :)

public class MainActivity extends AppCompatActivity {

    public static char SUB = '-';
    public static char MUL = '*';
    public static char DIV = '/';
    public static char ADD = '+';

    private TextView infoTextView;
    private TextView resultTextView;
    private TextView equalsTextView;

    private Boolean operationModeEnabled = false, isDot = false;
    private String value = "", previousValue = "0";
    private Character operationType = 'x';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;

        setContentView(R.layout.activity_main);
        decorView.setSystemUiVisibility(uiOptions);
        setupUIViews();
    }

    private void setupUIViews() {
        infoTextView = findViewById(R.id.txResult);
        resultTextView = findViewById(R.id.txControl);
        equalsTextView = findViewById(R.id.text_wa);
    }

    private void doOperationWithButton(Integer buttonNumber) {
        if (infoTextView.getText().toString().isEmpty()) { resultTextView.setText(""); }
        infoTextView.setText(infoTextView.getText().toString() + buttonNumber.toString());
        value = value + buttonNumber.toString();
        if (operationType != 'x') {
            resultTextView.setText(handleMathOperation(operationType, resultTextView.getText().toString(), value));
            previousValue = value;
        } else {
            resultTextView.setText(value);
        }
        operationModeEnabled = false;
    }

    private void equalsButtonTapped() {
        infoTextView.setText("");
        operationType='x';
        value="";
        operationModeEnabled = false;
        isDot = false;
    }

    private void dotButtonTapped() {
        if(!isDot && value.length() != 0) {
            infoTextView.setText(infoTextView.getText().toString() + ".");
            value += ".";
        } else if (!isDot && value.length() == 0)
        {
            infoTextView.setText(infoTextView.getText().toString() + "0" + ".");
            value += "0.";
        }
        isDot = true;
    }

    private void operationButtonTapped(char operationChar) {
        if (infoTextView.getText().toString().isEmpty()) {
            if (resultTextView.getText().toString().isEmpty()) {
                infoTextView.setText(infoTextView.getText().toString()+'0');
            } else {
                infoTextView.setText(infoTextView.getText().toString()+ resultTextView.getText().toString());
            }
            value = value + "0";
            previousValue = value;
            isDot = false;
            operationModeEnabled = false;
        }
        if (!operationModeEnabled) {
            infoTextView.setText(infoTextView.getText().toString() + operationChar);
            value = "";
            operationModeEnabled = true;
            operationType = operationChar;
            previousValue = "0";
            isDot = false;
        } else if (operationModeEnabled && operationType != operationChar) {
            String str_oper = infoTextView.getText().toString();
            String str_oper2 = str_oper.substring(0,str_oper.length()-1)+ operationChar;
            infoTextView.setText(str_oper2);

            value = "";
            operationModeEnabled = true;
            operationType = operationChar;
            previousValue = "0";
            isDot = false;
        }
    }

    public void buttonOnClick(View v) {
        resultTextView.setVisibility(View.VISIBLE);
        infoTextView.setVisibility(View.VISIBLE);
        equalsTextView.setVisibility(View.VISIBLE);
        switch (v.getId()) {
            case R.id.button0:
                if (infoTextView.getText().toString().isEmpty()) { resultTextView.setText(""); }
                if (isDot || value.equals("0")) { doOperationWithButton(0); }
                break;
            case R.id.button1:
                doOperationWithButton(1);
                break;
            case R.id.button2:
                doOperationWithButton(2);
                break;
            case R.id.button3:
                doOperationWithButton(3);
                break;
            case R.id.button4:
                doOperationWithButton(4);
                break;
            case R.id.button5:
                doOperationWithButton(5);
                break;
            case R.id.button6:
                doOperationWithButton(6);
                break;
            case R.id.button7:
                doOperationWithButton(7);
                break;
            case R.id.button8:
                doOperationWithButton(8);
                break;
            case R.id.button9:
                doOperationWithButton(9);
                break;
            case R.id.buttonwa:
                equalsButtonTapped();
                break;
            case R.id.buttonpoint:
                dotButtonTapped();
                break;
            case R.id.buttonplus:
                operationButtonTapped(ADD);
                break;
            case R.id.buttonmin:
                operationButtonTapped(SUB);
                break;
            case R.id.buttonumn:
                operationButtonTapped(MUL);
                break;
            case R.id.buttondel:
                operationButtonTapped(DIV);
                break;
        }
    }
    private String handleMathOperation(char operationType, String value1, String value2) {
        double doubleValue = Double.NaN;
        switch (operationType) {
            case '+':
                doubleValue = Double.parseDouble(value1) + Double.parseDouble(value2) - Double.parseDouble(previousValue);
                break;
            case '-':
                doubleValue = Double.parseDouble(value1) - Double.parseDouble(value2) + Double.parseDouble(previousValue);
                break;
            case '*':
                doubleValue = Double.parseDouble(value1) * Double.parseDouble(value2);
                if (Double.parseDouble(previousValue) > 0) {
                    doubleValue = doubleValue / Double.parseDouble(previousValue);
                }
                break;
            case '/':
                doubleValue = Double.parseDouble(value1) / Double.parseDouble(value2);
                if (Double.parseDouble(previousValue) > 0) {
                    doubleValue = doubleValue * Double.parseDouble(previousValue);
                }
                break;
        }
        if (doubleValue % 1 == 0) {
            return Double.toString(doubleValue);
        } else {
            if (Double.toString(doubleValue).length() > 15) {
                String doubleParsedString = Double.toString(doubleValue).substring(0,15);
                Double tempDouble = Double.parseDouble(doubleParsedString);
                return tempDouble.toString();
            } else {
                return Double.toString(doubleValue);
            }
        }
    }
}