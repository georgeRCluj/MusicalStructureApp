package com.example.android.musicalstructureapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.musicalstructureapp.Fragments.ArtistsFragment;
import com.example.android.musicalstructureapp.Fragments.PlaylistsFragment;
import com.example.android.musicalstructureapp.Fragments.SongsFragment;
import com.example.android.musicalstructureapp.Fragments.StoreFragment;

public class TabsCategoryAdapter extends FragmentPagerAdapter {
    private final int SONGS_FRAGMENT = 0;
    private final int PLAYLISTS_FRAGMENT = 1;
    private final int ARTISTS_FRAGMENT = 2;
    private final int STORE_FRAGMENT = 3;
    private final int ALL_FRAGMENTS = 4;

    private Context mContext;

    public TabsCategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case SONGS_FRAGMENT:
                return new SongsFragment();
            case PLAYLISTS_FRAGMENT:
                return new PlaylistsFragment();
            case ARTISTS_FRAGMENT:
                return new ArtistsFragment();
            case STORE_FRAGMENT:
                return new StoreFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return ALL_FRAGMENTS;
    }
}
