package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.UserInformationDto;
import com.fatih_demo.fatih_Demo.entity.UserInformation;

import java.util.List;

public interface UserInformationService {
    UserInformationDto save(UserInformation userInformation);

    UserInformationDto getUserInformation(Integer id);

    List<UserInformationDto> getAllUserInformation();

    void deleteUserInformation(Integer id);

    UserInformationDto updateUserInformation(Integer id, UserInformation userInformation);


}
