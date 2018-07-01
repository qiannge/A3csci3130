package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {
    private Button submitButton;
    private ListView listView;
    private DatabaseReference ref;
    Contact contact = new Contact();
    private FirebaseListAdapter<Contact> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        submitButton = (Button) findViewById(R.id.submitButton);
        listView = (ListView) findViewById(R.id.listView);
        ref = FirebaseDatabase.getInstance().getReference("Contact");
        adapter = new FirebaseListAdapter<Contact>(this, Contact.class, android.R.layout.simple_list_item_1, ref) {
            @Override
            protected void populateView(View view, Contact model, int position) {
                TextView name = (TextView) view.findViewById(android.R.id.text1);
                name.setText(model.name);
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact name = (Contact) adapter.getItem(i);
                showDetailView(name);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(i);

            }
        });
    }
    private void showDetailView(Contact name)
    {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("contract", name);
        startActivity(intent);
    }
}
