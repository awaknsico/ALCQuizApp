package com.example.android.alcquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String ans1 = "chimdi";
    boolean ans3 = false;
    String ans4 = "kunal";
    boolean ans6 = false;


    // Method Handling Question 1
    private boolean question1(){
        EditText q1_text = (EditText) findViewById(R.id.question1_edit_text);
        if(ans1.equals(q1_text.getText().toString().trim().toLowerCase()))
            return true;
        return false;
    }


    // Method Handling Question 2
    private boolean question2(){
        CheckBox ansA = (CheckBox) findViewById(R.id.fujiwara_check_box);
        CheckBox ansB = (CheckBox) findViewById(R.id.kuan_check_box);
        CheckBox ansC = (CheckBox) findViewById(R.id.lyla_check_box);
        CheckBox ansD = (CheckBox) findViewById(R.id.katherine_check_box);
        if((ansB.isChecked() && ansD.isChecked()) && (!ansA.isChecked() && !ansC.isChecked())){
            return true;
        }
        else {
            return false;
        }
    }


    // Method Handling Radio Buttons From Question 3
    public void q3Button(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.ew_radio_button:
                if(checked)
                    ans3 = false;
                break;
            case R.id.em_radio_button:
                if(checked)
                    ans3 = false;
                break;
            case R.id.st_radio_button:
                if(checked)
                    ans3 = true;
                break;
            case R.id.mz_radio_button:
                if(checked)
                    ans3 = false;
                break;
        }
    }
    // Method handling Question 3
    private boolean question3(){
        if(ans3)
            return true;
        return false;
    }



    // Method Handling Question 4
    private boolean question4(){
        EditText q2_text = (EditText) findViewById(R.id.question4_edit_text);
        if(ans4.equals(q2_text.getText().toString().trim().toLowerCase()))
            return true;
        return false;
    }


    // Method Handling Question 5
    private boolean question5(){
        CheckBox ansA = (CheckBox) findViewById(R.id.olalere_check_box);
        CheckBox ansB = (CheckBox) findViewById(R.id.aneke_check_box);
        CheckBox ansC = (CheckBox) findViewById(R.id.chimdindu_check_box);
        CheckBox ansD = (CheckBox) findViewById(R.id.solomon_check_box);
        if((ansA.isChecked() && ansD.isChecked()) && (!ansB.isChecked() && !ansC.isChecked())){
            return true;
        }
        else {
            return false;
        }
    }


    // Method Handling Radio Buttons From Question 6
    public void q6Button(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.cd_radio_button:
                if(checked)
                    ans6 = false;
                break;
            case R.id.ci_radio_button:
                if(checked)
                    ans6 = true;
                break;
            case R.id.pm_radio_button:
                if(checked)
                    ans6 = false;
                break;
            case R.id.cm_radio_button:
                if(checked)
                    ans6 = false;
                break;
        }
    }
    // Method Handling Question 6
    private  boolean question6(){
        if(ans6)
            return true;
        return false;
    }


    public void nextQuestion(View view){
        ViewGroup aBlock = (ViewGroup) findViewById(R.id.aBlock);
        ViewGroup qBlock = (ViewGroup) findViewById(R.id.qBlock);
        ViewGroup qBlock1 = (ViewGroup) findViewById(R.id.qBlock1);
        ViewGroup qBlock2 = (ViewGroup) findViewById(R.id.qBlock2);
        ViewGroup qBlock3 = (ViewGroup) findViewById(R.id.qBlock3);
        ViewGroup qBlock4 = (ViewGroup) findViewById(R.id.qBlock4);
        ViewGroup qBlock5 = (ViewGroup) findViewById(R.id.qBlock5);
        ViewGroup qBlock6 = (ViewGroup) findViewById(R.id.qBlock6);

        if (qBlock1.getVisibility() == View.VISIBLE){
            qBlock1.setVisibility(View.INVISIBLE);
            qBlock2.setVisibility(View.VISIBLE);
        } else if (qBlock2.getVisibility() == View.VISIBLE){
            qBlock2.setVisibility(View.INVISIBLE);
            qBlock3.setVisibility(View.VISIBLE);
        } else if (qBlock3.getVisibility() == View.VISIBLE){
            qBlock3.setVisibility(View.INVISIBLE);
            qBlock4.setVisibility(View.VISIBLE);
        } else if (qBlock4.getVisibility() == View.VISIBLE){
            qBlock4.setVisibility(View.INVISIBLE);
            qBlock5.setVisibility(View.VISIBLE);
        } else if (qBlock5.getVisibility() == View.VISIBLE){
            qBlock5.setVisibility(View.INVISIBLE);
            qBlock6.setVisibility(View.VISIBLE);
        }
        else {
            qBlock6.setVisibility(View.INVISIBLE);
            qBlock1.setVisibility(View.VISIBLE);
            qBlock.setVisibility(View.INVISIBLE);
            aBlock.setVisibility(View.VISIBLE);
        }

    }





    private void uncheckAll(ViewGroup vg) {
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            if (v instanceof CheckBox) {
                ((CheckBox) v).setChecked(false);
            } else if (v instanceof RadioGroup){
                ((RadioGroup) v).clearCheck();
            } else if (v instanceof EditText){
                ((EditText) v).setText("");
            } else if (v instanceof ViewGroup) {
                uncheckAll((ViewGroup) v);
            }
        }
    }

    public void resetInput(View view){
        ans3 = false;
        ans6 = false;
        ViewGroup aBlock = (ViewGroup) findViewById(R.id.aBlock);
        ViewGroup qBlock = (ViewGroup) findViewById(R.id.qBlock);
        ViewGroup qBlock1 = (ViewGroup) findViewById(R.id.qBlock1);

        uncheckAll((ViewGroup) findViewById(R.id.activity_main));
        aBlock.setVisibility(View.INVISIBLE);
        qBlock.setVisibility(View.VISIBLE);
    }



    public void submitInput(View view){
        int score = 0;
        int qNumber = 6;
        EditText userName = (EditText) findViewById(R.id.user_name);
        String name = userName.getText().toString();
        if(name.equals(""))
            name = "Hey!";
        if(question1())
            score ++;
        if(question2())
            score ++;
        if(question3())
            score ++;
        if(question4())
            score ++;
        if(question5())
            score ++;
        if(question6())
            score ++;
        Toast toast = Toast.makeText(this, getString(R.string.score_text, name, String.valueOf(score), String.valueOf(qNumber)), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();

    }


}
