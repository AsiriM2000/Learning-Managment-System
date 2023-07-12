package com.dataintimate.lms.service.impl;

import com.dataintimate.lms.dto.EnrollCourseDTO;
import com.dataintimate.lms.entity.EnrollCourse;
import com.dataintimate.lms.repo.EnrollCourseRepo;
import com.dataintimate.lms.service.EnrollCourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
@Service
@Transactional
public class EnrollCourseServiceImpl implements EnrollCourseService {

    @Autowired
    EnrollCourseRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveEnroll(EnrollCourseDTO courseDTO) {
        repo.save(modelMapper.map(courseDTO, EnrollCourse.class));
    }
}
