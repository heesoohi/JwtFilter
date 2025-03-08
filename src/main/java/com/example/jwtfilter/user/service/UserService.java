package com.example.jwtfilter.user.service;

import com.example.jwtfilter.user.dto.UserResponse;
import com.example.jwtfilter.user.entity.User;
import com.example.jwtfilter.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse save(String email) {

        if (userRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 가입된 이메일입니둥~");
        }

        User user = new User(email);
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getEmail());
    }
}
