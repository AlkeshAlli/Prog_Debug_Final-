package com.example.montreal_art;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class Art_home extends AppCompatActivity {

    RecyclerView recyclerView;
    List_Adapter list_adapter;
    List<Reservations> reserv=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_home);
            indata();
            recyclerView = findViewById(R.id.recyclerView2);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            list_adapter=new List_Adapter(reserv);
            recyclerView.setAdapter(list_adapter);

        }

    public void indata(){
        Reservations r=new Reservations(R.drawable.pic1,"Picaso","Abstract","18-01-2001","America");
        reserv.add(r);
        r=new Reservations(R.drawable.pic2,"M.F Hussain","River bay","21-03-1998 ","India");
        reserv.add(r);
        r=new Reservations(R.drawable.pic3,"Charles Bargue","French Art","13-05-1885","France");
        reserv.add(r);
        r=new Reservations(R.drawable.pic4,"Zund Robert","Sea shore","03-07-1901","Switzerland");
        reserv.add(r);
        r=new Reservations(R.drawable.pic5,"Joseph steve","Oil Painting","30-02-1891","America");
        reserv.add(r);


    }

}
