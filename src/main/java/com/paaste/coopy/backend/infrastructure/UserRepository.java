package com.paaste.coopy.backend.infrastructure;

import com.paaste.coopy.backend.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User find(long id);
    User save(User user);
    User update(User user);
}
