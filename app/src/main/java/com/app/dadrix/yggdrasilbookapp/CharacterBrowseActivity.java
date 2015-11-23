package com.app.dadrix.yggdrasilbookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CharacterBrowseActivity extends YggdrasilBookActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_browse);

        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i<10; i++){
            items.add("Category Product #"+i);
        }

        ArrayAdapter<String> aItems = new ArrayAdapter<String>(this, R.layout.item_sample, items);
        ListView lvTest = (ListView) findViewById(R.id.listViewCharacterBrowse);
        lvTest.setAdapter(aItems);
    }
}
