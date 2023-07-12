package com.dataintimate.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EnrollCourseDTO {
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
