
package com.proyecto.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_producto")
    private long id_producto;
    private String descripcion;
    private String marca;
    private int precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    
    
    public Producto(String descripcion, boolean activo){
        this.activo=activo;
        this.descripcion=descripcion;
    }
    
    public Producto(){
        
    }
}
