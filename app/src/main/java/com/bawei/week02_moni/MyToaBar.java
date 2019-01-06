package com.bawei.week02_moni;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.logging.Handler;

public class MyToaBar extends RelativeLayout {

    private Button left_img;
    private TextView left_text_view;
    private TextView title_text_view;
    private TextView right_text_view;
    private OnTopBarClickListen topBarClickListen;
    public MyToaBar(Context context) {
        super(context);
    }
    //设置监听器
    public void setMyTopBarOnClickListener(OnTopBarClickListen topBarOnClickListener){
        this.topBarClickListen = topBarOnClickListener;
    }
    //定义接口
    public interface OnTopBarClickListen{
        void onLeftClick();
    }

    public MyToaBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mytopbar_layout,this);
        left_img = findViewById(R.id.left_img);
        left_text_view = findViewById(R.id.left_text_view);
        title_text_view = findViewById(R.id.title_text_view);
        right_text_view = findViewById(R.id.right_text_view);
        left_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //获取自定义属性big赋值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTopBar);
        int left_background = typedArray.getResourceId(R.styleable.MyTopBar_left_background, 0);
        String left_text = typedArray.getString(R.styleable.MyTopBar_left_text);
        String title_text = typedArray.getString(R.styleable.MyTopBar_title_text);
        String right_text = typedArray.getString(R.styleable.MyTopBar_right_text);
        int color = typedArray.getColor(R.styleable.MyTopBar_text_color,0);

        //释放资源
        typedArray.recycle();
        left_img.setBackgroundResource(left_background);
        left_text_view.setText(left_text);
        title_text_view.setText(title_text);
        right_text_view.setText(right_text);
        left_text_view.setTextColor(color);
        title_text_view.setTextColor(color);
        right_text_view.setTextColor(color);
    }

    public MyToaBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyToaBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
