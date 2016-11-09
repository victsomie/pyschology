package ke.co.appslab.www.pyschology;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Navsystem extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    CheckBox medicine;
    CardView medimage;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navsystem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);
        img5 = (ImageView)findViewById(R.id.img5);
        medicine = (CheckBox)findViewById(R.id.med);
        medimage = (CardView)findViewById(R.id.ratemed);

        medicine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(medicine.isChecked()){
                    medimage.setVisibility(View.VISIBLE);
                    img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            img1.setImageResource(R.drawable.yess);
                            img2.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                            img3.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                            img4.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                            img5.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                        }
                    });
                    img2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            img1.setImageResource(R.drawable.yess);
                            img2.setImageResource(R.drawable.yess);
                            img3.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                            img4.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                            img5.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                        }
                    });img3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            img1.setImageResource(R.drawable.yess);
                            img2.setImageResource(R.drawable.yess);
                            img3.setImageResource(R.drawable.yess);
                            img4.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                            img5.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                        }
                    });img4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            img1.setImageResource(R.drawable.yess);
                            img2.setImageResource(R.drawable.yess);
                            img3.setImageResource(R.drawable.yess);
                            img4.setImageResource(R.drawable.yess);
                            img5.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                        }
                    });img5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            img1.setImageResource(R.drawable.yess);
                            img2.setImageResource(R.drawable.yess);
                            img3.setImageResource(R.drawable.yess);
                            img4.setImageResource(R.drawable.yess);
                            img5.setImageResource(R.drawable.yess);
                        }
                    });

                }
                else{
                    img1.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                    img2.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                    img3.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                    img4.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                    img5.setImageResource(R.drawable.ic_favorite_border_white_2dp);
                    medimage.setVisibility(View.GONE);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.navsystem, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent home = new Intent(this, Navsystem.class);
            startActivity(home);

        } else if (id == R.id.nav_slideshow) {
            Intent hom = new Intent(this, Worked.class);
            startActivity(hom);

        }  else if (id == R.id.nav_share) {
            Intent h = new Intent(this, Report.class);
            startActivity(h);

        } else if (id == R.id.nav_send) {

            Intent ho = new Intent(this, About.class);
            startActivity(ho);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
