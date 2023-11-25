package com.example.booster_back.controller;

import com.example.booster_back.model.Inventario;
import com.example.booster_back.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    @Autowired
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/all")
    public List<Inventario> getInventario() {
        return inventarioService.getInventario();
    } //close class

    @GetMapping("/getOne")
    public Inventario getOneInventario(Inventario inventario) {
        return inventarioService.getOne(inventario.getIdInventario());
    }

    @PutMapping("/insert")
    public String insert(Inventario inventario) {
        return inventarioService.newInventario(inventario);
    }

    @PutMapping("/update")
    public String update(Inventario inventario) {
        return inventarioService.updateInventario(inventario.getIdInventario(), inventario);
    }

    @PutMapping("/delete")
    public String delete(Inventario inventario) {
        return inventarioService.eliminar(inventario.getIdInventario());
    }
}
