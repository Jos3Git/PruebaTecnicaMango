package com.mango.dtos;

import com.mango.model.Slogan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

	private Long id;

	private String name;


	private String lastName;


	private String address;

	private String city;


	private String email;

	private List<SloganDto> slogans= new ArrayList<SloganDto>();

}
