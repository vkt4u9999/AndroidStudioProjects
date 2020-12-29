package com.vkt4u9999.clubolympus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.vkt4u9999.clubolympus.data.ClubOlympusContract;
import com.vkt4u9999.clubolympus.data.ClubOlympusContract.MemberEntry;


public class AddMemberActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private final static int EDIT_MEMBER_LOADER=123;
    Uri currentMemberUri;

    private ArrayAdapter spinnerAdapter;

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText sportEditText;

    private Spinner genderSpinner;
    private int gender= 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        Intent intent=getIntent();
        currentMemberUri=intent.getData();
        if (currentMemberUri == null){
            setTitle("Add new member");
            invalidateOptionsMenu();
        }else{
            setTitle("Edit the member");
            getSupportLoaderManager().initLoader(EDIT_MEMBER_LOADER,null,this);
        }

        firstNameEditText= findViewById(R.id.firsNameEditText);
        lastNameEditText= findViewById(R.id.lastNameEditText);
        sportEditText= findViewById(R.id.groupNameEditText);
        genderSpinner=findViewById(R.id.genderSpinner);



        spinnerAdapter=ArrayAdapter.createFromResource(this, R.array.array_spinner, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(spinnerAdapter);


        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedGender= (String)adapterView.getItemAtPosition(i);

                //Проверяем на пустую строку
                if (!TextUtils.isEmpty(selectedGender)){
                    if (selectedGender.equals("Male")) {
                        gender = ClubOlympusContract.MemberEntry.GENDER_MALE;
                    }else if (selectedGender.equals("Female")){
                        gender = ClubOlympusContract.MemberEntry.GENDER_FEMALE;
                    }else{
                        gender = ClubOlympusContract.MemberEntry.GENDER_UNKNOWN;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                gender=0;
            }
        });

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        super.onPrepareOptionsMenu(menu);

        if (currentMemberUri == null) {
            MenuItem menuItem = menu.findItem(R.id.delete_member);
            menuItem.setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_member_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_member:
                saveMember();
            return true;
            case R.id.delete_member:
                showDeleteMemberDialog();
            return true;
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void saveMember() {

        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String sport = sportEditText.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)) {
            Toast.makeText(this,
                    "Input the first name",
                    Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(lastName)) {
            Toast.makeText(this,
                    "Input the last name",
                    Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(sport)) {
            Toast.makeText(this,
                    "Input the sport",
                    Toast.LENGTH_LONG).show();
            return;
        } else if (gender == MemberEntry.GENDER_UNKNOWN) {
            Toast.makeText(this,
                    "Choose the gender",
                    Toast.LENGTH_LONG).show();
            return;
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put(MemberEntry.COLUMN_FIRST_NAME, firstName);
        contentValues.put(MemberEntry.COLUMN_LAST_NAME, lastName);
        contentValues.put(MemberEntry.COLUMN_SPORT, sport);
        contentValues.put(MemberEntry.COLUMN_GENDER, gender);

        if (currentMemberUri == null) {
            ContentResolver contentResolver = getContentResolver();
            Uri uri = contentResolver.insert(MemberEntry.CONTENT_URI,
                    contentValues);

            if (uri == null) {
                Toast.makeText(this,
                        "Insertion of data in the table failed",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,
                        "Data saved", Toast.LENGTH_LONG).show();
            }
        } else {
            int rowsChanged = getContentResolver().update(currentMemberUri,
                    contentValues, null, null);

            if (rowsChanged == 0) {
                Toast.makeText(this,
                        "Saving of data in the table failed",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,
                        "Member updated", Toast.LENGTH_LONG).show();
            }
        }
    }



    @NonNull
    @Override
    public Loader onCreateLoader(int id, @Nullable Bundle args) {
        String []projection= {
                ClubOlympusContract.MemberEntry._ID,
                ClubOlympusContract.MemberEntry.COLUMN_FIRST_NAME,
                ClubOlympusContract.MemberEntry.COLUMN_LAST_NAME,
                ClubOlympusContract.MemberEntry.COLUMN_GENDER,
                ClubOlympusContract.MemberEntry.COLUMN_SPORT
        };
        return new CursorLoader(this,
                currentMemberUri,
                projection,
                null,
                null,
                null
        );
    }

@Override
    public void onLoadFinished(@NonNull Loader <Cursor> loader, Cursor cursor) {

        if (cursor.moveToFirst()){
            int firstNameColumnIndex=cursor.getColumnIndex(ClubOlympusContract.MemberEntry.COLUMN_FIRST_NAME);
            int lastNameColumnIndex=cursor.getColumnIndex(ClubOlympusContract.MemberEntry.COLUMN_LAST_NAME);
            int genderColumnIndex=cursor.getColumnIndex(ClubOlympusContract.MemberEntry.COLUMN_GENDER);
            int sportColumnIndex=cursor.getColumnIndex(ClubOlympusContract.MemberEntry.COLUMN_SPORT);

            String firstName= cursor.getString(firstNameColumnIndex);
            String lastName= cursor.getString(lastNameColumnIndex);
            int gender= cursor.getInt(genderColumnIndex);
            String sport= cursor.getString(sportColumnIndex);


            firstNameEditText.setText(firstName);
            lastNameEditText.setText(lastName);
            sportEditText.setText(sport);

            switch (gender){
                case MemberEntry.GENDER_MALE:
                    genderSpinner.setSelection(1);
                    break;
                case MemberEntry.GENDER_FEMALE:
                    genderSpinner.setSelection(2);
                    break;
                case MemberEntry.GENDER_UNKNOWN:
                    genderSpinner.setSelection(0);
                    break;
            }
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }
    private void showDeleteMemberDialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Do you want to delete the member??");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteMember();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dialogInterface!=null){
                    dialogInterface.dismiss();
                }
            }
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }
    private void deleteMember(){
        if (currentMemberUri!= null){
            int rowsDeleted=getContentResolver().delete(currentMemberUri,null,null);

            if (rowsDeleted==0){
                Toast.makeText(this,
                        "Deleting of data is failed!", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,
                        "Member is deleted!", Toast.LENGTH_LONG).show();
            }
            finish();
        }
    }
}
