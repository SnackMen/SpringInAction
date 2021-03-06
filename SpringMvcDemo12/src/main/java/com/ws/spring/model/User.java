package com.ws.spring.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by laowang on 16-10-20.
 */
@Entity
@Table(name = "app_user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="sso_id",unique = true,nullable = false)
    private String ssoId;

    @NotEmpty
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @NotEmpty
    @Column(name="email",nullable = false)
    private String email;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserDocument> userDocuments = new HashSet<UserDocument>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserDocument> getUserDocuments() {
        return userDocuments;
    }

    public void setUserDocuments(Set<UserDocument> userDocuments) {
        this.userDocuments = userDocuments;
    }

    //重写hashcode和equals,主要为了防止set和map进行调用时出现问题
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ssoId == null) {
            if (other.ssoId != null)
                return false;
        } else if (!ssoId.equals(other.ssoId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + ssoId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + "]";
    }
}
