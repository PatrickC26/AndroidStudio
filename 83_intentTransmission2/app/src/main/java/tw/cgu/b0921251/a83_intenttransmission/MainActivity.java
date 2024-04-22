package tw.cgu.b0921251.a83_intenttransmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton boy, girl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boy = findViewById(R.id.RB_boy);
        girl = findViewById(R.id.RB_girl);
    }

    public void caculate(View view){
        Intent it = new Intent(this, showView.class);
        if (boy.isChecked())
            it.putExtra("gender", 0);
        else
            it.putExtra("gender", 1);
        TextView height = findViewById(R.id.T_height);
        it.putExtra("height", Double.parseDouble(height.getText().toString()));
        System.out.println(Double.parseDouble(height.getText().toString()));
        startActivity(it);
    }
}