package com.example.admin.allofferstesapp;

import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import utils.Utils;
/*
created by Anjana
 */

public class MainActivity extends AppCompatActivity implements OptionsScreenEveryWhere {
    /*
    font icons to set fonts
     */
    Typeface fontIcons;
    /*
    coordinatorLayout is main container
     */
    CoordinatorLayout coordinatorLayout;

    /*
    custom adapter
     */
    MyAdapter adapter;

    @Override
    public void navigateToEveryWhereFragment() {
        Utils.changeFragment(getSupportFragmentManager(), coordinatorLayout.getId(), OffersFragment
                .newInstance(fontIcons), FragmentTransaction.TRANSIT_NONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing font icon
        fontIcons = Typeface.createFromAsset(this.getAssets(), "MyFont.ttf");
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(toolbar);

        //finding views
        TextView leftIcon = (TextView) findViewById(R.id.tvLeft);
        TextView rightIcon = (TextView) findViewById(R.id.tvRightOne);
        TextView title = (TextView) findViewById(R.id.tvToolbarTitle);

        title.setText(Utils.formTitle(getResources().getString(R.string.title),
                getResources().getString(R.string.sub_title), R.style.jpb_title, R.style.jpb_subtitle, this));
        //setting font icons
        leftIcon.setTypeface(fontIcons);
        rightIcon.setTypeface(fontIcons);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);
        //adding fragment
        navigateToEveryWhereFragment();
    }
}
