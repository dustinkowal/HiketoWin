package com.e.hiketowin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewHike;
    HikeFirebaseData hikeDataSource;
    DatabaseReference myHikeDbRef;
    List<Hike> hikeList;
    ArrayAdapter<Hike> hikeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

  /*      // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("CIS 3334", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("CIS 3334", "Failed to read value.", error.toException());
            }
        });*/
    }

    private void setupFirebaseDataChange() {
        hikeDataSource = new HikeFirebaseData();
        myHikeDbRef = hikeDataSource.open();
        myHikeDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                hikeList = hikeDataSource.getAllHikes(dataSnapshot);
                // Instantiate a custom adapter for displaying each fish
                hikeAdapter = new HikeAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, hikeList);
                // Apply the adapter to the list
                listViewHike.setAdapter(hikeAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_hike) {
            Intent detailHikeIntent = new Intent(this, AddHikeActivity.class);
            finish();
            startActivity(detailHikeIntent);
        }
        if (id == R.id.action_login) {
            Intent loginIntent = new Intent(this, LoginActivity.class);
            finish();
            startActivity(loginIntent);
        }
        if (id == R.id.action_duluth_trails) {
            Intent duluthTrailsIntent = new Intent(this, DuluthTrailsActivity.class);
            finish();
            startActivity(duluthTrailsIntent);
        }

        return super.onOptionsItemSelected(item);
    }

}
