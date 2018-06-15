package at.wifi.swdev.gameandcounter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Task1Activity extends AppCompatActivity {

    int score = 0;

    Button answer1, answer2, answer3, answer4;
    TextView question, countLabel;

    private String rightAnswer;
    private int rightAnswerCount, wrongAnswerCount;
    private int quizCount = 1;

    static final private int QUIZ_COUNT = 3;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            {"question", "rightAnswer", "choise1", "choise2", "choise3"},
            {"questiona", "rightAnswera", "choise1a", "choise2a", "choise3a"},
            {"questionb", "rightAnswerb", "choise1b", "choise2b", "choise3b"},
            {"questionc", "rightAnswerc", "choise1c", "choise2c", "choise3c"},
            {"questiond", "rightAnswerd", "choise1d", "choise2d", "choise3d"},
            {"questione", "rightAnswere", "choise1e", "choise2e", "choise3e"},
            {"questionf", "rightAnswerf", "choise1f", "choise2f", "choise3f"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        countLabel = findViewById(R.id.countLabelTV);
        question = findViewById(R.id.questionTV);

        answer1 = findViewById(R.id.answer1BTN);
        answer2 = findViewById(R.id.answer2BTN);
        answer3 = findViewById(R.id.answer3BTN);
        answer4 = findViewById(R.id.answer4BTN);

        for (int i = 0; i < quizData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //Question
            tmpArray.add(quizData[i][1]); //Right Answer
            tmpArray.add(quizData[i][2]); //Choise 1
            tmpArray.add(quizData[i][3]); //Choise2
            tmpArray.add(quizData[i][4]); //Choise3

            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {
        countLabel.setText("Q" + quizCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        answer1.setText(quiz.get(0));
        answer2.setText(quiz.get(1));
        answer3.setText(quiz.get(2));
        answer4.setText(quiz.get(3));

        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view) {
        Button answerBTN = (Button) findViewById(view.getId());
        String btnText = answerBTN.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)) {
            alertTitle = "Correct!";
            rightAnswerCount++;
        } else {
            wrongAnswerCount++;
            alertTitle = "Wrong...";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer:" + rightAnswer);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);
                } else {
                    quizCount++;
                    showNextQuiz();
                }

            }
        });
        builder.setCancelable(false);
        builder.show();
    }


};

   /* View.OnClickListener handler1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            score++;
            Toast.makeText(Task1Activity.this, "" + score, Toast.LENGTH_SHORT).show();
            if (score >= 5) {
                Intent intent = new Intent(Task1Activity.this, ResultActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);

            }
        }
    };
    View.OnClickListener handler2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };*/



