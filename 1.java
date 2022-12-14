package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button btndiv,btnmul,btnsub,btnadd;
    Button btnequal,btndot,btnclear;
    EditText txtResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btn0=(Button)findViewById(R.id.btn0);
        btndiv=(Button)findViewById(R.id.btndiv);
        btnmul=(Button)findViewById(R.id.btnmul);
        btnsub=(Button)findViewById(R.id.btnsub);
        btnadd=(Button)findViewById(R.id.btnadd);
        btnequal=(Button)findViewById(R.id.btnequal);
        btndot=(Button)findViewById(R.id.btndot);
        btnclear=(Button)findViewById(R.id.btnclear);
        txtResults=(EditText) findViewById(R.id.Edittext);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnequal.setOnClickListener(this);
        btndot.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        txtResults.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btn1))
            txtResults.append("1");
        if(v.equals(btn2))
            txtResults.append("2");
        if(v.equals(btn3))
            txtResults.append("3");
        if(v.equals(btn4))
            txtResults.append("4");
        if(v.equals(btn5))
            txtResults.append("5");
        if(v.equals(btn6))
            txtResults.append("6");
        if(v.equals(btn7))
            txtResults.append("7");
        if(v.equals(btn8))
            txtResults.append("8");
        if(v.equals(btn9))
            txtResults.append("9");
        if(v.equals(btn0))
            txtResults.append("0");
        if(v.equals(btndiv))
            txtResults.append("/");
        if(v.equals(btnmul))
            txtResults.append("*");
        if(v.equals(btnsub))
            txtResults.append("-");
        if(v.equals(btnadd))
            txtResults.append("+");
        if(v.equals(btnclear))
            txtResults.setText("");
        if(v.equals(btndot))
            txtResults.append(".");
        if(v.equals(btnequal))
        {
            try {
                String data=txtResults.getText().toString();
                if(data.contains("/"))
                {
                    divide(data);
                }
                else if(data.contains("*"))
                {
                    mul(data);
                }
                else if (data.contains("+"))
                {
                    add(data);
                }
                else if(data.contains("-"))
                {
                    sub(data);
                }
            }
            catch (Exception e)
            {
                displayInvalidMessage("Invalid Input");
            }

    }
}


    private void sub(String data) {
        String[] operand=data.split("-");
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1-operand2;
            txtResults.setText(String.valueOf(Result));
        }
        else
            displayInvalidMessage("Invalid Input");
    }

    private void add(String data) {
        String[] operand=data.split(Pattern.quote("+"));
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1+operand2;
            txtResults.setText(String.valueOf(Result));
        }
        else
            displayInvalidMessage("Invalid Input");
    }

    private void mul(String data) {
        String[] operand=data.split(Pattern.quote("*"));
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1*operand2;
            txtResults.setText(String.valueOf(Result));
        }
        else
            displayInvalidMessage("Invalid Input");
    }

    private void divide(String data) {  
        String[] operand=data.split(Pattern.quote("/"));
        if(operand.length==2)
        {
            double operand1=Double.parseDouble(operand[0]);
            double operand2=Double.parseDouble(operand[1]);
            double Result=operand1/operand2;
            txtResults.setText(String.valueOf(Result));
        }
        else
            displayInvalidMessage("Invalid Input");
    }

    private void displayInvalidMessage(String invalid_input) {
        Toast.makeText(getBaseContext(),invalid_input, Toast.LENGTH_LONG).show();
    }
    }
