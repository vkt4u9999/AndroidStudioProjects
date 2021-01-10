package com.vkt4u9999.mydb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import com.vkt4u9999.mydb.Data.ComponentsAppDatabase;
import com.vkt4u9999.mydb.Model.Component;

public class MainActivity extends AppCompatActivity {

    private ComponentsAdapter componentsAdapter;
    private ArrayList<Component> componentArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ComponentsAppDatabase componentsAppDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.recyclerView);
        componentsAppDatabase= Room.databaseBuilder(getApplicationContext(), ComponentsAppDatabase.class, "ComponentsDB").build();

        new GetAllComponentsAsyncTask().execute();

        componentsAdapter= new ComponentsAdapter(this, componentArrayList,MainActivity.this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(componentsAdapter);


        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAndEditComponents(false, null, -1);
            }
        });
    }

    public void addAndEditComponents(final boolean isUpdate,final Component component, final int position) {
        LayoutInflater layoutInflaterAndroid= LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.layout_add_component,null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilderUserInput.setView(view);

        TextView newTitleTextView = view.findViewById(R.id.newTitleTextView);
        final EditText nameEditText= view.findViewById(R.id.nameEditText);
        final EditText priceEditText= view.findViewById(R.id.priceEditText);

        newTitleTextView.setText(!isUpdate ? "Add a task" : "Edit task");

        if(isUpdate && component !=null){
            nameEditText.setText(component.getName());
            priceEditText.setText(component.getPrice());
        }

        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(isUpdate ? "Update" : "Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton(isUpdate ? "Delete" : "Cancel",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (isUpdate) {

                            deleteComponent(component,position);

                        } else {
                            dialogInterface.cancel();
                        }
                    }
                });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(nameEditText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter task name!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(priceEditText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter task text!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }
                if (isUpdate && component != null) {

                        updateComponent(nameEditText.getText().toString(), priceEditText.getText().toString(), position);
                } else {

                        createComponent(nameEditText.getText().toString(), priceEditText.getText().toString());
                }
            }
        });
    }


    private void deleteComponent(Component component, int position) {

        componentArrayList.remove(position);
        new DeleteComponentAsyncTask().execute(component);

    }

    private void updateComponent(String name, String price, int position) {

        Component component= componentArrayList.get(position);
        component.setName(name);
        component.setPrice(price);

        new UpdateComponentAsyncTask().execute(component);

        componentArrayList.set(position,component);

    }
    public void createComponent(String name, String price){

        new CreateComponentAsyncTask().execute(new Component(0, name, price));


    }

    private class GetAllComponentsAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            componentArrayList.addAll(componentsAppDatabase.getComponentDAO().getAllComponents());

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            componentsAdapter.notifyDataSetChanged();
            super.onPostExecute(aVoid);
        }
    }
    private class CreateComponentAsyncTask extends AsyncTask<Component, Void,Void>{

        @Override
        protected Void doInBackground(Component... components) {
            long id= componentsAppDatabase.getComponentDAO().addComponent(components[0]);

            Component component=componentsAppDatabase.getComponentDAO().getComponent(id);

            if  (component != null){
                componentArrayList.add(0,component);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            componentsAdapter.notifyDataSetChanged();

        }
    }
    private class UpdateComponentAsyncTask extends AsyncTask<Component, Void, Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            componentsAdapter.notifyDataSetChanged();

        }

        @Override
        protected Void doInBackground(Component... components) {
            componentsAppDatabase.getComponentDAO().updateComponent(components[0]);

            return null;
        }
    }
    private class DeleteComponentAsyncTask extends AsyncTask<Component, Void,Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            componentsAdapter.notifyDataSetChanged();

        }

        @Override
        protected Void doInBackground(Component... components) {

            componentsAppDatabase.getComponentDAO().deleteComponent(components[0]);

            return null;
        }
    }
}