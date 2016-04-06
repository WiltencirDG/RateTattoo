package com.example.android.ratetattoo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity{

    private ImageView ivImage;
    private TextView tvName;
    private TextView tvAddress;
    private TextView tvPhone;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        int id = getIntent().getIntExtra("id",R.id.cv_shop_1);
        setUI();
        setCV(id);
    }

    private void setUI(){
        ivImage = (ImageView) findViewById(R.id.iv_shop);
        tvName = (TextView) findViewById(R.id.tv_n_shop);
        tvAddress = (TextView) findViewById(R.id.tv_a_shop);
        tvPhone = (TextView) findViewById(R.id.tv_p_shop);

    }

    private void setCV(int id){

        int image = 0;
        String name = "";
        String address = "";
        String phone = "";

        switch (id){
            case R.id.cv_shop_1:
                image = R.drawable.img_shop_1;
                name = getString(R.string.n_shop_1);
                address = getString(R.string.e_shop_1);
                phone = getString(R.string.p_shop_1);
                break;
        }

        ivImage.setImageResource(image);
        tvName.setText(name);
        tvAddress.setText(address);
        tvPhone.setText(phone);

    }
}
