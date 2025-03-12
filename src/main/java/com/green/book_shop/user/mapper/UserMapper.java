package com.green.book_shop.user.mapper;

import com.green.book_shop.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  //회원가입
  public void insertUser(UserDTO userDTO);

  //회원가입 아이디 중복 검사
  public String checkUserId(String userId);

  //로그인
  public UserDTO checkLogin(UserDTO userDTO);
}
