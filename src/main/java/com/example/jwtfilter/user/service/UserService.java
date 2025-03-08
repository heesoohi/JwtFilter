package com.example.jwtfilter.user.service;

import com.example.jwtfilter.user.dto.UserResponse;
import com.example.jwtfilter.user.entity.User;
import com.example.jwtfilter.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        return new UserResponse(user.getId(), user.getEmail());
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getEmail()))
                .toList();
    }
}
