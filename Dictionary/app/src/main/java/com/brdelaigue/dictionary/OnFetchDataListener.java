package com.brdelaigue.dictionary;

import com.brdelaigue.dictionary.Model.APIResponse;

public interface OnFetchDataListener {

    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);
}
