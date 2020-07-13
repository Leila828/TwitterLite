package com.example.twitter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Frag extends Fragment {
    View view;

    TextView textView;
private  String name;
public static final   String AGR_NAME="name";
    public TextView getTextView() {

        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    private MainActivity activity;
    public Frag() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Bundle bundle=   getArguments();
if (bundle !=null){
    name=bundle.getString(AGR_NAME);

}
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.frag,container,false);
         textView=(TextView) view.findViewById(R.id.textView2);
          textView.setText(name);
     return view;
    }

    public void setElements(String text)
    {
        textView.setText(text);

    }
}
