package com.convo.models;

import com.convo.models.dto.TextMessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TextMessageDtoMapper {

    TextMessageDtoMapper INSTANCE = Mappers.getMapper(TextMessageDtoMapper.class);

    @Mapping(target = "text", source = "text")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "status", source = "textstatus")
    TextMessage textMessageDtoToTextMessage(TextMessageDto textMessageDto);

    @Mapping(target = "text", source = "text")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "status", source = "textstatus")
    TextMessageDto textMessageToTextMessageoDto(TextMessage textMessage);

}
