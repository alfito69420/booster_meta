package com.example.booster_back.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Table
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    private String fecha;
    private double precioVenta;
    private double cantidadVenta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto idProducto;


}
