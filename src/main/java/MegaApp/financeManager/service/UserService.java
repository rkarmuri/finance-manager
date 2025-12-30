package MegaApp.financeManager.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import MegaApp.financeManager.repository.UserRepository;
import MegaApp.financeManager.entity.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    // Dependency Injection via constructor from UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user using Optional UserRepository methods
    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "User with this email already exists!";
        }
        
        userRepository.save(user);
        return "User registered successfully!";
    }

    // Fetch user details by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
