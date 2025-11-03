package com.example.programming_mobile_device_be.configuration;

import com.example.programming_mobile_device_be.entity.Role;
import com.example.programming_mobile_device_be.entity.User;
import com.example.programming_mobile_device_be.enums.Gender;
import com.example.programming_mobile_device_be.enums.RoleName;
import com.example.programming_mobile_device_be.repository.RoleRepository;
import com.example.programming_mobile_device_be.repository.UserRespository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ApplicationInitConfig {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRespository userRepository;

    @Bean
    @Transactional
    ApplicationRunner init() {
        return args -> {
            // 1️⃣ Tạo các role mặc định
            for (RoleName roleName : RoleName.values()) {
                roleRepository.findByName(roleName)
                        .orElseGet(() -> {
                            Role newRole = Role.builder()
                                    .name(roleName)
                                    .description("Default role: " + roleName)
                                    .build();
                            roleRepository.save(newRole);
                            log.info("✅ Created role: {}", roleName);
                            return newRole;
                        });
            }

            // 2️⃣ ADMIN
            Role adminRole = roleRepository.findByName(RoleName.ADMIN).orElseThrow();
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = User.builder()
                        .username("admin")
                        .email("admin@musicapp.com")
                        .password(passwordEncoder.encode("123456789"))
                        .gender(Gender.MALE)
                        .createdAt(LocalDateTime.now())
                        .roles(Set.of(adminRole))
                        .build();
                userRepository.save(admin);
                log.info("👑 Admin user created");
            }

            // 3️⃣ Nghệ sĩ (ARTIST)
            Role artistRole = roleRepository.findByName(RoleName.ARTIST).orElseThrow();
            List<String> artists = List.of("sontungmtp", "hoangdung", "min", "amee", "erik");

            for (String artistName : artists) {
                if (userRepository.findByUsername(artistName).isEmpty()) {
                    User artist = User.builder()
                            .username(artistName)
                            .email(artistName + "@musicapp.com")
                            .password(passwordEncoder.encode("123456789"))
                            .gender(Gender.MALE)
                            .createdAt(LocalDateTime.now())
                            .roles(Set.of(artistRole))
                            .build();
                    userRepository.save(artist);
                    log.info("🎤 Created artist: {}", artistName);
                }
            }

            // 4️⃣ Người dùng bình thường (USER)
            Role userRole = roleRepository.findByName(RoleName.USER).orElseThrow();
            for (int i = 1; i <= 10; i++) {
                String username = "user" + i;
                if (userRepository.findByUsername(username).isEmpty()) {
                    User normalUser = User.builder()
                            .username(username)
                            .email(username + "@musicapp.com")
                            .password(passwordEncoder.encode("123456789"))
                            .gender(i % 2 == 0 ? Gender.FEMALE : Gender.MALE)
                            .createdAt(LocalDateTime.now())
                            .roles(Set.of(userRole))
                            .build();
                    userRepository.save(normalUser);
                    log.info("🎧 Created normal user: {}", username);
                }
            }
        };
    }
}
