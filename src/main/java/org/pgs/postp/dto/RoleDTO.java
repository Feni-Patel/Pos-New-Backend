package org.pgs.postp.dto;

public class RoleDTO {
    private Long roleID;
    private String roleName;

    // Constructors
    public RoleDTO() {
    }

    public RoleDTO(Long roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    // Getters and Setters
    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
