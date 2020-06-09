package com.learn.balokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String STATE_RESULT = "state_result";

    EditText etLength;
    EditText etWidth;
    EditText etHeight;
    Button btnCount;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLength = findViewById(R.id.etLength);
        etWidth = findViewById(R.id.etWidth);
        etHeight = findViewById(R.id.etHeight);
        btnCount = findViewById(R.id.btnCount);
        tvResult = findViewById(R.id.tvResult);

        btnCount.setOnClickListener(this);

        // handle destroy activity
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCount) {
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;
            // empty validation
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }

            // double or not validation
            Double length = toDouble(inputLength);
            Double width = toDouble(inputWidth);
            Double height = toDouble(inputHeight);

            if (length == null) {
                isInvalidDouble = true;
                etLength.setError("Field harus angka");
            }
            if (width == null) {
                isInvalidDouble = true;
                etWidth.setError("Field harus angka");
            }
            if (height == null) {
                isInvalidDouble = true;
                etHeight.setError("Field harus angka");
            }

            // count result
            if (isEmptyFields == false && isInvalidDouble == false) {
                double volume = length * width * height;
                tvResult.setText(String.valueOf(volume));
            }


        }
    }

    private Double toDouble(String string){
        try {
            return Double.valueOf(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString().trim());
    }
}
