package at.wifi.swdev.gameandcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task2Activity extends AppCompatActivity {

    TextView wordTask, subject1, subject2;
    View subject1View, subject2View;

    private String rightSubject;
    private int rightAnswerCount, wrongAnswerCount;
    private int quizCount = 1;

    static final private int QUIZ_COUNT = 3;

    ArrayList<ArrayList<String>> wordArray = new ArrayList<>();

    String wordData[][] = {
            {"word", "rightSubject", "wrongSubject"},
            {"worda", "rightSubjecta", "wrongSubjecta"},
            {"wordb", "rightSubjectb", "wrongSubjectb"},
            {"wordc", "rightSubjectc", "wrongSubjectc"},
            {"wordd", "rightSubjectd", "wrongSubjectd"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        wordTask = findViewById(R.id.wordTV);
        subject1 = findViewById(R.id.subject1TV);
        subject2 = findViewById(R.id.subject2TV);
        subject1View = findViewById(R.id.viewOben);
        subject2View = findViewById(R.id.viewUnten);

        for (int i = 0; i < wordData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(wordData[i][0]); //word
            tmpArray.add(wordData[i][1]); //rightSubject
            tmpArray.add(wordData[i][2]); //wrongSubject

            wordArray.add(tmpArray);
        }
        showNextWordQuiz();

        wordTask.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });


    }

    public void showNextWordQuiz() {
        Random random = new Random();
        int randomNum = random.nextInt(wordArray.size());

        ArrayList<String> word = wordArray.get(randomNum);

        wordTask.setText(word.get(0));
        rightSubject = word.get(1);

        word.remove(0);
        Collections.shuffle(word);

        subject1.setText(word.get(0));
        subject2.setText(word.get(1));

        wordArray.remove(randomNum);
    }



}
