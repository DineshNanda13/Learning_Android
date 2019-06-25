package com.meterstoinches.learning_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    TextView t4;
    private Button mPasserelle = null;
    public final static int SPY = 5;
    public final static String INTENT_RESULT_ACTIVITY_1 = "hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        t4 = findViewById(R.id.t4);
        mPasserelle = (Button) findViewById(R.id.passerelle);

        mPasserelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondeActivite = new Intent(getApplicationContext(), Main6Activity.class);
                startActivityForResult(secondeActivite, SPY);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPY) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "You choose Activity " + data.getStringExtra(INTENT_RESULT_ACTIVITY_1),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
