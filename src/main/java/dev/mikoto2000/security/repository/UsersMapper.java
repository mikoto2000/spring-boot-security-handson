package dev.mikoto2000.security.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
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
            username,
            password,
            enabled
          FROM
            USERS
          WHERE
            USERS.username = #{username}
          """)
  Optional<User> findByUsername(String username);

  /* 追加ここから */
  @Insert("""
          INSERT INTO USERS
          (
            username,
            password,
            enabled
          )
            VALUES
          (
            #{username},
            #{password},
            #{enabled}
          )
          """)
  int insert(User user);
  /* 追加ここまで */
}
