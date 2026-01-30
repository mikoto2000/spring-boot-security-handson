package dev.mikoto2000.security.entity;

import lombok.Data;

/**
 * User
 */
@Data
public class User {
  private String username;
  private String password;
  private Boolean enabled;
}
