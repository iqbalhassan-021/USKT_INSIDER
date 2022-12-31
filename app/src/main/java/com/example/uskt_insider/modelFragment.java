package com.example.uskt_insider;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class modelFragment extends Fragment {
    View v;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        WebView modelview = (WebView) v.findViewById(R.id.loadModel);
        modelview.getSettings().setJavaScriptEnabled(true);
        modelview.loadUrl("file:///android_asset/model.html");
        v = inflater.inflate(R.layout.fragment_model, container, false);
        return v;
    }
}