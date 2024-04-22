package tw.cgu.b0921251.a8_4intentsendingback;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class editing extends AppCompatActivity
    implements DatePickerDialog.OnDateSetListener{

    EditText T_date, T_fee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        T_date = findViewById(R.id.T_date);
        T_fee = findViewById(R.id.T_fee);
    }

    public void save(View v){
        if (T_date.getText().toString().isEmpty())
            Toast.makeText(this,"請輸入日期！",Toast.LENGTH_SHORT).show();
        else if (T_fee.getText().toString().isEmpty())
            Toast.makeText(this,"請出入金額！", Toast.LENGTH_SHORT).show();
        else {
            Intent itb = new Intent();
            itb.putExtra("fee", T_date.getText().toString() + "`" + T_fee.getText().toString());
            setResult(RESULT_OK, itb);
            finish();
        }
    }

    public void cancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void changeTime(View v){
        try {
            DateTimeFormatter yyyy = DateTimeFormatter.ofPattern("yyyy");
            DateTimeFormatter MM = DateTimeFormatter.ofPattern("MM");
            DateTimeFormatter dd = DateTimeFormatter.ofPattern("dd");
            LocalDateTime now = LocalDateTime.now();
            new DatePickerDialog(this, this, Integer.parseInt(yyyy.format(now)), Integer.parseInt(MM.format(now)), Integer.parseInt(dd.format(now))).show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void onDateSet(DatePicker dp, int yyyy, int MM, int dd){
        T_date.setText(yyyy + "/" + MM + "/" + dd);
    }
}