package com.event.request;

import com.event.model.EnumGender;
import lombok.Data;

@Data
public class ContactRequest {
    private String name, last_name, email, phone, adresse, picture;
    private EnumGender gender;
    private Long user_id;
}
