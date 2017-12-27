package com.example.admin.allofferstesapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/*
Created by Anjana
 */
//Custom View
public class OfferView extends LinearLayout {

    private int mHeight, mWidth;
    private TextView tvEverywhereDesc;
    private TextView tvEeverywhereFavIcon;
    private ImageView ivBrandIcon;
    private TextView tvBrandName;
    private ImageView ivImage;

    public OfferView(Context context, NewOffers offers, Typeface fontIcons, int height) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
        this.mHeight = height;
        this.mWidth = height * 4 / 3;

        //inflating layout to container
        LayoutInflater.from(context).inflate(R.layout.item_everywhere, this, true);
        tvEverywhereDesc = (TextView) findViewById(R.id.tvEverywhereDesc);
        tvEeverywhereFavIcon = (TextView) findViewById(R.id.tv_everywhere_fav_icon);
        ivBrandIcon = (ImageView) findViewById(R.id.iv_brand_icon);
        tvBrandName = (TextView) findViewById(R.id.tv_brand_name);
        ivImage = (ImageView) findViewById(R.id.ivImage);

        tvEeverywhereFavIcon.setTypeface(fontIcons);

        tvEverywhereDesc.setText(offers.getDescription());
        ivImage.setImageBitmap(offers.getImage());
        tvBrandName.setText(offers.getBrandName());
    }
}
