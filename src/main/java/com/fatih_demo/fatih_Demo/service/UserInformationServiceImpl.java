package com.fatih_demo.fatih_Demo.service;
import com.fatih_demo.fatih_Demo.dto.UserInformationDto;
import com.fatih_demo.fatih_Demo.entity.UserInformation;
import com.fatih_demo.fatih_Demo.repo.UserInformationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInformationServiceImpl implements UserInformationService {
    private final UserInformationRepository userInformationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserInformationServiceImpl(UserInformationRepository userInformationRepository, ModelMapper modelMapper) {
        this.userInformationRepository = userInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserInformationDto save(UserInformation userInformation) {
        UserInformation savedUserInformation = userInformationRepository.save(userInformation);
        return modelMapper.map(savedUserInformation, UserInformationDto.class);
    }

    @Override
    public UserInformationDto getUserInformation(Integer id) {
        UserInformation userInformation = userInformationRepository.findById(id).orElse(null);
        return modelMapper.map(userInformation, UserInformationDto.class);
    }

    @Override
    public List<UserInformationDto> getAllUserInformation() {
        List<UserInformation> userInformationList = userInformationRepository.findAll();
        return userInformationList.stream()
                .map(info -> modelMapper.map(info, UserInformationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserInformation(Integer id) {
        userInformationRepository.deleteById(id);
    }

    @Override
    public UserInformationDto updateUserInformation(Integer id, UserInformation userInformation) {
        UserInformation userInformationToUpdate = userInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UserInformation with ID " + id + " not found"));

        userInformationToUpdate.setEmail(userInformation.getEmail());
        userInformationToUpdate.setPassword(userInformation.getPassword());
        userInformationToUpdate.setFirstname(userInformation.getFirstname());
        userInformationToUpdate.setLastname(userInformation.getLastname());

        userInformationRepository.save(userInformationToUpdate);

        return modelMapper.map(userInformationToUpdate, UserInformationDto.class);
    }
}
