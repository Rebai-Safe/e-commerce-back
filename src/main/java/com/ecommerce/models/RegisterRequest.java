package com.ecommerce.models;

import com.ecommerce.beans.AuthCredentials;
import com.ecommerce.beans.ProfileCredentials;

public class RegisterRequest {
    private AuthCredentials authCredentials;
    private ProfileCredentials profileCredentials;

    public AuthCredentials getAuthCredentials() {
        return authCredentials;
    }

    public void setAuthCredentials(AuthCredentials authCredentials) {
        this.authCredentials = authCredentials;
    }

    public ProfileCredentials getProfileCredentials() {
        return profileCredentials;
    }

    public void setProfileCredentials(ProfileCredentials profileCredentials) {
        this.profileCredentials = profileCredentials;
    }
}
