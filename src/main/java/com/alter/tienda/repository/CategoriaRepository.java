package com.alter.tienda.repository;

import com.alter.tienda.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    List<Categoria> findByNombre(String texto);
    
}
