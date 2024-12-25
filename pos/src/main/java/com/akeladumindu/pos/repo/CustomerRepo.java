package com.akeladumindu.pos.repo;


import com.akeladumindu.pos.entitiy.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    public Optional<Customer> findByPublicId(long id);
    public Optional<Customer> deleteByPublicId(long id);

    @Query(value = "SELECT * FROM customer WHERE name LIKE %?1% OR address LIKE %?1%", nativeQuery = true)
    Page<Customer> searchAllByAddressOrName(String searchText, PageRequest pageable);

}
