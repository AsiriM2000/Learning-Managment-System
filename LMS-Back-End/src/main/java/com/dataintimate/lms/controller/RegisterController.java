package com.dataintimate.lms.controller;

import com.dataintimate.lms.dto.RegisterDTO;
import com.dataintimate.lms.service.RegisterService;
import com.dataintimate.lms.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author : Asiri Madhusanka
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin
public class RegisterController {
    @Autowired
    RegisterService service;

    @PostMapping
    public ResponseUtil saveRegister(@RequestBody  RegisterDTO registerDTO){
        service.saveRegister(registerDTO);
        return new ResponseUtil("200","Registration Success...!",null);
    }

//    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseUtil addVehicle(@RequestPart("vImageFile") MultipartFile[] file, @RequestPart("register") RegisterDTO registerDTO) {
//
//
//        for (MultipartFile myFile : file) {
//
//            try {
//                String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//                File uploadsDir = new File(projectPath + "/uploads");
//                uploadsDir.mkdir();
//                myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
//                System.out.println(projectPath);
//            } catch (IOException | URISyntaxException e) {
//                e.printStackTrace();
//                return new ResponseUtil("500", "Registration Failed.Try Again Latter", null);
//            }
//        }
//
//
//
//
//        service.saveRegister(registerDTO);
//        return new ResponseUtil("200", "Registration Successfully...!", registerDTO);
//    }


    @PutMapping(path = "/uploadImg/{email}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("image") MultipartFile image, @PathVariable String email) {
        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();

            image.transferTo(new File(uploadsDir.getAbsolutePath() + "\\" + image.getOriginalFilename()));

            String imageLocation = image.getOriginalFilename();
            service.uploadRegisterImages(imageLocation, email);

            System.out.println(imageLocation);
            return new ResponseUtil("200", "Uploaded", null);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseUtil("500",e.getMessage(),null);
        }
    }

    @PutMapping
    public ResponseUtil updateInfo(@RequestBody RegisterDTO registerDTO){
        service.updateInfo(registerDTO);
        return new ResponseUtil("200","Update Success...!",null);
    }

    @GetMapping
    public ResponseUtil getAllDetail(){
        ArrayList<RegisterDTO> allDetail = service.getAllDetail();
        return new ResponseUtil("200","Success",allDetail);
    }

    @GetMapping(params = {"email","password"})
    public ResponseUtil findByEmailAndPassword(String email,String password){
        RegisterDTO details = service.findByEmailAndPassword(email, password);
        return new ResponseUtil("200","Success",details);
    }

    @DeleteMapping
    public ResponseUtil deleteInfo(String email){
        service.deleteInfo(email);
        return new ResponseUtil("200","Account Remove Success...!",null);
    }

}
