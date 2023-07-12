package com.dataintimate.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EnrollCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String birth;
    private String nic;
    private String gender;
    private String qualification;
    private String course;
    private String medium;
}
