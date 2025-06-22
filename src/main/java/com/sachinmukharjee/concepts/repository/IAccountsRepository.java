package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.Accounts;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountsRepository extends JpaRepository<Accounts,Integer> {


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM Accounts a WHERE a.id = :id")
    Accounts findByIdForUpdate(@Param("id") Long id);
}
