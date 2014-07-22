package com.robot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fernandinho on 7/20/14.
 */
public abstract class Model implements BaseModel {

    protected UploadState uploadState;
    protected Date creationDate;

    public Model(){
        creationDate = new Date();
        uploadState = UploadState.neverUploaded;
    }

    @Override
    public UploadState getUploadState() {
        return uploadState;
    }

    @Override
    public boolean isUploaded() {
        return uploadState == UploadState.uploaded;
    }

    @Override
    public boolean isUploading() {
        return uploadState == UploadState.uploading;
    }

    @Override
    public boolean needsUploading() {
        return uploadState == UploadState.needsUploading;
    }

    @Override
    public void setUploadState(UploadState uploadState) {
        this.uploadState = uploadState;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public List<Integer> getErrors() {
        return new ArrayList<Integer>(0);
    }
}
