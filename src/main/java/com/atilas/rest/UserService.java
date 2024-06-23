package com.atilas.rest;

import com.atilas.business.UserBusiness;
import com.atilas.dto.request.UserRequestDTO;
import com.atilas.dto.response.UserResponseDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("v1/user")
public class UserService {

    UserBusiness userBusiness;

    @Inject
    UserService(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUsers() {
        List<UserResponseDTO> users = userBusiness.findUsers();
        return Response.ok(users).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserRequestDTO user){
        UserResponseDTO newUser = userBusiness.createUser(user);
        return Response.created(URI.create(newUser.getId().toString())).build();
    }
}
