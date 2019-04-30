package com.e.hiketowin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class DuluthTrailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duluth_trails);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_login, menu);
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
            Intent detailHikeIntent = new Intent(getBaseContext(), AddHikeActivity.class);
            finish();
            startActivity(detailHikeIntent);
        }
        if (id == R.id.action_main) {
            Intent mainIntent = new Intent(this, MainActivity.class);
            finish();
            startActivity(mainIntent);

        }
        if (id == R.id.action_login) {
            Intent loginIntent = new Intent(getBaseContext(), LoginActivity.class);
            finish();
            startActivity(loginIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
