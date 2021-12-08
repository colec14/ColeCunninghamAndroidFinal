package edu.mssu.cis385.colecunninghamfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText inputIncome;
    private EditText inputRent;
    private EditText inputUtilities;
    private EditText inputGroceries;
    private EditText inputCar;
    private EditText inputCellPhone;
    private EditText inputInsurance;
    private EditText inputSavings;
    private EditText inputDebt;
    public static EditText inputMisc;
    public static final String INCOME_KEY =
            "income.message";
    public static final String RENT_KEY =
            "rent.message";
    public static final String UTILITIES_KEY =
            "utilities.message";
    public static final String GROCERIES_KEY =
            "groceries.message";
    public static final String CAR_KEY =
            "car.message";
    public static final String CELLPHONE_KEY =
            "cellphone.message";
    public static final String INSURANCE_KEY =
            "insurance.message";
    public static final String SAVINGS_KEY =
            "savings.message";
    public static final String DEBT_KEY =
            "debt.message";
    public static final String MISC_KEY =
            "misc.message";
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;
    private Button button_notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputIncome = findViewById(R.id.inputIncome);
        inputRent = findViewById(R.id.inputRent);
        inputUtilities = findViewById(R.id.inputUtilities);
        inputGroceries = findViewById(R.id.inputGroceries);
        inputCar = findViewById(R.id.inputCar);
        inputCellPhone = findViewById(R.id.inputCellPhone);
        inputInsurance = findViewById(R.id.inputInsurance);
        inputSavings = findViewById(R.id.inputSavings);
        inputDebt = findViewById(R.id.inputDebt);
        inputMisc = findViewById(R.id.inputMisc);
        button_notify = findViewById(R.id.notify);
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
        createNotificationChannel();
    }


    //Creates Options Menu and Gives option for Dark Mode
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }


    //Creating and Sending Notification
    public void sendNotification() {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

    public void createNotificationChannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Cole's Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Cole");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(){
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("Cole's Notification")
                .setContentText("This is my notification.")
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true);
        return notifyBuilder;
    }

    public void launchBillsActivity(View view) {
        Intent intent = new Intent(this, BillsActivity.class);
        String inputIncomeMessage = inputIncome.getText().toString();
        String inputRentMessage = inputRent.getText().toString();
        String inputUtilitiesMessage = inputUtilities.getText().toString();
        String inputGroceriesMessage = inputGroceries.getText().toString();
        String inputCarMessage = inputCar.getText().toString();
        String inputCellPhoneMessage = inputCellPhone.getText().toString();
        String inputInsuranceMessage = inputInsurance.getText().toString();
        String inputSavingsMessage = inputSavings.getText().toString();
        String inputDebtMessage = inputDebt.getText().toString();
        String inputMiscMessage = inputMisc.getText().toString();
        intent.putExtra(INCOME_KEY,inputIncomeMessage);
        intent.putExtra(RENT_KEY,inputRentMessage);
        intent.putExtra(UTILITIES_KEY,inputUtilitiesMessage);
        intent.putExtra(GROCERIES_KEY,inputGroceriesMessage);
        intent.putExtra(CAR_KEY,inputCarMessage);
        intent.putExtra(CELLPHONE_KEY,inputCellPhoneMessage);
        intent.putExtra(INSURANCE_KEY,inputInsuranceMessage);
        intent.putExtra(SAVINGS_KEY,inputSavingsMessage);
        intent.putExtra(DEBT_KEY,inputDebtMessage);
        intent.putExtra(MISC_KEY,inputMiscMessage);

        startActivity(intent);
    }
}