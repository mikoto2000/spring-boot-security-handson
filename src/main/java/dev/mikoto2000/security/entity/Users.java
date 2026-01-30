package dev.mikoto2000.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * User
 */
@Data
@Entity
public class Users {
  @Id
  private String username;
  private String password;
  private Boolean enabled;
}
