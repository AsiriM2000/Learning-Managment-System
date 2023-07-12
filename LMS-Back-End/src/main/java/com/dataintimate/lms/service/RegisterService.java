package com.dataintimate.lms.service;

import com.dataintimate.lms.dto.RegisterDTO;

import java.util.ArrayList;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
public interface RegisterService {
    void saveRegister(RegisterDTO registerDTO);
    void updateInfo(RegisterDTO registerDTO);
    void deleteInfo(String email);
    void uploadRegisterImages(String image, String email);
    ArrayList<RegisterDTO> getAllDetail();
    RegisterDTO findByEmailAndPassword (String email,String password);

}
