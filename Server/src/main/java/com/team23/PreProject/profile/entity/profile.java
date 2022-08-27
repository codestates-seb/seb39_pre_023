package com.team23.PreProject.profile.entity;

import com.team23.PreProject.user.entity.member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
public class profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer profile_id;
    @OneToOne(mappedBy = "profile")
    member member;
}
