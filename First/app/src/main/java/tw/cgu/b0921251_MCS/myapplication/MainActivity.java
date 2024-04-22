package tw.cgu.b0921251_MCS.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }


    public void button_click_toast(View view){
        Toast.makeText(this, "大家好", Toast.LENGTH_SHORT).show();
    }




    public void button_click_popup(View view){
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) MainActivity.this);
        popup.inflate(R.menu.menu_main);
        popup.show();
    }
}