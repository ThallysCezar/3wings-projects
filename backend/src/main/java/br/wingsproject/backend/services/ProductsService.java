package br.wingsproject.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.wingsproject.backend.domains.Products;
import br.wingsproject.backend.dtos.ProductsDTO;
import br.wingsproject.backend.exceptions.RecordNotFoundException;
import br.wingsproject.backend.mappers.ProductsMapper;
import br.wingsproject.backend.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
	
	private final ProductsRepository repo;
	private final ProductsMapper mapper;
	
	//Listar Todos
	public List<ProductsDTO> getAll() {
	    List<Products> productsList = repo.findAll();
	    return mapper.listEntityToDto(productsList);
	}
	
	//Listar por ID
	public ProductsDTO getById(Long id){
		Products prods = repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
		return mapper.entityToDto(prods);
	}
	
	//Adicionar um novo livro
	public ProductsDTO createBook(ProductsDTO dto){
		Products prods = mapper.DtoToEntity(dto);
		return mapper.entityToDto(repo.save(prods));
	}
	
	//Atualizar um livro existente
	public ProductsDTO updateBook(Long id, ProductsDTO dto){	
		Products existingProds = repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
		
		Products upBook = mapper.DtoToEntity(dto);
		upBook.setId(existingProds.getId());
		return mapper.entityToDto(repo.save(upBook));
	}
	
	//Remover um livro
	public void removeBook(Long id){	
		repo.delete(repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
	}

}
