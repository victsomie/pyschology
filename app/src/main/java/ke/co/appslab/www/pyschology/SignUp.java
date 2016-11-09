package ke.co.appslab.www.pyschology;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//import com.fourmob.datetimepicker.date.DatePickerDialog;
//import com.fourmob.datetimepicker.date.DatePickerDialog.OnDateSetListener;

//import com.example.admin.the3rdeye.gcm.GCMClientManager;

//import com.fourmob.datetimepicker.date.DatePickerDialog;
//import com.sleepbot.datetimepicker.time.TimePickerDialog;


import java.util.Calendar;
import java.util.HashMap;

public class SignUp extends AppCompatActivity implements TextWatcher /* for location implements ConnectionCallbacks,OnConnectionFailedListener */ {

    /* getting location
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private boolean mRequestingLocationUpdates = false;

    private LocationRequest mLocationRequest;
    private static int UPDATE_INTERVAL = 10000; // 10 sec
    private static int FATEST_INTERVAL = 5000; // 5 sec
    private static int DISPLACEMENT = 50; // 10 meters
    private Button reload; location codelocation*/

    public static final String  REGISTER_URL = "http://www.appslab.co.ke/testdb/signup.php";
    private Button btnSignup;
    private String dob;
    private TextView login;
    private String dateynagu  = null;
    private EditText inputName;
    private EditText inputAge;
    private RadioButton inputGenderm;
    private RadioGroup inputGender;
    private EditText inputEmail;
    private EditText inputCountry;
    private EditText inputPassword;
    private EditText inputConfirmpswd;
    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";
  //  String PROJECT_NUMBER="349972244733";
   // String regID;
    ProgressDialog progressDialog;
    static String gender;

    //datepicker
    private Button changeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE_PICKER_ID = 1111;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//datepicker
        changeDate = (Button) findViewById(R.id.dateButton);

        // Get current date by calender

        final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);

        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // On button click show datepicker dialog
                showDialog(DATE_PICKER_ID);

            }

        });



                login = (TextView)findViewById(R.id.login);
        inputAge = (EditText)findViewById(R.id.age);
        inputGenderm = (RadioButton)findViewById(R.id.mgender);
        inputGender = (RadioGroup)findViewById(R.id.gender);
        btnSignup = (Button)findViewById(R.id.btnSignup);
        inputName = (EditText)findViewById(R.id.name);
        inputConfirmpswd = (EditText)findViewById(R.id.confirmpswd);
        inputEmail = (EditText)findViewById(R.id.email1);
        inputPassword = (EditText)findViewById(R.id.pswd);
        inputCountry = (EditText)findViewById(R.id.age);

        inputAge.addTextChangedListener(this);
        inputName.addTextChangedListener(this);
        inputEmail.addTextChangedListener(this);
        inputConfirmpswd.addTextChangedListener(this);
        inputPassword.addTextChangedListener(this);

            /*check api google available
        if (checkPlayServices()) {
            buildGoogleApiClient();
        }*/
        inputGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.mgender:
                        gender = "Male";
                        break;
                    case R.id.fgender:
                        gender = "Female";
                        break;
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(SignUp.this, MainActivity.class);
                startActivity(m);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // location function displayLocation();
                Usersreg();
            }
        });

    }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            inputName.setError(null);
            inputEmail.setError(null);
            inputPassword.setError(null);
            inputConfirmpswd.setError(null);
            inputAge.setError(null);

        }


  /*  private void displayLocation() {

        mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {
            double latitude = mLastLocation.getLatitude();
            double longitude = mLastLocation.getLongitude();

            login.setText(latitude + ", " + longitude);

        } else {

            login.setText("(Couldn't get the location. Make sure location is enabled on the device)");
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkPlayServices();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        //Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
         //       + result.getErrorCode());
    }

    @Override
    public void onConnected(Bundle arg0) {

        // Once connected with google api, get the location
        displayLocation();
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.connect();
    }
location code not working so far check on monday*/

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        inputName.setError(null);
        inputEmail.setError(null);
        inputPassword.setError(null);
        inputConfirmpswd.setError(null);
        inputAge.setError(null);
    }



    @Override
    public void afterTextChanged(Editable s) {
        inputName.setError(null);
        inputEmail.setError(null);
        inputPassword.setError(null);
        inputConfirmpswd.setError(null);
        inputAge.setError(null);

    }




    //dateppicker

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                // open datepicker dialog.
                // set date picker for current date
                // add pickerListener listner to date picker
                return new DatePickerDialog(this, pickerListener, year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;

            // Show selected date

            //StringBuilder dateyangu = new StringBuilder().append(month + 1).append("-").append(day).append("-").append(year).append(" ");

           /* changeDate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));*/
            dateynagu = month + 1 + "-" + day + "-" + year + " ";
            changeDate.setText("You Date of Birth is " + dateynagu);
        }
    };
    private void Usersreg() {
        // String token = "regID";
        String uname = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String country = inputCountry.getText().toString().trim();
        String confirmpswd = inputConfirmpswd.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        if (uname.isEmpty() || uname.length() < 4) {
            inputName.setError("At least four characters");
        } else if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            inputEmail.setError("enter a valid email address");
        }
        else if (dateynagu.isEmpty() ) {
            inputAge.setError("Enter date of birth");
        }
        else if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            inputPassword.setError("Enter at least four characters and not more than ten");
        }
        else if (!confirmpswd.contentEquals(password)) {
            inputConfirmpswd.setError("Password don't match well");
        }
        else {
            inputName.setError(null);
            inputEmail.setError(null);
            inputPassword.setError(null);
            inputConfirmpswd.setError(null);
            inputAge.setError(null);
            if(gender == null){
                Toast.makeText(SignUp.this,"Select your gender",Toast.LENGTH_LONG).show();
            }
            register(uname, email,country, dateynagu,gender, password);

        }


    }



    private void register(String uname, String email,String country, String age, String gender, String password) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        String urlSuffix = "?uname=" + uname + "&email=" + email + "&country=" + country + "&age=" + age + "&gender=" + gender + "&password=" + password;
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                String hope = s;
                Toast.makeText(getApplicationContext(), hope, Toast.LENGTH_LONG).show();

                if (hope.contentEquals("success")) {
                    Intent n = new Intent(SignUp.this, MainActivity.class);
                    startActivity(n);
                    finish();
                }

            }

            @Override
            protected String doInBackground(String... params) {
                HashMap<String, String> data = new HashMap<String, String>();
                data.put("uname", params[0]);
                data.put("email", params[1]);
                data.put("country", params[2]);
                data.put("age", params[3]);
                data.put("gender", params[4]);
                data.put("password", params[5]);
                //data.put("token", params[3]);

                String result = ruc.sendPostRequest(REGISTER_URL, data);
                return result;

               /* String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;
                    result = bufferedReader.readLine();
                    return result;
                } catch (Exception e) {
                    return null;
                }*/
            }

        }

        RegisterUser ru = new RegisterUser();
        ru.execute(uname, email,country, age, gender, password);
    }

}
