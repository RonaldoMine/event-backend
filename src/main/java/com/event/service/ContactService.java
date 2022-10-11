package com.event.service;

import com.event.model.Contact;
import com.event.model.User;
import com.event.repository.ContactRepository;
import com.event.repository.UserRepository;
import com.event.request.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    /**
     * List Contact by enterprise
     *
     * @param enterprise_id id of enterprise
     * @return Contact
     */
    public List<Contact> getContacts(Long enterprise_id) {
        return contactRepository.findAllByEnterpriseId(enterprise_id);
    }

    /**
     * Save Contact
     *
     * @param contactRequest data of contact
     * @return Contact
     */
    public Contact save(ContactRequest contactRequest) {
        Contact contact = new Contact();
        User user = userRepository.findById(contactRequest.getUser_id()).get();
        contact.setName(contactRequest.getName());
        contact.setLast_name(contactRequest.getLast_name());
        contact.setEmail(contactRequest.getEmail());
        contact.setPhone(contactRequest.getPhone());
        contact.setEnterprise(user.getEnterprise());
        contact.setAdresse(contactRequest.getAdresse());
        contact.setPicture(contactRequest.getPicture());
        contact.setUser(user);
        contact.setGender(contactRequest.getGender());
        return contactRepository.save(contact);
    }

    /**
     * Update Contact
     *
     * @param id             of contact
     * @param contactRequest data of contact
     * @return Contact
     */
    public Contact update(ContactRequest contactRequest, Long id) {
        User user = userRepository.findById(contactRequest.getUser_id()).get();
        Contact contact = contactRepository.findById(id).get();
        contact.setName(contactRequest.getName());
        contact.setLast_name(contactRequest.getLast_name());
        contact.setEmail(contactRequest.getEmail());
        contact.setPhone(contactRequest.getPhone());
        contact.setEnterprise(user.getEnterprise());
        contact.setAdresse(contactRequest.getAdresse());
        contact.setPicture(contactRequest.getPicture());
        contact.setGender(contactRequest.getGender());
        return contactRepository.save(contact);
    }

    /**
     * Delete Contact
     *
     * @param id of contact
     * @return HttpStatus
     */
    public HttpStatus delete(Long id) {
        contactRepository.delete(contactRepository.findById(id).get());
        return HttpStatus.OK;
    }
}
