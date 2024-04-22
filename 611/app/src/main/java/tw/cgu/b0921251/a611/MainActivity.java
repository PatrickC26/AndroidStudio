package tw.cgu.b0921251.a611;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements TextWatcher, AdapterView.OnItemSelectedListener {

    Spinner S_Volt;
    EditText T_amper, T_amount, T_perday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        S_Volt = findViewById(R.id.S_Volt);
        T_amount = findViewById(R.id.T_amount);
        T_amper = findViewById(R.id.T_Amper);
        T_perday = findViewById(R.id.T_perday);

        S_Volt.setOnItemSelectedListener(this);
        T_amount.addTextChangedListener(this);
        T_perday.addTextChangedListener(this);
        T_amper.addTextChangedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        caculate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    void caculate(){
        TextView info = findViewById(R.id.L_info);
        if (!(T_amount.getText().toString().isEmpty() || T_amper.getText().toString().isEmpty() || T_perday.getText().toString().isEmpty())){
            try {
                double amper = Double.parseDouble(T_amper.getText().toString());
                double amount = Double.parseDouble(T_amount.getText().toString());
                double perday = Double.parseDouble(T_perday.getText().toString());
                double voltage = Double.parseDouble(S_Volt.getSelectedItem().toString().substring(0,3));

                double finalV =  30*amount*amper*perday*voltage/1000.0;
                info.setText("$" + String.valueOf(finalV));

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            info.setText("請輸入完整資訊");
        }
    }



    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        caculate();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        caculate();
    }
}