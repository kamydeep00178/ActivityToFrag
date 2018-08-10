package com.example.kamal.activitytofrag.ui.my;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> stringMutableLiveData;

    public void init()
    {
        stringMutableLiveData=new MutableLiveData<>();

    }

    public void sendData(String msg)
    {
        stringMutableLiveData.setValue(msg);
    }

    public LiveData<String> getMessage()
    {
        return stringMutableLiveData;


    }
}
