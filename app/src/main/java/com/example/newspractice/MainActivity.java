package com.example.newspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList  = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);

        creatTable();

        MyAdapter myAdapter = new MyAdapter();
        listview.setAdapter(myAdapter);
    }

    //=================================


    //===================

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View openview = inflater.inflate(R.layout.design,parent,false);


            ImageView itemCover = openview.findViewById(R.id.itemCover);
            TextView tvCat = openview.findViewById(R.id.tvCat);
            TextView itemTitle= openview.findViewById(R.id.itemTitle);
            TextView itemDes = openview.findViewById(R.id.itemDes);
            LinearLayout layItem = openview.findViewById(R.id.layItem);


            HashMap<String,String> hashMap = arrayList.get(position);
            String cat = hashMap.get("cat");
            String image_url = hashMap.get("image_url");
            String title = hashMap.get("title");
            String des = hashMap.get("des");


            Picasso.get().load(image_url)
                    .placeholder(R.drawable.book)
                    .into(itemCover);


            tvCat.setText(cat);
            itemTitle.setText(title);
            itemDes.setText(des);


            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            tvCat.setBackgroundColor(color);




            layItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News.TITLE = title;
                    News.DES = des;

                    Bitmap bitmap = ((BitmapDrawable) itemCover.getDrawable()).getBitmap();
                    News.MYBITMAP = bitmap;

                    startActivity(new Intent(MainActivity.this,News.class));

                }
            });




            return openview;













        }
    }



    //=================================


    //===================


    //=================================


    //===================



    //=================================




    private  void creatTable (){
        hashMap = new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/11/%E0%A6%87%E0%A6%A8%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BE%E0%A6%97%E0%A7%8D%E0%A6%B0%E0%A6%BE%E0%A6%AE%E0%A7%87%E0%A6%B0-%E0%A6%9B%E0%A6%AC%E0%A6%BF-%E0%A6%A5%E0%A7%87%E0%A6%95%E0%A7%87-%E0%A6%AE%E0%A7%81%E0%A6%B9%E0%A7%82%E0%A6%B0%E0%A7%8D%E0%A6%A4%E0%A7%87%E0%A6%87-%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BF%E0%A6%95%E0%A6%BE%E0%A6%B0-%E0%A6%AC%E0%A6%BE%E0%A6%A8%E0%A6%BF%E0%A7%9F%E0%A7%87-%E0%A6%A6%E0%A7%87%E0%A6%AC%E0%A7%87-%E0%A6%8F%E0%A6%86%E0%A6%87.jpg");
        hashMap.put("title","ইনস্টাগ্রামের ছবি থেকে মুহূর্তেই স্টিকার বানিয়ে দেবে এআই");
        hashMap.put("des","\n" +
                "মেটার মালিকানাধীন সোশ্যাল মিডিয়া প্ল্যাটফর্ম ইনস্টাগ্রাম। কোটি কোটি ব্যবহারকারী আছে প্ল্যাটফর্মটির। প্রতিনিয়ত আপডেট হচ্ছে ব্যবহারকারীদের অভিজ্ঞতা ভালো করতে। এবার নতুন এক ফিচার যুক্ত হয়েছে। যেখানে আপনার পোস্ট করা ছবি ভিডিও থেকে মুহূর্তেই স্টিকার বানিয়ে নিতে পারবেন।\n" +
                "ইনস্টাগ্রামের আইওএস এবং অ্যান্ড্রয়েড ভার্সনে প্রায়ই নতুন ফিচার যুক্ত হচ্ছে। জানা গিয়েছে খুব শিগগির এই প্লাটফর্মে পাওয়া যাবে কৃত্রিম মেধা-চালিত টুলসহ একগুচ্ছ নতুন ফিচার। এই ফিচারগুলো ব্যবহারকারীদের ছবি এবং ভিডিও থেকে স্টিকার তৈরি করার সুযোগ করে দেবে। এবিষয়ে পরীক্ষা নিরীক্ষা চালাচ্ছে সংস্থাটি।\n" +
                "স্টিকার সার্চ এন্ট্রি বক্সে ক্রিয়েট বোতামে ক্লিক করলে পাওয়া যাবে এই নতুন ‘কাস্টম স্টিকার জেনারেটর’ ফিচারটি। তৈরি হওয়া স্টিকার পোল, কুইজ বা অন্যত্র ব্যবহার করা যাবে।\n" +
                "\n" +
                "\n" +
                "মেটার নিজস্ব ‘সেগমেন্ট এনিথিং এআই’ মডেল ব্যবহার করে তৈরি করা হচ্ছে এই কাস্টম এআই স্টিকার জেনারেটর। এতে ব্যবহারকারীরা ক্যামেরা রোল বা প্ল্যাটফর্মে থাকা যে কোনো ছবি বা ভিডিও ব্যবহার করে স্টিকার তৈরি করতে পারবেন।\n" +
                "আইমেসেজে যেভাবে স্টিকার তৈরি হয়, প্রায় একই রকম ভাবে এক ক্লিকেই এই কাজ সারতে পারবেন ব্যবহারকারী। সেক্ষেত্রে একটি ছবি থেকে যে কোনো বস্তুকে আলাদা করে ফেলা যাবে সহজে। মনের মতো না হলে আবার ম্যানুয়ালি বিষয় নির্বাচনও করে নেওয়া যাবে।\n" +
                "স্টিকার তৈরি হয়ে গেলে, সেটি ব্যবহারকারী তার যে কোনো রিল বা স্টোরিতে ব্যবহার করতে পারবেন। সেক্ষেত্রে ‘ইউজ স্টিকার’ বোতামে ট্যাপ করতে হবে।\n");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("cat","SPORTS");
        hashMap.put("image_url","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/11/20/2023-11-19t170223z_963868620_up1ejbj1bbxvz_rtrmadp_3_cricket-worldcup-ind-aus.jpg");
        hashMap.put("title","Ponting hails 'almost faultless' captaincy of Cummins");
        hashMap.put("des","He specifically lauded Cummins' courage to bowl first after winning the toss, a bold choice that proved to be the right one.\n" +
                "\"I mean, any captain deciding to bowl first at the toss, that's a gutsy, courageous move. Australia felt that if they could bowl well on that dry wicket early on and restrict India, batting was going to get easier in the second innings – but we all know if you get that call wrong and you lose the game, that's a huge decision to make for a relatively young captain,\" said Ponting.\n" +
                "\"I thought his leadership actually has got better and better right through the tournament. His bowling has got better, and the way he used his bowlers today and some of his field placements to (Virat) Kohli and KL Rahul, outstanding, so once again, an Australian team just finds a way to get it done in the final,\" he added.\n" +
                "Despite retaining the Ashes earlier this year and winning the ICC Test Championship, many Aussie cricket fans were sceptical of Cummins' credentials as a captain in the 50-over format leading up to the World Cup.\n" +
                "Ponting feels that the criticisms Cummins faced as a leader were mostly baseless and the triumph over India showed why the right-arm pacer is the ideal man to lead the Aussies.\n" +
                "\"I don't know where the negativity's come from because there's been no real basis for it. You look at their overall Test record since he's been captain is outstanding. And now he's a World Cup-winning captain, a World Test Championship-winning captain and a captain who retained the Ashes, so that negativity needs to be put aside now.\"\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/11/%E0%A6%87%E0%A6%A8%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BE%E0%A6%97%E0%A7%8D%E0%A6%B0%E0%A6%BE%E0%A6%AE%E0%A7%87%E0%A6%B0-%E0%A6%9B%E0%A6%AC%E0%A6%BF-%E0%A6%A5%E0%A7%87%E0%A6%95%E0%A7%87-%E0%A6%AE%E0%A7%81%E0%A6%B9%E0%A7%82%E0%A6%B0%E0%A7%8D%E0%A6%A4%E0%A7%87%E0%A6%87-%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BF%E0%A6%95%E0%A6%BE%E0%A6%B0-%E0%A6%AC%E0%A6%BE%E0%A6%A8%E0%A6%BF%E0%A7%9F%E0%A7%87-%E0%A6%A6%E0%A7%87%E0%A6%AC%E0%A7%87-%E0%A6%8F%E0%A6%86%E0%A6%87.jpg");
        hashMap.put("title","ইনস্টাগ্রামের ছবি থেকে মুহূর্তেই স্টিকার বানিয়ে দেবে এআই");
        hashMap.put("des","\n" +
                "মেটার মালিকানাধীন সোশ্যাল মিডিয়া প্ল্যাটফর্ম ইনস্টাগ্রাম। কোটি কোটি ব্যবহারকারী আছে প্ল্যাটফর্মটির। প্রতিনিয়ত আপডেট হচ্ছে ব্যবহারকারীদের অভিজ্ঞতা ভালো করতে। এবার নতুন এক ফিচার যুক্ত হয়েছে। যেখানে আপনার পোস্ট করা ছবি ভিডিও থেকে মুহূর্তেই স্টিকার বানিয়ে নিতে পারবেন।\n" +
                "ইনস্টাগ্রামের আইওএস এবং অ্যান্ড্রয়েড ভার্সনে প্রায়ই নতুন ফিচার যুক্ত হচ্ছে। জানা গিয়েছে খুব শিগগির এই প্লাটফর্মে পাওয়া যাবে কৃত্রিম মেধা-চালিত টুলসহ একগুচ্ছ নতুন ফিচার। এই ফিচারগুলো ব্যবহারকারীদের ছবি এবং ভিডিও থেকে স্টিকার তৈরি করার সুযোগ করে দেবে। এবিষয়ে পরীক্ষা নিরীক্ষা চালাচ্ছে সংস্থাটি।\n" +
                "স্টিকার সার্চ এন্ট্রি বক্সে ক্রিয়েট বোতামে ক্লিক করলে পাওয়া যাবে এই নতুন ‘কাস্টম স্টিকার জেনারেটর’ ফিচারটি। তৈরি হওয়া স্টিকার পোল, কুইজ বা অন্যত্র ব্যবহার করা যাবে।\n" +
                "\n" +
                "\n" +
                "মেটার নিজস্ব ‘সেগমেন্ট এনিথিং এআই’ মডেল ব্যবহার করে তৈরি করা হচ্ছে এই কাস্টম এআই স্টিকার জেনারেটর। এতে ব্যবহারকারীরা ক্যামেরা রোল বা প্ল্যাটফর্মে থাকা যে কোনো ছবি বা ভিডিও ব্যবহার করে স্টিকার তৈরি করতে পারবেন।\n" +
                "আইমেসেজে যেভাবে স্টিকার তৈরি হয়, প্রায় একই রকম ভাবে এক ক্লিকেই এই কাজ সারতে পারবেন ব্যবহারকারী। সেক্ষেত্রে একটি ছবি থেকে যে কোনো বস্তুকে আলাদা করে ফেলা যাবে সহজে। মনের মতো না হলে আবার ম্যানুয়ালি বিষয় নির্বাচনও করে নেওয়া যাবে।\n" +
                "স্টিকার তৈরি হয়ে গেলে, সেটি ব্যবহারকারী তার যে কোনো রিল বা স্টোরিতে ব্যবহার করতে পারবেন। সেক্ষেত্রে ‘ইউজ স্টিকার’ বোতামে ট্যাপ করতে হবে।\n");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("cat","SPORTS");
        hashMap.put("image_url","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/11/20/2023-11-19t170223z_963868620_up1ejbj1bbxvz_rtrmadp_3_cricket-worldcup-ind-aus.jpg");
        hashMap.put("title","Ponting hails 'almost faultless' captaincy of Cummins");
        hashMap.put("des","He specifically lauded Cummins' courage to bowl first after winning the toss, a bold choice that proved to be the right one.\n" +
                "\"I mean, any captain deciding to bowl first at the toss, that's a gutsy, courageous move. Australia felt that if they could bowl well on that dry wicket early on and restrict India, batting was going to get easier in the second innings – but we all know if you get that call wrong and you lose the game, that's a huge decision to make for a relatively young captain,\" said Ponting.\n" +
                "\"I thought his leadership actually has got better and better right through the tournament. His bowling has got better, and the way he used his bowlers today and some of his field placements to (Virat) Kohli and KL Rahul, outstanding, so once again, an Australian team just finds a way to get it done in the final,\" he added.\n" +
                "Despite retaining the Ashes earlier this year and winning the ICC Test Championship, many Aussie cricket fans were sceptical of Cummins' credentials as a captain in the 50-over format leading up to the World Cup.\n" +
                "Ponting feels that the criticisms Cummins faced as a leader were mostly baseless and the triumph over India showed why the right-arm pacer is the ideal man to lead the Aussies.\n" +
                "\"I don't know where the negativity's come from because there's been no real basis for it. You look at their overall Test record since he's been captain is outstanding. And now he's a World Cup-winning captain, a World Test Championship-winning captain and a captain who retained the Ashes, so that negativity needs to be put aside now.\"\n");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/11/%E0%A6%87%E0%A6%A8%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BE%E0%A6%97%E0%A7%8D%E0%A6%B0%E0%A6%BE%E0%A6%AE%E0%A7%87%E0%A6%B0-%E0%A6%9B%E0%A6%AC%E0%A6%BF-%E0%A6%A5%E0%A7%87%E0%A6%95%E0%A7%87-%E0%A6%AE%E0%A7%81%E0%A6%B9%E0%A7%82%E0%A6%B0%E0%A7%8D%E0%A6%A4%E0%A7%87%E0%A6%87-%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BF%E0%A6%95%E0%A6%BE%E0%A6%B0-%E0%A6%AC%E0%A6%BE%E0%A6%A8%E0%A6%BF%E0%A7%9F%E0%A7%87-%E0%A6%A6%E0%A7%87%E0%A6%AC%E0%A7%87-%E0%A6%8F%E0%A6%86%E0%A6%87.jpg");
        hashMap.put("title","ইনস্টাগ্রামের ছবি থেকে মুহূর্তেই স্টিকার বানিয়ে দেবে এআই");
        hashMap.put("des","\n" +
                "মেটার মালিকানাধীন সোশ্যাল মিডিয়া প্ল্যাটফর্ম ইনস্টাগ্রাম। কোটি কোটি ব্যবহারকারী আছে প্ল্যাটফর্মটির। প্রতিনিয়ত আপডেট হচ্ছে ব্যবহারকারীদের অভিজ্ঞতা ভালো করতে। এবার নতুন এক ফিচার যুক্ত হয়েছে। যেখানে আপনার পোস্ট করা ছবি ভিডিও থেকে মুহূর্তেই স্টিকার বানিয়ে নিতে পারবেন।\n" +
                "ইনস্টাগ্রামের আইওএস এবং অ্যান্ড্রয়েড ভার্সনে প্রায়ই নতুন ফিচার যুক্ত হচ্ছে। জানা গিয়েছে খুব শিগগির এই প্লাটফর্মে পাওয়া যাবে কৃত্রিম মেধা-চালিত টুলসহ একগুচ্ছ নতুন ফিচার। এই ফিচারগুলো ব্যবহারকারীদের ছবি এবং ভিডিও থেকে স্টিকার তৈরি করার সুযোগ করে দেবে। এবিষয়ে পরীক্ষা নিরীক্ষা চালাচ্ছে সংস্থাটি।\n" +
                "স্টিকার সার্চ এন্ট্রি বক্সে ক্রিয়েট বোতামে ক্লিক করলে পাওয়া যাবে এই নতুন ‘কাস্টম স্টিকার জেনারেটর’ ফিচারটি। তৈরি হওয়া স্টিকার পোল, কুইজ বা অন্যত্র ব্যবহার করা যাবে।\n" +
                "\n" +
                "\n" +
                "মেটার নিজস্ব ‘সেগমেন্ট এনিথিং এআই’ মডেল ব্যবহার করে তৈরি করা হচ্ছে এই কাস্টম এআই স্টিকার জেনারেটর। এতে ব্যবহারকারীরা ক্যামেরা রোল বা প্ল্যাটফর্মে থাকা যে কোনো ছবি বা ভিডিও ব্যবহার করে স্টিকার তৈরি করতে পারবেন।\n" +
                "আইমেসেজে যেভাবে স্টিকার তৈরি হয়, প্রায় একই রকম ভাবে এক ক্লিকেই এই কাজ সারতে পারবেন ব্যবহারকারী। সেক্ষেত্রে একটি ছবি থেকে যে কোনো বস্তুকে আলাদা করে ফেলা যাবে সহজে। মনের মতো না হলে আবার ম্যানুয়ালি বিষয় নির্বাচনও করে নেওয়া যাবে।\n" +
                "স্টিকার তৈরি হয়ে গেলে, সেটি ব্যবহারকারী তার যে কোনো রিল বা স্টোরিতে ব্যবহার করতে পারবেন। সেক্ষেত্রে ‘ইউজ স্টিকার’ বোতামে ট্যাপ করতে হবে।\n");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("cat","SPORTS");
        hashMap.put("image_url","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/11/20/2023-11-19t170223z_963868620_up1ejbj1bbxvz_rtrmadp_3_cricket-worldcup-ind-aus.jpg");
        hashMap.put("title","Ponting hails 'almost faultless' captaincy of Cummins");
        hashMap.put("des","He specifically lauded Cummins' courage to bowl first after winning the toss, a bold choice that proved to be the right one.\n" +
                "\"I mean, any captain deciding to bowl first at the toss, that's a gutsy, courageous move. Australia felt that if they could bowl well on that dry wicket early on and restrict India, batting was going to get easier in the second innings – but we all know if you get that call wrong and you lose the game, that's a huge decision to make for a relatively young captain,\" said Ponting.\n" +
                "\"I thought his leadership actually has got better and better right through the tournament. His bowling has got better, and the way he used his bowlers today and some of his field placements to (Virat) Kohli and KL Rahul, outstanding, so once again, an Australian team just finds a way to get it done in the final,\" he added.\n" +
                "Despite retaining the Ashes earlier this year and winning the ICC Test Championship, many Aussie cricket fans were sceptical of Cummins' credentials as a captain in the 50-over format leading up to the World Cup.\n" +
                "Ponting feels that the criticisms Cummins faced as a leader were mostly baseless and the triumph over India showed why the right-arm pacer is the ideal man to lead the Aussies.\n" +
                "\"I don't know where the negativity's come from because there's been no real basis for it. You look at their overall Test record since he's been captain is outstanding. And now he's a World Cup-winning captain, a World Test Championship-winning captain and a captain who retained the Ashes, so that negativity needs to be put aside now.\"\n");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/11/%E0%A6%87%E0%A6%A8%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BE%E0%A6%97%E0%A7%8D%E0%A6%B0%E0%A6%BE%E0%A6%AE%E0%A7%87%E0%A6%B0-%E0%A6%9B%E0%A6%AC%E0%A6%BF-%E0%A6%A5%E0%A7%87%E0%A6%95%E0%A7%87-%E0%A6%AE%E0%A7%81%E0%A6%B9%E0%A7%82%E0%A6%B0%E0%A7%8D%E0%A6%A4%E0%A7%87%E0%A6%87-%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BF%E0%A6%95%E0%A6%BE%E0%A6%B0-%E0%A6%AC%E0%A6%BE%E0%A6%A8%E0%A6%BF%E0%A7%9F%E0%A7%87-%E0%A6%A6%E0%A7%87%E0%A6%AC%E0%A7%87-%E0%A6%8F%E0%A6%86%E0%A6%87.jpg");
        hashMap.put("title","ইনস্টাগ্রামের ছবি থেকে মুহূর্তেই স্টিকার বানিয়ে দেবে এআই");
        hashMap.put("des","\n" +
                "মেটার মালিকানাধীন সোশ্যাল মিডিয়া প্ল্যাটফর্ম ইনস্টাগ্রাম। কোটি কোটি ব্যবহারকারী আছে প্ল্যাটফর্মটির। প্রতিনিয়ত আপডেট হচ্ছে ব্যবহারকারীদের অভিজ্ঞতা ভালো করতে। এবার নতুন এক ফিচার যুক্ত হয়েছে। যেখানে আপনার পোস্ট করা ছবি ভিডিও থেকে মুহূর্তেই স্টিকার বানিয়ে নিতে পারবেন।\n" +
                "ইনস্টাগ্রামের আইওএস এবং অ্যান্ড্রয়েড ভার্সনে প্রায়ই নতুন ফিচার যুক্ত হচ্ছে। জানা গিয়েছে খুব শিগগির এই প্লাটফর্মে পাওয়া যাবে কৃত্রিম মেধা-চালিত টুলসহ একগুচ্ছ নতুন ফিচার। এই ফিচারগুলো ব্যবহারকারীদের ছবি এবং ভিডিও থেকে স্টিকার তৈরি করার সুযোগ করে দেবে। এবিষয়ে পরীক্ষা নিরীক্ষা চালাচ্ছে সংস্থাটি।\n" +
                "স্টিকার সার্চ এন্ট্রি বক্সে ক্রিয়েট বোতামে ক্লিক করলে পাওয়া যাবে এই নতুন ‘কাস্টম স্টিকার জেনারেটর’ ফিচারটি। তৈরি হওয়া স্টিকার পোল, কুইজ বা অন্যত্র ব্যবহার করা যাবে।\n" +
                "\n" +
                "\n" +
                "মেটার নিজস্ব ‘সেগমেন্ট এনিথিং এআই’ মডেল ব্যবহার করে তৈরি করা হচ্ছে এই কাস্টম এআই স্টিকার জেনারেটর। এতে ব্যবহারকারীরা ক্যামেরা রোল বা প্ল্যাটফর্মে থাকা যে কোনো ছবি বা ভিডিও ব্যবহার করে স্টিকার তৈরি করতে পারবেন।\n" +
                "আইমেসেজে যেভাবে স্টিকার তৈরি হয়, প্রায় একই রকম ভাবে এক ক্লিকেই এই কাজ সারতে পারবেন ব্যবহারকারী। সেক্ষেত্রে একটি ছবি থেকে যে কোনো বস্তুকে আলাদা করে ফেলা যাবে সহজে। মনের মতো না হলে আবার ম্যানুয়ালি বিষয় নির্বাচনও করে নেওয়া যাবে।\n" +
                "স্টিকার তৈরি হয়ে গেলে, সেটি ব্যবহারকারী তার যে কোনো রিল বা স্টোরিতে ব্যবহার করতে পারবেন। সেক্ষেত্রে ‘ইউজ স্টিকার’ বোতামে ট্যাপ করতে হবে।\n");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("cat","SPORTS");
        hashMap.put("image_url","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/11/20/2023-11-19t170223z_963868620_up1ejbj1bbxvz_rtrmadp_3_cricket-worldcup-ind-aus.jpg");
        hashMap.put("title","Ponting hails 'almost faultless' captaincy of Cummins");
        hashMap.put("des","He specifically lauded Cummins' courage to bowl first after winning the toss, a bold choice that proved to be the right one.\n" +
                "\"I mean, any captain deciding to bowl first at the toss, that's a gutsy, courageous move. Australia felt that if they could bowl well on that dry wicket early on and restrict India, batting was going to get easier in the second innings – but we all know if you get that call wrong and you lose the game, that's a huge decision to make for a relatively young captain,\" said Ponting.\n" +
                "\"I thought his leadership actually has got better and better right through the tournament. His bowling has got better, and the way he used his bowlers today and some of his field placements to (Virat) Kohli and KL Rahul, outstanding, so once again, an Australian team just finds a way to get it done in the final,\" he added.\n" +
                "Despite retaining the Ashes earlier this year and winning the ICC Test Championship, many Aussie cricket fans were sceptical of Cummins' credentials as a captain in the 50-over format leading up to the World Cup.\n" +
                "Ponting feels that the criticisms Cummins faced as a leader were mostly baseless and the triumph over India showed why the right-arm pacer is the ideal man to lead the Aussies.\n" +
                "\"I don't know where the negativity's come from because there's been no real basis for it. You look at their overall Test record since he's been captain is outstanding. And now he's a World Cup-winning captain, a World Test Championship-winning captain and a captain who retained the Ashes, so that negativity needs to be put aside now.\"\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","TECH");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/11/%E0%A6%87%E0%A6%A8%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BE%E0%A6%97%E0%A7%8D%E0%A6%B0%E0%A6%BE%E0%A6%AE%E0%A7%87%E0%A6%B0-%E0%A6%9B%E0%A6%AC%E0%A6%BF-%E0%A6%A5%E0%A7%87%E0%A6%95%E0%A7%87-%E0%A6%AE%E0%A7%81%E0%A6%B9%E0%A7%82%E0%A6%B0%E0%A7%8D%E0%A6%A4%E0%A7%87%E0%A6%87-%E0%A6%B8%E0%A7%8D%E0%A6%9F%E0%A6%BF%E0%A6%95%E0%A6%BE%E0%A6%B0-%E0%A6%AC%E0%A6%BE%E0%A6%A8%E0%A6%BF%E0%A7%9F%E0%A7%87-%E0%A6%A6%E0%A7%87%E0%A6%AC%E0%A7%87-%E0%A6%8F%E0%A6%86%E0%A6%87.jpg");
        hashMap.put("title","ইনস্টাগ্রামের ছবি থেকে মুহূর্তেই স্টিকার বানিয়ে দেবে এআই");
        hashMap.put("des","\n" +
                "মেটার মালিকানাধীন সোশ্যাল মিডিয়া প্ল্যাটফর্ম ইনস্টাগ্রাম। কোটি কোটি ব্যবহারকারী আছে প্ল্যাটফর্মটির। প্রতিনিয়ত আপডেট হচ্ছে ব্যবহারকারীদের অভিজ্ঞতা ভালো করতে। এবার নতুন এক ফিচার যুক্ত হয়েছে। যেখানে আপনার পোস্ট করা ছবি ভিডিও থেকে মুহূর্তেই স্টিকার বানিয়ে নিতে পারবেন।\n" +
                "ইনস্টাগ্রামের আইওএস এবং অ্যান্ড্রয়েড ভার্সনে প্রায়ই নতুন ফিচার যুক্ত হচ্ছে। জানা গিয়েছে খুব শিগগির এই প্লাটফর্মে পাওয়া যাবে কৃত্রিম মেধা-চালিত টুলসহ একগুচ্ছ নতুন ফিচার। এই ফিচারগুলো ব্যবহারকারীদের ছবি এবং ভিডিও থেকে স্টিকার তৈরি করার সুযোগ করে দেবে। এবিষয়ে পরীক্ষা নিরীক্ষা চালাচ্ছে সংস্থাটি।\n" +
                "স্টিকার সার্চ এন্ট্রি বক্সে ক্রিয়েট বোতামে ক্লিক করলে পাওয়া যাবে এই নতুন ‘কাস্টম স্টিকার জেনারেটর’ ফিচারটি। তৈরি হওয়া স্টিকার পোল, কুইজ বা অন্যত্র ব্যবহার করা যাবে।\n" +
                "\n" +
                "\n" +
                "মেটার নিজস্ব ‘সেগমেন্ট এনিথিং এআই’ মডেল ব্যবহার করে তৈরি করা হচ্ছে এই কাস্টম এআই স্টিকার জেনারেটর। এতে ব্যবহারকারীরা ক্যামেরা রোল বা প্ল্যাটফর্মে থাকা যে কোনো ছবি বা ভিডিও ব্যবহার করে স্টিকার তৈরি করতে পারবেন।\n" +
                "আইমেসেজে যেভাবে স্টিকার তৈরি হয়, প্রায় একই রকম ভাবে এক ক্লিকেই এই কাজ সারতে পারবেন ব্যবহারকারী। সেক্ষেত্রে একটি ছবি থেকে যে কোনো বস্তুকে আলাদা করে ফেলা যাবে সহজে। মনের মতো না হলে আবার ম্যানুয়ালি বিষয় নির্বাচনও করে নেওয়া যাবে।\n" +
                "স্টিকার তৈরি হয়ে গেলে, সেটি ব্যবহারকারী তার যে কোনো রিল বা স্টোরিতে ব্যবহার করতে পারবেন। সেক্ষেত্রে ‘ইউজ স্টিকার’ বোতামে ট্যাপ করতে হবে।\n");
        arrayList.add(hashMap);
        hashMap = new HashMap<>();
        hashMap.put("cat","SPORTS");
        hashMap.put("image_url","https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2023/11/20/2023-11-19t170223z_963868620_up1ejbj1bbxvz_rtrmadp_3_cricket-worldcup-ind-aus.jpg");
        hashMap.put("title","Ponting hails 'almost faultless' captaincy of Cummins");
        hashMap.put("des","He specifically lauded Cummins' courage to bowl first after winning the toss, a bold choice that proved to be the right one.\n" +
                "\"I mean, any captain deciding to bowl first at the toss, that's a gutsy, courageous move. Australia felt that if they could bowl well on that dry wicket early on and restrict India, batting was going to get easier in the second innings – but we all know if you get that call wrong and you lose the game, that's a huge decision to make for a relatively young captain,\" said Ponting.\n" +
                "\"I thought his leadership actually has got better and better right through the tournament. His bowling has got better, and the way he used his bowlers today and some of his field placements to (Virat) Kohli and KL Rahul, outstanding, so once again, an Australian team just finds a way to get it done in the final,\" he added.\n" +
                "Despite retaining the Ashes earlier this year and winning the ICC Test Championship, many Aussie cricket fans were sceptical of Cummins' credentials as a captain in the 50-over format leading up to the World Cup.\n" +
                "Ponting feels that the criticisms Cummins faced as a leader were mostly baseless and the triumph over India showed why the right-arm pacer is the ideal man to lead the Aussies.\n" +
                "\"I don't know where the negativity's come from because there's been no real basis for it. You look at their overall Test record since he's been captain is outstanding. And now he's a World Cup-winning captain, a World Test Championship-winning captain and a captain who retained the Ashes, so that negativity needs to be put aside now.\"\n");
        arrayList.add(hashMap);






    }




}