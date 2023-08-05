package com.example.demo.service;

import java.util.List;

import com.example.demo.service.TO.VehiculoTO;

public interface IVehiculoService {

	
	public List<VehiculoTO> buscarTodos();
	public VehiculoTO consultarPorNumeroPlaca(String numero);
}
