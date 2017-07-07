package com.example.android.musicalstructureapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.musicalstructureapp.Activities.PurchaseSongActivity;
import com.example.android.musicalstructureapp.R;

public class StoreFragment extends Fragment {
    private View store_fragment_view;
    private RelativeLayout clickButton;
    private TextView store_fragment_textView;

    public StoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initializeUiComponents(inflater, container);
        setListenerOnClickButton();
        return store_fragment_view;
    }

    private void initializeUiComponents(LayoutInflater inflater, ViewGroup container) {
        store_fragment_view = inflater.inflate(R.layout.fragment_view, container, false);
        clickButton = (RelativeLayout) store_fragment_view.findViewById(R.id.fragmentViewId);
        store_fragment_textView = (TextView) store_fragment_view.findViewById(R.id.fragment_text_view);
        store_fragment_textView.setText(getActivity().getResources().getString(R.string.tab_4_body));
    }

    private void setListenerOnClickButton() {
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPurchaseActivity = new Intent(getActivity(), PurchaseSongActivity.class);
                startActivity(goToPurchaseActivity);
            }
        });
    }
}
