package com.nissum.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nissum.user.util.Util;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class UserDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;

    @JsonIgnore
    @CreationTimestamp
    @Column
    private Date created;

    @JsonIgnore
    @CreationTimestamp
    @Column
    private Date modified;

    @JsonIgnore
    @CreationTimestamp
    @Column
    private Date last_login;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="idphone")
    @ElementCollection
    @Column
    private List<PhonesDto> phones;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public List<PhonesDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhonesDto> phones) {
        this.phones = phones;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(Util.validateMail(email)){
            this.email = email;
        }else{
            throw new EntityExistsException("invalid mail format "
                    + email);
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(Util.validatePassword(password)){
            this.password = password;
        }else{
            throw new EntityExistsException("format password incorrect "
                    + email);
        }

    }

}
