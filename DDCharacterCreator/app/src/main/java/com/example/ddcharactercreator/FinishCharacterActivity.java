package com.example.ddcharactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinishCharacterActivity extends AppCompatActivity {

    private Button FinishCharacterButton;

    DatabaseHelper myDatabaseHelper;

    TextView selectedRace;
    TextView selectedClass;
    TextView rolledStatStrength;
    TextView rolledStatDexterity;
    TextView rolledStatConstitution;
    TextView rolledStatIntelligence;
    TextView rolledStatWisdom;
    TextView rolledStatCharisma;

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
        setContentView(R.layout.activity_finish_character);

        myDatabaseHelper = new DatabaseHelper(this);


        selectedClass = (TextView)findViewById(R.id.textViewClassFinishOutP);
        selectedRace = (TextView)findViewById(R.id.textViewRaceFinishOutP);
        rolledStatStrength = (TextView)findViewById(R.id.textViewStrengthOutP);
        rolledStatDexterity = (TextView)findViewById(R.id.textViewDexFinishOutP);
        rolledStatConstitution = (TextView)findViewById(R.id.textViewConFinishOutP);
        rolledStatIntelligence = (TextView)findViewById(R.id.textViewIntFinishOutP);
        rolledStatWisdom = (TextView)findViewById(R.id.textViewWisFinishOutP);
        rolledStatCharisma = (TextView)findViewById(R.id.textViewChaFinishOutP);

        final String passClass = getIntent().getStringExtra(SelectRaceActivity.EXTRA_TEXT);
        selectedClass.setText(passClass);

        final String passRace = getIntent().getStringExtra(SelectRaceActivity.EXTRA_TEXT2);
        selectedRace.setText(passRace);

        //final String passName = CharName.getText().toString();
        final EditText CharName = (EditText)findViewById(R.id.editTextName);

        String passStrength = getIntent().getStringExtra(StatGenActivity.EXTRA_STRENGTH);
        rolledStatStrength.setText(passStrength);

        String passDexterity = getIntent().getStringExtra(StatGenActivity.EXTRA_DEXTERITY);
        rolledStatDexterity.setText(passDexterity);

        String passConstitution = getIntent().getStringExtra(StatGenActivity.EXTRA_CONSTITUTION);
        rolledStatConstitution.setText(passConstitution);

        String passIntelligence = getIntent().getStringExtra(StatGenActivity.EXTRA_INTELLIGENCE);
        rolledStatIntelligence.setText(passIntelligence);

        String passWisdom = getIntent().getStringExtra(StatGenActivity.EXTRA_WISDOM);
        rolledStatWisdom.setText(passWisdom);

        String passCharisma = getIntent().getStringExtra(StatGenActivity.EXTRA_CHARISMA);
        rolledStatCharisma.setText(passCharisma);

        final String passEverything = passClass + " " + passRace + " " + passStrength + " " + passDexterity + " " + passConstitution + " " + passIntelligence + " " + passWisdom + " " + passCharisma;

        FinishCharacterButton = (Button) findViewById(R.id.finishCharacterBtn);

        FinishCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDatabaseHelper.insertNewCharacter(CharName.getText().toString() + " " + passEverything);
                MainActivity();
            }
        });

    }

    public void MainActivity()
    {
        Intent intent = new Intent(this, ViewCharactersActivity.class);
        startActivity(intent);
    }


}
