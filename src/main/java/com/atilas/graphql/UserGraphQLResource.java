package com.atilas.graphql;

import com.atilas.business.UserBusiness;
import com.atilas.dto.response.UserResponseDTO;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class UserGraphQLResource {

    UserBusiness userBusiness;

    @Inject
    UserGraphQLResource(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @Query("findUsers")
    @Description("findUsers")
    public List<UserResponseDTO> findUsers() {
        return userBusiness.findUsers();
    }

    @Query("findUsersById")
    @Description("findUsers by id")
    public UserResponseDTO findUsersById(Long id) {
        return userBusiness.findUserId(id);
    }
}
