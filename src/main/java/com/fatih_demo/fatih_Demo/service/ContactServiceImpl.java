package com.fatih_demo.fatih_Demo.service;
import com.fatih_demo.fatih_Demo.dto.ContactDto;
import com.fatih_demo.fatih_Demo.entity.Contact;
import com.fatih_demo.fatih_Demo.repo.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactDto save(Contact contact) {
        contact = contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public ContactDto getContact(Integer id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public List<ContactDto> getAllContact() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }

    @Override
    public ContactDto updateContact(Integer id, Contact contact) {
        Contact contactToUpdate = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));

        contactToUpdate.setTitle(contact.getTitle());
        contactToUpdate.setAddress(contact.getAddress());
        contactToUpdate.setTel(contact.getTel());
        contactToUpdate.setFax(contact.getFax());
        contactToUpdate.setEmail(contact.getEmail());
        contactToUpdate.setImageUrl(contact.getImageUrl());

        contactRepository.save(contactToUpdate);

        return modelMapper.map(contactToUpdate, ContactDto.class);
    }
}