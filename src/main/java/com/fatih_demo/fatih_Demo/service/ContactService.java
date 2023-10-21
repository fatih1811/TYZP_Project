package com.fatih_demo.fatih_Demo.service;

import com.fatih_demo.fatih_Demo.dto.ContactDto;
import com.fatih_demo.fatih_Demo.entity.Contact;

import java.util.List;

public interface ContactService {
    ContactDto save(Contact contact);

    ContactDto getContact(Integer id);

    List<ContactDto> getAllContact();

    ContactDto updateContact(Integer id, Contact contact);

    void deleteContact(Integer id);
}
