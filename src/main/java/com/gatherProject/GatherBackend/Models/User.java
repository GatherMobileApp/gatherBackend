package com.gatherProject.GatherBackend.Models;

import java.util.List;

public class Individual {

    private String username;
    private String password;
    private String email;
    //wil figure out this functionality
    private String profilePic;
    private String aboutMe;
    private String address;
    private String distancePreference;
    private String denom;
    private String style;
    private List<Feature> ministryFeatures;
    private boolean isMinistry;
    private List<Event> events;
    private String fbUrl;
    private String websiteUrl;
    private String ministryEmail;
    private String phoneNumber;

    public Individual () {};

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistancePreference() {
        return distancePreference;
    }

    public void setDistancePreference(String distancePreference) {
        this.distancePreference = distancePreference;
    }

    public String getDenom() {
        return denom;
    }

    public void setDenom(String denom) {
        this.denom = denom;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public List<Feature> getMinistryFeatures() {
        return ministryFeatures;
    }

    public void setMinistryFeatures(List<Feature> ministryFeatures) {
        this.ministryFeatures = ministryFeatures;
    }

    public boolean isMinistry() {
        return isMinistry;
    }

    public void setMinistry(boolean ministry) {
        isMinistry = ministry;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
