package com.robot;

import java.util.Date;
import java.util.List;

/**
 * Created by fernandinho on 6/25/14.
 */
public interface BaseModel {

    /**
     * @return the current upload state
     * @see com.robot.UploadState
     */
    public UploadState getUploadState();

    /**
     * @return true if the current uploadState is UploadState.uploaded
     */
    public boolean isUploaded();

    /**
     * @return true if the current uploadState is UploadState.uploading
     */
    public boolean isUploading();

    /**
     * @return true if the current uploadState is UploadState.needsUploading
     */
    public boolean needsUploading();

    /**
     * Sets the upload state
     * @param uploadState the upload state
     */
    public void setUploadState(UploadState uploadState);

    /**
     * @return the date when this BaseModel was created locally, not remotely.
     */
    public Date getCreationDate();

    /**
     * When creating a new model instance this method verifies that all conditions are met,
     * i.e. all non null fields are not null, al non-empty fields are not empty, etc.
     * @return true if the model is valid.
     */
    public boolean isValid();

    /**
     * @return a list of all errors that must be fixed before the object can be saved.
     */
    public List<Integer> getErrors();

    public static class ModelInvalidException extends Exception{

        public ModelInvalidException(String message){
            super(message);
        }
    }
}
