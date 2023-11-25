package com.example.booster_back.service;

import com.example.booster_back.model.Inventario;
import com.example.booster_back.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private InventarioRepository inventarioRepository;

    @Autowired
    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public List<Inventario> getInventario() {
        return this.inventarioRepository.findAll();
    } //close method

    public Inventario getOne(Long id) {
        return inventarioRepository.findById(id).get();
    } //close method

    public String newInventario(Inventario inventario) {

        inventario.setIdProducto(inventario.getIdProducto());
        inventario.setCantidadProducto(inventario.getCantidadProducto());
        inventarioRepository.save(inventario);

        return "Se ha insertado el usuario";
    } //close method

    public String updateInventario(Long id, Inventario inventario) {

        if (id == inventario.getIdInventario()) {

            inventario.setIdProducto(inventario.getIdProducto());
            inventario.setCantidadProducto(inventario.getCantidadProducto());
            inventarioRepository.save(inventario);
            return "Se ha actualizado";
        }

        return "No se ha actualizado";
    } //close method

    public String eliminar(Long id) {
        this.inventarioRepository.deleteById(id);
        return "Se ha eliminado la venta con el id:" + id;
    } //close method
}
