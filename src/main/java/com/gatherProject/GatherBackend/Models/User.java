package com.gatherProject.GatherBackend.Models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private String email;
    private String profilePicUrl;
    private String aboutMe;
    private String address;
    private String distancePreference;
    private String denom;
    private String style;
    private List<Feature> ministryFeatures;
    private List<ChatRoom> chatRooms;

    public User(String username, String password, String email, String profilePicUrl, String aboutMe, String address, String distancePreference, String denom, String style, List<Feature> ministryFeatures) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profilePicUrl = profilePicUrl;
        this.aboutMe = aboutMe;
        this.address = address;
        this.distancePreference = distancePreference;
        this.denom = denom;
        this.style = style;
        this.ministryFeatures = ministryFeatures;
        this.chatRooms = new ArrayList<ChatRoom>();
    }

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
        return profilePicUrl;
    }

    public void setProfilePic(String profilePic) {
        this.profilePicUrl = profilePicUrl;
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

    public List<ChatRoom> getChatRooms() {
        return chatRooms;
    }

    public void setChatRooms(List<ChatRoom> chatRooms) {
        this.chatRooms = chatRooms;
    }
}
