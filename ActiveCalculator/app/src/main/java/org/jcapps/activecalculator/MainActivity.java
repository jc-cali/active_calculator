package org.jcapps.activecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent mIntentAdd;
    private Intent mIntentSubtract;
    private Intent mIntentMultiply;
    private Intent mIntentDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnAdd = (Button) findViewById(R.id.btn_add);
        Button btnSubtract = (Button) findViewById(R.id.btn_subtract);
        Button btnMultiply = (Button) findViewById(R.id.btn_multiply);
        Button btnDivide = (Button) findViewById(R.id.btn_divide);

        mIntentAdd = new Intent(MainActivity.this, AddActivity.class);
        mIntentSubtract = new Intent(MainActivity.this, SubtractActivity.class);
        mIntentMultiply = new Intent(MainActivity.this, MultipleActivity.class);
        mIntentDivide = new Intent(MainActivity.this, DivideActivity.class);

        TextView txtReturnResult = (TextView) findViewById(R.id.txt_lastresults);

        Intent fromAddActivity = getIntent();
        if (fromAddActivity != null) {
            String msgFromAddActivity;
            try {
                msgFromAddActivity = fromAddActivity.getStringExtra("MSG");
                txtReturnResult.setText(msgFromAddActivity);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        View.OnClickListener addlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Main","click btn_add");
                startActivity(mIntentAdd);
            }
        };

        View.OnClickListener subtractlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Main","click btn_subtract");
                startActivity(mIntentSubtract);
            }
        };

        View.OnClickListener multiplylistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Main","click btn_multiply");
                startActivity(mIntentMultiply);
            }
        };

        View.OnClickListener dividelistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Main","click btn_divide");
                startActivity(mIntentDivide);
            }
        };

        btnAdd.setOnClickListener(addlistener);
        btnSubtract.setOnClickListener(subtractlistener);
        btnMultiply.setOnClickListener(multiplylistener);
        btnDivide.setOnClickListener(dividelistener);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
    }

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
