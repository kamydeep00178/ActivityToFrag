package com.example.kamal.activitytofrag.ui.my;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamal.activitytofrag.R;

public class MyFragment extends Fragment {

    private MyViewModel mViewModel;
    private TextView textView;

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.my_fragment, container, false);
        textView=(TextView)view.findViewById(R.id.message);

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        ViewModelProviders.of(getActivity()).get(MyViewModel.class).getMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String message) {
                textView.setText(message);
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();

            }
        });
    }

}
