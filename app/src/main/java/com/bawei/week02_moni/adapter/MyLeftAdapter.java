package com.bawei.week02_moni.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.week02_moni.R;
import com.bawei.week02_moni.bean.MyDataLeft;

import java.util.List;

public class MyLeftAdapter extends RecyclerView.Adapter<MyLeftAdapter.ViewHolder> {
    private Context context;
    private List<MyDataLeft.DataBean> leftData;
    private LayoutInflater inflater;

    public MyLeftAdapter(Context context, List<MyDataLeft.DataBean> leftData) {
        this.context = context;
        this.leftData = leftData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.left_recycler_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.left_text_title.setText(leftData.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return leftData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView left_text_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //right_recycler_img = itemView.findViewById(R.id.right_recycler_img);
            left_text_title = itemView.findViewById(R.id.left_text_title);
        }
    }
}
