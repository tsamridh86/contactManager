
package com.example.android.sql_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts

    }

    public void addButtonClicked(View view) {

        DatabaseHandler db = new DatabaseHandler(this);
        EditText inputText = (EditText) findViewById(R.id.inputText);
        EditText inputNumber = (EditText) findViewById(R.id.inputNumber);
        String inputName = inputText.getText().toString();
        String inputNo = inputNumber.getText().toString();
        db.addContact(new Contact(inputName, inputNo));

    }


    public void displayButtonClicked (View view){
        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();
        TextView outputScreen1 = (TextView) findViewById(R.id.outputTextId);
        TextView outputScreen2 = (TextView) findViewById(R.id.outputTextName);
        TextView outputScreen3 = (TextView) findViewById(R.id.outputTextNumber);

        String id = "Id\n";
        String name = "Name\n";
        String num = "Number\n";
        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            Log.d("Name: ", log);
            id = id+cn.getID()+"\n";
            name = name+cn.getName()+"\n";
            num = num+cn.getPhoneNumber()+"\n";

        }
        outputScreen1.setText(id);
        outputScreen2.setText(name);
        outputScreen3.setText(num);
    }

    public void deleteButtonClicked(View view){
        DatabaseHandler db = new DatabaseHandler(this);
        db.deleteAllContact();
    }
}
