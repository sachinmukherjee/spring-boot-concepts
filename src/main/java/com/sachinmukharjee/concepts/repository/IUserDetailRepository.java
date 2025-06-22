package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDetailRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String username);
}
