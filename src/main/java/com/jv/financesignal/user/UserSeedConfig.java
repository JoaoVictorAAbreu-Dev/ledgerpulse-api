package com.jv.financesignal.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserSeedConfig {
  @Bean
  CommandLineRunner seedDefaultUser(UserRepository repository, PasswordEncoder passwordEncoder) {
    return args -> {
      if (repository.findByEmail("demo@ledgerpulse.dev").isEmpty()) {
        var user = new AppUser();
        user.setEmail("demo@ledgerpulse.dev");
        user.setPasswordHash(passwordEncoder.encode("ledger123"));
        repository.save(user);
      }
    };
  }
}
