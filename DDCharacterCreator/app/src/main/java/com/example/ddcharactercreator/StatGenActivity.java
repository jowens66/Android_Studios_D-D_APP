package com.example.ddcharactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class StatGenActivity extends AppCompatActivity {

    private Button finishCharacterButton;
    private Button rollDiceButton;
    TextView StatStr;
    TextView StatDex;
    TextView StatCon;
    TextView StatInt;
    TextView StatWis;
    TextView StatCha;
    int randStr = ThreadLocalRandom.current().nextInt(3, 18 + 1);
    int randDex = ThreadLocalRandom.current().nextInt(3, 18 + 1);
    int randCon = ThreadLocalRandom.current().nextInt(3, 18 + 1);
    int randInt = ThreadLocalRandom.current().nextInt(3, 18 + 1);
    int randWis = ThreadLocalRandom.current().nextInt(3, 18 + 1);
    int randCha = ThreadLocalRandom.current().nextInt(3, 18 + 1);
    //int selectedValueId;
    TextView selectedRace;
    TextView selectedClass;
    boolean clicked = false;

    public static final String EXTRA_TEXT = "com.example.ddcharactercreator.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.ddcharactercreator.EXTRA_TEXT2";
    public static final String EXTRA_STRENGTH = "com.example.ddcharactercreator.EXTRA_STRENGTH";
    public static final String EXTRA_DEXTERITY = "com.example.ddcharactercreator.EXTRA_DEXTERITY";
    public static final String EXTRA_CONSTITUTION = "com.example.ddcharactercreator.EXTRA_CONSTITUTION";
    public static final String EXTRA_INTELLIGENCE = "com.example.ddcharactercreator.EXTRA_INTELLIGENCE";
    public static final String EXTRA_WISDOM = "com.example.ddcharactercreator.EXTRA_WISDOM";
    public static final String EXTRA_CHARISMA = "com.example.ddcharactercreator.EXTRA_CHARISMA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_gen);

        finishCharacterButton = (Button) findViewById(R.id.finishCharacterBtn);
        finishCharacterButton.setEnabled(false);

        finishCharacterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FinishCharacterActivity();
            }
        });

        StatStr = (TextView) findViewById(R.id.textViewStrOutP);
        StatDex = (TextView) findViewById(R.id.textViewDexOutP);
        StatCon = (TextView) findViewById(R.id.textViewConOutP);
        StatInt = (TextView) findViewById(R.id.textViewIntellOutP);
        StatWis = (TextView) findViewById(R.id.textViewWisOutP);
        StatCha = (TextView) findViewById(R.id.textViewChaOutP);

        selectedClass = (TextView)findViewById(R.id.textViewStatClassPassOutP);
        selectedRace = (TextView)findViewById(R.id.textViewStatRacePassOutP);

        String passClass = getIntent().getStringExtra(SelectRaceActivity.EXTRA_TEXT);
        selectedClass.setText(passClass);

        String passRace = getIntent().getStringExtra(SelectRaceActivity.EXTRA_TEXT2);
        selectedRace.setText(passRace);


        rollDiceButton = (Button) findViewById(R.id.rollStatsBtn);
        rollDiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                StatStr.setText(String.valueOf(randStr));
                StatDex.setText(String.valueOf(randDex));
                StatCon.setText(String.valueOf(randCon));
                StatInt.setText(String.valueOf(randInt));
                StatWis.setText(String.valueOf(randWis));
                StatCha.setText(String.valueOf(randCha));

                finishCharacterButton.setEnabled(true);
            }
        });

    }

    public void FinishCharacterActivity()
    {
        String passClass = selectedClass.getText().toString();
        String passRace = selectedRace.getText().toString();
        String passStrength = StatStr.getText().toString();
        String passDexterity = StatDex.getText().toString();
        String passConstitution = StatCon.getText().toString();
        String passIntelligence = StatInt.getText().toString();
        String passWisdom = StatWis.getText().toString();
        String passCharisma = StatCha.getText().toString();

        Intent intent = new Intent(this, FinishCharacterActivity.class);
        intent.putExtra(EXTRA_TEXT, passClass);
        intent.putExtra(EXTRA_TEXT2, passRace);
        intent.putExtra(EXTRA_STRENGTH, passStrength);
        intent.putExtra(EXTRA_DEXTERITY, passDexterity);
        intent.putExtra(EXTRA_CONSTITUTION, passConstitution);
        intent.putExtra(EXTRA_INTELLIGENCE, passIntelligence);
        intent.putExtra(EXTRA_WISDOM, passWisdom);
        intent.putExtra(EXTRA_CHARISMA, passCharisma);
        startActivity(intent);
    }
}
