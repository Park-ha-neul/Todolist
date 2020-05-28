package com.tdl.api.repo;

import com.tdl.api.web.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<User, Long> {

}
