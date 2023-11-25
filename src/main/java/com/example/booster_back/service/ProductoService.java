package com.example.booster_back.service;

import com.example.booster_back.model.Producto;
import com.example.booster_back.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProducto() {
        return this.productoRepository.findAll();
    } //close method

    public Producto getOne(Long id) {
        return productoRepository.findById(id).get();
    } //close method

    public String newProducto(Producto producto) {

        producto.setNombre(producto.getNombre());
        producto.setDescripcion(producto.getDescripcion());
        producto.setPrecio(producto.getPrecio());
        productoRepository.save(producto);

        return "Se ha insertado el usuario";
    } //close method

    public String updateProducto(Long id, Producto producto) {

        if (id == producto.getIdProducto()) {

            producto.setNombre(producto.getNombre());
            producto.setDescripcion(producto.getDescripcion());
            producto.setPrecio(producto.getPrecio());
            productoRepository.save(producto);
            return "Se ha actualizado";
        }

        return "No se ha actualizado";
    } //close method

    public String eliminar(Long id) {
        this.productoRepository.deleteById(id);
        return "Se ha eliminado la venta con el id:" + id;
    } //close method
}
