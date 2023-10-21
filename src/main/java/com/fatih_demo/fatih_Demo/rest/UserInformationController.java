package com.fatih_demo.fatih_Demo.rest;

import com.fatih_demo.fatih_Demo.dto.UserInformationDto;
import com.fatih_demo.fatih_Demo.entity.UserInformation;
import com.fatih_demo.fatih_Demo.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-information")
public class UserInformationController {
    private final UserInformationService userInformationService;

    @Autowired
    public UserInformationController(UserInformationService userInformationService) {
        this.userInformationService = userInformationService;
    }

    @PostMapping("/add")
    public UserInformationDto saveUserInformation(@RequestBody UserInformation userInformation) {
        return userInformationService.save(userInformation);
    }

    @GetMapping("/{id}")
    public UserInformationDto getUserInformation(@PathVariable Integer id) {
        return userInformationService.getUserInformation(id);
    }

    @GetMapping("/all")
    public List<UserInformationDto> getAllUserInformation() {
        return userInformationService.getAllUserInformation();
    }

    @PutMapping("/{id}")
    public UserInformationDto updateUserInformation(@PathVariable Integer id, @RequestBody UserInformation userInformation) {
        return userInformationService.updateUserInformation(id, userInformation);
    }

    @DeleteMapping("/{id}")
    public void deleteUserInformation(@PathVariable Integer id) {
        userInformationService.deleteUserInformation(id);
    }
}
