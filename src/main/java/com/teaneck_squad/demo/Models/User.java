package com.teaneck_squad.demo.Models;

import javax.persistence.*;

@Entity(name="user")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "USER_ID", unique = true, nullable = false)
   private Long userId;

   @Column(name = "first_name", nullable = false)
   private String firstName;

   @Column(name = "last_name", nullable = false)
   private String lastName;


public Long getUserId() {
return userId;
}

public String getFirstName() {
return firstName;
}

public String getLastName() {
return lastName;
}

public void setUserId(Long userId) {
this.userId = userId;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}
}
