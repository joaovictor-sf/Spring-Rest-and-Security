package com.joaovictor.login.repository;

import com.joaovictor.login.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();
    // O JpaRepository vai criar o método findAllByActiveTrue() automaticamente
    // O JpaRepository é capaz de criar métodos, contando que sigam o padrão de nomenclatura do Spring Data JPA
}
