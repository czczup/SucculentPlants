package com.succulent.wztxy.succulentplants.blossom.tool;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {

    public static void doGet(String address, okhttp3.Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
