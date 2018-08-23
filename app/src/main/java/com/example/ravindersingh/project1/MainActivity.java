package com.example.ravindersingh.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * @param correctQuestion is used for calculating the number of question that student answered correctly
     * @param wrongQuestions is used for calculating the number of  question that student answered wrong
     */
    int correctQuestions = 0;
    int wrongQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "WELCOME TO THE QUIZ" + "\n" + "BEST OF LUCK !", Toast.LENGTH_LONG).show();
    }

    /**
     * checkCorrectQuestions function checks for the correct  answers from question Q1 to Q8
     */
    public void checkCorrectQuestions() {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radio_box_ques1_option2);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radio_box_ques2_option4);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radio_box_ques3_option3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.radio_box_ques4_option2);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.radio_box_ques5_option2);
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.radio_box_ques6_option2);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_ques7_option1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_ques7_option2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_ques7_option3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox_ques7_option4);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkbox_ques8_option1);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkbox_ques8_option2);
        CheckBox checkBox7 = (CheckBox) findViewById(R.id.checkbox_ques8_option3);
        CheckBox checkBox8 = (CheckBox) findViewById(R.id.checkbox_ques8_option4);
        if (radioButton1.isChecked()) {
            correctQuestions += 1;
        }
        if (radioButton2.isChecked()) {
            correctQuestions += 1;
        }
        if (radioButton3.isChecked()) {
            correctQuestions += 1;
        }
        if (radioButton4.isChecked()) {
            correctQuestions += 1;
        }
        if (radioButton5.isChecked()) {
            correctQuestions += 1;
        }
        if (radioButton6.isChecked()) {
            correctQuestions += 1;
        }
        if (checkBox1.isChecked() && checkBox2.isChecked()) {
            if(checkBox3.isChecked()==false && checkBox4.isChecked()==false) {
                correctQuestions += 1;
            }
        }
        if (checkBox5.isChecked() && checkBox6.isChecked() && checkBox7.isChecked()) {
            if(checkBox8.isChecked()==false) {
                correctQuestions += 1;
            }
        }
    }

    /**
     * checkTextFieldQuestions function checks for the correct answers for the questions Q9 and Q10
     */
    public void checkTextFieldQuestions() {
        EditText editText1 = (EditText) findViewById(R.id.text_field1);
        EditText editText2 = (EditText) findViewById(R.id.text_field2);
        String answer1 = editText1.getText().toString();
        String answer2 = editText2.getText().toString();
        if (answer1.equals("1972")) {
            correctQuestions += 1;
        }
        if (answer2.equals("8")) {
            correctQuestions += 1;
        }
        wrongQuestions = 10 - correctQuestions;
    }

    /**
     * resetScore function is used to set variable correctQuestions and wrongQuestions to zero
     */
    public void resetScore() {
        correctQuestions = 0;
        wrongQuestions=0;
    }

    /**
     * message function is used to display message regarding multiple option correct
     */
    public void message(View view) {
        Toast.makeText(this, "Score will be given only if all the options for this question are marked correct", Toast.LENGTH_SHORT).show();
    }

    /**
     * display function is used to display final score by toast
     */
    public void display(View view) {
        checkCorrectQuestions();
        checkTextFieldQuestions();
        if(correctQuestions==10){
            Toast.makeText(this, " Thanks for your participation " + "\n" + " You have answered all questions correctly " + "\n" + " Your score is " + correctQuestions + "/10 ", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, " Thanks for your participation " + "\n" + " You have answered " + wrongQuestions + " questions wrong " + "\n" + " Your score is " + correctQuestions + "/10 " +"\n"+" Try Again !", Toast.LENGTH_LONG).show();
        }
        resetScore();

    }
}
