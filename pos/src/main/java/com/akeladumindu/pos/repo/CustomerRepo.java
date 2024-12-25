package com.akeladumindu.pos.repo;


import com.akeladumindu.pos.entitiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    public Optional<Customer> findByPublicId(long id);
    public Optional<Customer> deleteByPublicId(long id);
}
