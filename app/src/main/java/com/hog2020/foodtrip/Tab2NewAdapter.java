package com.hog2020.foodtrip;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Tab2NewAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<FooddataItem> items;


    public Tab2NewAdapter(Context context, ArrayList<FooddataItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.newitem,parent,false);
        VH vh = new VH(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;

        FooddataItem item = items.get(position);
        String imgUrl ="http://hog2069.dothome.co.kr/Fooddata/"+item.image;
        Log.i("tag",imgUrl);
        Glide.with(context).load(imgUrl).into(vh.iv);

        vh.tvname.setText(item.name);
        vh.tvinfo.setText(item.address);
        vh.tvphone.setText(item.number);



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tvname;
        TextView tvinfo;
        TextView tvphone;

        public VH(@NonNull View itemView) {
            super(itemView);

            iv= itemView.findViewById(R.id.iv_item);
            tvname=itemView.findViewById(R.id.tv_Item1);
            tvinfo=itemView.findViewById(R.id.tv_Item2);
            tvphone=itemView.findViewById(R.id.tv_Item3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();

                    String image = items.get(position).image;
                    String name =items.get(position).name;
                    String info= items.get(position).address;
                    String phone=items.get(position).number;

                    Intent intent = new Intent(context,NewClickActivity.class);
                    intent.putExtra("image",image);
                    intent.putExtra("name",name);
                    intent.putExtra("info",info);
                    intent.putExtra("phone",phone);

                    context.startActivity(intent);


                }
            });
       }
    }
}
