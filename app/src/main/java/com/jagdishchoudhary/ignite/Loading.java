package com.jagdishchoudhary.ignite;

import android.app.Application;

import java.net.URL;
import java.util.List;

/**
 * Created by Jagdish on 09-03-2018.
 */

public class Loading extends Application{
    private List<User> userList;
    private User user;
    private URL url;
    private int childCount;;
    private String eventName;
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
