package com.meterstoinches.learning_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String topics [] = {"AsyncTask","Sqlite Database","Sensors","Intents"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                }else if(position == 1){
                    Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                    startActivity(intent);
                }else if(position == 2){
                    Intent intent = new Intent(getApplicationContext(),Main4Activity.class);
                    startActivity(intent);
                }else if(position == 3){
                    Intent intent = new Intent(getApplicationContext(),Main5Activity.class);
                    startActivity(intent);
                }
            }
        });

    }
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return topics.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);
            TextView textView_details = (TextView) convertView.findViewById(R.id.detailsID);
            textView_details.setText(topics[position]);
            return convertView;
        }
    }
}
