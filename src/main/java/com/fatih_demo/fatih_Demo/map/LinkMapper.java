package com.fatih_demo.fatih_Demo.map;

import org.mapstruct.Mapper;



import com.fatih_demo.fatih_Demo.dto.LinkDto;
import com.fatih_demo.fatih_Demo.entity.Link;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LinkMapper {
    LinkMapper MAPPER = Mappers.getMapper(LinkMapper.class);
    @Mapping(source = "createdDate", target = "publishedDate")
    LinkDto mapToLinkDto(Link link);
    @Mapping(source = "publishedDate", target = "createdDate")
    Link mapToLink(LinkDto linkDto);
}

