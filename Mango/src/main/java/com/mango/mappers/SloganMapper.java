package com.mango.mappers;


import com.mango.dtos.SloganDto;
import com.mango.model.Slogan;

public interface SloganMapper {


    static SloganDto to(Slogan ent) {
		if (ent!=null) {
			return SloganDto.builder()
				.id(ent.getId())
				.sloganText(ent.getSloganText())
				.build();
		}
		return null;
    }

    static Slogan to(SloganDto dto) {
		if(dto!=null) {
			return Slogan.builder()
				.id(dto.getId())
				.sloganText(dto.getSloganText())
				.user(UserMapper.to(dto.getUser()))
				.build();
		}
		return null;
    }
}
