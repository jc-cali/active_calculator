package org.jcapps.activecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubtractActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    TextView subtractResult;
    Button btnsubtract;
    int num1, num2, result;

    private Intent mReturnSubtractResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtract);

        // Ref.: http://codehandbook.org/a-simple-android-application-for-adding-two-numbers/
        firstNumber = (EditText) findViewById(R.id.edt_subfield1);
        secondNumber = (EditText) findViewById(R.id.edt_subfield2);
        subtractResult = (TextView) findViewById(R.id.txt_subresults);
        btnsubtract = (Button) findViewById(R.id.btn_subtract);

        btnsubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(firstNumber.getText().toString());
                num2 = Integer.parseInt(secondNumber.getText().toString());
                result = num1 - num2;
                subtractResult.setText(Integer.toString(result));
            }
        });

        Button btnreturnsubtract = (Button) findViewById(R.id.btn_returnsubtract);

        View.OnClickListener subtractlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Subtract Activity", "click btn_returnsubtract");
                mReturnSubtractResults = new Intent(SubtractActivity.this, MainActivity.class);
                String message = "Last calculation was a subtraction of "+ firstNumber.getText().toString() + " - " + secondNumber.getText().toString() + " = " + String.valueOf(result);
                mReturnSubtractResults.putExtra("MSG",message);
                startActivity(mReturnSubtractResults);
            }
        };

        btnreturnsubtract.setOnClickListener(subtractlistener);


    }
}
