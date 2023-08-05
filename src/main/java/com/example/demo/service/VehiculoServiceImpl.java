package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.TO.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public List<VehiculoTO> buscarTodos() {
		// TODO Auto-generated method stub
	      List<Vehiculo> lista = this.iVehiculoRepository.buscarTodos();
	        List<VehiculoTO> ls = new ArrayList<>();
	        for (Vehiculo vehiculo : lista) {
	            ls.add(this.convertirTo(vehiculo));
	        }
	        return ls;
	}

	@Override
	public VehiculoTO consultarPorNumeroPlaca(String numero) {
		// TODO Auto-generated method stub
		
		return this.convertirTo(this.iVehiculoRepository.buscarPorNumeroPLaca(numero));
		
	}
	
	
	private VehiculoTO convertirTo(Vehiculo vehiculo) {
		
		VehiculoTO vehiculoTO= new VehiculoTO();
		vehiculoTO.setId(vehiculo.getId());
		vehiculoTO.setPlaca(vehiculo.getPlaca());
		vehiculoTO.setModelo(vehiculo.getModelo());
		vehiculoTO.setMarca(vehiculo.getMarca());
		vehiculoTO.setDescripcion(vehiculo.getDescripcion());
		
		return vehiculoTO;
	}
	


	
	 


	
}
