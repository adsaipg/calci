package com.example.adarsh.calci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button butn1;
    private Button butn2;
    private Button butn3;
    private Button butn4;
    private Button butn5;
    private Button butn6;
    private Button butn7;
    private Button butn8;
    private Button butn9;
    private Button butn0;
    private Button butnequal;

    private Button butnclr;
    private Button butndivide;
    private Button butnmult;
    private Button butnadd;
    private Button butnsub;

    String str = "";
    String str1="";
    String str3="";
    Character op = null;
    double  num, numtemp;
    private TextView calciResult;
    private TextView calciEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butn1 = (Button) findViewById(R.id.buttn1);
        butn2 = (Button) findViewById(R.id.buttn2);
        butn3 = (Button) findViewById(R.id.buttn3);
        butn4 = (Button) findViewById(R.id.buttn4);
        butn5 = (Button) findViewById(R.id.buttn5);
        butn6 = (Button) findViewById(R.id.buttn6);
        butn7 = (Button) findViewById(R.id.buttn7);
        butn8 = (Button) findViewById(R.id.buttn8);
        butn9 = (Button) findViewById(R.id.buttn9);
        butn0 = (Button) findViewById(R.id.buttn0);

        butnclr = (Button) findViewById(R.id.buttndel);
        butndivide = (Button) findViewById(R.id.buttndiv);
        butnadd = (Button) findViewById(R.id.buttnadd);
        butnsub = (Button) findViewById(R.id.buttnsub);
        butnequal = (Button) findViewById(R.id.buttnequal);
        butnmult = (Button) findViewById(R.id.buttnmult);
        calciEnter = (TextView) findViewById(R.id.textid);
        calciResult = (TextView) findViewById(R.id.textid2);

        butn1.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(1);
                                     }
                                 }
        );
        butn2.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(2);
                                     }
                                 }
        );
        butn3.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(3);
                                     }
                                 }
        );
        butn4.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(4);
                                     }
                                 }
        );
        butn5.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(5);
                                     }
                                 }
        );
        butn6.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(6);
                                     }
                                 }
        );
        butn7.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(7);
                                     }
                                 }
        );
        butn8.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(8);
                                     }
                                 }
        );
        butn9.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(9);
                                     }
                                 }
        );
        butn0.setOnClickListener(new View.OnClickListener() {
            @Override

                                     public void onClick(View v) {
                                         insertvalue(0);
                                     }
                                 }
        );

        butnadd.setOnClickListener(new View.OnClickListener() {
            @Override

                                       public void onClick(View v) {


                                           op = '+';
                                           str=str+op;
                                           calciEnter.setText(str);
                                       }
                                   }
        );
        butnsub.setOnClickListener(new View.OnClickListener() {
            @Override

                                       public void onClick(View v) {


                                           op = '-';
                                           str=str+op;
                                           calciEnter.setText(str);
                                       }
                                   }
        );
        butnmult.setOnClickListener(new View.OnClickListener() {
            @Override

                                        public void onClick(View v) {


                                            op = 'x';
                                            str=str+op;
                                            calciEnter.setText(str);
                                        }
                                    }
        );
        butndivide.setOnClickListener(new View.OnClickListener() {
            @Override

                                          public void onClick(View v) {


                                              op = '/';
                                              str=str+op;
                                              calciEnter.setText(str);
                                          }
                                      }
        );
        butnclr.setOnClickListener(new View.OnClickListener() {
            @Override

                                       public void onClick(View v) {

                                       if(calciEnter.getText().toString()!=null)
                                           reset(calciEnter.getText().toString());


                                       }
                                   }
        );
        butnclr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                reset2();
                return true;
            }
        });
        butnequal.setOnClickListener(new View.OnClickListener() {
            @Override

                                       public void onClick(View v) {
                                           show_result();

                                       }
                                   }
        );


    }

    public void reset2() {
        str = "";
        str1="";
        num = 0;
        numtemp = 0;
        str3="";
        op=null;
        calciEnter.setText("");
        calciResult.setText("");

    }
    public void reset(String str2){

        str2=str2.substring(0,str2.length()-1);
        str=str2;
        calciEnter.setText(str);



    }

    public void insertvalue(int j) {
        if (op == null) {
            str = str + Integer.toString(j);
            num = Integer.valueOf(str).intValue();
            calciEnter.setText(str);
        }
        if (op !=null) {

            str1 = str1 + Integer.toString(j);
            str3=str3+str1;
            str=str+str1;
            calciEnter.setText(str);
            numtemp = Integer.valueOf(str3).intValue();
            calculateResult();
            str1="";

        }
    }

    public void calculateResult() {
        if (op == '+')
            num = numtemp + num;
        else if (op == '-')
            num = num - numtemp;
        else if (op == '/')
            num = num / numtemp;
        else if (op == 'x')
            num = numtemp * num;
        calciResult.setText("" + num);
    }
    public void show_result() {
        str = "";
        str1 = "";
        str3 = "";
        op = null;
        calciEnter.setText("" + num);
        calciResult.setText("");
    }



}