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

        View itemView = inflater.inflate(R.layout.new_recycleritem,parent,false);
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

            iv= itemView.findViewById(R.id.iv_new);
            tvname=itemView.findViewById(R.id.tv_name);
            tvinfo=itemView.findViewById(R.id.tv_info);
            tvphone=itemView.findViewById(R.id.tv_phone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    String name = items.get(position).name;
                    String info = items.get(position).address;
                    String phone= items.get(position).number;
                    String image =items.get(position).image;

//                    Intent intent = new Intent(context,NewTab2Fragment.class);
//                    intent.putExtra("name",name);
//                    intent.putExtra("address",info);
//                    intent.putExtra("number",phone);
//                    intent.putExtra("image",image);
//
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, new Pair<View,String>(iv,"no"));
//                        context.startActivity(intent,options.toBundle());
//                    }else {
//                        context.startActivity(intent);
//                    }


                    //MainActivity 에서 동적 퍼미션 작업 다하기
                    //탭 3번 데이터 저장후 지워지게게 하기
                }
            });
       }
    }
}
