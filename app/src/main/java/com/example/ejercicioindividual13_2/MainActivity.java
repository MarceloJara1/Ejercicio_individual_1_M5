package com.example.ejercicioindividual13_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicioindividual13_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private WebViewFragment webViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.filledButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = binding.textField.getEditText().getText().toString();
                openWebViewFragment(url);
                binding.textField.setVisibility(View.GONE);
                binding.filledButton.setVisibility(View.GONE);
                binding.filledButton2.setVisibility(View.VISIBLE);
                binding.fragmentContainer.setVisibility(View.VISIBLE);
            }
        });

        binding.filledButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeWebViewFragment();
                binding.textField.setVisibility(View.VISIBLE);
                binding.filledButton.setVisibility(View.VISIBLE);
                binding.filledButton2.setVisibility(View.GONE);
                binding.fragmentContainer.setVisibility(View.GONE);
            }
        });
    }

    private void openWebViewFragment(String url){
        Bundle bundle = new Bundle();
        bundle.putString("url", url);

        webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(binding.fragmentContainer.getId(), webViewFragment);
        transaction.commit();
    }

    private void closeWebViewFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(webViewFragment);
        transaction.commit();
    }
}