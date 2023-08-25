
package com.proyecto.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="marca")
public class Marca implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_marca")
    private long id_marca;
    private String descripcion;
    private String ruta_imagen;
    private boolean activo;
    
    
    
    public Marca(String descripcion, boolean activo){
        this.activo=activo;
        this.descripcion=descripcion;
    }
    
    public Marca(){
        
    }
}
