package com.hld.retrofit2.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hilda on 25/11/2016.
 */

public class LoginRequestModel {
    @SerializedName("username") public String username;
    @SerializedName("password") public String password;
    @SerializedName("pusbotsToken") public String pushbots_token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPushbots_token() {
        return pushbots_token;
    }

    public void setPushbots_token(String pushbots_token) {
        this.pushbots_token = pushbots_token;
    }
}
