package com.example.delivermyfood;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    String mTitle[]={
            "Cafe Havanah",
            "Ricky Restuarant",
            "Hajjat Restuarant",
            "Lake View",
            "Serene Hotel",
            "Hotel Kash",
            "Hungry Goose Pizzera",
            "Sippers"
    };
    String mDescription[]={
            "Havanah Mall, Mbarara Town ",
            "Havanah Mbarara Town, Lockup No.2",
            "Taso Village, Mbarara",
            "Nyamitanga, Mbarara",
            "Kakoba Road",
            "Kashanyarazi, Mbarara",
            "Adit mall opp Bank of Uganda,Floor2",
            "Mbarara University"};
    int images[]={
            R.drawable.cafe_havannah,
            R.drawable.ricky_restuarant,
            R.drawable.hajjat_restuarant,
            R.drawable.lake_view,
            R.drawable.serene_hotel,
            R.drawable.hotel_kash,
            R.drawable.hungry_goose,
            R.drawable.sippers_must
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView=(ListView)findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(this,mTitle,mDescription,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    startActivity(new Intent(HomeActivity.this,Order2Activity.class));
                }else{
                    startActivity(new Intent(HomeActivity.this,Order2Activity.class));
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Action Under Development", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        } if (id == R.id.call_us) {
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+256776239674"));
            startActivity(intent);
            return true;
        } if (id == R.id.settings) {
            startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
            return true;
        } if (id == R.id.about) {
            startActivity(new Intent(HomeActivity.this,AboutActivity.class));
            return true;
        } if (id == R.id.logout) {
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(HomeActivity.this,Order2Activity.class));
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
        } else if (id == R.id.nav_delivery) {
            Toast.makeText(this, "Action not yet Programmed", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_location) {
            startActivity(new Intent(HomeActivity.this,MapsActivity.class));
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "Action not yet Programmed", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_Support_us) {
            startActivity(new Intent(HomeActivity.this, SupportActivity.class));
        }else if (id == R.id.nav_AboutApp) {
            startActivity(new Intent(HomeActivity.this,AboutActivity.class));
        }else if(id==R.id.nav_callus){
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+256776239674"));
            startActivity(intent);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
    public MyAdapter(Context c, String title[], String description[], int imgs[]) {
        super(c, R.layout.rows,R.id.textview1, title);
        this.context = c;
        this.rTitle = title;
        this.rDescription = description;
        this.rImgs = imgs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.rows,parent,false);
        ImageView images=row.findViewById(R.id.image);
        TextView mTitle=row.findViewById(R.id.textview1);
        TextView mDescription=row.findViewById(R.id.textview2);

        images.setImageResource(rImgs[position]);
        mTitle.setText(rTitle[position]);
        mDescription.setText(rDescription[position]);
        return row;
    }
}
}
