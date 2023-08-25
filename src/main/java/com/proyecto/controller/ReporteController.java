/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;

import com.proyecto.Service.ReporteService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Daniel Lopez
 */
@Controller
@RequestMapping("/reportes")
public class ReporteController {
    
    
    @Autowired
    ReporteService reporteService;
    
    @GetMapping("/principal")
    public String principal(Model model){
        return "/reportes/principal";
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<Resource>  usuarios(@RequestParam String tipo) throws IOException{
        var reporte="Users";
                
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/ventas")
    public ResponseEntity<Resource>  ventas(@RequestParam String tipo) throws IOException{
        var reporte="ventasTR";
                
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/marcas")
    public ResponseEntity<Resource>  categorias(@RequestParam String tipo) throws IOException{
        var reporte="Marcas";
                
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    @GetMapping("/productos")
    public ResponseEntity<Resource>  productos(@RequestParam String tipo) throws IOException{
        var reporte="productosTR";
                
        return reporteService.generaReporte(reporte, null, tipo);
    }
    
    
    
}
