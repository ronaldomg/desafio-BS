package br.com.bluesoft.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bluesoft.desafio.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, String> {
    
}