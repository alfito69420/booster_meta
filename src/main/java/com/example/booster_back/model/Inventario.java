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
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;

    private int cantidadProducto;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto idProducto;

}
