package com.lemon.lemonmovies.model.result;

/**
 * Model that represents PersonResult in presentation-layer
 */
public final class PersonResultDataModel {

    private final int mPersonId;
    private final String mPersonName;
    private final String mPersonKnownFor;
    private final String mPersonPhoto;

    private PersonResultDataModel(final Builder builder) {
        this.mPersonId = builder.id;
        this.mPersonName = builder.name;
        this.mPersonKnownFor = builder.knownFor;
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

    public String getPersonKnownFor() {
        return mPersonKnownFor;
    }

    public String getPersonPhoto() {
        return mPersonPhoto;
    }

    public static final class Builder {

        private int id;
        private String name;
        private String knownFor;
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

        public Builder setKnownFor(final String knownFor) {
            this.knownFor = knownFor;
            return this;
        }

        public Builder setPhoto(final String photo) {
            this.photo = photo;
            return this;
        }

        public PersonResultDataModel build() {
            return new PersonResultDataModel(this);
        }
    }
}
