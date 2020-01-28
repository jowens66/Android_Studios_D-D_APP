package com.example.ddcharactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button VersionInfoButton; //Create Variable to link to the App info button
    private Button CreateCharacterButton;   //Create Variable to link to the Create Character button
    private Button ViewCharactersButton; //Create Variable to link to the View Characters button
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this); //Call constructor of DatabaseHelper class

        VersionInfoButton = (Button) findViewById(R.id.appInfoBtn);
        VersionInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVersionInfoActivity();
            }
        });

        CreateCharacterButton = (Button) findViewById(R.id.newCharBtn);
        CreateCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                CreateNPCActivity();
            }
        });

        ViewCharactersButton = (Button) findViewById(R.id.viewCharBtn);
        ViewCharactersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                ViewCharactersActivity();
            }
        });
    }

    public void openVersionInfoActivity()
    {
        Intent intent = new Intent(this, VersionInfoActivity.class);
        startActivity(intent);
    }

    public void CreateNPCActivity()
    {
        Intent intent = new Intent(this, CreateNPCActivity.class);
        startActivity(intent);
    }

    public void ViewCharactersActivity(){
        Intent intent = new Intent(this, ViewCharactersActivity.class);
        startActivity(intent);
    }
}
