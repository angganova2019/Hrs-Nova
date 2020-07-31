package com.nova.hrs.entity;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String token;
    private boolean email_verified;
    private LocalDateTime timestamps;
}
