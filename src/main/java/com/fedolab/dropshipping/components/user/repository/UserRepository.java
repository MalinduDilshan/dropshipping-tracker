package com.fedolab.dropshipping.components.user.repository;

import com.fedolab.dropshipping.components.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
