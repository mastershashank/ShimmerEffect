package com.shimmer.shimmereffect;

public class ShimmerModel {

    private String title;
    private String description;

    //Constructor

    public ShimmerModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    //Setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Getter


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
