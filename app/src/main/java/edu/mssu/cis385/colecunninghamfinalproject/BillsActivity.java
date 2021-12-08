package edu.mssu.cis385.colecunninghamfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.testng.annotations.Test;

public class BillsActivity extends AppCompatActivity {
    public static String inputIncomeMessage;
    public static String inputRentMessage;
    public static String inputUtilitiesMessage;
    public static String inputGroceriesMessage;
    public static String inputCarMessage;
    public static String inputCellPhoneMessage;
    public static String inputInsuranceMessage;
    public static String inputSavingsMessage;
    public static String inputDebtMessage;
    public static String inputMiscMessage;
    public static String lowerText;

    public static int income;
    public static int rent;
    public static int utilities;
    public static int groceries;
    public static int car;
    public static int cellphone;
    public static int insurance;
    public static int savings;
    public static int debt;
    public static int misc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        inputIncomeMessage = getIntent().getStringExtra(MainActivity.INCOME_KEY);
        inputRentMessage = getIntent().getStringExtra(MainActivity.RENT_KEY);
        inputUtilitiesMessage = getIntent().getStringExtra(MainActivity.UTILITIES_KEY);
        inputGroceriesMessage = getIntent().getStringExtra(MainActivity.GROCERIES_KEY);
        inputCarMessage = getIntent().getStringExtra(MainActivity.CAR_KEY);
        inputCellPhoneMessage = getIntent().getStringExtra(MainActivity.CELLPHONE_KEY);
        inputInsuranceMessage = getIntent().getStringExtra(MainActivity.INSURANCE_KEY);
        inputSavingsMessage = getIntent().getStringExtra(MainActivity.SAVINGS_KEY);
        inputDebtMessage = getIntent().getStringExtra(MainActivity.DEBT_KEY);
        inputMiscMessage = getIntent().getStringExtra(MainActivity.MISC_KEY);

        //Intent intent = getIntent();
        ConvertMessages(); //Converts input to int
        BillCheck(); //Checks input to see if they are spending too much of budget
        CreateMessages(); // Creates Messages for "% of Income" and if they spend too much
        SetMessages(); //Sends the messages to the text fields
    }

    public static void ConvertMessages(){
        income = Integer.parseInt(inputIncomeMessage);
        rent = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        utilities = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        groceries = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        car = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        cellphone = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        insurance = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        savings = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        debt = (Integer.parseInt(inputIncomeMessage)) / income * 100;
        misc = (Integer.parseInt(inputIncomeMessage)) / income * 100;
    }

    public static void BillCheck(){
        if (rent > 30)
        {
            lowerText += "Rent";
        }
        if (utilities > 10)
        {
            lowerText += "Utilities";
        }
        if (car > 10)
        {
            lowerText += "Car";
        }
        if (insurance > 10)
        {
            lowerText += "Insurance";
        }
        if (savings > 15)
        {
            lowerText += "Rent";
        }
        if (groceries > 15)
        {
            lowerText += "Utilities";
        }
        if (cellphone > 15)
        {
            lowerText += "Cell Phone";
        }
        else
        {
            lowerText = "All of your bills are fine";
        }
    }

    public static void CreateMessages()
    {
        inputIncomeMessage = (income + "% of your income");
        inputRentMessage = (rent + "% of your income");
        inputUtilitiesMessage = (utilities + "% of your income");
        inputGroceriesMessage = (groceries + "% of your income");
        inputCarMessage = (car + "% of your income");
        inputCellPhoneMessage = (cellphone + "% of your income");
        inputInsuranceMessage = (insurance + "% of your income");
        inputSavingsMessage = (savings + "% of your income");
        inputDebtMessage = (debt + "% of your income");
        inputMiscMessage = (misc + "% of your income");
    }

    public void SetMessages()
    {
        TextView textViewRent = findViewById(R.id.textRentPer);
        TextView textViewUtilities = findViewById(R.id.textUtilitiesPer);
        TextView textViewGroceries = findViewById(R.id.textGroceriesPer);
        TextView textViewCar = findViewById(R.id.textCarPer);
        TextView textViewCellPhone = findViewById(R.id.textCellPhonePer);
        TextView textViewInsurance = findViewById(R.id.textInsurancePer);
        TextView textViewSavings = findViewById(R.id.textSavingsPer);
        TextView textViewDebt = findViewById(R.id.textDebtPer);
        TextView textViewMisc = findViewById(R.id.textMiscPer);
        TextView textPercentOver = findViewById(R.id.textPercentOver);

        textViewRent.setText(inputRentMessage);
        textViewUtilities.setText(inputUtilitiesMessage);
        textViewGroceries.setText(inputGroceriesMessage);
        textViewCar.setText(inputCarMessage);
        textViewCellPhone.setText(inputCellPhoneMessage);
        textViewInsurance.setText(inputInsuranceMessage);
        textViewSavings.setText(inputSavingsMessage);
        textViewDebt.setText(inputDebtMessage);
        textViewMisc.setText(inputMiscMessage);
        textPercentOver.setText(lowerText);

    }

    public void launchMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}