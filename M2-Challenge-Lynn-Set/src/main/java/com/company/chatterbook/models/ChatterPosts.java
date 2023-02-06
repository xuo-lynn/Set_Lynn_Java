package com.company.chatterbook.models;

public class ChatterPosts {

        private String post;

        public ChatterPosts(String post){
            this.setPost(post);
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

}
