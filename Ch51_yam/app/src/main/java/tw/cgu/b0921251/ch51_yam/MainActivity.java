package tw.cgu.b0921251.ch51_yam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, TextWatcher {

    TextView weight1, weight2, buy1, buy2, total;
    EditText money, weight;
    RadioGroup moneyR, weightR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.T_weight);
        money = findViewById(R.id.T_money);
        money.addTextChangedListener(this);
        weight.addTextChangedListener(this);


        weight1 = findViewById(R.id.LF_money1);
        weight2 = findViewById(R.id.LF_money2);

        buy1 = findViewById(R.id.LF_weight2);
        buy2 = findViewById(R.id.LF_weight3);

        total = findViewById(R.id.LF_total);

        moneyR = findViewById(R.id.R_money);
        weightR = findViewById(R.id.R_weight);
        moneyR.setOnCheckedChangeListener(this);
        weightR.setOnCheckedChangeListener(this);
    }


    void cacl(){
        double monD, mon1, mon2;
        double weiD, wei1, wei2;


        try {
            monD = Double.parseDouble(money.getText().toString());
        }
        catch (Exception e){
            monD = 0;
        }

        try {
            weiD = Double.parseDouble(weight.getText().toString());
        }
        catch (Exception e){
            weiD = 0;
        }

        if (moneyR.getCheckedRadioButtonId() == R.id.money1) {
            mon1 = monD ;
            mon2 = monD / 0.6;
        }
        else {
            mon2 = monD;
            mon1 = monD * 0.6;
        }

        if (weightR.getCheckedRadioButtonId() == R.id.weight1) {
            wei1 = weiD;
            wei2 = weiD * 0.6;
        }
        else {
            wei2 = weiD;
            wei1 = weiD / 0.6;
        }

        weight1.setText("每斤價格：" + String.format("%.1f", mon1));
        weight2.setText("每公斤價格：" + String.format("%.1f", mon2));

        buy1.setText("斤：" + String.format("%.1f", wei1));
        buy2.setText("公斤：" + String.format("%.1f", wei2));

        double totalD = wei1 * mon1;

        total.setText("總共：" + String.format("%.1f", totalD));
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        cacl();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        cacl();
    }
}