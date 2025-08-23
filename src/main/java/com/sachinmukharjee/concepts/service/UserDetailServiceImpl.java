package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.UserRegister;
import com.sachinmukharjee.concepts.entity.Users;
import com.sachinmukharjee.concepts.repository.IUserDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements IUserDetailsService {

  private IUserDetailRepository userDetailRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userDetailRepository
        .findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not Found"));
  }

  @Override
  public Users save(UserRegister userRegister) {
    try {
      return userDetailRepository.save(toEntity(userRegister));
    } catch (Exception e) {
      throw new RuntimeException("Unable to Create Users");
    }
  }

  private Users toEntity(UserRegister userRegister) {
    Users users = new Users();
    users.setUsername(userRegister.getUserName());
    users.setPassword(userRegister.getEncodedPassword());
    //users.setRoles(userRegister.getRole().stream().collect(Collectors.toSet()));
    return users;
  }
}
