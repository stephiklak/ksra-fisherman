package com.ksra.fisherman.dto;

import com.ksra.fisherman.model.User;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private User.Role role;
}
