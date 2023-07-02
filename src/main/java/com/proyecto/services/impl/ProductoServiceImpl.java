
package com.proyecto.services.impl;

import com.proyecto.Service.ProductoService;
import com.proyecto.dao.ProductoDao;
import com.proyecto.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos){
        var lista= productoDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto){
        return productoDao.findById(producto.getId_producto()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Producto producto){
        productoDao.save(producto);
    }
    
    @Override
    @Transactional
    public void delete(Producto producto){
        productoDao.delete(producto);
    }
}
