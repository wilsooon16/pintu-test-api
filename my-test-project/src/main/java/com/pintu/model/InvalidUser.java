package com.pintu.model;


public class InvalidUser {

    private final Object id;
    private final Object title;
    private final Object body;
    private final Object userId;
    
    // Default constructor needed for Jackson deserialization
    public InvalidUser() {
        this.id = null;
        this.title = null;
        this.body = null;
        this.userId = null;
    }

    private InvalidUser(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.body = builder.body;
        this.userId = builder.userId;
    }

    public Object getId() {
        return id;
    }

    public Object getTitle() {
        return title;
    }

    public Object getBody() {
        return body;
    }

    public Object getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "InvalidUser{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                '}';
    }

    public static class Builder {
        private Object id;
        private Object title;
        private Object body;
        private Object userId;

        public Builder id(Object id) {
            this.id = id;
            return this;
        }

        public Builder title(Object title) {
            this.title = title;
            return this;
        }

        public Builder body(Object body) {
            this.body = body;
            return this;
        }

        public Builder userId(Object userId) {
            this.userId = userId;
            return this;
        }

        public InvalidUser build() {
            return new InvalidUser(this);
        }
    }
}
