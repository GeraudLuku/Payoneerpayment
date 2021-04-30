package com.example.payoneerpayment;

import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {


    //check if appbar is visible on activity launch
    @Test
    public void test_isAppBarVisible_onAppLaunch() {
        

        onView(withId(R.id.toolbar))
                .check(matches(isDisplayed()));

    }

    //check if progress is visible on activity launch
    @Test
    public void test_isProgressbarVisible_onAppLaunch() {
        onView(withId(R.id.load_progress))
                .check(matches(isDisplayed()));

    }

    //check if recyclerview is not visible on activity launch
    @Test
    public void test_isRecyclerviewInVisible_onAppLaunch() {
        onView(withId(R.id.recyclerview))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

    }
}