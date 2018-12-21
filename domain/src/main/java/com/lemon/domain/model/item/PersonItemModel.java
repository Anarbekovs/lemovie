package com.lemon.domain.model.item;

/**
 * Model that represents PersonItem in domain-layer
 */
public final class PersonItemModel {

    private final int mId;
    private final String mName;
    private final String mKnownAs;
    private final String mPhoto;

    public PersonItemModel(int id, String name, String knownAs, String photo) {
        this.mId = id;
        this.mName = name;
        this.mKnownAs = knownAs;
        this.mPhoto = photo;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getKnownAs() {
        return mKnownAs;
    }

    public String getPhoto() {
        return mPhoto;
    }
}
