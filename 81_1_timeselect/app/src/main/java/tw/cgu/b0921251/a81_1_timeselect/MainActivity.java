package tw.cgu.b0921251.a81_1_timeselect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity
        implements View.OnTouchListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    TextView date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        time = findViewById(R.id.time);

        date.setOnTouchListener(this);
        time.setOnTouchListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if (view.getId() == R.id.date){
            DateTimeFormatter yyyy = DateTimeFormatter.ofPattern("yyyy");
            DateTimeFormatter MM = DateTimeFormatter.ofPattern("MM");
            DateTimeFormatter dd = DateTimeFormatter.ofPattern("dd");
            LocalDateTime now = LocalDateTime.now();
            try {
                new DatePickerDialog(this, this, Integer.parseInt(yyyy.format(now)), Integer.parseInt(MM.format(now)), Integer.parseInt(dd.format(now))).show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if (view.getId() == R.id.time){
            DateTimeFormatter hh = DateTimeFormatter.ofPattern("yyyy");
            DateTimeFormatter mm = DateTimeFormatter.ofPattern("MM");
            LocalDateTime now = LocalDateTime.now();
            try{
                new TimePickerDialog(this, this,Integer.parseInt(hh.format(now)),Integer.parseInt(mm.format(now)),true).show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void onDateSet(DatePicker dp, int yyyy, int MM, int dd){
        date.setText("您設定的日期為\n " + yyyy + "年" + MM + "月" + dd + "日");
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hh, int mm) {
        time.setText("您設定的日期為\n " + hh + "點" + mm + "分");
    }
}