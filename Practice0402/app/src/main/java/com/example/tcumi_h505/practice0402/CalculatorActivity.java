package com.example.tcumi_h505.practice0402;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void buttonClick(View v)
    {
        AlertDialog a = new AlertDialog.Builder(this).create();
        TextView t = (TextView)findViewById(R.id.textView2);
        EditText e1 = (EditText)findViewById(R.id.editText1);
        EditText e2 = (EditText)findViewById(R.id.editText2);
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        if(s1.equals("") || s2.equals(""))
        {
            a.setTitle("error");
            a.setMessage("欄位不可空白!");
            a.show();
        }
        else if(!isValidValue(s1) || !isValidValue(s2))
        {
            a.setTitle("error");
            a.setMessage("請輸入數字!");
            a.show();
        }
        else {
            switch (v.getId()) {
                case R.id.button1:
                    t.setText("答案 : " + String.format("%.2f", Double.parseDouble(s1) + Double.parseDouble(s2)));
                    break;
                case R.id.button2:
                    t.setText("答案 : " + String.format("%.2f", Double.parseDouble(s1) - Double.parseDouble(s2)));
                    break;
                case R.id.button3:
                    t.setText("答案 : " + String.format("%.2f", Double.parseDouble(s1) * Double.parseDouble(s2)));
                    break;
                case R.id.button4:
                    if(s2.equals("0"))
                    {
                        a.setTitle("error");
                        a.setMessage("除數不可為0!");
                        a.show();
                    }
                    else
                    {
                        t.setText("答案 : " + String.format("%.2f", Double.parseDouble(s1) / Double.parseDouble(s2)));
                    }
                    break;
            }
        }
    }
    public boolean isValidValue(String s)
    {
        String standard = "[0-9]+.?[0-9]*";
        Pattern pattern = Pattern.compile(standard);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
