package com.shop.eShop.dto.cliente;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shop.eShop.entities.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toEntity(ClienteDTO clienteDTO);
    ClienteDTO toDTO(Cliente cliente);
}
