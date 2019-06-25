package com.meterstoinches.learning_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    TextView t2;
    TextView sqlitedbTextView;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t2 = findViewById(R.id.t2);
        sqlitedbTextView = (TextView) findViewById(R.id.sqlitedbTextView);
        sqlitedbTextView.setMovementMethod(new ScrollingMovementMethod());
        db=new DatabaseHandler(this);
        db.getReadableDatabase();

        displayall();
    }
    public void displayall(){
        List<Marks> marks = db.getAllMarks();
        if (marks.size()==0){
            sqlitedbTextView.setText("No records in the Database");
        }
        for (Marks m : marks){
            String log = "ID: "+m.getId()+" , Name: "+m.getName()
                    +" , Marks: "+m.getMarks();
            sqlitedbTextView.append(log+"\n"+"\n");
        }
    }
    public void update(){
        sqlitedbTextView.setText("");
        displayall();
    }
    public void addstudent(){
        db.addMarks("Tom","82");
    }
    public void addmany(){
        db.addMarks("Peter","90");
        db.addMarks("Robert","30");
        db.addMarks("Nick","40");
        db.addMarks("Mike","60");
        db.addMarks("Amber","75");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.add_record){
            addstudent();
            update();
            return true;
        }
        if(id==R.id.add_many){
            addmany();
            update();
            return true;
        }
        if(id==R.id.delete_last){
            db.deleteLastRow();
            update();
            return true;
        }
        if(id==R.id.delete_database){
            db.deleteAll();
            update();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
