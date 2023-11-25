package com.example.booster_back.controller;

import com.example.booster_back.model.Venta;
import com.example.booster_back.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/venta")
public class VentaController {

    private final VentaService ventaService;

    @Autowired
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping("/all")
    public List<Venta> getInventario() {
        return ventaService.getVenta();
    } //close class

    @GetMapping("/getOne")
    public Venta getOneInventario(Venta venta) {
        return ventaService.getOne(venta.getIdVenta());
    }

    @PutMapping("/insert")
    public String insert(Venta venta) {
        return ventaService.newVenta(venta);
    }

    @PutMapping("/update")
    public String update(Venta venta) {
        return ventaService.updateVenta(venta.getIdVenta(), venta);
    }

    @PutMapping("/delete")
    public String delete(Venta venta) {
        return ventaService.eliminar(venta.getIdVenta());
    }
}
