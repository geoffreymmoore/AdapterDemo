package com.moore.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get ListView object from XML
        listView = (ListView) findViewById(R.id.listView);

        String[] values = getResources().getStringArray(R.array.list_adaptor_array);

        // Define a new Adapter
        // First parameter - context
        // Second parameter - layout for the row
        // Third parameter - ID of the textView to which the data is written
        // Fourth parameter - array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,android.R.id.text1,values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView clicked item index
                int itemPosition = position + 1;

                // ListView Clicked Item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(), "Position: " + itemPosition + "\nListItem: " + itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}
