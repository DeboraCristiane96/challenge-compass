package com.css.challenge.presentation.dto;

import com.css.challenge.model.user.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
}
