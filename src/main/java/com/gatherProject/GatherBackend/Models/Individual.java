package com.gatherProject.GatherBackend.Models;

import java.util.ArrayList;
import java.util.List;

public class Individual extends User {

    private List<Ministry> ministryMatchList;


    public Individual(String username, String password, String email, String profilePicUrl, String aboutMe, String address, String distancePreference, String denom, String style, List<Feature> ministryFeatures) {
        super(username, password, email, profilePicUrl, aboutMe, address, distancePreference, denom, style, ministryFeatures);
        this.ministryMatchList = new ArrayList<Ministry>();
    }

    public List<Ministry> getMinistryMatchList() {
        return ministryMatchList;
    }

    public void setMinistryMatchList(List<Ministry> ministryMatchList) {
        this.ministryMatchList = ministryMatchList;
    }
}
