package com.dainy33.logstorage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dainy33 on 2019-04-27.
 */
public class InstanceState {
    @SerializedName("instance_id")
    private int instanceID;

    @SerializedName("value")
    private String value;

    public int getInstanceID() {
        return instanceID;
    }

    public void setInstanceID(int instanceID) {
        this.instanceID = instanceID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InstanceState{" +
                "instanceID=" + instanceID +
                ", value='" + value + '\'' +
                '}';
    }
}
