package com.hog2020.foodtrip;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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

public class TopAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item2> item2;

    public TopAdapter(Context context, ArrayList<Item2> item2ArrayList) {
        this.context = context;
        this.item2 = item2ArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.toplist,parent,false);
        VH holder=new VH(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;

        Item2 item =item2.get(position);
        vh.tvtopname.setText(item.tvname);
        vh.tvtopinfo.setText(item.tvinfo);

        Glide.with(context).load(item.ivimg).into(vh.ivtopimg);
        Glide.with(context).load(item.ivheart).into(vh.ivtopheart);
        Glide.with(context).load(item.ivtalk).into(vh.ivtoptalk);

    }

    @Override
    public int getItemCount() {
        return item2.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView ivtopimg,ivtopheart,ivtoptalk;
        TextView tvtopname,tvtopinfo;

        public VH(@NonNull View itemView) {
            super(itemView);
            ivtopimg=itemView.findViewById(R.id.iv_topimg);
            ivtopheart=itemView.findViewById(R.id.iv_topheart);
            ivtoptalk= itemView.findViewById(R.id.iv_toptalk);
            tvtopname=itemView.findViewById(R.id.tv_topname);
            tvtopinfo=itemView.findViewById(R.id.tv_topinfo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =getLayoutPosition();

                    String name = item2.get(position).tvname;
                    String info =item2.get(position).tvinfo;
                    int img= item2.get(position).ivimg;
                    int heart= item2.get(position).ivheart;
                    int talk= item2.get(position).ivtalk;

                    Intent intent = new Intent(context,Clickpage2.class);
                    intent.putExtra("tvname",name);
                    intent.putExtra("tvinfo",info);
                    intent.putExtra("ivimg",img);
                    intent.putExtra("ivheart",heart);
                    intent.putExtra("ivtalk",talk);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity)context,new Pair<View,String>(ivtopimg,"ivimg"));
                        context.startActivity(intent,options.toBundle());
                    }else {
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
