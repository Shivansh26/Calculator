package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    };
    TextView txtCalculations;
    TextView txtResult;
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationResult;
    private String calculationString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber ="";
        calculationResult = 0;
        calculationString="";

        txtCalculations = (TextView)findViewById(R.id.txtCalculations);
        txtResult = (TextView)findViewById(R.id.txtResult);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnZero).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btnEqual:
                operatorIsTapped(OPERATOR.EQUAL);

                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationString = calculationString + " + ";

                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
                case R.id.btn6:
                    numberIsTapped(6);
                break;
            case R.id.btnMinus:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationString = calculationString + " - ";
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnMultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationString = calculationString + " * ";
                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btnZero:
                numberIsTapped(0);
                break;
            case R.id.btnDivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationString = calculationString + " / ";
                break;



        }
        txtCalculations.setText(calculationString);

    }
    private void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtResult.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculations.setText(calculationString);
    }
    private void operatorIsTapped(OPERATOR tappedOperator){
        if(currentOperator!=null) {
            if (currentNumber != "") {
                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case PLUS:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                        break;

                }
                stringNumberAtLeft = String.valueOf(calculationResult);
                txtResult.setText(stringNumberAtLeft);
                calculationString = stringNumberAtLeft;

            }
        }else{
            stringNumberAtLeft=currentNumber;
            currentNumber="";
        }
        currentOperator = tappedOperator;
    }
    private void clearTapped(){
        stringNumberAtLeft="";
        stringNumberAtRight="";
        calculationResult=0;
        currentNumber="";
        currentOperator=null;
        txtResult.setText("0");
        calculationString="0";

    }
}