package org.pgs.postp.dto;

public class UserDTO {
    private Long userID;
    private String username;
    private String password;
    private Long roleId;

    public UserDTO() {
    }

    public UserDTO(Long userID, String username, String password, Long roleId) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
