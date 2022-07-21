package lotte.com.lottket.controller;

import com.google.gson.Gson;
import lotte.com.lottket.dto.UserDto;
import lotte.com.lottket.service.user.UserService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @RequestMapping(value="login.do", method= RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="logout.do" ,method = RequestMethod.GET)
    public String logout() {
        return "logout";
    }

    @RequestMapping(value="signIn.do", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String signIn(@RequestBody String json) {
        System.out.println(json);
        String userName="", userProfileImage="", userGender="", userAge="", userBirthday="", userEmail="";
        //더 좋은 방법 없을까
        JSONObject jObject = new JSONObject(json);
        //userId
        Long userId = jObject.getLong("id");
        JSONObject kakao = jObject.getJSONObject("kakao_account");
        //userAge
        if(kakao.has("age_range")) {
            userAge = kakao.getString("age_range");
        }
        //userBirthday
        if(kakao.has("birthday")) {
            userBirthday = kakao.getString("birthday");
        }
        //userEmail
        if(kakao.has("email")) {
            userEmail = kakao.getString("email");
        }
        //userGender
        if(kakao.has("userGender")) {
            userGender = kakao.getString("gender");
        }
        JSONObject profile = kakao.getJSONObject("profile");
        //userName
        if(profile.has("nickname")) {
            userName = profile.getString("nickname");
        }
        //userProfileImage
        if(profile.has("userProfileImage")) {
            userProfileImage = profile.getString("thumbnail_image_url");
        }
        //address, detailAddress는 따로 받아 온다고 생각.
        String userAddress="";
        String userDetailAddress="";
        UserDto dto = new UserDto(userId, userName, userProfileImage, userAddress, userDetailAddress, "5", "user", userGender, userAge, userBirthday, userEmail);
        int count = service.signIn(dto);

        String result = "{\"grade\":\"" + dto.getUserGrade() + "\", \"role\":\"" + dto.getUserRole() + "\"}";

        return result;
    }


    @RequestMapping(value="getUser.do", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUser(String email) {
        return service.getUser(email);
    }

    @RequestMapping(value="updateAddress.do", method = RequestMethod.POST)
    @ResponseBody
    public int updateAddress(UserDto dto) {
        return service.updateAddress(dto);
    }
}
