package com.bawei.week02_moni.home.presenter;

import com.bawei.week02_moni.api.Api;
import com.bawei.week02_moni.fargment.ShouYeFragment;
import com.bawei.week02_moni.home.model.IWeekModel;
import com.bawei.week02_moni.home.model.WeekModel;

public class WeekPresenter implements IWeekPresenter{
    ShouYeFragment shouYeFragment;
    private final WeekModel weekModel;

    public WeekPresenter(ShouYeFragment shouYeFragment) {
        this.shouYeFragment = shouYeFragment;
        weekModel = new WeekModel();
    }

    @Override
    public void getPresenterData() {
        weekModel.getData(Api.DATA_LEFT, new IWeekModel.ModelInterface() {
            @Override
            public void loadSuccess(String data) {
                shouYeFragment.getViewData(data);
            }

            @Override
            public void loadFailed() {

            }
        });
        weekModel.getData(Api.DATA_RIGHT, new IWeekModel.ModelInterface() {
            @Override
            public void loadSuccess(String data) {
                shouYeFragment.getRightData(data);
            }

            @Override
            public void loadFailed() {

            }
        });

    }
}
