package tw.cgu.b0921251.a72survey;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements DialogInterface.OnClickListener {

    ImageView ig1,ig2,ig3;
    TextView L_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ig1 = findViewById(R.id.IG1);
        ig2 = findViewById(R.id.IG2);
        ig3 = findViewById(R.id.IG3);

        ig1.setVisibility(View.GONE);
        ig2.setVisibility(View.GONE);
        ig3.setVisibility(View.GONE);

        L_show = findViewById(R.id.L_show);
    }


    public void start(View v){
        new AlertDialog.Builder(this)
                .setTitle("畢業問卷調查")
                .setMessage("")
                .setIcon(android.R.drawable.ic_menu_edit)
                .setNeutralButton("考慮中", (DialogInterface.OnClickListener) this)
                .setPositiveButton("打算", (DialogInterface.OnClickListener) this)
                .setNegativeButton("不打算", (DialogInterface.OnClickListener) this)
                .show();
        Button a = findViewById(R.id.button);
        a.setText("再問一次");
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        ig1.setVisibility(View.GONE);
        ig2.setVisibility(View.GONE);
        ig3.setVisibility(View.GONE);
        if (i == DialogInterface.BUTTON_NEUTRAL){
            L_show.setText("長庚五年一貫便宜又快速");
            ig1.setVisibility(View.VISIBLE);
            L_show.setTextColor(Color.BLUE);
        }
        else if (i == DialogInterface.BUTTON_NEGATIVE){
            L_show.setText("可以慢慢照工作了");
            ig2.setVisibility(View.VISIBLE);
            L_show.setTextColor(Color.RED);
        }
        else if (i == DialogInterface.BUTTON_POSITIVE){
            L_show.setText("祝你有個好的決定");
            ig3.setVisibility(View.VISIBLE);
            L_show.setTextColor(Color.GREEN);
        }
    }
}