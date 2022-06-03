package com.innso.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innso.test.entity.DossierClient;
import org.springframework.data.repository.CrudRepository;

public interface DossierClientRepository extends JpaRepository<DossierClient, Long> {

}
