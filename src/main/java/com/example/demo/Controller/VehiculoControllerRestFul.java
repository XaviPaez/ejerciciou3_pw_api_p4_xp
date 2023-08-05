package com.example.demo.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVehiculoService;
import com.example.demo.service.TO.VehiculoTO;
@RestController
@RequestMapping(path = "/vehiculos")
public class VehiculoControllerRestFul {
	

		@Autowired
		private IVehiculoService iVehiculoService;
		
		
	    public ResponseEntity<List<VehiculoTO>> buscarTodos(){
	        List<VehiculoTO> lista=this.iVehiculoService.buscarTodos();
	        for (VehiculoTO vehiculoTO : lista) {
	            Link myLink = linkTo(methodOn(VehiculoControllerRestFul.class).consultarPorNumero(vehiculoTO.getPlaca()))
	                    .withSelfRel();
	            vehiculoTO.add(myLink);
	        }

	        return new ResponseEntity<>(lista, null, 200);
	    }

	    @GetMapping(path = "/{placa}")
	    public ResponseEntity<VehiculoTO> consultarPorNumero(@PathVariable String placa){
	        VehiculoTO vehiculo = this.iVehiculoService.consultarPorNumeroPlaca(placa);
	        return new ResponseEntity<>(vehiculo, null, 200);
	    }

	 

	}

		

	


