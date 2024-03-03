package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{   // User primary key "id" 의 type long 을 넣는다

    Optional<User> findByName(String name);

   // boolean existByName(String name);

    //long countByAge(Integer age);
}
