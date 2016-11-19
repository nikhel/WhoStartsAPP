package com.example.niklas.whostarts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    Switch standardSwitch;
    Switch fantasySwitch;
    Switch nerdSwitch;
    Switch darwinSwitch;
    Switch ownSwitch;
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = Preferences.get(getApplicationContext());

        setContentView(R.layout.settings_layout);
        standardSwitch = (Switch) findViewById(R.id.switch1);
        standardSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean value = standardSwitch.isChecked();
                preferences.saveStandard(value);
            }
        });
        standardSwitch.setChecked(preferences.getStandard());

        fantasySwitch = (Switch) findViewById(R.id.switch2);
        fantasySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean value = fantasySwitch.isChecked();
                preferences.saveFantasy(value);
            }
        });
        fantasySwitch.setChecked(preferences.getFantasy());

        darwinSwitch = (Switch) findViewById(R.id.switch3);
        darwinSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean value = darwinSwitch.isChecked();
                preferences.saveDarwin(value);
            }
        });
        darwinSwitch.setChecked(preferences.getDarwin());

        nerdSwitch = (Switch) findViewById(R.id.switch4);
        nerdSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean value = nerdSwitch.isChecked();
                preferences.saveNerd(value);
            }
        });
        nerdSwitch.setChecked(preferences.getNerd());

        ownSwitch = (Switch) findViewById(R.id.switch5);
        ownSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean value = ownSwitch.isChecked();
                preferences.saveOwn(value);
            }
        });
        ownSwitch.setChecked(preferences.getOwn());
    }
}
