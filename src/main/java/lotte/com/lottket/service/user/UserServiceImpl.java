package lotte.com.lottket.service.user;

import lotte.com.lottket.dao.user.UserDao;
import lotte.com.lottket.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSevice{
    @Autowired
    UserDao dao;

    @Override
    public int signIn(UserDto dto) {
        return dao.signIn(dto);
    }

    @Override
    public int signUp(UserDto dto) {
        return dao.signUp(dto);
    }

    @Override
    public UserDto getUser(UserDto dto) {
        return dao.getUser(dto);
    }
}