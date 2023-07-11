package com.dataintimate.lms.repo;

import com.dataintimate.lms.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
public interface RegisterRepo extends JpaRepository<Register,String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Register SET image=:image WHERE email=:email", nativeQuery = true)
    void updateRegisterFilePaths(@Param("image") String image, @Param("email") String email);

    Register findByEmailAndPassword (String email,String password);

}
