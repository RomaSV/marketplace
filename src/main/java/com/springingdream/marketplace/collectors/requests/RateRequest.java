package com.springingdream.marketplace.collectors.requests;

public class RateRequest {
    long pid;
    long uid;
    int rating;

    public RateRequest() {

    }

    public RateRequest(long pid, long uid, int rating) {
        this.pid = pid;
        this.uid = uid;
        this.rating = rating;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
