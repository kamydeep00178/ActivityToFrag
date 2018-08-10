package com.example.kamal.activitytofrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;

import com.example.kamal.activitytofrag.ui.my.MyFragment;
import com.example.kamal.activitytofrag.ui.my.MyViewModel;

public class MyActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        handler = new Handler();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MyFragment.newInstance())
                    .commitNow();
        }
        //Make View Holder Object
        myViewModel=ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.init();
        myViewModel.sendData("Hello kamy");

        // Make thread to send data again
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myViewModel.sendData("How are You ?");
                        }
                    });

            }
        }).start();
    }
}
