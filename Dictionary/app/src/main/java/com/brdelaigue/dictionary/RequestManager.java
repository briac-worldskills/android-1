package com.brdelaigue.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.brdelaigue.dictionary.Model.APIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class RequestManager {

    Context context;

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.dictionaryapi.dev/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getWordMeaning(OnFetchDataListener listener, String word) {
        callDictonary callDictonary = retrofit.create(RequestManager.callDictonary.class);
        Call<List<APIResponse>> call = callDictonary.callMeanings(word);

        call.enqueue(new Callback<List<APIResponse>>() {
            @Override
            public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetchData(response.body().get(0), response.message());
            }

            @Override
            public void onFailure(Call<List<APIResponse>> call, Throwable t) {
                listener.onError("Request Failed!!");
            }
        });

    }

    public interface callDictonary {
        @GET("entries/en/{word}")
        Call<List<APIResponse>> callMeanings(
             @Path("word") String word
        );
    }
}
