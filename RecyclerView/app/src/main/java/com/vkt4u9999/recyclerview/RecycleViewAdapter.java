package com.vkt4u9999.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewViewHolder> {


    private  ArrayList<RecyclerViewItem> arrayList;
    public RecycleViewAdapter(ArrayList<RecyclerViewItem> arrayList){
        this.arrayList= arrayList;
    }
    public static class RecycleViewViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;


        public RecycleViewViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView1=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
        }
    }

    @NonNull
    @Override
    public RecycleViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);

        RecycleViewViewHolder recycleViewViewHolder= new RecycleViewViewHolder(view);
        return recycleViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewViewHolder holder, int position) {
        RecyclerViewItem recyclerViewItem=arrayList.get(position);

        holder.imageView.setImageResource(recyclerViewItem.getImageResource());
        holder.textView1.setText(recyclerViewItem.getText1());
        holder.textView2.setText(recyclerViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
