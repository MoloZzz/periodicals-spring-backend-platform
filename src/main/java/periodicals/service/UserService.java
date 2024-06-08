package periodicals.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import periodicals.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Business logic methods
}
