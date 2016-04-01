package com.andromap33.world_clock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String countryname = "India" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Spinner countrySpinner = (Spinner) findViewById(R.id.spinner) ;
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this , R.array.country_name , android.R.layout.simple_spinner_item) ;
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) ;
        countrySpinner.setAdapter(countryAdapter) ;

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            TextView countryName = (TextView) findViewById(R.id.country_name) ;
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                countryname = countrySpinner.getSelectedItem().toString() ;
                countryName.setText(countryname) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                countryName.setText(countryname) ;
            }

        });

        /* System.out.println("What the hell") ;
        TextView countryName = (TextView) findViewById(R.id.country_name) ;
        countryname = countrySpinner.getSelectedItem().toString() ;
        countryName.setText(countryname) ;
        */
    }

    /* public void show(View view) {
        Spinner countrySpinner = (Spinner) findViewById(R.id.spinner) ;
        TextView countryName = (TextView) findViewById(R.id.country_name) ;
        countryName.setText(countrySpinner.getSelectedItem().toString()) ;
    } */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
