package com.bawei.week02_moni.home.model;

public interface IWeekModel {
    void getData(String url, ModelInterface modelInterface);
    interface ModelInterface{
        void loadSuccess(String data);
        void loadFailed();
    }
}
