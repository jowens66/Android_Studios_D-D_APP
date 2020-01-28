package com.example.ddcharactercreator;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ViewCharactersActivity extends AppCompatActivity {

    DatabaseHelper myDatabaseHelper;
    ArrayAdapter<String> mAdapter;
    ListView myListView;
    private Button btnDelete;
    private Button btnEdit;
    TextView characterTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_characters);

        myDatabaseHelper = new DatabaseHelper(this);
        myListView = (ListView)findViewById(R.id.lstCharacter);

        loadList();

    }

    private void loadList(){
        ArrayList<String> characterList = myDatabaseHelper.getAllCharacters();

        if (mAdapter == null){
            mAdapter = new ArrayAdapter<String>(this, R.layout.row_character, R.id.characterTitle, characterList);
          myListView.setAdapter(mAdapter);

        }
        else
        {
            mAdapter.clear();
            mAdapter.addAll(characterList);
            mAdapter.notifyDataSetChanged();
        }

    }

    public void deleteCharacter(View view){
        View parent = (View) view.getParent();
        TextView characterTextView = (TextView) parent.findViewById(R.id.characterTitle);
        //TextView characterTextViewClass = (TextView) parent.findViewById(R.id.characterClass);
        String Cname = String.valueOf(characterTextView.getText());
        //String Cclass = String.valueOf(characterTextViewClass.getText());
        myDatabaseHelper.deleteCharacter(Cname);
        loadList();
    }

    public void editCharacter(View view){
        TextView characterTextView = (TextView) findViewById(R.id.characterTitle);
        final String oldName = String.valueOf(characterTextView.getText());

        final EditText etxCharEdit = new EditText(this);
        etxCharEdit.setText(oldName);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Edit Character")
                .setView(etxCharEdit)
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String fact = String.valueOf(etxCharEdit.getText());
                        myDatabaseHelper.EditCharacter(fact, oldName);
                        loadList();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }

}

