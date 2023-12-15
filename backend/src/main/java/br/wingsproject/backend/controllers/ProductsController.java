package br.wingsproject.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.wingsproject.backend.dtos.ProductsDTO;
import br.wingsproject.backend.services.ProductsService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("books")
@AllArgsConstructor
public class ProductsController {
	
	private final ProductsService service;

	@GetMapping
	public List<ProductsDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductsDTO getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductsDTO createBook(@RequestBody ProductsDTO dto) {
		return service.createBook(dto);
	}
	
	@PutMapping("/{id}")
	public ProductsDTO updateBook(@PathVariable Long id, ProductsDTO dto) {
		return service.updateBook(id, dto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeBook(@PathVariable Long id) {
		service.removeBook(id);
	}
}
