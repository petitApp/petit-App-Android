package com.example.petit_app;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

public class CalendarFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    RegisterActivity registerActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        registerActivity = (RegisterActivity) getActivity();

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Toast.makeText(getActivity(), dayOfMonth + " / " + (month+1) + " / " + year, Toast.LENGTH_SHORT).show();
        Calendar calendar = new GregorianCalendar(year, (month), dayOfMonth);
        Date dateCalendar = calendar.getTime();
        registerActivity.sendDatePicker(dateCalendar);
    }



}