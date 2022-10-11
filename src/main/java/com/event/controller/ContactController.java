package com.event.controller;

import com.event.model.Contact;
import com.event.request.ContactRequest;
import com.event.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("contacts")
@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    /**
     * Return a list of contacts
     *
     * @param enterprise_id represent the ID of enterprises
     * @return List contact by enterprise enterprise
     */
    @GetMapping("/{enterprise_id}")
    public List<Contact> all(@PathVariable("enterprise_id") Long enterprise_id) {
        return contactService.getContacts(enterprise_id);
    }

    /**
     * Return one saved contact
     *
     * @param contactRequest represent the body of request to save new contact
     * @return Contact save
     */
    @PostMapping("save")
    public Contact save(@RequestBody ContactRequest contactRequest) {
        return contactService.save(contactRequest);
    }

    /**
     * Return one updated contact
     *
     * @param contactRequest represent the body of request to update contact
     * @param id             represent a id of Contact
     * @return Contact save
     */
    @PutMapping("update/{id}")
    public Contact update(@RequestBody ContactRequest contactRequest, @PathVariable Long id) {
        return contactService.update(contactRequest, id);
    }

    /**
     * Return Ok if contact have been deleted
     *
     * @param id represent the id of contact to delete
     * @return Contact save
     */
    @DeleteMapping("delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        return contactService.delete(id);
    }
}
