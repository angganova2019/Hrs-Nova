package com.nova.hrs.services;

import com.nova.hrs.dao.UserRepository;
import com.nova.hrs.entity.MyUserDetails;
import com.nova.hrs.entity.Pengguna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Pengguna> user = userRepository.findByEmail(s);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));

        return user.map(MyUserDetails::new).get();
    }
}
