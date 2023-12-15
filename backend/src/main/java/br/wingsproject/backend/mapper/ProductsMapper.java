package br.wingsproject.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.wingsproject.backend.domains.Products;
import br.wingsproject.backend.dtos.ProductsDTO;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
    ProductsDTO entityToDto(Products prods);

    List<ProductsDTO> listEntityToDto(List<Products> prods);

    @Mapping(target = "id", ignore = true)
    Products DtoToEntity(ProductsDTO dto);
}
