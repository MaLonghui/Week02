package com.bawei.week02_moni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.week02_moni.fargment.FenLeiFragment;
import com.bawei.week02_moni.fargment.MiMeFragment;
import com.bawei.week02_moni.fargment.ShopCarFragment;
import com.bawei.week02_moni.fargment.ShouYeFragment;
import com.bawei.week02_moni.fargment.WodeFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import org.w3c.dom.Text;

public class ShowActivity extends AppCompatActivity {

    private MyToaBar my_topbar;
    private BottomTabBar botttom_bar;
    private TextView title_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        my_topbar = findViewById(R.id.my_topBar);
        botttom_bar = findViewById(R.id.bottom_bar);
        title_text_view = findViewById(R.id.title_text_view);
        my_topbar.setMyTopBarOnClickListener(new MyToaBar.OnTopBarClickListen() {
            @Override
            public void onLeftClick() {

            }
        });
       botttom_bar.init(getSupportFragmentManager())
               .setImgSize(50,50)
               .setFontSize(8)
               .setTabPadding(4,6,10)
               .addTabItem("首页",R.drawable.rb1_selector,ShouYeFragment.class)
               .addTabItem("分类",R.drawable.rb2_selector,FenLeiFragment.class)
               .addTabItem("觅me",R.drawable.rb4_selector,MiMeFragment.class)
               .addTabItem("购物车",R.drawable.rb3_selector,ShopCarFragment.class)
               .addTabItem("我的",R.drawable.rb5_selector,WodeFragment.class)
               .isShowDivider(false)
               .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                   @Override
                   public void onTabChange(int position, String name){
                       title_text_view.setText(name);
                   }

               });
    }
}
