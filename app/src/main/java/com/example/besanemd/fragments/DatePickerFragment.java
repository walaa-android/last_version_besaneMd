package com.example.besanemd.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.besanemd.R;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends   DialogFragment {

    String date;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }
    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    date="" + view.getDayOfMonth()+" / " + (view.getMonth()+1)+" / " + view.getYear();

                    EditText editTextDateOfBirth=getActivity().findViewById(R.id.editTextDateOfBirth);

                    editTextDateOfBirth.setText(date);




                }
            };

}
