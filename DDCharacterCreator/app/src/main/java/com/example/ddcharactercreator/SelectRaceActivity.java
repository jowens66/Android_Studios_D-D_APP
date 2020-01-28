package com.example.ddcharactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class SelectRaceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button SubmitRaceButton;
    private Spinner DragonbornSpinner;
    int selectedValueId;
     RadioGroup RadGroupRace;
     RadioButton RadButtonDragonborn;
     RadioButton RadButtonDwarf;
     RadioButton RadButtonElf;
     RadioButton RadButtonGnome;
     RadioButton RadButtonHalfElf;
     RadioButton RadButtonHalfOrc;
     RadioButton RadButtonHalfling;
     RadioButton RadButtonHuman;
     RadioButton RadButtonTiefling;
     TextView selectedRace;
     TextView selectedClass;
     String selectWay;
    public static final String EXTRA_TEXT = "com.example.ddcharactercreator.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.ddcharactercreator.EXTRA_TEXT2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_race);

        //Declare radio group
        RadGroupRace = (RadioGroup) findViewById(R.id.radioGroupRace);
        //Declare Button
        SubmitRaceButton = (Button) findViewById(R.id.nextPageStatsBtn);
        //Declare radio button
        RadButtonDragonborn = (RadioButton)findViewById(R.id.radioBtnDragonborn);
        RadButtonDwarf = (RadioButton)findViewById(R.id.radioBtnDwarf);
        RadButtonElf = (RadioButton)findViewById(R.id.radioBtnElf);
        RadButtonGnome = (RadioButton)findViewById(R.id.radioBtnGnome);
        RadButtonHalfElf = (RadioButton)findViewById(R.id.radioBtnHalfElf);
        RadButtonHalfOrc = (RadioButton)findViewById(R.id.radioBtnHalfOrc);
        RadButtonHalfling = (RadioButton)findViewById(R.id.radioBtnHalfling);
        RadButtonHuman = (RadioButton)findViewById(R.id.radioBtnHuman);
        RadButtonTiefling = (RadioButton)findViewById(R.id.radioBtnTiefling);
        //Declare text view
        selectedClass = (TextView)findViewById(R.id.textViewRaceClassPassOutP);
        //Declare text view
        selectedRace = (TextView)findViewById(R.id.txtViewSelectedRace);




        String passClass = getIntent().getStringExtra(CreateNPCActivity.EXTRA_TEXT);
        selectedClass.setText(passClass);

        String passRace = getIntent().getStringExtra(SelectRaceActivity.EXTRA_TEXT2);
        selectedRace.setText(passRace);

        //Set Dragonborn as default race
        RadGroupRace.check(R.id.radioBtnDragonborn);
        selectedRace.setText("Dragonborn");
        selectWay = "Dragonborn";

        RadGroupRace.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Get the id of the selected radio button
                selectedValueId = RadGroupRace.getCheckedRadioButtonId();

                //Check the id of the selected radio button
                if(selectedValueId == RadButtonDragonborn.getId()){

                    if (selectWay != "Dragonborn"){
                        selectedRace.setText("Dragonborn");
                        selectWay = "Dragonborn";
                    }
                }
                else if(selectedValueId == RadButtonDwarf.getId()){

                    if (selectWay != "Dwarf"){
                        selectedRace.setText("Dwarf");
                        selectWay = "Dwarf";
                    }
                }
                else if(selectedValueId == RadButtonElf.getId()){

                    if (selectWay != "Elf"){
                        selectedRace.setText("Elf");
                        selectWay = "Elf";
                    }
                }
                else if(selectedValueId == RadButtonGnome.getId()){

                    if (selectWay != "Gnome"){
                        selectedRace.setText("Gnome");
                        selectWay = "Gnome";
                    }
                }
                else if(selectedValueId == RadButtonHalfElf.getId()){

                    if (selectWay != "Half Elf"){
                        selectedRace.setText("Half Elf");
                        selectWay = "Half Elf";
                    }
                }
                else if(selectedValueId == RadButtonHalfOrc.getId()){

                    if (selectWay != "Half Orc"){
                        selectedRace.setText("Half Orc");
                        selectWay = "Half Orc";
                    }
                }
                else if(selectedValueId == RadButtonHalfling.getId()){

                    if (selectWay != "Halfling"){
                        selectedRace.setText("Halfling");
                        selectWay = "Halfling";
                    }
                }
                else if(selectedValueId == RadButtonHuman.getId()){

                    if (selectWay != "Human"){
                        selectedRace.setText("Human");
                        selectWay = "Human";
                    }
                }
                else if(selectedValueId == RadButtonTiefling.getId()){

                    if (selectWay != "Tiefling"){
                        selectedRace.setText("Tiefling");
                        selectWay = "Tiefling";
                    }
                }
            }
        });

        final Spinner spinnerDragonborn = findViewById(R.id.spinnerDragonborn);

        ArrayAdapter<CharSequence> adapterDragonborn = ArrayAdapter.createFromResource(this,
                R.array.spinnerDragonborn, android.R.layout.simple_spinner_item);
        adapterDragonborn.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerDragonborn.setAdapter(adapterDragonborn);
        spinnerDragonborn.setOnItemSelectedListener(this);
        spinnerDragonborn.setSelection(adapterDragonborn.getPosition("Black"));
        spinnerDragonborn.setEnabled(false);

        Spinner spinnerDwarf = findViewById(R.id.spinnerDwarf);
        ArrayAdapter<CharSequence> adapterDwarf = ArrayAdapter.createFromResource(this,
                R.array.spinnerDwarf, android.R.layout.simple_spinner_item);
        adapterDwarf.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerDwarf.setAdapter(adapterDwarf);
        spinnerDwarf.setOnItemSelectedListener(this);
        spinnerDwarf.setEnabled(false);

        Spinner spinnerElf = findViewById(R.id.spinnerElf);
        ArrayAdapter<CharSequence> adapterElf = ArrayAdapter.createFromResource(this,
                R.array.spinnerElf, android.R.layout.simple_spinner_item);
        adapterElf.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerElf.setAdapter(adapterElf);
        spinnerElf.setOnItemSelectedListener(this);
        spinnerElf.setEnabled(false);

        Spinner spinnerGnome = findViewById(R.id.spinnerGnome);
        ArrayAdapter<CharSequence> adapterGnome = ArrayAdapter.createFromResource(this,
                R.array.spinnerGnome, android.R.layout.simple_spinner_item);
        adapterGnome.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerGnome.setAdapter(adapterGnome);
        spinnerGnome.setOnItemSelectedListener(this);
        spinnerGnome.setEnabled(false);

        Spinner spinnerHalfElf = findViewById(R.id.spinnerHalfElf);
        ArrayAdapter<CharSequence> adapterHalfElf = ArrayAdapter.createFromResource(this,
                R.array.spinnerHalfElf, android.R.layout.simple_spinner_item);
        adapterHalfElf.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerHalfElf.setAdapter(adapterHalfElf);
        spinnerHalfElf.setOnItemSelectedListener(this);
        spinnerHalfElf.setEnabled(false);

        Spinner spinnerHalfling = findViewById(R.id.spinnerHalfling);
        ArrayAdapter<CharSequence> adapterHalfling = ArrayAdapter.createFromResource(this,
                R.array.spinnerHalfling, android.R.layout.simple_spinner_item);
        adapterHalfling.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerHalfling.setAdapter(adapterHalfling);
        spinnerHalfling.setOnItemSelectedListener(this);
        spinnerHalfling.setEnabled(false);

        Spinner spinnerHuman = findViewById(R.id.spinnerHuman);
        ArrayAdapter<CharSequence> adapterHuman = ArrayAdapter.createFromResource(this,
                R.array.spinnerHuman, android.R.layout.simple_spinner_item);
        adapterHuman.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerHuman.setAdapter(adapterHuman);
        spinnerHuman.setOnItemSelectedListener(this);
        spinnerHuman.setEnabled(false);

        Spinner spinnerTiefling = findViewById(R.id.spinnerTiefling);
        ArrayAdapter<CharSequence> adapterTiefling = ArrayAdapter.createFromResource(this,
                R.array.spinnerTiefling, android.R.layout.simple_spinner_item);
        adapterTiefling.setDropDownViewResource(android.R.layout.select_dialog_singlechoice); //select_dialog_singlechoice turns the spinner into radio buttons.
        spinnerTiefling.setAdapter(adapterTiefling);
        spinnerTiefling.setOnItemSelectedListener(this);
        spinnerTiefling.setEnabled(false);



        SubmitRaceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               StatGenActivity();
            }
        });
    }

    public void StatGenActivity()
    {
        String passClass = selectedClass.getText().toString();
        String passRace = selectedRace.getText().toString();

        Intent intent = new Intent(this, StatGenActivity.class);
        intent.putExtra(EXTRA_TEXT, passClass);
        intent.putExtra(EXTRA_TEXT2, passRace);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
