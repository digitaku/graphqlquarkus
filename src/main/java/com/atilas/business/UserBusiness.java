package com.atilas.business;

import com.atilas.dto.request.UserRequestDTO;
import com.atilas.dto.response.UserResponseDTO;
import com.atilas.entity.User;
import com.atilas.repository.UserRepository;
import com.atilas.util.mapper.UserMapper;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

@RequestScoped
public class UserBusiness {

    UserRepository userRepository;

    @Inject
    UserBusiness(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> findUsers() {
        List<User> list = userRepository.findAll(Sort.by("name", Sort.Direction.Ascending)).list();
        return list.stream().map(UserMapper.INSTANCE::userToUserResponseDTO).toList();
    }

    @Transactional
    public UserResponseDTO createUser(@Valid UserRequestDTO user) {
        User newUser = UserMapper.INSTANCE.userRequestDTOToUser(user);
        userRepository.persist(newUser);
        return UserMapper.INSTANCE.userToUserResponseDTO(newUser);
    }

    public UserResponseDTO findUserId(Long id) {
        User user = userRepository.findById(id);
        return UserMapper.INSTANCE.userToUserResponseDTO(user);
    }
}
