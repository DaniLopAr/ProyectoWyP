/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;
import com.proyecto.Service.FirebaseStorageService;


import com.proyecto.Service.ProductoService;
import com.proyecto.domain.Producto;
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
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    public ProductoService productoService;
    
    
    @GetMapping("/listado")
    public String listado(Model model){
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalproductos",productos.size());
        return "producto/listado";
    }
    
    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto){
        return "/producto/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    
    
    
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile){
        if(!imagenFile.isEmpty()){
            productoService.save(producto);
            producto.setImagen(
                firebaseStorageService.cargaImagen(
                imagenFile,
                        "categoria",
                        producto.getId_producto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
        
    }
    
    
    
    @GetMapping("/eliminar/{id_producto}")
    public String productoEliminar(Producto producto){
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/modificar/{id_producto}")
    public String productoModificar (Producto producto, Model model){
        producto=productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }
    
    
    
}
