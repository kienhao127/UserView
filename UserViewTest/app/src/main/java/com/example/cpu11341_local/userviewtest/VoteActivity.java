package com.example.cpu11341_local.userviewtest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;

public class VoteActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vote, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager;
        ArrayList<VoteData> arrayListVote = new ArrayList<VoteData>();
        ArrayList<UserData> arrayListUser = new ArrayList<UserData>();

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_vote, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText("");

            setUserInfo();
            setVoteInfo();

            String str = getArguments().getString(ARG_SECTION_NUMBER);
            ArrayList<VoteData> newArrayListVote = new ArrayList<VoteData>();
            for (VoteData v : arrayListVote){
                if (v.getVoteDate() == str){
                    newArrayListVote.add(v);
                }
            }
            Collections.sort(newArrayListVote, new Comparator<VoteData>(){
                @Override
                public int compare(VoteData v1, VoteData v2) {
                    return Double.valueOf(v2.getScore()).compareTo(v1.getScore());
                }
            });
            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewVote);
            adapter = new RecyclerVoteAdapter(arrayListUser, newArrayListVote);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

            return rootView;
        }

        public void setVoteInfo(){
            arrayListVote.clear();
            VoteData voteData = new VoteData("1", "5/2017", 5);
            arrayListVote.add(voteData);
            voteData = new VoteData("1", "6/2017", 4.5);
            arrayListVote.add(voteData);
            voteData = new VoteData("1", "7/2017", 4.6);
            arrayListVote.add(voteData);
            voteData = new VoteData("2", "5/2017", 4.3);
            arrayListVote.add(voteData);
            voteData = new VoteData("2", "6/2017", 4.2);
            arrayListVote.add(voteData);
            voteData = new VoteData("2", "7/2017", 4.1);
            arrayListVote.add(voteData);
            voteData = new VoteData("3", "5/2017", 4.5);
            arrayListVote.add(voteData);
            voteData = new VoteData("3", "6/2017", 4.6);
            arrayListVote.add(voteData);
            voteData = new VoteData("3", "7/2017", 4.1);
            arrayListVote.add(voteData);
            voteData = new VoteData("4", "5/2017", 5);
            arrayListVote.add(voteData);
            voteData = new VoteData("4", "6/2017", 4.7);
            arrayListVote.add(voteData);
            voteData = new VoteData("4", "7/2017", 4.9);
            arrayListVote.add(voteData);
            voteData = new VoteData("5", "5/2017", 4.1);
            arrayListVote.add(voteData);
            voteData = new VoteData("5", "6/2017", 4);
            arrayListVote.add(voteData);
            voteData = new VoteData("5", "7/2017", 4.6);
            arrayListVote.add(voteData);
        }
        public void setUserInfo(){
            arrayListUser.clear();
            UserData userData = new UserData("1", "u1", R.drawable.u1);
            arrayListUser.add(userData);
            userData = new UserData("2", "u2", R.drawable.u2);
            arrayListUser.add(userData);
            userData = new UserData("3", "u3", R.drawable.u3);
            arrayListUser.add(userData);
            userData = new UserData("4", "u4", R.drawable.u4);
            arrayListUser.add(userData);
            userData = new UserData("5", "u5", R.drawable.u5);
            arrayListUser.add(userData);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:{
                    return PlaceholderFragment.newInstance("5/2017");
                }
                case 1:{
                    return PlaceholderFragment.newInstance("6/2017");
                }
            }
            return PlaceholderFragment.newInstance("7/2017");
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "5/2017";
                case 1:
                    return "6/2017";
                case 2:
                    return "7/2017";
            }
            return null;
        }
    }

}
