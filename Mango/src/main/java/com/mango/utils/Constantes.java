package com.mango.utils;

public interface Constantes {
	public static final int LIMIT_SLOGANS_PER_USER = 3;

	public static final String SLOGAN_DTO_GET_ID_TIENE_QUE_SER_DISTINTO_DE_NULO = "sloganDto.getId() mut have a non null value ";
	public static final String EL_USARIO_QUE_DESA_ELIMINAR_NO_EXISTE_EN_BBDD = "The user doesn't exist at BBDD";
	public static final String ID_PARAM_MAY_HAVE_A_VALUE = "id param may have a value";
	public static final String USER_DTO_ID_MAY_HAVE_A_NON_NULL_VALUE = "userDto Id may have a non null value";
	public static final String USUARIO_NO_ENCONTRADO = "user not found";
	public static final String SLOGAN_DTO_USER_DTO_ID_HAS_NOT_TO_BE_NULL = "SloganDto->userDto->id has not to be null";
	public static final String LIMIT_SLOGANS_HAS_BEEN_EXCEEDED = "Limit slogans has been exceeded";
	public static final String NAME_LASTNAME_ADDRESS_CITY_EMAIL_MANDATORIES = "Name, lastName, address,city and email are mandatories";
}
