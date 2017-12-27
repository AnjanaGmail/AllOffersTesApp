package com.example.admin.allofferstesapp;

import android.graphics.Bitmap;

import java.io.Serializable;

/*
Created by Anjana
 */
//Pojo class to parse offers response
public class NewOffers implements Serializable {
    private String name;
    private Bitmap image;
    private String description;
    private String brandName;
    private Bitmap brandIcon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Bitmap getBrandIcon() {
        return brandIcon;
    }

    public void setBrandIcon(Bitmap brandIcon) {
        this.brandIcon = brandIcon;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewOffers{");
        sb.append("name='").append(name).append('\'');
        sb.append(", image=").append(image);
        sb.append(", description='").append(description).append('\'');
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", brandIcon=").append(brandIcon);
        sb.append('}');
        return sb.toString();
    }
}
