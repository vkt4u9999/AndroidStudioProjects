package com.vkt4u9999.mydb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vkt4u9999.mydb.Model.Component;

import java.util.ArrayList;

public class ComponentsAdapter extends RecyclerView.Adapter<ComponentsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Component> components;
    private MainActivity mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView priceTextView;


        public MyViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            priceTextView = view.findViewById(R.id.priceTextView);

        }
    }
    public ComponentsAdapter(Context context, ArrayList<Component> components, MainActivity mainActivity) {
        this.context = context;
        this.components = components;
        this.mainActivity = mainActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.components_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        final Component component = components.get(position);

        holder.nameTextView.setText(component.getName());
        holder.priceTextView.setText(component.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                mainActivity.addAndEditComponents(true, component, position);
            }
        });
    }

    @Override
    public int getItemCount() {

        return components.size();
    }


}
