package br.wingsproject.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import br.wingsproject.backend.domains.Products;
import br.wingsproject.backend.dtos.ProductsDTO;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
	ProductsDTO entityToDto(Products prods);
	List<ProductsDTO> listEntityToDto(List<Products> prods);
	Products DtoToEntity(ProductsDTO dto);
}
