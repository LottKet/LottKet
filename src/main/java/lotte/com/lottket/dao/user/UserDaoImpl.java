package lotte.com.lottket.dao.user;

import lotte.com.lottket.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    SqlSession session;

    String ns = "User.";

    @Override
    public int signIn(UserDto dto) {
        Long id = session.selectOne(ns + "signIn", dto);
        if(id != null) {
            System.out.println(id);
            return 1;
        }else {
            int result = session.insert(ns + "signUp", dto);
            if(result>0) {
                return 2;
            }else {
                return 0;
            }
        }
    }

    @Override
    public int signUp(UserDto dto) {
        return session.insert(ns + "signUp");
    }

    @Override
    public UserDto getUser(String email) {
        return session.selectOne(ns + "getUser", email);
    }

    @Override
    public UserDto findByUserId(long userId) {
        return session.selectOne(ns+"findByUserId",userId);
    }

    @Override
    public int updateAddress(UserDto dto) {
        return session.update(ns + "updateAddress", dto);
    }


}