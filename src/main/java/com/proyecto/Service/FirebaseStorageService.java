/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.Service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Daniel Lopez
 */
public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com#
    final String BucketName = "proyecto-13cd2.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "proyecto";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-85131-firebase-adminsdk-82j8z-808210e0d3";
}
