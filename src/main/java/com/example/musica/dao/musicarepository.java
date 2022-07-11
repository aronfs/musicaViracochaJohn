/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.musica.dao;

import com.example.musica.model.Musica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author arons
 */
public interface musicarepository extends JpaRepository<Musica, Integer>{
    
    @Override
    List<Musica> findAll();
    
}
