package dev.mikoto2000.security.reporitory;

import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dev.mikoto2000.security.entity.User;

/**
 * UsersMapper
 */
@Mapper
public interface UsersMapper {
  @Select("""
          SELECT
            *
          FROM
            USERS
          WHERE
            USERS.username = #{username}
          """)
  Optional<User> findByUsername(String username);
}
