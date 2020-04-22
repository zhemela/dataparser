package com.example.dataparser.dto;

public class PostDto extends AbstractDto{
    private String info;
    private Integer likes;

    public PostDto(String info, Integer likes) {
        this.info = info;
        this.likes = likes;
    }

    public String getInfo() {
        return info;
    }

    public PostDto setInfo(String info) {
        this.info = info;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public PostDto setLikes(Integer likes) {
        this.likes = likes;
        return this;
    }
}
