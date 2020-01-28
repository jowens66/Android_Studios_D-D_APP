package com.example.ddcharactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CreateNPCActivity extends AppCompatActivity {
    private Button SubmitClassButton;
    RadioGroup RadGroupClass;
    int selectedValueId;
    RadioButton RadButtonBarb;
    RadioButton RadButtonBard;
    RadioButton RadButtonCleric;
    RadioButton RadButtonDruid;
    RadioButton RadButtonFighter;
    RadioButton RadButtonMonk;
    RadioButton RadButtonPaladin;
    RadioButton RadButtonRanger;
    RadioButton RadButtonRogue;
    RadioButton RadButtonSorcerer;
    RadioButton RadButtonWarlock;
    RadioButton RadButtonWizard;
    TextView selectedClass;
    String selectWay;
    public static final String EXTRA_TEXT = "com.example.ddcharactercreator.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_npc);
        //Declare Button
        SubmitClassButton = (Button) findViewById(R.id.nextPageRaceBtn);
        //Declare radio group
        RadGroupClass = (RadioGroup)findViewById(R.id.radioClass);
        //Declare radio button
        RadButtonBarb = (RadioButton)findViewById(R.id.radioBtnBarbarian);
        RadButtonBard = (RadioButton)findViewById(R.id.radioBtnBard);
        RadButtonCleric = (RadioButton)findViewById(R.id.radioBtnCleric);
        RadButtonDruid = (RadioButton)findViewById(R.id.radioBtnDruid);
        RadButtonFighter = (RadioButton)findViewById(R.id.radioBtnFighter);
        RadButtonMonk = (RadioButton)findViewById(R.id.radioBtnMonk);
        RadButtonPaladin = (RadioButton)findViewById(R.id.radioBtnPaladin);
        RadButtonRanger = (RadioButton)findViewById(R.id.radioBtnRanger);
        RadButtonRogue = (RadioButton)findViewById(R.id.radioBtnRogue);
        RadButtonSorcerer = (RadioButton)findViewById(R.id.radioBtnSorcerer);
        RadButtonWarlock = (RadioButton)findViewById(R.id.radioBtnWarlock);
        RadButtonWizard = (RadioButton)findViewById(R.id.radioBtnWizard);
        //Declare text view
        selectedClass = (TextView)findViewById(R.id.textViewSelectedClass);

        RadGroupClass.check(R.id.radioBtnBarbarian);
        selectedClass.setText("Barbarian");
        selectWay = "Barbarian";

        RadGroupClass.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Get the id of the selected radio button
                selectedValueId = RadGroupClass.getCheckedRadioButtonId();
                //Check the id of the selected radio button
                if(selectedValueId == RadButtonBarb.getId()){

                    if (selectWay != "Barbarian"){
                        selectedClass.setText("Barbarian");
                        selectWay = "Barbarian";
                    }
                }
                else if(selectedValueId == RadButtonBard.getId()){

                    if (selectWay != "Bard"){
                        selectedClass.setText("Bard");
                        selectWay = "Bard";
                    }
                }
                else if(selectedValueId == RadButtonCleric.getId()){

                    if (selectWay != "Cleric"){
                        selectedClass.setText("Cleric");
                        selectWay = "Cleric";
                    }
                }
                else if(selectedValueId == RadButtonDruid.getId()){

                    if (selectWay != "Druid"){
                        selectedClass.setText("Druid");
                        selectWay = "Druid";
                    }
                }
                else if(selectedValueId == RadButtonFighter.getId()){

                    if (selectWay != "Fighter"){
                        selectedClass.setText("Fighter");
                        selectWay = "Fighter";
                    }
                }
                else if(selectedValueId == RadButtonMonk.getId()){

                    if (selectWay != "Monk"){
                        selectedClass.setText("Monk");
                        selectWay = "Monk";
                    }
                }
                else if(selectedValueId == RadButtonPaladin.getId()){

                    if (selectWay != "Paladin"){
                        selectedClass.setText("Paladin");
                        selectWay = "Paladin";
                    }
                }
                else if(selectedValueId == RadButtonRanger.getId()){

                    if (selectWay != "Ranger"){
                        selectedClass.setText("Ranger");
                        selectWay = "Ranger";
                    }
                }
                else if(selectedValueId == RadButtonRogue.getId()){

                    if (selectWay != "Rogue"){
                        selectedClass.setText("Rogue");
                        selectWay = "Rogue";
                    }
                }
                else if(selectedValueId == RadButtonSorcerer.getId()){

                    if (selectWay != "Sorcerer"){
                        selectedClass.setText("Sorcerer");
                        selectWay = "Sorcerer";
                    }
                }
                else if(selectedValueId == RadButtonWarlock.getId()){

                    if (selectWay != "Warlock"){
                        selectedClass.setText("Warlock");
                        selectWay = "Warlock";
                    }
                }
                else if(selectedValueId == RadButtonWizard.getId()){

                    if (selectWay != "Wizard"){
                        selectedClass.setText("Wizard");
                        selectWay = "Wizard";
                    }
                }
            }
        });


        SubmitClassButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SelectRaceActivity();
            }
        });
    }

    public void SelectRaceActivity()
    {
        String passClass = selectedClass.getText().toString();

        Intent intent = new Intent(this, SelectRaceActivity.class);
        intent.putExtra(EXTRA_TEXT, passClass);
        startActivity(intent);
    }
}
