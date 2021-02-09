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
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Tab1Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items;

    public Tab1Adapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView= inflater.inflate(R.layout.tab1_recyclerview,parent,false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;

        Item item =items.get(position);
        vh.tvhouse.setText(item.tvhouse);
        vh.tvaddress.setText(item.tvaddress);
        vh.iv.setImageResource(item.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tvhouse;
        TextView tvaddress;

        public VH(@NonNull View itemView) {
            super(itemView);

            iv=itemView.findViewById(R.id.iv);
            tvhouse= itemView.findViewById(R.id.tv_house);
            tvaddress= itemView.findViewById(R.id.tv_address);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =getLayoutPosition();
                    String house=items.get(position).tvhouse;
                    String address=items.get(position).tvaddress;
                    int img = items.get(position).img;

                    Intent intent = new Intent(context,ClickPage.class);
                    intent.putExtra("house",house);
                    intent.putExtra("address",address);
                    intent.putExtra("img",img);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, new Pair<View,String>(iv,"img"));
                        context.startActivity(intent,options.toBundle());
                    }else {
                        context.startActivity(intent);
                    }

                }
            });
        }
    }


}
