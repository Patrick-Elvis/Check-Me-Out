package com.ruth.checkmeout;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.ruth.checkmeout.ui.MainActivity;
import com.ruth.checkmeout.ui.ScanningFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ScannerInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkScannedFragment() {
        ScanningFragment fragment=new ScanningFragment();
        activityTestRule.getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flContent,fragment).commit();
        try {                             // the sleep method requires to be checked and handled so we use try block
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }

    }
}
