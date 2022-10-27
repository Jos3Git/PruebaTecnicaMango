package com.mango.model;

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

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "NAME")
	private String name;

	@NotBlank
	@Column (name = "LASTNAME")
	private String lastName;

	@NotBlank
	@Column (name = "ADDRESS")
	private String address;

	@NotBlank
	@Column (name = "CITY")
	private String city;

	@NotBlank
	@Column (name = "EMAIL")
	private String email;

	@OneToMany(mappedBy = "user")
	private List<Slogan> slogans= new ArrayList<Slogan>();

}
