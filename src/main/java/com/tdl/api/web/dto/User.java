package com.tdl.api.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long msrl;
    @Column(nullable = false, unique = true, length = 30)
    private String uid;
    @Column(nullable = false, length = 100)
    private String name;

    public User(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public long getMsrl(){
        return msrl;
    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
