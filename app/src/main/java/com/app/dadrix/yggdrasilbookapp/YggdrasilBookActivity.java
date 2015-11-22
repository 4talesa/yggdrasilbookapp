package com.app.dadrix.yggdrasilbookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Rondinelli on 22/11/2015.
 */
public class YggdrasilBookActivity extends AppCompatActivity {

    static final String defaultActivity         = "defaultActivity";

    protected String activityName = defaultActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (Exception e){
            System.out.println("Error - onCreate - setDisplayHomeAsUpEnabled: " + e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);

        try {
            MenuItem searchItem = menu.findItem(R.id.action_search);

            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String query) {

                    System.out.println("onQueryTextSubmit: " + query);
                    // perform query here
                    return true;

                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    System.out.println("onQueryTextChange: " + newText);
                    return false;

                }

            });
        }catch (Exception e){
            System.out.println("Error - onCreateOptionsMenu - searchItem: " + e.toString());
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent it;

        System.out.println("activity: " + this.activityName);

        switch (item.getItemId()) {

            case android.R.id.home:
                it = new Intent(this, BookBrowseActivity.class);
                this.startActivity(it);
                return true;

            case R.id.book_browse_menu:
                it = new Intent(this, BookBrowseActivity.class);
                this.startActivity(it);
                return true;

            case R.id.book_detail_menu:
                it = new Intent(this, BookDetailActivity.class);
                this.startActivity(it);
                return true;

            case R.id.character_browse_menu:
                it = new Intent(this, CharacterBrowseActivity.class);
                this.startActivity(it);
                return true;

            case R.id.character_detail_menu:
                it = new Intent(this, CharacterDetailActivity.class);
                this.startActivity(it);
                return true;

            case R.id.event_browse_menu:
                it = new Intent(this, EventBrowseActivity.class);
                this.startActivity(it);
                return true;

            case R.id.event_detail_menu:
                it = new Intent(this, EventDetailActivity.class);
                this.startActivity(it);
                return true;

            case R.id.place_browse_menu:
                it = new Intent(this, PlaceBrowseActivity.class);
                this.startActivity(it);
                return true;

            case R.id.place_detail_menu:
                it = new Intent(this, PlaceDetailActivity.class);
                this.startActivity(it);
                return true;

            case R.id.profile_browse_menu:
                it = new Intent(this, ProfileBrowseActivity.class);
                this.startActivity(it);
                return true;

            case R.id.profile_detail_menu:
                it = new Intent(this, ProfileDetailActivity.class);
                this.startActivity(it);
                return true;

            case R.id.sign_in_menu:
                it = new Intent(this, SignInActivity.class);
                this.startActivity(it);
                return true;

            case R.id.sign_up_menu:
                it = new Intent(this, SignUpActivity.class);
                this.startActivity(it);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
