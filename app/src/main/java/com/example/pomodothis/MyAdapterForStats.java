package com.example.pomodothis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterForStats extends  RecyclerView.Adapter<MyAdapterForStats.Myholder>{
    Context context;
    ArrayList<Today> lesstats;
    private LayoutInflater mInflater;

    MyAdapterForStats (Context cntxt, ArrayList<Today> lesstats) {
        this.context = cntxt;
        this.mInflater = LayoutInflater.from(context);
        this.lesstats = lesstats;
    }


    @Override
    public int getItemCount() {
        return this.lesstats.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    class Myholder extends RecyclerView.ViewHolder{
        TextView date;
        TextView stat;
        TextView breaks;
        public Myholder(@NonNull View itemView)
        {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            stat=itemView.findViewById(R.id.productivity);
            breaks=itemView.findViewById(R.id.allbreaks);
        }
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_stat_layout,null,false);

        View v = mInflater.inflate(R.layout.mini_stat_layout,parent,false);

        Myholder h = new Myholder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        Today a=lesstats.get(position);
        //String a=lesstats.get(position);
        holder.date.setText(a.getDate());
        holder.stat.setText(Statistics_Activity.minutesToFormat(a.getPomos() * 25));
        holder.breaks.setText(Statistics_Activity.minutesToFormat(a.getBreaks() * 5));
    }
}
