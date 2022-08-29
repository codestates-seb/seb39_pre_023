package com.team23.PreProject.profile.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team23.PreProject.member.entity.member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
public class profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer profile_id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="MEMBER_ID")
    @JsonIgnore
    member member;

    public void setMember(member member)
    {
        this.member = member;
    }

    @Column(name="STUB_REPUTATION")
    Integer stubReputation = 0;

    @Column(name = "STUB_REACHED" )
    Integer stubReached = 0;

    @Column(name = "ABOUT")
    String about = "blank";

    @Column(name = "SIGN_IN_DATE")
    LocalDateTime signInDate = LocalDateTime.now();

    @Column(name="LAST_VISIT")
    LocalDateTime lastVisit = LocalDateTime.now();


}
