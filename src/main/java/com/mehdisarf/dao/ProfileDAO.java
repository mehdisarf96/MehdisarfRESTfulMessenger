package com.mehdisarf.dao;

import com.mehdisarf.models.Profile;

import java.util.HashMap;
import java.util.Map;

public class ProfileDAO { // Profile DAO (Stub)

    private static Map<String, Profile> profiles = new HashMap<>();

    static {
        profiles.put("MESAR", new Profile(1L, "MESAR", "Mehdi", "Sarf"));
        profiles.put("R2", new Profile(2L, "R2", "Roro", "Twi"));
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
