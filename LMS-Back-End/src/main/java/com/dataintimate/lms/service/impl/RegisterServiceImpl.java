package com.dataintimate.lms.service.impl;

import com.dataintimate.lms.dto.RegisterDTO;
import com.dataintimate.lms.entity.Register;
import com.dataintimate.lms.repo.RegisterRepo;
import com.dataintimate.lms.service.RegisterService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveRegister(RegisterDTO registerDTO) {
        if (repo.existsById(registerDTO.getEmail())){
            throw new RuntimeException("Register "+registerDTO.getEmail()+" Already Exist...!");
        }
        repo.save(modelMapper.map(registerDTO, Register.class));
    }

    @Override
    public void updateInfo(RegisterDTO registerDTO) {
        if (!repo.existsById(registerDTO.getEmail())){
            throw new RuntimeException("Register "+registerDTO.getEmail()+" Not Available To Update...!");
        }
        repo.save(modelMapper.map(registerDTO,Register.class));
    }

    @Override
    public void deleteInfo(String email) {
        if (!repo.existsById(email)){
            throw new RuntimeException(email+" Not Available to Delete...!");
        }
        repo.deleteById(email);
    }

    @Override
    public void uploadRegisterImages(String image, String email) {
        repo.updateRegisterFilePaths(image, email);
    }

    @Override
    public ArrayList<RegisterDTO> getAllDetail() {
        return modelMapper.map(repo.findAll(),new TypeToken<ArrayList<RegisterDTO>>(){}.getType());
    }

    @Override
    public RegisterDTO findByEmailAndPassword(String email, String password) {
        return modelMapper.map(repo.findByEmailAndPassword(email, password),RegisterDTO.class);
    }


}
