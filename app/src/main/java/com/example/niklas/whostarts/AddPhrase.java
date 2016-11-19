package com.example.niklas.whostarts;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPhrase extends AppCompatActivity {
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phrase);

        textField = (EditText) findViewById(R.id.newInstructionEditText);

        findViewById(R.id.addNewInstructionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPhrase = textField.getText().toString();
                if(newPhrase.contains("¤")){
                    Toast.makeText(getApplicationContext(),"¤ is not allowed to use",Toast.LENGTH_SHORT).show();
                }
                else {
                    Preferences.get(getApplicationContext()).addToStringArray(newPhrase);
                    Toast.makeText(getApplicationContext(),"Phrase added",Toast.LENGTH_SHORT).show();
                }
                textField.setText("");
            }
        });

        findViewById(R.id.clear_pref_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(AddPhrase.this)
                        .setTitle("EXTERMINATION!")
                        .setMessage("Are you sure you want to delete all your own content?")
                        .setPositiveButton("accept", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Preferences.get(getApplicationContext()).resetStringArray();
                                Toast.makeText(getApplicationContext(),"All your added phrases has now been removed",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();



            }
        });
    }
}
