package lotte.com.lottket.service.user;

import lotte.com.lottket.dto.UserDto;

public interface UserService {
    int signIn(UserDto dto);

    int signUp(UserDto dto);

    UserDto getUser(String email);

    UserDto findByUserId(long userId);

    int updateAddress(UserDto dto);
}
