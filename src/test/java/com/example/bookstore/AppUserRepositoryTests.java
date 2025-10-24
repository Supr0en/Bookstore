package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.example.bookstore.domain.AppUser;
import com.example.bookstore.domain.AppUserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AppUserRepositoryTests {
   @Autowired
   private AppUserRepository appUserRepository;

   @Test
    public void createAndFindNewAppUser() { // test for adding new User and find user by username
       AppUser appUser = new AppUser("Testi Terhaaja", "test", "testaajan@gmail.com", "ADMIN");
       appUserRepository.save(appUser);
       assertThat(appUserRepository.findByUsername("Testi Terhaaja")).isNotNull();
       appUserRepository.delete(appUser);
   }
   @Test
    public void createAndDeleteAppUser() {
       AppUser appUser = new AppUser("Testi Terhaaja", "test", "testaajan@gmail.com", "ADMIN");
       appUserRepository.save(appUser);

       appUserRepository.delete(appUser);
       assertFalse(appUserRepository.existsById(appUser.getId()));
   }
}
