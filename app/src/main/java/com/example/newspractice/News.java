package com.example.newspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class News extends AppCompatActivity {
    FloatingActionButton fabbutton;
    TextToSpeech textToSpeech;
    TextView tvtitle,tvdes;

    ImageView coverImage;
    public static  String TITLE = "";
    public static  String DES = "";
    public static Bitmap MYBITMAP = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        coverImage = findViewById(R.id.coverImage);
        tvtitle = findViewById(R.id.tvtitle);
        tvdes = findViewById(R.id.tvdes);
        fabbutton = findViewById(R.id.fabbutton);


        tvtitle.setText(TITLE);
        tvdes.setText(DES);
        if (MYBITMAP!=null)coverImage.setImageBitmap(MYBITMAP);

        textToSpeech =new TextToSpeech(News.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });


        fabbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvdes.getText().toString();
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });
    }
}