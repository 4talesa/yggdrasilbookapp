package com.app.dadrix.yggdrasilbookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;

public class CharacterDetailActivity extends YggdrasilBookActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i<10; i++){
            items.add("Category Product #"+i);
        }

        ArrayAdapter<String> aItems = new ArrayAdapter<String>(this, R.layout.item_sample, items);
        TwoWayView lvTest = (TwoWayView) findViewById(R.id.listViewCharacterDetail);
        lvTest.setAdapter(aItems);
    }
}
