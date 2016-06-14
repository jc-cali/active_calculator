package org.jcapps.activecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
    EditText firstNumber;
    EditText secondNumber;
    TextView  addResult;
    Button btnadd;
    int num1 =0, num2=0, sum;

    private Intent mReturnAddResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Ref.: http://codehandbook.org/a-simple-android-application-for-adding-two-numbers/
        firstNumber = (EditText) findViewById(R.id.edt_addfield1);
        secondNumber = (EditText) findViewById(R.id.edt_addfield2);
        addResult = (TextView) findViewById(R.id.txt_addresults);
        btnadd = (Button) findViewById(R.id.btn_add);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(firstNumber.getText().toString());
                num2 = Integer.parseInt(secondNumber.getText().toString());
                sum = num1 + num2;
                addResult.setText(String.valueOf(sum));

            }
        });

        Button btnreturnadd = (Button) findViewById(R.id.btn_returnadd);

        View.OnClickListener addlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Add Activity", "click btn_returnadd");
                mReturnAddResults = new Intent(AddActivity.this, MainActivity.class);
                String message = "Last calculation was an addition of "+ firstNumber.getText().toString() + " + " + secondNumber.getText().toString() + " = " + String.valueOf(sum);
                mReturnAddResults.putExtra("MSG",message);
                startActivity(mReturnAddResults);
            }
        };

        btnreturnadd.setOnClickListener(addlistener);

    }
}
