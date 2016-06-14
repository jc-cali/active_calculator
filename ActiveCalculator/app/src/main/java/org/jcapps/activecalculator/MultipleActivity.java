package org.jcapps.activecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MultipleActivity extends AppCompatActivity {
    EditText firstNumber;
    EditText secondNumber;
    TextView multiplyResult;
    Button btnmultiply;
    int num1, num2, result;

    private Intent mReturnMultiplyResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);

        // Ref.: http://codehandbook.org/a-simple-android-application-for-adding-two-numbers/
        // Ref. #2:http://stackoverflow.com/questions/26056249/how-insert-number-double-in-edittext
        firstNumber = (EditText) findViewById(R.id.edt_multiplyfield1);
        secondNumber = (EditText) findViewById(R.id.edt_multiplyfield2);
        multiplyResult = (TextView) findViewById(R.id.txt_multiplyresults);
        btnmultiply = (Button) findViewById(R.id.btn_multiply);

        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Integer.parseInt(firstNumber.getText().toString());
                num2 = Integer.parseInt(secondNumber.getText().toString());
                result = num1 * num2;
                multiplyResult.setText(Integer.toString(result));
            }
        });
        Button btnreturnmultiply = (Button) findViewById(R.id.btn_returnmultiply);

        View.OnClickListener multiplylistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Multiply Activity", "click btn_returnmultiply");
                mReturnMultiplyResults = new Intent(MultipleActivity.this, MainActivity.class);
                String message = "Last calculation was a multiplication of "+ firstNumber.getText().toString() + " * " + secondNumber.getText().toString() + " = " + String.valueOf(result);

                mReturnMultiplyResults.putExtra("MSG",message);
                startActivity(mReturnMultiplyResults);
            }
        };

        btnreturnmultiply.setOnClickListener(multiplylistener);

    }
}
