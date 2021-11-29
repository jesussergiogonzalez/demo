package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.products.Productos;

public interface ProductosDAO extends JpaRepository<Productos, Long>{

}
