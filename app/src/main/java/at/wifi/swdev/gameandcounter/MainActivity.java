package at.wifi.swdev.gameandcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTask1(View view) {
        Intent intent = new Intent(MainActivity.this, Task1Activity.class);
        startActivity(intent);
    }

    public void startTask2(View view) {
        Intent intent = new Intent(MainActivity.this, Task2Activity.class);
        startActivity(intent);
    }

    public void startTask3(View view) {
        Intent intent = new Intent(MainActivity.this, Task3Activity.class);
        startActivity(intent);
    }
}
