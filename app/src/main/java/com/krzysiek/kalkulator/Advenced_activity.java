package com.krzysiek.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Advenced_activity extends AppCompatActivity implements View.OnClickListener{
    
    TextView Display;
    int clear_flag=0;
    String sign_flag="";
    int last_button = 0;
    Double total=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advenced);
        Button One = (Button) findViewById(R.id.b1);
        Button Two = (Button) findViewById(R.id.b2);
        Button Three = (Button) findViewById(R.id.b3);
        Button Four = (Button) findViewById(R.id.b4);
        Button Five = (Button) findViewById(R.id.b5);
        Button Six = (Button) findViewById(R.id.b6);
        Button Seven = (Button) findViewById(R.id.b7);
        Button Eight = (Button) findViewById(R.id.b8);
        Button Nine = (Button) findViewById(R.id.b9);
        Button Zero = (Button) findViewById(R.id.b0);
        Button Square = (Button) findViewById(R.id.Square);
        Button Percent = (Button) findViewById(R.id.Percent);
        Button Root = (Button) findViewById(R.id.Root);
        Button Score = (Button) findViewById(R.id.Score);
        Button Dot = (Button) findViewById(R.id.Dot);
        Button Prev = (Button) findViewById(R.id.Prev);
        Button Clear = (Button) findViewById(R.id.Clear);
        Button PlusMinus= (Button) findViewById(R.id.PlusMinus);
        Display = (TextView) findViewById(R.id.textView);

        One.setOnClickListener(this);
        Two.setOnClickListener(this);
        Three.setOnClickListener(this);
        Four.setOnClickListener(this);
        Five.setOnClickListener(this);
        Six.setOnClickListener(this);
        Seven.setOnClickListener(this);
        Eight.setOnClickListener(this);
        Nine.setOnClickListener(this);
        Zero.setOnClickListener(this);
        Root.setOnClickListener(this);
        Percent.setOnClickListener(this);
        Square.setOnClickListener(this);
        Score.setOnClickListener(this);
        Dot.setOnClickListener(this);
        Prev.setOnClickListener(this);
        Clear.setOnClickListener(this);
        PlusMinus.setOnClickListener(this);
    }
    public void ShowNum(String num){
        if(clear_flag==1){
            Display.setText(" ");
            clear_flag=0;
        }
        else if(Display.getText()=="0"){
            Display.setText(" ");
        }
        Display.setText(Display.getText() + num);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.b0){
            ShowNum("0");
        }
        else if (v.getId() == R.id.b1){
            ShowNum("1");
        }
        else if (v.getId() == R.id.b2){
            ShowNum("2");
        }
        else if (v.getId() == R.id.b3){
            ShowNum("3");
        }
        else if (v.getId() == R.id.b4){
            ShowNum("4");
        }
        else if (v.getId() == R.id.b5){
            ShowNum("5");
        }
        else if (v.getId() == R.id.b6){
            ShowNum("6");
        }
        else if (v.getId() == R.id.b7){
            ShowNum("7");
        }
        else if (v.getId() == R.id.b8){
            ShowNum("8");
        }
        else if (v.getId() == R.id.b9){
            ShowNum("9");
        }
        else if (v.getId() == R.id.Clear) {
            Display.setText("0");
            total=0.0;
            sign_flag="";
        }
        else if (v.getId() == R.id.Dot) {
            if (clear_flag == 1){
                Display.setText("");
                clear_flag = 0;
            }
            if (Display.getText().toString().indexOf(".")<0){
                Display.setText(Display.getText() + ".");
            }
        }
        else if (v.getId() == R.id.Prev) {
            if (Display.getText().toString().length()>0){
                int start = 0;
                int end = Display.getText().toString().length()-1;
                String newText = Display.getText().toString().substring(start, end);
                Display.setText(newText);
            }

        }
        else if(v.getId()==R.id.Score){
            Double newNumber = Double.parseDouble(Display.getText().toString());
            if(sign_flag == "%"){
                total = (total * newNumber)/100;
                Display.setText(total.toString());
            }
            sign_flag = "=";


        }
        else if(v.getId()==R.id.Root){
            Double newNumber = Double.parseDouble(Display.getText().toString());
            total = Math.sqrt(newNumber);
            Display.setText(total.toString());
        }
        else if(v.getId()==R.id.PlusMinus){
            Double newNumber = Double.parseDouble(Display.getText().toString());
            total = newNumber * (-1);
            Display.setText(total.toString());
        }
        else if(v.getId()==R.id.Square){
            Double newNumber = Double.parseDouble(Display.getText().toString());
            total = Math.pow(newNumber,2);
            Display.setText(total.toString());
        }
        else if(v.getId()==R.id.Percent){
            sign_flag = "%";
            clear_flag = 1; //set_flag
            Double newNumber = Double.parseDouble(Display.getText().toString());
            total = newNumber;
            Display.setText(total.toString());
        }
        last_button = v.getId();
    }
}