package com.example.android.musicalstructureapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.musicalstructureapp.Activities.PlaySongActivity;
import com.example.android.musicalstructureapp.R;

import static com.example.android.musicalstructureapp.Activities.MainActivity.adapter;
import static com.example.android.musicalstructureapp.Activities.MainActivity.isIntentFromArtists;
import static com.example.android.musicalstructureapp.Activities.MainActivity.isIntentFromPlaylist;

public class SongsFragment extends Fragment {
    private View song_fragment_view;
    private RelativeLayout clickButton;
    private TextView songs_fragment_textView;

    public SongsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initializeUiComponents(inflater, container);
        setListenerOnClickButton();
        return song_fragment_view;
    }

    private void initializeUiComponents(LayoutInflater inflater, ViewGroup container) {
        song_fragment_view = inflater.inflate(R.layout.fragment_view, container, false);
        clickButton = (RelativeLayout) song_fragment_view.findViewById(R.id.fragmentViewId);
        songs_fragment_textView = (TextView) song_fragment_view.findViewById(R.id.fragment_text_view);
        if (isIntentFromPlaylist) {
            songs_fragment_textView.setText(getActivity().getResources().getString(R.string.tab_1_body_from_playlists));
            isIntentFromPlaylist = false;
        } else if (isIntentFromArtists) {
            songs_fragment_textView.setText(getActivity().getResources().getString(R.string.tab_1_body_from_artists));
            isIntentFromArtists = false;
        } else {
            songs_fragment_textView.setText(getActivity().getResources().getString(R.string.tab_1_body));
        }
    }

    private void setListenerOnClickButton() {
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPlaySongActivity = new Intent(getActivity(), PlaySongActivity.class);
                startActivity(goToPlaySongActivity);
            }
        });
    }
}
