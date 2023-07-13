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

    @Override
    public String generateEnrollId() {
        long count = repo.count();
        String id = "E00-001";

        if (count != 0) {
            String generateCustomerId = repo.generateEnrollId();
            int tempId = Integer.parseInt(generateCustomerId.split("-")[1]);
            tempId += 1;
            if (tempId < 10) {
                id = "E00-00" + tempId;
            } else if (tempId < 100) {
                id = "E00-0" + tempId;
            } else if (tempId < 1000) {
                id = "E00-" + tempId;
            }
        } else {
            id = "E00-001";
        }
        return id;
    }

    @Override
    public EnrollCourseDTO getEnroll(String id) {
        return modelMapper.map(repo.getEnroll(id),EnrollCourseDTO.class);
    }
}
