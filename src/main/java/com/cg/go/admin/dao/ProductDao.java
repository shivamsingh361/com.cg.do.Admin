package com.cg.go.admin.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.admin.dto.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, String> {

}
