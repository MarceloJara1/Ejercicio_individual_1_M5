package com.example.ejercicioindividual13_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ejercicioindividual13_2.databinding.FragmentWebViewBinding;


public class WebViewFragment extends Fragment {

    private FragmentWebViewBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentWebViewBinding.inflate(inflater, container, false);

        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        String url = getArguments().getString("url");
        WebView webView = binding.webView;
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }
}