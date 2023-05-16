package com.saulusribeiro.controlepedidos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saulusribeiro.controlepedidos.domain.Cliente;
import com.saulusribeiro.controlepedidos.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	@Autowired
	private  ClienteService ClienteService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		
		Cliente obj = ClienteService.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
