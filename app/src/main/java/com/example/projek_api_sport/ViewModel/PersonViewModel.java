package com.example.projek_api_sport.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projek_api_sport.Model.Person.PersonDiscoverResponse;
import com.example.projek_api_sport.Model.Person.PersonDiscoverResultSportsItem;
import com.example.projek_api_sport.Service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<PersonDiscoverResultSportsItem>> listDiscoverPersonItem       =   new MutableLiveData<>();

    public void setPersonDiscover()
    {
        if(this.apiMain == null)
        {
            apiMain                                                                                 =   new ApiMain();
        }

        apiMain.getApiSport().getPersonDiscover().enqueue(new Callback<PersonDiscoverResponse>() {
            @Override
            public void onResponse(Call<PersonDiscoverResponse> call, Response<PersonDiscoverResponse> response) {
                PersonDiscoverResponse personDiscoverResponse                                       =   response.body();

                if(personDiscoverResponse != null && personDiscoverResponse.getSports() != null)
                {
                    ArrayList<PersonDiscoverResultSportsItem> personDiscoverResultSportsItems       =   personDiscoverResponse.getSports();
                    listDiscoverPersonItem.postValue(personDiscoverResultSportsItems);
                }
            }

            @Override
            public void onFailure(Call<PersonDiscoverResponse> call, Throwable t) {
                t.getMessage();
                Log.e("Error", t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<PersonDiscoverResultSportsItem>> getPersonDiscover()
    {
        return listDiscoverPersonItem;
    }

}
