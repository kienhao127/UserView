package com.example.cpu11341_local.userviewtest;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

import android.widget.TextView;

import java.util.ArrayList;

public class ViewTimeActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_view_time);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_time, menu);
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
    public static ArrayList<ViewTimeData> arrayListViewTimeData = new ArrayList<ViewTimeData>();
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_STRING = "section_string";
        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(ARG_SECTION_STRING, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_view_time, container, false);
            String str = getArguments().getString(ARG_SECTION_STRING);
            SetViewTimeInfo();

            ArrayList<String> arrayListColName = new ArrayList<>();
            ArrayList<String> arrayListColNameColor = new ArrayList<>();
            ArrayList<Integer> arrayListViewTime = new ArrayList<>();

            arrayListColName.add("Show");
            arrayListColName.add("PC");
            arrayListColName.add("Moblie");
            arrayListColName.add("Khác");

            arrayListColNameColor.add("#3fc3c5");
            arrayListColNameColor.add("#fe5e5e");
            arrayListColNameColor.add("#ffbd4a");
            arrayListColNameColor.add("#4069ff");

            for (ViewTimeData v : arrayListViewTimeData){
                if (v.getViewDate() == str){
                    arrayListViewTime.clear();
                    arrayListViewTime.add(v.getShowTime());
                    arrayListViewTime.add(v.getPCTime());
                    arrayListViewTime.add(v.getMobileTime());
                    arrayListViewTime.add(v.getOtherTime());

                }
            }

            CustomBarChart graphicView = (CustomBarChart) rootView.findViewById(R.id.custom_bar_chart);
            graphicView.setColValue(arrayListColName, arrayListColNameColor, arrayListViewTime);
            return rootView;
        }

        void SetViewTimeInfo(){
            arrayListViewTimeData.add(new ViewTimeData("1", "5/2017", 3,2,0,0));
            arrayListViewTimeData.add(new ViewTimeData("1", "6/2017", 120,30,26,4));
            arrayListViewTimeData.add(new ViewTimeData("1", "7/2017", 31,22,40,10));
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
                    return ViewTimeActivity.PlaceholderFragment.newInstance("5/2017");
                }
                case 1:{
                    return ViewTimeActivity.PlaceholderFragment.newInstance("6/2017");
                }
            }
            return ViewTimeActivity.PlaceholderFragment.newInstance("7/2017");
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
