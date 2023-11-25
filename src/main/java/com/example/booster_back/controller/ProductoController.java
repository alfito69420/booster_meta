package com.example.booster_back.controller;

import com.example.booster_back.model.Producto;
import com.example.booster_back.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public List<Producto> getInventario() {
        return productoService.getProducto();
    } //close class

    @GetMapping("/getOne")
    public Producto getOneInventario(Producto producto) {
        return productoService.getOne(producto.getIdProducto());
    }

    @PutMapping("/insert")
    public String insert(Producto producto) {
        return productoService.newProducto(producto);
    }

    @PutMapping("/update")
    public String update(Producto producto) {
        return productoService.updateProducto(producto.getIdProducto(), producto);
    }

    @PutMapping("/delete")
    public String delete(Producto producto) {
        return productoService.eliminar(producto.getIdProducto());
    }
}
