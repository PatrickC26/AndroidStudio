package tw.cgu.b0921251.a4_5vibrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnTouchListener{

    TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.Text);
        a.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN)
            vb.vibrate(5000);
        else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
            vb.cancel();

        return true;
    }
}