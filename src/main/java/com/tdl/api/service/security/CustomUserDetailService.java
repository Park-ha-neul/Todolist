package com.tdl.api.service.security;

import com.tdl.api.advice.exception.CUserNotFoundException;
import com.tdl.api.common.CacheKey;
import com.tdl.api.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    @Cacheable(value = CacheKey.USER, key = "#userPk", unless = "#result == null")
    public UserDetails loadUserByUsername(String userPk) {
        return (UserDetails) userJpaRepo.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}