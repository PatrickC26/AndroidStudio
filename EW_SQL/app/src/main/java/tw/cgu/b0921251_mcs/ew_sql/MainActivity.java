package tw.cgu.b0921251_mcs.ew_sql;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_Click();
            }
        });
    }

    public void button_Click() {
        dbHelper = new MyDBHelper(this);
        db = dbHelper.getWritableDatabase();
        TextView output = (TextView)
                findViewById(R.id.output);
        output.setText("資料庫是否開啟: " + db.isOpen() +
                "\n資料庫版本: " + db.getVersion());
    }
}
