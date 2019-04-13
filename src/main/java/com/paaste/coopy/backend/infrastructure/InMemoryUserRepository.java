package com.paaste.coopy.backend.infrastructure;

import com.paaste.coopy.backend.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository(value = "MockUserRepository")
public class InMemoryUserRepository implements UserRepository {

    private Map<Long, User> repository = new HashMap<>();

    @Override
    public User find(long id) {
        return repository.get(id);
    }

    @Override
    public User save(User user) {
        repository.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(User user) {
        Optional<User> currentUser = Optional.ofNullable(find(user.getId()));
        repository.put(user.getId(), user);
                return currentUser
                .orElse(user);
    }
}
