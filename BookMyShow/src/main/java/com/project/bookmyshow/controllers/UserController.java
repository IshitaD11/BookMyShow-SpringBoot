package com.project.bookmyshow.controllers;

import com.project.bookmyshow.DTOs.ResponseStatus;
import com.project.bookmyshow.DTOs.SignUpRequestDTO;
import com.project.bookmyshow.DTOs.SignUpResponseDTO;
import com.project.bookmyshow.models.User;
import com.project.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public SignUpResponseDTO signUp(SignUpRequestDTO request){
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();

        try{
            User user = userService.signUp(
                    request.getEmailId(),
                    request.getPassword()
            );

            signUpResponseDTO.setUserId(user.getId());
            signUpResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex){
            signUpResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }

        return signUpResponseDTO;
    }
}
