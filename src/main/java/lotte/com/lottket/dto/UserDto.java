package lotte.com.lottket.dto;


public class UserDto {

    private long userId;
    private String userName;
    private String userProfileImage;
    private String userAddress;
    private String userDetailAddress;
    private String userGrade;
    private String userRole;
    private String userGender;
    private String userAge;
    private String userBirthday;
    private String userEmail;
    private String userPhoneNumber;

    public UserDto(){}
    
    public UserDto(Long userId) {
        this.userId = userId;
        String userProfileImage = "";
        String userAddress = "";
        String userDetailAddress = "";
        String userGrade = "";
        String userRole = "";
        String userGender = "";
        String userAge = "";
        String userBirthday = "";
        String userEmail = "";
        String userPhoneNumber = "";
    }

   public UserDto(long userId, String userName, String userProfileImage, String userAddress, String userDetailAddress, String userGrade, String userRole, String userGender, String userAge, String userBirthday, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
        this.userAddress = userAddress;
        this.userDetailAddress = userDetailAddress;
        this.userGrade = userGrade;
        this.userRole = userRole;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userBirthday = userBirthday;
        this.userEmail = userEmail;
    }

    public UserDto(long userId, String userName, String userProfileImage, String userAddress, String userDetailAddress, String userGrade, String userRole, String userGender, String userAge, String userBirthday, String userEmail, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userProfileImage = userProfileImage;
        this.userAddress = userAddress;
        this.userDetailAddress = userDetailAddress;
        this.userGrade = userGrade;
        this.userRole = userRole;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userBirthday = userBirthday;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserDetailAddress() {
        return userDetailAddress;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userProfileImage='" + userProfileImage + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userDetailAddress='" + userDetailAddress + '\'' +
                ", userGrade='" + userGrade + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }
}
