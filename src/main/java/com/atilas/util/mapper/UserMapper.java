package com.atilas.util.mapper;

import com.atilas.dto.request.UserRequestDTO;
import com.atilas.dto.response.UserResponseDTO;
import com.atilas.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO userToUserResponseDTO(User user);
    User userResponseDTOToUser(UserResponseDTO userResponseDTO);

    @Mapping(target = "id", ignore = true)
    User userRequestDTOToUser(UserRequestDTO user);
}
