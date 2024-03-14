package org.pgs.postp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Roles")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID")
    private Long roleID;

    @Column(name = "RoleName", unique = true, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<UserModel> users;

    // Constructors
    public RoleModel() {
    }

    public RoleModel(String roleName) {
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

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
