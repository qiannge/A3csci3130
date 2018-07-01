package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends Activity {
    private EditText Name1,BusinessNumber1,PrimaryBusiness1,Address1,Province1;
    private Button update,delete;
    private DatabaseReference ref;
    Contact c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedelete);


        Name1 = (EditText) findViewById(R.id.Name1);
        BusinessNumber1 = (EditText) findViewById(R.id.BusinessNumber1);
        PrimaryBusiness1 = (EditText) findViewById(R.id.PrimaryBusiness1);
        Address1 = (EditText) findViewById(R.id.Address1);
        Province1 = (EditText) findViewById(R.id.Province1);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        ref = FirebaseDatabase.getInstance().getReference("Contact");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Contact contact = dataSnapshot1.getValue(Contact.class);
                    Name1.setText(contact.name);
                    BusinessNumber1.setText(contact.businessNumber);
                    PrimaryBusiness1.setText(contact.primaryBusiness);
                    Address1.setText(contact.address);
                    Province1.setText(contact.province);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateContact();
                Intent i = new Intent();
                i.setClass(Main3Activity.this,MainActivity.class);
                Main3Activity.this.startActivity(i);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.removeValue();
                Intent i = new Intent();
                i.setClass(Main3Activity.this,MainActivity.class);
                Main3Activity.this.startActivity(i);
            }
        });
    }
    private void updateContact(){
        String name = Name1.getText().toString();
        String number = BusinessNumber1.getText().toString();
        String primary = PrimaryBusiness1.getText().toString();
        String address = Address1.getText().toString();
        String province = Province1.getText().toString();
        String id = c.getId();

        Contact contact = new Contact(name, number, primary, address, province, id);


        ref.child(id).setValue(contact);
    }
}
