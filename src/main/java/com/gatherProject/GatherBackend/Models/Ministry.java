package com.gatherProject.GatherBackend.Models;

import java.util.ArrayList;
import java.util.List;

public class Ministry extends User {

    private List<Individual> individualMatchList;
    private List<Event> events;
    private String fbUrl;
    private String websiteUrl;
    private String ministryEmail;
    private String phoneNumber;


    public Ministry(String username, String password, String email, String profilePicUrl, String aboutMe, String address, Integer distancePreference, String denom, String style, List<Feature> ministryFeatures, List<ChatRoom> chatRooms, String fbUrl, String ministryEmail, String websiteUrl, String phoneNumber) {
        super(username, password, email, profilePicUrl, aboutMe, address, distancePreference, denom, style, ministryFeatures);
        this.individualMatchList = new ArrayList<Individual>();
        this.events = new ArrayList<Event>();
        this.fbUrl = fbUrl;
        this.websiteUrl = websiteUrl;
        this.ministryEmail = ministryEmail;
        this.phoneNumber = phoneNumber;
        this.setChatRooms(chatRooms);
    }

    public Ministry() {
        super();
        this.individualMatchList = new ArrayList<Individual>();
        this.events = new ArrayList<Event>();
    }

    public List<Individual> getIndividualMatchList() {
        return individualMatchList;
    }

    public void setIndividualMatchList(List<Individual> individualMatchList) {
        this.individualMatchList = individualMatchList;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
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
