package com.hog2020.foodtrip;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SetRecyclerAdapter extends RecyclerView.Adapter{

    Context context;
    ArrayList<SetItem> arrayList;

    public SetRecyclerAdapter(Context context, ArrayList<SetItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View itemview =inflater.inflate(R.layout.setrecycler_item,parent,false);
        VH holder = new VH(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;
        SetItem item= arrayList.get(position);
        vh.st.setText(item.st);
        vh.st1.setText(item.st1);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView st;
        TextView st1;

        public VH(@NonNull View itemView) {
            super(itemView);

            st=itemView.findViewById(R.id.st);
            st1=itemView.findViewById(R.id.st1);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getLayoutPosition();
                    String st = arrayList.get(position).st;

                    Intent intent = new Intent(context,AlermActivity.class);
                    intent.putExtra("st",st);

                    context.startActivity(intent);
                }
            });
        }
    }
}
