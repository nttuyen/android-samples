package com.nttuyen.android.samples.slidingmenu;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.nttuyen.android.samples.R;
import com.nttuyen.android.umon.widget.SlidingMenu;

public class SlidingMenuActivity1 extends ActionBarActivity {

    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_menu_activity1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        menu = new SlidingMenu(this);
        TextView text = new TextView(this);
        text.setText("Menu view here :)");
        menu.setContentView(text);
        menu.attachTo(this);
        menu.setDrawerImageResource(R.drawable.ic_drawer);

        //. Change width
        //Display display = getWindowManager().getDefaultDisplay();
        //int screenWidth = display.getWidth();
        //menu.setWidth(screenWidth * 2 / 3);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        menu.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sliding_menu_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (menu.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        this.menu.toggle();
    }
}
