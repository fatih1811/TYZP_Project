package com.fatih_demo.fatih_Demo.rest;

import com.fatih_demo.fatih_Demo.dto.ContactDto;
import com.fatih_demo.fatih_Demo.entity.Contact;
import com.fatih_demo.fatih_Demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/get/all")
    public List<ContactDto> getAllContacts() {
        return contactService.getAllContact();
    }

    @GetMapping("/{id}")
    public ContactDto getContactById(@PathVariable Integer id) {
        return contactService.getContact(id);
    }

    @PostMapping("/add")
    public ContactDto createContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @PutMapping("/{id}")
    public ContactDto updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Integer id) {
        contactService.deleteContact(id);
    }
}
