/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;
import com.proyecto.Service.FirebaseStorageService;


import com.proyecto.Service.MarcaService;
import com.proyecto.domain.Marca;
import com.proyecto.services.impl.FirebaseStorageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/marca")
public class MarcaController {
    
    @Autowired
    public MarcaService marcaService;
    
    
    @GetMapping("/listado")
    public String listado(Model model){
        var marcas = marcaService.getMarcas(false);
        model.addAttribute("marcas", marcas);
        model.addAttribute("totalmarcas",marcas.size());
        return "marca/listado";
    }
    
    @GetMapping("/nuevo")
    public String marcaNuevo(Marca marca){
        return "/marca/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    
    
    
    
    
    
    @PostMapping("/guardar")
    public String marcaGuardar(Marca marca, @RequestParam("imagenFile") MultipartFile imagenFile){
        if(!imagenFile.isEmpty()){
            marcaService.save(marca);
            marca.setRuta_imagen(
                firebaseStorageService.cargaImagen(
                imagenFile,
                        "categoria",
                        marca.getId_marca()));
            
        }
        marcaService.save(marca);
        return "redirect:/marca/listado";
        
    }
    
    
    
    @GetMapping("/eliminar/{id_marca}")
    public String marcaEliminar(Marca marca){
        marcaService.delete(marca);
        return "redirect:/marca/listado";
    }
    
    @GetMapping("/modificar/{id_marca}")
    public String marcaModificar (Marca marca, Model model){
        marca=marcaService.getMarca(marca);
        model.addAttribute("marca", marca);
        return "/marca/modifica";
    }
    
    
    
}
