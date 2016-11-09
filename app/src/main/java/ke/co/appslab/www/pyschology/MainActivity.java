package ke.co.appslab.www.pyschology;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private TextView info;
    //private LoginButton loginButton;
   // private CallbackManager callbackManager;
    public static final String  REGISTER_URL = "http://www.appslab.co.ke/testdb/maishalg.php";

    public  static final String TAG = MainActivity.class.getSimpleName();
    private Button login;
    private EditText inputEmail, inputPassword;
    private ProgressDialog pDialog;
    private boolean loggedIn = false;
    String PROJECT_NUMBER="349972244733";
    String regID;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        info = (TextView)findViewById(R.id.info);
       // loginButton = (LoginButton)findViewById(R.id.login_button);

        //login
        TextView register = (TextView)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        inputEmail = (EditText)findViewById(R.id.email);
        inputPassword = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.btnLogin);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String adm = inputEmail.getText().toString().trim().toUpperCase();
                String password = inputPassword.getText().toString().trim().toLowerCase();
                String token = regID;

                if(!adm.isEmpty() && !password.isEmpty()){
                    checkLogin(adm, password, token);
                }

                else {
                    inputEmail.setError("This field is required");
                    inputPassword.setError("This field is required");
                    Toast.makeText(getApplicationContext(), "Enter the required credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
                finish();
            }
        });


        //facebook



        /*loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(AppConfig.SHARED_PREF_NAME,
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(AppConfig.LOGGEDIN_SHARED_PREF, true);
                editor.putString("id", regID);
                editor.putString("user","fb");
                editor.putString(AppConfig.ADM_SHARED_PREF, regID);
                editor.commit();
                Intent n = new Intent(MainActivity.this, VideoList.class);
                startActivity(n);
                //Toast.makeText(MainActivity.this, "Log in with facebook is successful", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Log in with facebook is was cancelled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(MainActivity.this, "Log in with facebook failed", Toast.LENGTH_LONG).show();
            }
        });*/


    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }*/
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*@Override
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
    }*/

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(AppConfig.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        loggedIn = sharedPreferences.getBoolean(AppConfig.LOGGEDIN_SHARED_PREF, false);

        if(loggedIn){
            Intent n = new Intent(MainActivity.this, Home.class);
            startActivity(n);
            finish();
        }
    }

    private void checkLogin(final String uname, final String password, final String token){
        class UserLoginClass extends AsyncTask<String,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Please Wait",null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("success")){
                    SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(AppConfig.SHARED_PREF_NAME,
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(AppConfig.LOGGEDIN_SHARED_PREF, true);
                    editor.putString("id", regID);
                    editor.putString("user",password);
                    editor.putString(AppConfig.ADM_SHARED_PREF, regID);
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    //intent.putExtra(USER_NAME,username);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String,String> data = new HashMap<>();
                data.put("uname",params[0]);
                data.put("password",params[1]);
                //data.put("token",params[2]);

                RegisterUserClass ruc = new RegisterUserClass();

                String result = ruc.sendPostRequest(REGISTER_URL,data);

                return result;
            }
        }
        UserLoginClass ulc = new UserLoginClass();
        ulc.execute(uname, password);
    }


    /*private void checkLogin(final String adm, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session


                        // Now store the user in SQLite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String adm = user.getString("adm");
                        String course = user.getString("course");
                        String school = user.getString("school");
                        String regdate = user.getString("regdate");

                        // Inserting row in users table


                        // Launch main activity
                        Intent intent = new Intent(MainActivity.this,
                                NewsPage.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("adm", adm);
                params.put("password", password );

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }*/
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
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
