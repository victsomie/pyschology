package ke.co.appslab.www.pyschology;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class Worked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worked);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView b = (TextView)findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Worked.this, Home.class);
                startActivity(home);
            }
        });

        TextView s = (TextView)findViewById(R.id.submit);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Thank you for your feedback.", Snackbar.LENGTH_LONG)
                        .setAction("smile is a medicine", null).show();
            }
        });
        final Dialog dialog = new Dialog(Worked.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog2);


       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent home = new Intent(Worked.this, Report.class);
                startActivity(home);

                Snackbar.make(view, "Thank you for your feedback.", Snackbar.LENGTH_LONG)
                        .setAction("smile is a medicine", null).show();

                /*ImageView hideme = (ImageView)
                TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
                text.setText("Thank you for talking to me i love listening");

                ImageButton dialogButton4 = (ImageButton) dialog.findViewById(R.id.btn_dialog2);
                dialogButton4.setVisibility(View.GONE);
                ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.btn_dialog1);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent home = new Intent(Worked.this, Home.class);
                        startActivity(home);
                        dialog.dismiss();
                           /* Toast.makeText(Home.this, "Money Rules The World", Toast.LENGTH_LONG).show();

                    }
                });

                dialog.show();

            }
        });*/
        /*FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Worked.this, Home.class);
                startActivity(home);


            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_worked, menu);
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
}
