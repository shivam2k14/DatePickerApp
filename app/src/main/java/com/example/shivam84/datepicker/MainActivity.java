package com.example.shivam84.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Button btn_click;
    int year_x;
    int month_x;
    int day_x;
    private static final int dialog_id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar cal= Calendar.getInstance();

        showDialogOnClickButton();
        year_x=cal.get(Calendar.YEAR);
        month_x=cal.get(Calendar.MONTH);
        day_x=cal.get(Calendar.DAY_OF_MONTH);

    }

    public void showDialogOnClickButton(){

        btn_click=(Button)findViewById(R.id.button);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialog_id);

            }
        }
        );
    }


    @Override
    protected Dialog onCreateDialog(int id){
        if(id == dialog_id)
        return new DatePickerDialog(this,dPickerListener,year_x,month_x,day_x);
        return null;

    }


    private DatePickerDialog.OnDateSetListener dPickerListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x=year;
            month_x=month +1;
            day_x=dayOfMonth;

            Toast.makeText(MainActivity.this,year_x +"/"+ month_x + "/" +day_x,Toast.LENGTH_LONG).show();


        }
    };
}
