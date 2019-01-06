package com.bawei.week02_moni.home.model;

import com.bawei.week02_moni.utils.Okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeekModel implements IWeekModel{

    @Override
    public void getData(String url, final ModelInterface modelInterface) {
        Okhttp.okHttpGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                modelInterface.loadSuccess(response.body().string());
            }
        });

    }
}
