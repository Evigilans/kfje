package com.epam.service;

import com.epam.model.User;
import com.epam.model.dto.UserDto;
import com.epam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findUserById(long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());

        return userRepository.save(user);
    }

    public User updateUser(long userId, UserDto userDto) {
        User updatedUser = null;

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            updatedUser = optionalUser.get();
            updatedUser.setUsername(userDto.getUsername());
            updatedUser.setAmountOfPosts(userDto.getAmountOfPosts());
            updatedUser = userRepository.save(updatedUser);
        }

        return updatedUser;
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }
}
