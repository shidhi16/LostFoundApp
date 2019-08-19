package com.example.lostfoundapp.Activities.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lostfoundapp.AboutUs;
import com.example.lostfoundapp.Activities.adapters.BrandAdapter;
import com.example.lostfoundapp.Activities.pojoUsers.Items;
import com.example.lostfoundapp.LostFoundSingleton;
import com.example.lostfoundapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static Bitmap bitmap;

    Toolbar toolbar;
    FloatingActionButton fab;
    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    RecyclerView recyclerView;

    BrandAdapter firstAdapter;

    Context context;


    String strItems;


    AppCompatActivity activity = MenuActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();


        recyclerView = findViewById(R.id.recyclerView);
        firstAdapter = new BrandAdapter(MenuActivity.this, LostFoundSingleton.getInstance().getItemsList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firstAdapter);

        try {
            strItems = readItems("itemslist");
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        setArrayListOfItems();



    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.ftbAdd);
        recyclerView = findViewById(R.id.recyclerView);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity,AddItem.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        firstAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            startActivity(new Intent(MenuActivity.this, LoginForm.class));

            return true;
        }
        if(id == R.id.about_us)
        {
            startActivity(new Intent(MenuActivity.this, AboutUs.class));

        }

        return super.onOptionsItemSelected(item);
      }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private String readItems(String itemslist) throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(getAssets().open(itemslist), StandardCharsets.UTF_8));

        String items = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            items = items + line;
        }

        return items;


    }

    private void setArrayListOfItems() {

        try {
            JSONArray itemsArray = new JSONArray(strItems);
            for (int i = 0; i < itemsArray.length(); i++) {
                Items item = new Items();
                JSONObject itemObject = itemsArray.getJSONObject(i);


                item.setItemID(itemObject.getInt("itemID"));
                item.setItemName(itemObject.getString("itemName"));
                item.setDescription(itemObject.getString("description"));
                item.setStatus(itemObject.getString("status"));
                item.setItemImage(itemObject.getString("itemImage"));
                item.setContact(String.valueOf(itemObject.getInt("contact")));

                LostFoundSingleton.getInstance().itemsArrayList.add(item);
                firstAdapter.notifyDataSetChanged();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
