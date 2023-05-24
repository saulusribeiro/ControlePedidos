package com.saulusribeiro.controlepedidos.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saulusribeiro.controlepedidos.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	

}
