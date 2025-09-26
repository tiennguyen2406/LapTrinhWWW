package iuh.fit.se.dao;

import iuh.fit.se.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    Product findById(String id);
}
