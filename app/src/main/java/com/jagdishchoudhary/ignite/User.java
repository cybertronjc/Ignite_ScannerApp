package com.jagdishchoudhary.ignite;

/**
 * Created by Jagdish on 09-03-2018.
 */

public class User {
    private String ref;
    private int id;
    private String name;


    public User(){}

    public User(String ref,String name, int id) {
        this.ref = ref;
        this.name = name;
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
