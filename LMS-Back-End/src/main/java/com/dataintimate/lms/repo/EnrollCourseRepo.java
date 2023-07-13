package com.dataintimate.lms.repo;

import com.dataintimate.lms.entity.EnrollCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
public interface EnrollCourseRepo extends JpaRepository<EnrollCourse,String> {
    @Query(value = "SELECT id FROM Enroll_Course ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String generateEnrollId();

    @Query(value = "SELECT * FROM Enroll_Course WHERE id =:id",nativeQuery = true)
    EnrollCourse getEnroll(@Param("id") String id);

}
