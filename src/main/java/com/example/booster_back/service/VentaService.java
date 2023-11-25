package com.example.booster_back.service;

import com.example.booster_back.model.Venta;
import com.example.booster_back.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private VentaRepository ventaRepository;

    @Autowired
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> getVenta() {
        return this.ventaRepository.findAll();
    } //close method

    public Venta getOne(Long id) {
        return ventaRepository.findById(id).get();
    } //close method

    public String newVenta(Venta venta) {

        venta.setFecha(venta.getFecha());
        venta.setPrecioVenta(venta.getPrecioVenta());
        venta.setCantidadVenta(venta.getCantidadVenta());
        venta.setIdProducto(venta.getIdProducto());
        ventaRepository.save(venta);

        return "Se ha insertado el usuario";
    } //close method

    public String updateVenta(Long id, Venta venta) {

        if(id == venta.getIdVenta()) {

            venta.setIdVenta(venta.getIdVenta());
            venta.setPrecioVenta(venta.getPrecioVenta());
            venta.setCantidadVenta(venta.getCantidadVenta());
            venta.setIdProducto(venta.getIdProducto());
            ventaRepository.save(venta);
            return "Se actualizo";
        }
        return "No encontro usuario";
    } //close method

    public String eliminar(Long id) {
        this.ventaRepository.deleteById(id);
        return "Se ha eliminado la venta con el id:" + id;
    } //close method
}
