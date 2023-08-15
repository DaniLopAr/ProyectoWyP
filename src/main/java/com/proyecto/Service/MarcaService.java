/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.Service;

import com.proyecto.domain.Marca;
import java.util.List;


public interface MarcaService {
    
     // Se obtiene un listado de categorias en un List
    public List<Marca> getMarcas(boolean activos);
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public Marca getMarca(Marca marca);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Marca marca);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Marca marca);
}
