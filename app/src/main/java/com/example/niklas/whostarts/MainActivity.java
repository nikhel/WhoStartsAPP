package com.example.niklas.whostarts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton buttonGenerate;
    TextView instructionTextView;
    ArrayList<String> instructionList;

    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = Preferences.get(getApplicationContext());


        instructionTextView = (TextView) findViewById(R.id.informationText);
        instructionTextView.setText("");

        buttonGenerate = (ImageButton) findViewById(R.id.imageButtongetNewInfo);
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int tempPosition = random.nextInt(instructionList.size());

                instructionTextView.setText(instructionList.get(tempPosition));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_add:
                Intent launchNewIntent = new Intent(MainActivity.this, AddPhrase.class);
                startActivityForResult(launchNewIntent,1);
                return true;
            case R.id.settings:
                Intent intentSettings = new Intent(MainActivity.this, Settings.class);
                startActivityForResult(intentSettings,2);
                return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        createList();
    }

    private void createList(){

        instructionList = new ArrayList<>();
        Preferences pref = Preferences.get(getApplicationContext());

        if(pref.getStandard()){
            for(String value : getResources().getStringArray(R.array.standard)){
                instructionList.add(value);
            }
        }
        if(pref.getDarwin()){
            for(String value : getResources().getStringArray(R.array.darwin_award)){
                instructionList.add(value);
            }
        }

        if(pref.getFantasy()){
            for(String value : getResources().getStringArray(R.array.fantasy)){
                instructionList.add(value);
            }
        }

        if(pref.getNerd()){
            for(String value : getResources().getStringArray(R.array.nerd)){
                instructionList.add(value);
            }
        }

        if(pref.getOwn()){
            for(String value : pref.getStringArray().split("¤")){
                if(value.length()>0){
                    instructionList.add(value);
                }
            }
        }

        if(instructionList.isEmpty()){
            pref.saveDarwin(true);
            for(String value : getResources().getStringArray(R.array.darwin_award)){
                instructionList.add(value);
            }
        }

    }
}
