package dev.mikoto2000.security.reporitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mikoto2000.security.entity.Users;

/**
 * Users
 */
public interface UsersRepository extends JpaRepository<Users, String> {
  Optional<Users> findByUsername(String username);
}
