package com.dina.dina.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dina.dina.R;
import com.dina.dina.activity.CreateCampaignActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CampaignFragment extends Fragment {

    @OnClick(R.id.create_campaign_button)
    public void createCampaign() {
        //new Intent
        Intent intent = new Intent(getActivity(), CreateCampaignActivity.class);
        startActivity(intent);
    }

    public CampaignFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_campaign, container, false);
        ButterKnife.bind(this, view);
        getActivity().setTitle("Campaign");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
