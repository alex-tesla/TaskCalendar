package com.devsav.model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class People {
  private Long id;
  private String firstname;
  private String lastname;
  private String email;
  private String login;
  private String password;
  private Boolean is_blocked;
  private String role;

  public People() {
  }

  public People(People people) {
  }

  public People(Long id, String firstname, String lastname, String email, String login, String password, Boolean is_blocked, String role) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.login = login;
    this.password = password;
    this.is_blocked = is_blocked;
    this.role = role;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getIs_blocked() {
    return is_blocked;
  }

  public void setIs_blocked(Boolean is_blocked) {
    this.is_blocked = is_blocked;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
