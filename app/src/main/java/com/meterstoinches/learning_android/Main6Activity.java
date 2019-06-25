package com.meterstoinches.learning_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main6Activity extends AppCompatActivity {
    private Button mButton1 = null;
    private Button mButton2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra(Main5Activity.INTENT_RESULT_ACTIVITY_1, "1");
                setResult(RESULT_OK, result);
                finish();
            }
        });
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra(Main5Activity.INTENT_RESULT_ACTIVITY_1, "2");
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}
