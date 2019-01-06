package com.bawei.week02_moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.week02_moni.R;
import com.bawei.week02_moni.bean.MyDataRight;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MyRightAdapter extends RecyclerView.Adapter<MyRightAdapter.ViewHolder> {
    private Context context;
    private List<MyDataRight.DataBean> rightData;
    private LayoutInflater inflater;


    public MyRightAdapter(Context context, List<MyDataRight.DataBean> rightData) {
        this.context = context;
        this.rightData = rightData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.right_recycler_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RequestOptions options = new RequestOptions();
        Glide.with(context)
                .load(rightData.get(i).getList().get(i).getIcon())
                .apply(options)
                .into(viewHolder.right_recycler_img);
        viewHolder.right_recycler_text.setText(rightData.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return rightData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView right_recycler_img;
        private final TextView right_recycler_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            right_recycler_img = itemView.findViewById(R.id.right_recycler_img);
            right_recycler_text = itemView.findViewById(R.id.right_recycler_text);
        }
    }
}
