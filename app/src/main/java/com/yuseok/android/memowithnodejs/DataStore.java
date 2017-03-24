package com.yuseok.android.memowithnodejs;

import com.yuseok.android.memowithnodejs.domain.Data;

import java.util.List;

/**
 * Created by YS on 2017-03-24.
 */

public class DataStore {

    private static DataStore instance = null;

    private DataStore() {}

    public static DataStore getInstance() {
        if(instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    private List<Data.Qna> datas;

    public List<Data.Qna> getDatas() {
        return datas;
    }

    public void setDatas(List<Data.Qna> datas) {
        this.datas = datas;
    }
}
