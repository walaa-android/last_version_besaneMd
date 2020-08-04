package com.example.besanemd.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.besanemd.R;
import com.example.besanemd.activities.AboutUsActivity;
import com.example.besanemd.activities.ContactUsActivity;
import com.example.besanemd.activities.EditProfileActivity;
import com.example.besanemd.activities.SplashActivity;
import com.example.besanemd.activities.TestResultActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    ImageView imageViewBack ;
    TextView editProfile , textViewLogOut ,  test_result  , textViewAboutUs , textViewContactUs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =inflater.inflate(R.layout.fragment_profile, container, false);
        imageViewBack = v.findViewById(R.id.imageViewBack);
        textViewAboutUs= v.findViewById(R.id.textViewAboutUs);
        textViewContactUs=v.findViewById(R.id.textViewContactUs);
        textViewContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactUsIntent = new Intent (getContext() , ContactUsActivity.class);
                startActivity(contactUsIntent);
            }
        });
        textViewAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent aboutUsIntent = new Intent (getContext() , AboutUsActivity.class);
              startActivity(aboutUsIntent);
            }
        });
        textViewLogOut=v.findViewById(R.id.textViewLogOut);
        test_result= v.findViewById(R.id.test_result);
        test_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listResult = new Intent(getContext() , TestResultActivity.class);
                startActivity(listResult);
            }
        });
        editProfile = v.findViewById(R.id.editProfile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editProfileIntent = new Intent(getContext() , EditProfileActivity.class);
                startActivity(editProfileIntent);
            }
        });


        textViewLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogLog = new Dialog(getContext());
                dialogLog.setContentView(R.layout.log_out_dialog);
                dialogLog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView  text_view_cancel = dialogLog.findViewById(R.id.text_view_cancel);
                ImageView  close_icon = dialogLog.findViewById(R.id.close_icon);
                close_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogLog.dismiss();
                    }
                });
                text_view_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       dialogLog.dismiss();
                    }
                });
                TextView text_view_confirm = dialogLog.findViewById(R.id.text_view_confirm);
                text_view_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity() , SplashActivity.class);
                        startActivity(intent);
                    }
                });
                dialogLog.show();
                dialogLog.setCancelable(false);
            }
        });


        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return v;
    }
}