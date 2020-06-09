package com.learn.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivityMove = findViewById(R.id.btn_activity_move);
        Button btnActivityMoveData = findViewById(R.id.btn_activity_move_data);
        Button btnDialNumber = findViewById(R.id.btn_dial_number);

        btnActivityMove.setOnClickListener(this);
        btnActivityMoveData.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity_move :
                Intent intent = new Intent(MainActivity.this, ActivityMove.class);
                startActivity(intent);
                break;
            case R.id.btn_activity_move_data :
                Intent intent1 = new Intent(MainActivity.this, ActivityMoveData.class);
                intent1.putExtra(ActivityMoveData.EXTRA_NAME, "iwon gunawan");
                intent1.putExtra(ActivityMoveData.EXTRA_AGE, 20);
                startActivity(intent1);
                break;
            case R.id.btn_dial_number:
                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:08988429390" ));
                startActivity(intent2);
                break;
        }
    }
}
