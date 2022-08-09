package com.nova.shoppinglist.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {

    private Long userId;
    @NotBlank
    private String userName;
    @NotBlank
    private String userPassword;
    @NotBlank
    private String repeatUserPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRepeatUserPassword() {
        return repeatUserPassword;
    }

    public void setRepeatUserPassword(String repeatUserPassword) {
        this.repeatUserPassword = repeatUserPassword;
    }
}
