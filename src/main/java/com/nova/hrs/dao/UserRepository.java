package com.nova.hrs.dao;

import com.nova.hrs.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Pengguna, String> {
    Optional<Pengguna> findByEmail(String userName);
}
