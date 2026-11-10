package com.alter.tienda.service;

import com.alter.tienda.model.Categoria;
import com.alter.tienda.repository.CategoriaRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository r) {
        this.categoriaRepository = r;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerCategoria(Integer id) {
        return categoriaRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada"));
    }

    public Categoria crearCategoria(Categoria categoria) {
        validarCategoria(categoria);
        categoria.setIdCategorias(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Integer id, Categoria categoria) {
        validarCategoria(categoria);
        Categoria existente = obtenerCategoria(id);
        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());
        return categoriaRepository.save(existente);
    }

    public void eliminarCategoria(Integer id) {
        categoriaRepository.delete(obtenerCategoria(id));
    }

    private void validarCategoria(Categoria categoria) {
        if (categoria == null || categoria.getNombre() == null || categoria.getNombre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de la categoría es obligatorio");
        }
        categoria.setNombre(categoria.getNombre().trim());
    }
} 
