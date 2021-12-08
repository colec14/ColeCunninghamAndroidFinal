package edu.mssu.cis385.colecunninghamfinalproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BillsActivityTest {
    private BillsActivity mBillsActivity;

    @Before
    public void setUp() {mBillsActivity = new BillsActivity();}

    @Test
    public void UnitTest1() {
        TextView textViewRent = mBillsActivity.findViewById(R.id.textRentPer);
        assertTrue(textViewRent.isSingleLine());
    }

    @Test
    public void UnitTest2() {
        TextView test2 = mBillsActivity.findViewById(R.id.textMiscPer);
        String test3 = test2.getText().toString();
        assertFalse(test3 == "");
    }

    @Test
    public void UnitTest3()
    {
        Button test3 =mBillsActivity.findViewById(R.id.button);
        assertTrue(test3.isClickable());

    }
}