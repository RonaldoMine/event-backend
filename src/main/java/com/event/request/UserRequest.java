package com.event.request;

import lombok.Data;

@Data
public class UserRequest {
    private String name, last_name, email, phone, password;
}
