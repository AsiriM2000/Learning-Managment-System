package com.dataintimate.lms.controller;

import com.dataintimate.lms.dto.EnrollCourseDTO;
import com.dataintimate.lms.service.EnrollCourseService;
import com.dataintimate.lms.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/api/v1/enroll")
@CrossOrigin
public class EnrollCourseController {

    @Autowired
    EnrollCourseService service;

    @PostMapping
    public ResponseUtil saveEnroll(@RequestBody EnrollCourseDTO courseDTO){
        service.saveEnroll(courseDTO);
        return new ResponseUtil("200","Enroll Course Success...!",null);
    }
}
