package com.ecommerce.library.repository;

import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p")
    Page<ProductDto> pageProduct(Pageable pageable);
    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    Page<ProductDto> searchProducts(String keyword, Pageable pageable);
    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    List<Product> searchProductsList(String keyword);
}
