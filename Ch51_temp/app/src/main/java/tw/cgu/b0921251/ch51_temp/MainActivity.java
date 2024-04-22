package tw.cgu.b0921251.ch51_temp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener, TextWatcher {


    TextView tempC, tempF;
    EditText tempInput;
    RadioGroup tempType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempC = findViewById(R.id.L_tempC);
        tempF = findViewById(R.id.L_tempF);

        tempInput = findViewById(R.id.T_temp);
        tempInput.addTextChangedListener(this);

        tempType = findViewById(R.id.R_tempSelect);
        tempType.setOnCheckedChangeListener(this);
    }

    public void tempChange(){
        if (tempType.getCheckedRadioButtonId() == R.id.RBC){
            double tempi = 0.0;

            try {
                tempi = Double.parseDouble(tempInput.getText().toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }

            double c = tempi;
            double f = (tempi/1.8 + 32.0);

            tempC.setText(String.format("%.1f", c) + "°C");
            tempF.setText(String.format("%.1f", f) + "°F");

        }
        else {
            double tempi = 0.0;

            try {
                tempi = Double.parseDouble(tempInput.getText().toString());
            }
            catch (Exception e){
                e.printStackTrace();
            }

            double f = tempi;
            double c = (tempi -32.0)/1.8;

            tempC.setText(String.format("%.1f", c) + "°C");
            tempF.setText(String.format("%.1f", f) + "°F");
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        tempChange();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        tempChange();
    }
}