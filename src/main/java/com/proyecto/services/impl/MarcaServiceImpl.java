
package com.proyecto.services.impl;

import com.proyecto.Service.MarcaService;
import com.proyecto.dao.MarcaDao;
import com.proyecto.domain.Marca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarcaServiceImpl implements MarcaService{
    
    @Autowired
    private MarcaDao marcaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Marca> getMarcas(boolean activos){
        var lista= marcaDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Marca getMarca(Marca marca){
        return marcaDao.findById(marca.getId_marca()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Marca marca){
        marcaDao.save(marca);
    }
    
    @Override
    @Transactional
    public void delete(Marca marca){
        marcaDao.delete(marca);
    }
}
