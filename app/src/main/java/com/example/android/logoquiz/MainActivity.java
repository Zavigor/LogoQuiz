package com.example.android.logoquiz;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* This method takes the focus out of the EditText */

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    /* This method saves the user's name and checks the answers */

    public void get_an_answer(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_input);
        String name = nameField.getText().toString();
        if (name.equalsIgnoreCase("")) {
            Toast.makeText(this, "Please write your name", Toast.LENGTH_SHORT).show();
            return;
        }

        CheckBox question1 = findViewById(R.id.nike_checkbox);
        CheckBox question2 = findViewById(R.id.reebok_checkbox);
        CheckBox question3 = findViewById(R.id.sprandi_checkbox);

        CheckBox question4 = findViewById(R.id.mercedes_checkbox);
        CheckBox question5 = findViewById(R.id.toyota_checkbox);
        CheckBox question6 = findViewById(R.id.mazda_checkbox);

        RadioButton question7 = findViewById(R.id.bk_radiobutton_1);
        RadioButton question8 = findViewById(R.id.bk_radiobutton_2);
        RadioButton question9 = findViewById(R.id.bk_radiobutton_3);

        RadioButton question10 = findViewById(R.id.gl_radiobutton_1);
        RadioButton question11 = findViewById(R.id.gl_radiobutton_2);
        RadioButton question12 = findViewById(R.id.gl_radiobutton_3);

        EditText edit_ibm = findViewById(R.id.edit_ibm);
        String question13 = edit_ibm.getText().toString();


        if (question2.isChecked()) {
            score = score + 1;
        }
        if (question5.isChecked()) {
            score = score + 1;
        }
        if (question7.isChecked()) {
            score = score + 1;
        }
        if (question10.isChecked()) {
            score = score + 1;
        }
        if (question13.equalsIgnoreCase("IBM")){
            score = score + 1;
        }
        String scoreMessage = displayScore(name, score);

        TextView scoreSummary = (TextView) findViewById(R.id.score_display);
        scoreSummary.setText(scoreMessage);

    }

    /* This method displays different score message depending on the score */

    public String displayScore (String name, int score) {

        String scoreMessage;

        if (score < 5) {
            scoreMessage = "Dear " + name + ", you answered correctly only to " + score + " questions.\n\nTo learn a few secrets of professional designers, try to answer all the questions.";
        } else {
            scoreMessage = "You can not be fooled. " + name + ", are you a designer? " + score + " points! \n\n" +
                    "You are right, in the first picture a fragment of the Reebok logo. The more original the logo, the easier it is to remember it.\n\n" +
                    "In the distance, you can see the Toyota sign. A good logo has a simple, recognizable contour that can be viewed even from outer space.\n\n" +
                    "Yes, the first circle contains the colors of the Burgerking logo. Agree, you had to think about the question." +
                    "What proves - the fewer colors in the logo, the better it is remembered.\n\n" +
                    "It was difficult with Google. I wonder how many people can correctly answer this question from the first attempt?\n\n" +
                    "Of course this is IBM! Very often the first logos of companies contain many elements. Time cleans out all garbage.\n\n" +
                    "If you need a quality logo, I'll work it out for you. Examples of my work on the site zavigor.ru\n\n" +
                    "Thank you!";
        }
        return scoreMessage;

    }

    /* This method resets the quiz and comes back to the beginning of the ScrollView */

    public void reset (View view) {
        score = 0;

//        EditText textField = (EditText) findViewById(R.id.name_input);
//        textField.setText(null);

        CheckBox question1 = findViewById(R.id.nike_checkbox);
        if (question1.isChecked()) {
            question1.toggle();}

        CheckBox question2 = findViewById(R.id.reebok_checkbox);
        if (question2.isChecked()) {
            question2.toggle();}

        CheckBox question3 = findViewById(R.id.sprandi_checkbox);
        if (question3.isChecked()) {
            question3.toggle();}

        CheckBox question4 = findViewById(R.id.mercedes_checkbox);
        if (question4.isChecked()) {
            question4.toggle();}

        CheckBox question5 = findViewById(R.id.toyota_checkbox);
        if (question5.isChecked()) {
            question5.toggle();}

        CheckBox question6 = findViewById(R.id.mazda_checkbox);
        if (question6.isChecked()) {
            question6.toggle();}

        RadioGroup radio1 = (RadioGroup) findViewById(R.id.radio1);
        radio1.clearCheck();

        RadioGroup radio2 = (RadioGroup) findViewById(R.id.radio2);
        radio2.clearCheck();

        EditText edit_ibm = (EditText) findViewById(R.id.edit_ibm);
        edit_ibm.setText(null);


        ScrollView scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.fullScroll(ScrollView.FOCUS_UP);
        scroll.setFocusableInTouchMode(true);

        TextView scoreDisplay = (TextView) findViewById(R.id.score_display);
        scoreDisplay.setText(null);


    }

}