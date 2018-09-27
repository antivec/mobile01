package com.example.webber.myproject1;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

   DivisionCategoryAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("WelCome!!");



        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        ShowExpandableList();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ImageButton Button_A = (ImageButton) findViewById(R.id.imageButton01);
        Button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.webber.myproject1.ActivityA.class);
                startActivity(intent);
            }
        });

        ImageButton Button_B = (ImageButton) findViewById(R.id.imageButton02);
        Button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"Empty Activity!! " , Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
            }
        });
        ImageButton Button_C = (ImageButton) findViewById(R.id.imageButton03);
        Button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"Empty Activity!! " , Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
            }
        });
        ImageButton Button_D = (ImageButton) findViewById(R.id.imageButton04);
        Button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"Empty Activity!! " , Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
            }
        });
        ImageButton Button_E = (ImageButton) findViewById(R.id.imageButton05);
        Button_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"Working on!! " , Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
            }
        });
        ImageButton Button_F = (ImageButton) findViewById(R.id.imageButton06);
        Button_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"Empty Activity!! " , Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM,0,0);
                toast.show();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("QUIT").setMessage("Are you Sure ??")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).show();

        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void prepareMenuData()
    {



        MenuModel menuModel = new MenuModel("BasketBall", true, true);  // add Category(Basketball) with division

        headerList.add(menuModel);
        List<MenuModel> l_childModel = new ArrayList<>();
        MenuModel childModel = new MenuModel("Introduction", false, false);
        l_childModel.add(childModel);

        childModel = new MenuModel("Rules", false, false);
        l_childModel.add(childModel);

        childModel = new MenuModel("Positions", false, false);
        l_childModel.add(childModel);

        if (menuModel.hasChild)
        {
            childList.put(menuModel, l_childModel);
        }


         menuModel = new MenuModel("Calendar", false, true); // add category (Calendar) without division

        headerList.add(menuModel);
        if(!menuModel.hasChild)
        {
            childList.put(menuModel, null);
        }

    }

    private void ShowExpandableList() {

        expandableListAdapter = new com.example.webber.myproject1.DivisionCategoryAdapter(this,headerList,childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    Toast toast = Toast.makeText(getApplicationContext(),"Group Clicked, Group id = " + groupPosition , Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();

                    switch (expandableListAdapter.getMenuName(groupPosition))
                    {
                        case "Calendar" :
                            Intent intent = new Intent(getApplicationContext(), com.example.webber.myproject1.CalenderActivity.class);
                            startActivity(intent);
                            break;

                    }


                    if (!headerList.get(groupPosition).hasChild)
                    {

                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null)
                {
                    MenuModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    Toast toast = Toast.makeText(getApplicationContext(),"Child Clicked, Group id = " + groupPosition + childPosition, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                    switch (childPosition) {
                        case 0:
                            Intent intent = new Intent(getApplicationContext(), com.example.webber.myproject1.ActivityA.class);
                            startActivity(intent);
                    }
                }

                return false;
            }
        });
    }
}
