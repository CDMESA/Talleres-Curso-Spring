package com.organizacion.software.t1;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioCliente extends CrudRepository<Cliente, Long> {
    List<Cliente> findByLastName(String lastName);
    Cliente findById(long id);
}
