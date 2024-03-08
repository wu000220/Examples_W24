package com.college.examples;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class FirstActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //For NavigationDrawer:
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(item ->
            {
                String message = null;

                int item_id = item.getItemId();

                //what to do when the menu item is selected:
                if (item_id  == R.id.share_item ) {
                    message = getString(R.string.share_message);
                }
                else if (item_id  == R.id.app_bar_search) {
                    message = getString(R.string.search_message);
                }
                else if ( item_id  == R.id.mail_item) {
                    message = getString(R.string.email_message);
                }
                else if ( item_id == R.id.video_item) {
                    message = getString(R.string.video_message);
                }
                else if ( item_id  == R.id.call_item) {
                    message = getString(R.string.call_message);
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                if ( message != null ) {
                    Toast.makeText(this,  getString(R.string.navigation_title, message), Toast.LENGTH_LONG).show();
                }
                return false ;
            }
        );
    }
}

