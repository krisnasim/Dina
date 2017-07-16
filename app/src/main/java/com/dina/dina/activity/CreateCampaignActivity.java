package com.dina.dina.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.dina.dina.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateCampaignActivity extends AppCompatActivity {

    @BindView(R.id.pick_time_input) EditText pick_time_input;
    @BindView(R.id.info_program_name_input) EditText info_program_name_input;
    @BindView(R.id.info_competitor_input) EditText info_competitor_input;


    private Calendar myCalendar;
    private TimePickerDialog.OnTimeSetListener startTimeListener;

    @OnClick(R.id.pick_time_input)
    public void pickStartDate() {
        new TimePickerDialog(CreateCampaignActivity.this, startTimeListener,
                myCalendar.get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE),
                true).show();
        updateDateLabel(pick_time_input);
    }

    @OnClick(R.id.new_campaign_button)
    public void createCampaign() {
        String campaignTitle = info_program_name_input.getText().toString();
        String campaignContent = info_competitor_input.getText().toString();
        String time = pick_time_input.getText().toString();

        if(campaignTitle.matches("") || campaignContent.matches("") || time.matches("")) {
            Toast.makeText(this, "oops, something is missing from your form! Please check again", Toast.LENGTH_SHORT).show();
        } else {
            //wait for REST function!
            //for now...
            Toast.makeText(this, "Campaign created successfully!", Toast.LENGTH_SHORT).show();
            goBackHome();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_campaign);
        ButterKnife.bind(this);
        myCalendar = Calendar.getInstance();
        initiateTimeListeners();

        setTitle("Create New Campaign");

        pick_time_input.setFocusable(false);
        pick_time_input.setClickable(false);
    }

    private void initiateTimeListeners() {
        startTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                myCalendar.set(Calendar.MINUTE, minute);
                updateDateLabel(pick_time_input);
            }
        };
    }

    private void updateDateLabel(EditText obj) {
        //String myFormat = "dd/MM/yy"; //In which you need put here
        String myFormat = "HH:mm"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        obj.setText(sdf.format(myCalendar.getTime()));
    }

    private void goBackHome() {
        //make intent to go back to home
        Intent intent = new Intent(CreateCampaignActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
