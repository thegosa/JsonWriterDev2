package com.thegosa.jsonwriterdev;

public class Pojo {

    String desc;
    String image;

    public Pojo(String desc, String image) {
        this.desc = desc;
        this.image = image;
    }

    public Pojo() {

    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
