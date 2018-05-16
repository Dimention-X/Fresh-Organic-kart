package com.example.arpitkanda.orgnickart;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.sql.Connection;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottom;
    MaterialSearchView searchView;
    Button login_button;
    Connection conn;
    ConnectionClass connectionClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottom =(BottomNavigationView)findViewById(R.id.navigation_id);
        searchView=(MaterialSearchView)findViewById(R.id.search_view_id);
        login_button=(Button)findViewById(R.id.login_button_id);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)bottom.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        home_class homeClass=new home_class();
        fragmentTransaction.replace(R.id.fragmentContainer,homeClass);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
//        login_fragment();
        bottom_onClick();
        connectionClass = new ConnectionClass();
        (new DBConnect()).execute(null, null, null);
    }



    public void login_fragment(){
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Login_Register.class);
                startActivity(intent);
            }
        });
    }
    public void bottom_onClick(){
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                Item_Categorey item_categorey=new Item_Categorey();
                Item_with_Images item_images=new Item_with_Images();
                int id=item.getItemId();
                if(id==R.id.navigation_home){

                }else if(id==R.id.navigation_dashboard){
                    fragmentTransaction.replace(R.id.fragmentContainer,item_categorey);
                }else if(id== R.id.navigation_notifications){
                    fragmentTransaction.replace(R.id.fragmentContainer,item_images);
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    class DBConnect extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection conn = connectionClass.conn();
                Toast.makeText(Main2Activity.this, "GET CONNECTION"+conn,
                        Toast.LENGTH_LONG).show();
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.e("GET SOME ERRORS", ex.toString());
            }
            return null;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        MenuItem item =menu.findItem(R.id.search_id);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent=new Intent(Main2Activity.this,Login_Register.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if(id==R.id.login_button_id){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
