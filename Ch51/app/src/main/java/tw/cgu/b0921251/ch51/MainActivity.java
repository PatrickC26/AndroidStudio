package tw.cgu.b0921251.ch51;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void selected(View V){
        TextView text = findViewById(R.id.text);
        RadioGroup ticket = findViewById(R.id.radioGroup);

        switch (ticket.getCheckedRadioButtonId()){
            case R.id.radioButton:
                text.setText("買全票");
                break;

            case R.id.radioButton2:
                text.setText("買半票");
                break;

            case R.id.radioButton3:
                text.setText("買敬老票");
                break;
        }
    }
}