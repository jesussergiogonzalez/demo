package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.ProductosDAO;
import com.example.demo.products.Productos;


@RestController
@RequestMapping("/")
public class ProductsRest {

	@Autowired
	private ProductosDAO productosDao ;
	
	@GetMapping
	public String Hello() {
		var Mensaje="";
	
		Mensaje =  "<br>" + "<br>"
				+ "Este es un ejemplo de uso de las aplicaciones API-REST " + "<br>" + "<br>" + "<br>"
				+ "Para acceder a la lista de productos usar esta liga: " + "<a href=\"../productos\">Listado de Productos</a>"
				+ "";
		
		return Mensaje;		
	}
	
	@GetMapping("productos")
	public ResponseEntity<List<Productos>> GetProductos()
	{
		List<Productos> Prod = productosDao.findAll();
		return ResponseEntity.ok(Prod);
	}
	
	@RequestMapping( value="{IdProduct}")
	public ResponseEntity<Productos> GetProductosXID(@PathVariable("IdProduct") Long IDProd )
	{
		Optional<Productos> OPTProd= productosDao.findById(IDProd);
		
		if ( OPTProd.isPresent()){
			return ResponseEntity.ok(OPTProd.get());
		}
		else
		{
			return ResponseEntity.notFound().build();	
		}		
	}
	
	@PostMapping
	public ResponseEntity<Productos> AddProducto(@RequestBody Productos Prod){
			Productos NuevoProducto = productosDao.save(Prod);
			return ResponseEntity.ok(NuevoProducto);
			
	}
	
}
