package com.phanquangminhlong.MLBaemin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.phanquangminhlong.adapters.Adapter;
import com.phanquangminhlong.models.Restaurant;
import com.phanquangminhlong.MLBaemin.databinding.ActivityRestaurantBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    ActivityRestaurantBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_restaurant);
        binding = ActivityRestaurantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       loadData();
       addEvent();


    }

    private void addEvent() {
        binding.lvRestaurant.setOnItemClickListener((adapterView, view, i, l) -> {
            Restaurant restaurant = (Restaurant) adapterView.getItemAtPosition(i);
            Dialog dialog = new Dialog(RestaurantActivity.this);
            dialog.setContentView(R.layout.cus_dialog);
            ImageView img = dialog.findViewById(R.id.imv_dialogPhoto);
            img.setImageResource(restaurant.getPhoto());
            TextView txtName = dialog.findViewById(R.id.txt_dialogName);
            TextView txtAddress = dialog.findViewById(R.id.txt_dialogAddress);
            TextView txtRatingValue = dialog.findViewById(R.id.txt_dialogRatingValue);
            txtName.setText(restaurant.getPlaceName());
            txtAddress.setText(restaurant.getAddress());
            txtRatingValue.setText(String.valueOf(restaurant.getRatingValue()));
            dialog.show();

        });

    }

    private void loadData()  {
        ArrayList<Restaurant>list_restaurant = new ArrayList<>();
        Intent intent = getIntent();
        String item = intent.getStringExtra("item");
        int index = item.equals("LUNCH_BOX") ? 0 : 1;


        try {
            JSONArray arrRes = new JSONArray(getJsonData(RestaurantActivity.this,"data.json"));
            JSONObject ResType = arrRes.getJSONObject(index);
            JSONArray resList = ResType.getJSONArray(item);
            for(int i = 0; i<resList.length(); i++){
                JSONObject res = resList.getJSONObject(i);
                String placeName = res.getString("placeName");
                String dishName = res.getString("dishName");
                String photo = res.getString("photo");
                int photoId = getResources().getIdentifier(photo,"drawable",getPackageName());
                String address = res.getString("address");
                double ratingValue = res.getDouble("ratingValue");
                String ratingCount = res.getString("ratingCount");
                Restaurant restaurant = new Restaurant(placeName,dishName,photoId,ratingValue,ratingCount,address);
                list_restaurant.add(restaurant);
            }

//        if(index == 0){
//            list_restaurant.add(new Restaurant("Cơm Tấm Đại Đồng","Cơm Sườn",R.drawable.lunch_com_tam_dai_dong,4.1,"(100+)","38 Đường Số 17, P. Linh Trung, Q. Thủ Đức, Tp.HCM"));

            binding.txtRestaurantType.setText(index==0 ? "RICE" : "NOODLE");
            Adapter adapter = new Adapter(RestaurantActivity.this,R.layout.restaurant_item,list_restaurant);
            binding.lvRestaurant.setAdapter(adapter);

        }
     catch (JSONException e) {
            e.printStackTrace();
        }

    }


    static String getJsonData(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
}