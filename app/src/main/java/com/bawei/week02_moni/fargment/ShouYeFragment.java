package com.bawei.week02_moni.fargment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.week02_moni.R;
import com.bawei.week02_moni.adapter.MyLeftAdapter;
import com.bawei.week02_moni.adapter.MyRightAdapter;
import com.bawei.week02_moni.bean.MyDataLeft;
import com.bawei.week02_moni.bean.MyDataRight;
import com.bawei.week02_moni.home.presenter.WeekPresenter;
import com.bawei.week02_moni.home.view.IWeekView;
import com.google.gson.Gson;

import java.util.List;


public class ShouYeFragment extends Fragment implements IWeekView {


    private RecyclerView left_recycler;
    private RecyclerView right_recycler;
    private WeekPresenter weekPresenter;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shou_ye, container, false);
        left_recycler = view.findViewById(R.id.left_recycler);
        right_recycler = view.findViewById(R.id.right_recycler);
        //初始化presenter
        weekPresenter = new WeekPresenter(ShouYeFragment.this);
        weekPresenter.getPresenterData();
        //创建线性布局
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //创建网格布局
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        //recycler设置布局样式
        left_recycler.setLayoutManager(linearLayoutManager);
        right_recycler.setLayoutManager(gridLayoutManager);
        return view;
    }

    @Override
    public void getViewData(final String data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                MyDataLeft myDataLeft = gson.fromJson(data, MyDataLeft.class);
                List<MyDataLeft.DataBean> leftData = myDataLeft.getData();
                //设置适配器
                MyLeftAdapter leftAdapter = new MyLeftAdapter(getActivity(),leftData);
                left_recycler.setAdapter(leftAdapter);
            }
        });
    }
    @Override
    public void getRightData(final String data) {
          getActivity().runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  Gson gson = new Gson();
                  MyDataRight myDataRight = gson.fromJson(data, MyDataRight.class);
                  List<MyDataRight.DataBean> rightData = myDataRight.getData();
                  //设置适配器
                  MyRightAdapter rightAdapter = new MyRightAdapter(getActivity(),rightData);
                  right_recycler.setAdapter(rightAdapter);
              }
          });
    }
}
