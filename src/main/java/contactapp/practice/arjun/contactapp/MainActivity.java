package contactapp.practice.arjun.contactapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockPackageManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import static android.Manifest.permission.READ_CONTACTS;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button search,sync,clear;
SearchView searchView;
DatabaseHelper databaseHelper;
    ArrayList<String> nameList;
    ArrayList<String> phoneNoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sync=(Button)findViewById(R.id.sync);
        search=(Button)findViewById(R.id.search);
        clear=(Button)findViewById(R.id.clear);
        databaseHelper=new DatabaseHelper(this);
        //searchView=(SearchView) findViewById(R.id.searchview);
        search.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent i=new Intent(MainActivity.this,ViewAll.class);
                startActivity(i);
                return true;
            }
        });
        sync.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
Toast.makeText(MainActivity.this,"Successfully updated contacts from phone to Database",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }



    }

