package com.example.montreal_art;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class List_Adapter extends  RecyclerView.Adapter<List_Adapter.List_Viewfinder> {
    public  List<Reservations> refer=new ArrayList<>();
    public List_Adapter(List<Reservations> refer)
    {
        this.refer =refer;
    }
    public List_Viewfinder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_1, parent, false);
        List_Viewfinder viewfinder = new List_Viewfinder(view);
        return viewfinder;
    }

    @Override
    public void onBindViewHolder(@NonNull List_Viewfinder holder, int position) {
        int i1= refer.get(position).getImage();
        String s1= refer.get(position).getType();
        String s2= refer.get(position).getIndate();
        String s3= refer.get(position).getOutdate();
        String s4= refer.get(position).getPrice();
        holder.img.setImageResource(i1);
        holder.t1.setText(s1);
        holder.t2.setText(s2);
        holder.t3.setText(s3);
        holder.t4.setText(s4);
    }

    @Override
    public int getItemCount() {
        return refer.size();
    }


    public static class List_Viewfinder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView t1, t2, t3, t4;

        public List_Viewfinder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView5);
            t1 = itemView.findViewById(R.id.textView14);
            t2 = itemView.findViewById(R.id.textView3);
            t3 = itemView.findViewById(R.id.textView16);
            t4 = itemView.findViewById(R.id.textView18);
        }
    }
}
