package com.mercari.mercaritest.data.model;

/**
 * Created by ssavdekar on 4/29/18.
 */

public class SellItems {
    private String id, name, status, photo;
    private int num_likes, num_comments, price;

    public SellItems() {
    }

    public SellItems(String id, String name, String status, String photo, int likes, int comments, int price) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.photo = photo;
        this.num_likes = likes;
        this.num_comments = comments;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNumLikes() {
        return num_likes;
    }

    public void setNumLikes(int likes) {
        this.num_likes = likes;
    }

    public int getNumComments() {
        return num_comments;
    }

    public void setNumComments(int comments) {
        this.num_comments = comments;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
