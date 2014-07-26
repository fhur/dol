package com.robot;

/**
 * Created by fernandinho on 7/20/14.
 */
public interface StorageAdapter<T extends BaseModel> {

    public boolean save();

}
