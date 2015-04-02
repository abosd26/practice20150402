package com.example.tcumi_h505.myapplication;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button b = (Button)findViewById(R.id.okButton);
       Button b2 = (Button)findViewById(R.id.okButton2);
       b.setOnTouchListener(this);
       b2.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(v.getId() == R.id.okButton)
            {
                Button b = (Button)findViewById(R.id.okButton);
                b.setBackgroundColor(Color.BLUE);
            }
            else if(v.getId() == R.id.okButton2)
            {
                Button b = (Button)findViewById(R.id.okButton2);
                b.setBackgroundColor(Color.YELLOW);
            }
        }
        else if(event.getAction() == MotionEvent.ACTION_UP)
        {
            if(v.getId() == R.id.okButton)
            {
                Button b = (Button)findViewById(R.id.okButton);
                b.setBackgroundColor(Color.parseColor("#ff8cff72"));
            }
            else if(v.getId() == R.id.okButton2)
            {
                Button b = (Button)findViewById(R.id.okButton2);
                b.setBackgroundColor(Color.GRAY);
            }
        }
        return false;
    }
//  public void buttonClick(View v)
//  {
//        Button b = (Button)v;
//        if(v.getId() == R.id.okButton)
//        {
//            b.setBackgroundColor(Color.BLUE);
//        }
//        else if(v.getId() == R.id.okButton2)
//        {
//            b.setBackgroundColor(Color.GREEN);
//        }
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
