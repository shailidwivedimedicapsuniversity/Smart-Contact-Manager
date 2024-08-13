package com.scm.repositories;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
// extra methods database related operations
// custom query methods
// custom finder methods
Optional<User> findByEmail(String email);
Optional<User> findByEmailAndPassword(String email, String password);

}
