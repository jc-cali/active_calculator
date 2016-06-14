package org.jcapps.activecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DivideActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    TextView divideResult;
    Button btndivide;
    double num1, num2, result;

    private Intent mReturnDivideResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divide);

        // Ref.: http://codehandbook.org/a-simple-android-application-for-adding-two-numbers/
        firstNumber = (EditText) findViewById(R.id.edt_dividefield1);
        secondNumber = (EditText) findViewById(R.id.edt_dividefield2);
        divideResult = (TextView) findViewById(R.id.txt_divideresults);
        btndivide = (Button) findViewById(R.id.btn_divide);

        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(firstNumber.getText().toString());
                num2 = Double.parseDouble(secondNumber.getText().toString());
                result = num1 / num2;
                divideResult.setText(Double.toString(result));
            }
        });

        Button btnreturndivide = (Button) findViewById(R.id.btn_returnDivide);

        View.OnClickListener dividelistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Divide Activity", "click btn_returndivide");
                mReturnDivideResults = new Intent(DivideActivity.this, MainActivity.class);
                String message = "Last calculation was a division of "+ firstNumber.getText().toString() + " / " + secondNumber.getText().toString() + " = " + Double.toString(result);
                mReturnDivideResults.putExtra("MSG",message);
                startActivity(mReturnDivideResults);
            }
        };

        btnreturndivide.setOnClickListener(dividelistener);

    }
}
