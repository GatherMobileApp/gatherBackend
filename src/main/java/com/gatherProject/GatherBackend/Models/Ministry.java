package com.gatherProject.GatherBackend.Models;

import java.util.ArrayList;
import java.util.List;

public class Ministry extends User {

    private List<Individual> individualMatchList;
    private String fbUrl;
    private String websiteUrl;
    private String ministryEmail;
    private String phoneNumber;

    public Ministry(String username, String password, String email, String profilePicUrl, String aboutMe, String address, String distancePreference, String denom, String style, List<Feature> ministryFeatures, List<Individual> individualMatchList, String fbUrl, String websiteUrl, String ministryEmail, String phoneNumber) {
        super(username, password, email, profilePicUrl, aboutMe, address, distancePreference, denom, style, ministryFeatures);

        if (individualMatchList == null) {
            this.individualMatchList = new ArrayList<>();
        } else {
            this.individualMatchList = individualMatchList;
        }

        this.fbUrl = fbUrl;
        this.websiteUrl = websiteUrl;
        this.ministryEmail = ministryEmail;
        this.phoneNumber = phoneNumber;
    }

    public Ministry() {
        super();
        individualMatchList = new ArrayList<>();
    }

    public List<Individual> getIndividualMatchList() {
        return individualMatchList;
    }

    public void setIndividualMatchList(List<Individual> individualMatchList) {
        this.individualMatchList = individualMatchList;
    }

    public String getFbUrl() {
        return fbUrl;
    }

    public void setFbUrl(String fbUrl) {
        this.fbUrl = fbUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getMinistryEmail() {
        return ministryEmail;
    }

    public void setMinistryEmail(String ministryEmail) {
        this.ministryEmail = ministryEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
