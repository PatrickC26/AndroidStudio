package tw.cgu.b0921251_mcs.ew_sql_30;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class addNew extends AppCompatActivity {
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    private EditText txtTitle, txtPrice, txtPerson;
    private CheckBox C_checkout;
    private static final String DATABASE_TABLE = "books";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        // 建立SQLiteOpenHelper物件
        dbHelper = new MyDBHelper(this);
        db = dbHelper.getWritableDatabase(); // 開啟資料庫

//        Toast mytoast = new Toast(this);
//        mytoast.setText("Result: " + String.valueOf(db.getPath()));
//        mytoast.show();


        txtTitle = findViewById(R.id.T_bookName);
        txtPrice = findViewById(R.id.T_bookPrice);
        txtPerson = findViewById(R.id.T_orderPerson);
        C_checkout = findViewById(R.id.C_hasCheckout);


        findViewById(R.id.B_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload();
                txtTitle.setText("");
                txtPerson.setText("");
                txtPrice.setText("");
                C_checkout.setChecked(false);
            }
        });
    }

    public void upload(){
        ContentValues cv = new ContentValues();
        cv.put("title", txtTitle.getText().toString());
        cv.put("person", txtPerson.getText().toString());

        double price = Double.parseDouble(txtPrice.getText().toString());
        cv.put("price", price);

        cv.put("checkOut", C_checkout.isChecked() ? 1 : 0);

        System.out.println("title: " + txtTitle.getText().toString());
        System.out.println("person: " + txtPerson.getText().toString());
        System.out.println("checkOut: " + String.valueOf(C_checkout.isChecked() ? 1 : 0));
        System.out.println("price: " + price);

        System.out.println(cv);




        long new_id = db.insert(DATABASE_TABLE, null, cv);

        Toast mytoast = new Toast(this);
        mytoast.setText("Result: " + String.valueOf(new_id));
        mytoast.show();


    }

}
