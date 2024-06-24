package com.example.applications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ArticleActivity extends AppCompatActivity {

    private Button fireHotlineButton;
    private Button medicalHotlineButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        fireHotlineButton = findViewById(R.id.fire_hotline_button);
        medicalHotlineButton = findViewById(R.id.medical_hotline_button);
        backButton = findViewById(R.id.back_button);

        fireHotlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://cebudailynews.inquirer.net/499085/the-dangers-of-fire-common-causes-and-tips-on-how-to-prevent-it?fbclid=IwZXh0bgNhZW0CMTAAAR2u17FmI_dfwhnv4EBd-deLKT6QidjvdhvwnxwDwq1h53J7B_0KgpDp9mo_aem_AaT0EkDIhPrFEeGUSf5B6D1V6v6L_C3MOSeMqEJOO7L2AM631CbCiCLAb78UWnbMvqsOvWZy_9rGlLLWmdOjVXun");
            }
        });

        medicalHotlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://oakbendmedcenter.org/2023/10/11/how-to-prepare-for-a-medical-emergency-essential-tips-and-resources/?fbclid=IwZXh0bgNhZW0CMTAAAR03bUTHNyFLrkH-gqr_0-gvrwwdob398Nkjz9F3PJjSZ2CLnRJA_cU3aro_aem_AaRc59LEr9RBGmdRRX1RCHP3PceIc5R4l9rFbAIx9sNqmOnz_RnoaQNdT3l5STgNXdWyENMwJElBJ3BOJ9MdBZfK");
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainActivity();
            }
        });
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(ArticleActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
