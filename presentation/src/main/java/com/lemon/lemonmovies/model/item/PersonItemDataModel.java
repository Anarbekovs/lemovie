package com.lemon.lemonmovies.model.item;

/**
 * Model that represents PersonItem in presentation-layer
 */
public final class PersonItemDataModel {

    private final int mPersonId;
    private final String mPersonName;
    private final String mPersonKnownAs;
    private final String mPersonPhoto;

    private PersonItemDataModel(final Builder builder) {
        this.mPersonId = builder.id;
        this.mPersonName = builder.name;
        this.mPersonKnownAs = builder.knownAs;
        this.mPersonPhoto = builder.photo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getPersonId() {
        return mPersonId;
    }

    public String getPersonName() {
        return mPersonName;
    }

    public String getPersonKnownAs() {
        return mPersonKnownAs;
    }

    public String getPersonPhoto() {
        return mPersonPhoto;
    }

    public static final class Builder {

        private int id;
        private String name;
        private String knownAs;
        private String photo;

        private Builder() {
        }

        public Builder setId(final int id) {
            this.id = id;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setKnownAs(final String knownAs) {
            this.knownAs = knownAs;
            return this;
        }

        public Builder setPhoto(final String photo) {
            this.photo = photo;
            return this;
        }

        public PersonItemDataModel build() {
            return new PersonItemDataModel(this);
        }
    }
}
