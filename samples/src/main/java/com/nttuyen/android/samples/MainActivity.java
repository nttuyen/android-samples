package com.nttuyen.android.samples;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.nttuyen.android.samples.slidingmenu.SlidingMenuActivity1;
import com.nttuyen.android.samples.slidingmenu.SlidingMenuSample;
import com.nttuyen.android.umon.widget.SlidingMenu;


public class MainActivity extends ActionBarActivity {

    private SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        menu = new SlidingMenu(this);
        TextView text = new TextView(this);
        text.setText("Menu view here :)");
        menu.setContentView(text);
        menu.attachTo(this);
        menu.setDrawerImageResource(R.drawable.ic_drawer);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        menu.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(menu.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.btn_sliding_menu_activity) {
            go(SlidingMenuSample.class);
        }
        if(v.getId() == R.id.btn_sliding_menu_activity1) {
            go(SlidingMenuActivity1.class);
        }
    }

    public void go(Class<? extends Activity> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
