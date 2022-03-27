package com.mehdisarf.resources;

import com.mehdisarf.models.Profile;
import com.mehdisarf.services.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
public class ProfileResource {

    private ProfileService profileService = new ProfileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile createProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @Path("/{profileName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("profileName") String profName) {
        return profileService.getProfile(profName);
    }

    @Path("/{profileName}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile updateProfile(@PathParam("profileName") String profName, Profile profile) {
        profile.setProfileName(profName);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public void removeProfile(@PathParam("profileName") String profName) {
        profileService.removeProfile(profName);
    }
}
