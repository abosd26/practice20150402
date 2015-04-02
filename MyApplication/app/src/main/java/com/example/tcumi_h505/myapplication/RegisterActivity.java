package com.example.tcumi_h505.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
    }
    public void buttonClick(View v)
    {
        EditText t = (EditText)findViewById(R.id.mail);
        EditText p = (EditText)findViewById(R.id.pw);
        EditText c = (EditText)findViewById(R.id.cpw);
        if(v.getId() == R.id.reset)
        {
            t.setText("");
            p.setText("");
            c.setText("");
        }
        else if(v.getId() == R.id.confirm)
        {
            String temp = "\n";
            boolean check = true;
            AlertDialog a = new AlertDialog.Builder(this).create();
            if(t.getText().toString().equals(""))
            {
                temp += "請輸入電子郵件!\n";
                check = false;
            }
            if(p.getText().toString().equals(""))
            {
                temp += "請輸入密碼!\n";
                check = false;
            }
            else {
                if (!isValidEmail(t.getText().toString())) {
                    temp += "信箱格式不符!\n";
                    check = false;
                }
                if (!isPasswordConfirmed()) {
                    temp += "密碼不相符!\n";
                    check = false;
                }
            }
            if(!check)
            {
                a.setTitle("Message");
                a.setMessage(temp);
                a.show();
            }
            else
            {
                a.setTitle("Message");
                a.setMessage("OK\n");
                a.show();
            }
        }
    }
    public boolean isPasswordConfirmed()
    {
        EditText p = (EditText)findViewById(R.id.pw);
        EditText c = (EditText)findViewById(R.id.cpw);
        String s1 = p.getText().toString();
        String s2 = c.getText().toString();
        if(s1.equals(s2))
        {
            return true;
        }
        return false;
    }
    public boolean isValidEmail(String e)
    {
        String patternstr = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(patternstr);
        Matcher matcher = pattern.matcher(e);

        return matcher.matches();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
