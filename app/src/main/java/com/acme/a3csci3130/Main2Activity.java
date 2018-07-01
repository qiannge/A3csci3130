package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends Activity {
    private EditText Name,BusinessNumber,PrimaryBusiness,Address,Province;
    private Button create;
    private DatabaseReference ref;
    Contact contact = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Name = (EditText) findViewById(R.id.Name);
        BusinessNumber = (EditText) findViewById(R.id.BusinessNumber);
        PrimaryBusiness = (EditText) findViewById(R.id.PrimaryBusiness);
        Address = (EditText) findViewById(R.id.Address);
        Province = (EditText) findViewById(R.id.Province);
        create = (Button) findViewById(R.id.create);

        ref = FirebaseDatabase.getInstance().getReference("Contact");

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createContact();
                Intent i = new Intent();
                i.setClass(Main2Activity.this,MainActivity.class);
                Main2Activity.this.startActivity(i);
            }
        });

    }
    public void createContact(){
        String name = Name.getText().toString();
        String number = BusinessNumber.getText().toString();
        String primary = PrimaryBusiness.getText().toString();
        String address = Address.getText().toString();
        String province = Province.getText().toString();
        String uid = ref.push().getKey().toString();

        Contact contact = new Contact(name, number, primary, address, province, uid);


        ref.child(uid).setValue(contact);
    }
}
