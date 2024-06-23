package com.atilas.repository;

import com.atilas.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UserRepository implements PanacheRepository<User> {
}
