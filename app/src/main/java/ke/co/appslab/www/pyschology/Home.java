package ke.co.appslab.www.pyschology;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TextWatcher {
    private TextView specify;
    private EditText other;
    private EditText sit;
    private String situation=" ";
    private String otherinfo = "null";
    boolean otheremo = false;
    ImageView emoji;
    public int emorate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Dialog dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog2);



        sit = (EditText)findViewById(R.id.name);
        specify = (TextView)findViewById(R.id.specify);
        other = (EditText)findViewById(R.id.other);
        emoji = (ImageView)findViewById(R.id.emoji);

        final Button others = (Button)findViewById(R.id.others);
        final LinearLayout rateemo = (LinearLayout)findViewById(R.id.rateemo);
        final TextView rate = (TextView)findViewById(R.id.rate);
        final TextView rate1 = (TextView)findViewById(R.id.rate1);
        final TextView rate2 = (TextView)findViewById(R.id.rate2);
        final TextView rate3 = (TextView)findViewById(R.id.rate3);
        final TextView rate4 = (TextView)findViewById(R.id.rate4);
        final Button sad = (Button)findViewById(R.id.sad);
        final Button fear = (Button)findViewById(R.id.fear);
        final Button angry = (Button)findViewById(R.id.angry);
        final Button happy = (Button)findViewById(R.id.happy);
        final Button worried = (Button)findViewById(R.id.worried);
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateemo.setVisibility(View.VISIBLE);
                specify.setVisibility(View.GONE);
                otheremo = false;
                other.setVisibility(View.GONE);
                rate3.setText("60 %");
                emorate = 6;
                situation = sit.getText().toString().trim();
                if (situation.isEmpty()) {
                    sit.setError("Please tell me your situation first");

                    //dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button
                    TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                    text.setText("Please tell me your situation or just tell something today");

                    ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                    dialogButton4.setVisibility(View.GONE);
                    ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                        }
                    });

                    dialog.show();
                }
                rate.setBackgroundColor(getResources().getColor(R.color.sad));
                rate1.setBackgroundColor(getResources().getColor(R.color.sad));
                rate2.setBackgroundColor(getResources().getColor(R.color.sad));
                rate3.setBackgroundColor(getResources().getColor(R.color.rte));
                rate4.setBackgroundColor(getResources().getColor(R.color.rte));

                emoji.setImageResource(R.drawable.sad);
                angry.setBackgroundColor(getResources().getColor(R.color.white));
                happy.setBackgroundColor(getResources().getColor(R.color.white));
                sad.setBackgroundColor(getResources().getColor(R.color.sad));
                fear.setBackgroundColor(getResources().getColor(R.color.white));
                worried.setBackgroundColor(getResources().getColor(R.color.white));
                others.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        worried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateemo.setVisibility(View.VISIBLE);
                specify.setVisibility(View.GONE);
                other.setVisibility(View.GONE);
                otheremo = false;
                rate3.setText("80 %");
                emorate = 8;
                situation = sit.getText().toString().trim();
                if (situation.isEmpty()) {
                    sit.setError("Please tell me your situation first");

                    //dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button
                    TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                    text.setText("Please tell me your situation or just tell something today");

                    ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                    dialogButton4.setVisibility(View.GONE);
                    ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                        }
                    });

                    dialog.show();
                }
                rate.setBackgroundColor(getResources().getColor(R.color.worried));
                rate1.setBackgroundColor(getResources().getColor(R.color.worried));
                rate2.setBackgroundColor(getResources().getColor(R.color.worried));
                rate3.setBackgroundColor(getResources().getColor(R.color.worried));
                rate4.setBackgroundColor(getResources().getColor(R.color.rte));

                emoji.setImageResource(R.drawable.worrying);
                angry.setBackgroundColor(getResources().getColor(R.color.white));
                happy.setBackgroundColor(getResources().getColor(R.color.white));
                sad.setBackgroundColor(getResources().getColor(R.color.white));
                fear.setBackgroundColor(getResources().getColor(R.color.white));
                worried.setBackgroundColor(getResources().getColor(R.color.worried));
                others.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });


        fear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rateemo.setVisibility(View.VISIBLE);
                specify.setVisibility(View.GONE);
                other.setVisibility(View.GONE);
                otheremo = false;
                rate3.setText("40 %");
                emorate = 4;
                situation = sit.getText().toString().trim();
                if (situation.isEmpty()) {
                    sit.setError("Please tell me your situation first");

                    //dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button
                    TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                    text.setText("Please tell me your situation or just tell something today");

                    ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                    dialogButton4.setVisibility(View.GONE);
                    ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                        }
                    });

                    dialog.show();
                }
                rate.setBackgroundColor(getResources().getColor(R.color.fear));
                rate1.setBackgroundColor(getResources().getColor(R.color.fear));
                rate2.setBackgroundColor(getResources().getColor(R.color.rte));
                rate3.setBackgroundColor(getResources().getColor(R.color.rte));
                rate4.setBackgroundColor(getResources().getColor(R.color.rte));
                emoji.setImageResource(R.drawable.fear);
                angry.setBackgroundColor(getResources().getColor(R.color.white));
                happy.setBackgroundColor(getResources().getColor(R.color.white));
                sad.setBackgroundColor(getResources().getColor(R.color.white));
                fear.setBackgroundColor(getResources().getColor(R.color.fear));
                worried.setBackgroundColor(getResources().getColor(R.color.white));
                others.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });


        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateemo.setVisibility(View.VISIBLE);
                specify.setVisibility(View.GONE);
                other.setVisibility(View.GONE);
                otheremo = false;
                rate3.setText("20 %");
                emorate = 2;
                situation = sit.getText().toString().trim();
                if (situation.isEmpty()) {
                    sit.setError("Please tell me your situation first");

                    //dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button
                    TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                    text.setText("Please tell me your situation or just tell something today");

                    ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                    dialogButton4.setVisibility(View.GONE);
                    ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                        }
                    });

                    dialog.show();
                }
                rate.setBackgroundColor(getResources().getColor(R.color.angry));
                rate1.setBackgroundColor(getResources().getColor(R.color.rte));
                rate2.setBackgroundColor(getResources().getColor(R.color.rte));
                rate3.setBackgroundColor(getResources().getColor(R.color.rte));
                rate4.setBackgroundColor(getResources().getColor(R.color.rte));
                emoji.setImageResource(R.drawable.angry);
                angry.setBackgroundColor(getResources().getColor(R.color.angry));
                happy.setBackgroundColor(getResources().getColor(R.color.white));
                sad.setBackgroundColor(getResources().getColor(R.color.white));
                fear.setBackgroundColor(getResources().getColor(R.color.white));
                worried.setBackgroundColor(getResources().getColor(R.color.white));
                others.setBackgroundColor(getResources().getColor(R.color.white));
                            }
        });

        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otheremo = true;
                specify.setVisibility(View.VISIBLE);
                other.setVisibility(View.VISIBLE);
                rateemo.setVisibility(View.GONE);
                emorate = 0;
                situation = sit.getText().toString().trim();
                if (situation.isEmpty()) {
                    sit.setError("Please tell me your situation first");

                    //dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button
                    TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                    text.setText("Please tell me your situation or just tell something today");

                    ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                    dialogButton4.setVisibility(View.GONE);
                    ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                        }
                    });

                    dialog.show();
                }

                emoji.setImageResource(R.drawable.ic_priority_high_white_24dp);
                rate.setBackgroundColor(getResources().getColor(R.color.white));
                rate1.setBackgroundColor(getResources().getColor(R.color.white));
                rate2.setBackgroundColor(getResources().getColor(R.color.white));
                rate3.setBackgroundColor(getResources().getColor(R.color.white));
                rate4.setBackgroundColor(getResources().getColor(R.color.white));
                angry.setBackgroundColor(getResources().getColor(R.color.white));
                happy.setBackgroundColor(getResources().getColor(R.color.white));
                sad.setBackgroundColor(getResources().getColor(R.color.white));
                fear.setBackgroundColor(getResources().getColor(R.color.white));
                worried.setBackgroundColor(getResources().getColor(R.color.white));
                others.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });


        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateemo.setVisibility(View.VISIBLE);
                specify.setVisibility(View.GONE);
                other.setVisibility(View.GONE);
                otheremo = false;
                rate3.setText("100 %");
                emorate = 10;
               situation = sit.getText().toString().trim();
                if (situation.isEmpty()) {
                    sit.setError("Please tell me your situation first");

                    //dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button
                    TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                    text.setText("Please tell me your situation or just tell something today");

                    ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                    dialogButton4.setVisibility(View.GONE);
                    ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                        }
                    });

                    dialog.show();
                }
                rate.setBackgroundColor(getResources().getColor(R.color.happy));
                rate1.setBackgroundColor(getResources().getColor(R.color.happy));
                rate2.setBackgroundColor(getResources().getColor(R.color.happy));
                rate3.setBackgroundColor(getResources().getColor(R.color.happy));
                rate4.setBackgroundColor(getResources().getColor(R.color.happy));
                emoji.setImageResource(R.drawable.happy);
                angry.setBackgroundColor(getResources().getColor(R.color.white));
                happy.setBackgroundColor(getResources().getColor(R.color.happy));
                sad.setBackgroundColor(getResources().getColor(R.color.white));
                fear.setBackgroundColor(getResources().getColor(R.color.white));
                worried.setBackgroundColor(getResources().getColor(R.color.white));
                others.setBackgroundColor(getResources().getColor(R.color.white));

            }
        });






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                otherinfo = other.getText().toString().trim();
                    if (otheremo == true && otherinfo.isEmpty()){
                        other.setError("Specify your emotion write something please");
                        //dialog.setTitle("Title...");

                        // set the custom dialog components - text, image and button
                        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                        text.setText("Please describe what your feel, the emotion you can use hash tag eg #confused  ");

                        ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                        dialogButton4.setVisibility(View.GONE);
                        ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                        // if button is clicked, close the custom dialog
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                            }
                        });

                        dialog.show();
                    }

                else if(situation.contentEquals(" ") && emorate==0) {

                        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                        text.setText("Please describe your situation what caused your emotions");

                        ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                        dialogButton4.setVisibility(View.GONE);
                        ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                        // if button is clicked, close the custom dialog
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();
                            */
                            }
                        });

                        dialog.show();

                        /*Snackbar.make(view, "App under test data cannot be pushed to database", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();*/
                        /*Intent next = new Intent(Home.this, Worked.class);
                        next.putExtra("rate", emorate);
                        next.putExtra("situation", situation);
                        next.putExtra("other",otherinfo);
                        startActivity(next);*/
                    }
                else{
                        startActivity(new Intent(Home.this, Navsystem.class) );
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
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        sit.setError(null);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        sit.setError(null);
    }

    @Override
    public void afterTextChanged(Editable s) {
        sit.setError(null);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            //
            /*Intent home = new Intent(this, Navsystem.class);
            startActivity(home);*/
        } else if (id == R.id.history) {

            Intent home = new Intent(this, Main2Activity.class);
            startActivity(home);
        } else if (id == R.id.sf) {
            Intent hom = new Intent(this, Worked.class);
            startActivity(hom);

        }
        else if (id == R.id.report) {
            Intent h = new Intent(this, Report.class);
            startActivity(h);

        }
        else if (id == R.id.about) {
            Intent ho = new Intent(this, About.class);
            startActivity(ho);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
