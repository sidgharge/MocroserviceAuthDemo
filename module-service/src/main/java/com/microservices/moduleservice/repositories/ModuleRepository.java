package com.microservices.moduleservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.moduleservice.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	Module findByUser(String username);

}
