package bg.softuni.mobileleleleto.models.entity;

import bg.softuni.mobileleleleto.models.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRoleEnum userRole;

    public UserRoleEntity() {
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }
}
