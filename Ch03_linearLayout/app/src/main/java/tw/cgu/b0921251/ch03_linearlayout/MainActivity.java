package tw.cgu.b0921251.ch03_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void editFinal(View v){
        TextView a = findViewById(R.id.L_final);
        EditText b = findViewById(R.id.T_name);
        EditText c = findViewById(R.id.T_lname);
        EditText d = findViewById(R.id.T_phone);
        EditText e = findViewById(R.id.T_pswd);
//        if (e.getText().toString().equals("12345678")) {
            a.setText(b .getText().toString() + c.getText().toString() + "\n電話是：" + d.getText().toString());
//        }
    }
}