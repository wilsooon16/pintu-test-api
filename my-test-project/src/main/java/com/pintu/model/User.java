package com.pintu.model;

public class User {
    private Integer id;
    private String title;
    private String body;
    private Integer userId;
    
    // Default constructor needed for Jackson deserialization
    public User() {
    }

    protected User(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.body = builder.body;
        this.userId = builder.userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Integer getUserId() {
        return userId;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                '}';
    }

    public static class Builder {
        private Integer id;
        private String title;
        private String body;
        private Integer userId;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
