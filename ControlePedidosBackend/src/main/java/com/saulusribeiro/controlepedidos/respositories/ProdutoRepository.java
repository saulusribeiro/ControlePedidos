package com.saulusribeiro.controlepedidos.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saulusribeiro.controlepedidos.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	

}
