package com.meterstoinches.learning_android;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t1,t2;
    Button b1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.asyncTextViewID);
        t2.setMovementMethod(new ScrollingMovementMethod());
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        b1 = (Button) findViewById(R.id.asyncBtnID);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask task = new MyTask();
                task.execute("p1","p2","p3","p4","p5","p6");
            }
        });
    }
    public class MyTask extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            update("starting task");
            progressBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i= 0 ; i<strings.length ; i++){
                publishProgress("working with "+ strings[i]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "task complete";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            update(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            update(s);
            progressBar.setVisibility(View.INVISIBLE);
            super.onPostExecute(s);
        }
    }
    public void update(String message){
        t2.append(message+"\n");
    }
}
