/**
 * 
 */
package com.intellect.igh.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lakshmipriya.ramesh
 *
 */

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(String assoId);
}
