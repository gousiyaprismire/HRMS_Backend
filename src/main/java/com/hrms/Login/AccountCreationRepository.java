package com.hrms.Login;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface AccountCreationRepository extends JpaRepository<AccountCreationEntity, Long> {

 Optional<AccountCreationEntity> findByEmailAndPassword(String email, String password);

 boolean existsByEmail(String email);

	Optional<AccountCreationEntity> findByEmail(String email);

}

