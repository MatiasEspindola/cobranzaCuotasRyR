package com.ryr.models.repo;

import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Categoria;

public interface I_Categoria_Repo extends CrudRepository<Categoria, Long>{

}
