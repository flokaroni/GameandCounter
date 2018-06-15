package at.wifi.swdev.gameandcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTV = findViewById(R.id.resultTV);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        resultTV.setText(score + " / 3");
    }

    public void startMain(View view) {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
