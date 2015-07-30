package com.lopez.espada.falconi.people_list_devspark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Lisandro Falconi on 28/07/15.
 *
 */
public class NewEditPerson extends AppCompatActivity {
    private Toolbar toolbar;
    private Button savePersonButton;
    private EditText personNameField;
    private EditText personPhoneField;
    private EditText personEmailField;
    private EditText personAddressField;
    private EditText personDoBField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_form);

        bindViews();
    }

    private void bindViews() {

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_home_black));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        personNameField  = (EditText) findViewById(R.id.person_name);
        personPhoneField  = (EditText) findViewById(R.id.person_phone);
        personEmailField  = (EditText) findViewById(R.id.person_email);
        personAddressField = (EditText) findViewById(R.id.person_address);
        personDoBField =  (EditText) findViewById(R.id.person_dob);
        savePersonButton = (Button)findViewById(R.id.save_button);
        
        savePersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO validate fields (?)
                Log.d("NewEditPerson","onCLick");
                Intent returnIntent = new Intent();
                returnIntent.putExtra(MainActivity.PERSON, buildPersonFromFields());
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

    private Person buildPersonFromFields() {
        Person person = new Person();
        person.setName(personNameField.getText().toString());
        person.setAddress(personAddressField.getText().toString());
        person.setEmail(personEmailField.getText().toString());
        person.setPhone(personPhoneField.getText().toString());
        person.setDob(personDoBField.getText().toString());
        return person;
    }
}
