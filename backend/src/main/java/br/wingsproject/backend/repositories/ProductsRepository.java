package br.wingsproject.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.wingsproject.backend.domains.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
}
