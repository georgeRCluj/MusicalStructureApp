package com.example.android.musicalstructureapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.musicalstructureapp.Activities.MainActivity;
import com.example.android.musicalstructureapp.R;

import static com.example.android.musicalstructureapp.Fragments.PlaylistsFragment.INTENT_FROM_PLAYLIST;

public class ArtistsFragment extends Fragment {
    private View artists_fragment_view;
    private RelativeLayout clickButton;
    private TextView artists_fragment_textView;
    public static String ACTIVITY_LANDING_KEY = "activity_landing_key";
    public static String INTENT_FROM_ASTISTS = "intent_from_artists";

    public ArtistsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initializeUiComponents(inflater, container);
        setListenerOnClickButton();
        return artists_fragment_view;
    }

    private void initializeUiComponents(LayoutInflater inflater, ViewGroup container) {
        artists_fragment_view = inflater.inflate(R.layout.fragment_view, container, false);
        clickButton = (RelativeLayout) artists_fragment_view.findViewById(R.id.fragmentViewId);
        artists_fragment_textView = (TextView) artists_fragment_view.findViewById(R.id.fragment_text_view);
        artists_fragment_textView.setText(getActivity().getResources().getString(R.string.tab_3_body));
    }

    private void setListenerOnClickButton() {
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainActivity = new Intent(getActivity(), MainActivity.class);
                goToMainActivity.putExtra(ACTIVITY_LANDING_KEY, INTENT_FROM_ASTISTS);
                startActivity(goToMainActivity);
            }
        });
    }
}
