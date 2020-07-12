package com.example.besanemd.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.besanemd.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourthStepFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourthStepFragment extends Fragment {
TextView textViewStepForth;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FourthStepFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FourthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourthStepFragment newInstance(String param1, String param2) {
        FourthStepFragment fragment = new FourthStepFragment();
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



        View v= inflater.inflate(R.layout.fragment_fourth, container, false);
        textViewStepForth = v.findViewById(R.id.textViewStepForth);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString str1= new SpannableString("Putting ");
    /*    StyleSpan boldSpan = new StyleSpan(android.graphics.Typeface.BOLD );
        builder.append("Blood ", boldSpan, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                .append("Sample\n" +
                        " Collection");*/

        str1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorBlack)), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("The Chemical\n");
        str2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 0, str2.length(), 0);
        builder.append(str2);

        SpannableString str3= new SpannableString("To The Kit");
        str3.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorBlack)), 0, str3.length(), 0);
        builder.append(str3);
        textViewStepForth.setText( builder, TextView.BufferType.SPANNABLE);

        return v;
    }
}