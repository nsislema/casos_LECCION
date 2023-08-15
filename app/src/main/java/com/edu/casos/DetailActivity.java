package com.edu.casos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.edu.casos.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String SUPERTEMA_KEY= "supertema";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding =
                ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras=getIntent().getExtras();
        SuperTema superTema=extras.getParcelable(SUPERTEMA_KEY);

        binding.heroName.setText(superTema.getName());
        binding.alterEgoText.setText(superTema.getAlertEgo());
        binding.bioText.setText(superTema.getBio());
        binding.ratingBar.setRating(superTema.getPower());
    }
}