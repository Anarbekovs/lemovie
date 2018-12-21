package com.lemon.domain.model.result;

/**
 * Model that represents PersonResult in domain-layer
 */
public final class PersonResultModel {

    private final int mId;
    private final String mName;
    private final String mKnownFor;
    private final String mPhoto;

    public PersonResultModel(int id, String name, String knownFor, String photo) {
        this.mId = id;
        this.mName = name;
        this.mKnownFor = knownFor;
        this.mPhoto = photo;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getKnownFor() {
        return mKnownFor;
    }

    public String getPhoto() {
        return mPhoto;
    }
}
