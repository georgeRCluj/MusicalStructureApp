package com.example.android.musicalstructureapp.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.musicalstructureapp.Adapters.TabsCategoryAdapter;
import com.example.android.musicalstructureapp.R;

import static com.example.android.musicalstructureapp.Fragments.ArtistsFragment.INTENT_FROM_ASTISTS;
import static com.example.android.musicalstructureapp.Fragments.PlaylistsFragment.ACTIVITY_LANDING_KEY;
import static com.example.android.musicalstructureapp.Fragments.PlaylistsFragment.INTENT_FROM_PLAYLIST;

public class MainActivity extends AppCompatActivity {
    public static ViewPager viewPager;
    public static boolean isIntentFromPlaylist = false;
    public static boolean isIntentFromArtists = false;
    public static TabsCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeUiComponents();
        initializeTabAndViewPager();
        changeActionBarTitleDependingOnTheCurrentTab();
        checkIfActivityIsStartedFromIntent();
    }

    private void initializeUiComponents() {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initializeTabAndViewPager() {
        adapter = new TabsCategoryAdapter(MainActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setCustomView(R.layout.tab_1_songs);
        tabLayout.getTabAt(1).setCustomView(R.layout.tab_2_playlists);
        tabLayout.getTabAt(2).setCustomView(R.layout.tab_3_artists);
        tabLayout.getTabAt(3).setCustomView(R.layout.tab_4_store);
    }

    private void changeActionBarTitleDependingOnTheCurrentTab() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        getSupportActionBar().setTitle(R.string.Fragment_1_name);
                        break;
                    case 1:
                        getSupportActionBar().setTitle(R.string.Fragment_2_name);
                        break;
                    case 2:
                        getSupportActionBar().setTitle(R.string.Fragment_3_name);
                        break;
                    case 3:
                        getSupportActionBar().setTitle(R.string.Fragment_4_name);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void checkIfActivityIsStartedFromIntent() {
        Intent intent = getIntent();
        String intentLocation = intent.getStringExtra(ACTIVITY_LANDING_KEY);
        if (intentLocation != null) {
            if (intentLocation.equals(INTENT_FROM_PLAYLIST)) {
                isIntentFromPlaylist = true;
            } else if (intentLocation.equals(INTENT_FROM_ASTISTS)) {
                isIntentFromArtists = true;
            } else {
                isIntentFromPlaylist = false;
                isIntentFromArtists = false;
            }
        }
    }
}