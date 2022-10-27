package com.mango.services;

import com.mango.dtos.UserDto;
import com.mango.exceptions.UserNotFoundRuntimeException;
import com.mango.mappers.UserMapper;
import com.mango.model.User;
import com.mango.repositories.SloganRepository;
import com.mango.repositories.UserRepository;
import com.mango.utils.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


	private final UserRepository userRepository;

    private final SloganRepository sloganRepository;

    @Override
    public List<UserDto> finalAll(){
        List<UserDto> usersDto =userRepository.findAll().stream()
                .map(user -> UserMapper.to(user))
                .collect(Collectors.toList());

        return usersDto;
    }

    @Override
    public UserDto findById(Long id){
        if (id==null){
            throw new IllegalArgumentException(Constantes.ID_PARAM_MAY_HAVE_A_VALUE);
        }
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()){
            return UserMapper.to(user.get());
        }
        else{
            throw new UserNotFoundRuntimeException(Constantes.USUARIO_NO_ENCONTRADO);
        }
    }

	@Override
	public UserDto findByUser(UserDto userDto) {
		if(userDto==null || StringUtils.isEmpty(userDto.getName())
			|| StringUtils.isEmpty(userDto.getLastName())
			|| StringUtils.isEmpty(userDto.getAddress())
			|| StringUtils.isEmpty(userDto.getEmail())) {

			throw new IllegalArgumentException(Constantes.NAME_LASTNAME_ADDRESS_CITY_EMAIL_MANDATORIES);
		}
		return UserMapper.to(userRepository.findByNameAndLastNameAndAddressAndCityAndEmail(userDto.getName(),userDto.getLastName(),userDto.getAddress(),userDto.getCity(),userDto.getEmail()));
	}

    @Override
    public UserDto create(UserDto userDto){
        if (userDto==null ||  userDto.getId()!=null){
            throw new IllegalArgumentException(Constantes.USER_DTO_ID_MAY_HAVE_A_NON_NULL_VALUE);
        }


        return UserMapper.to(userRepository.save(UserMapper.to(userDto)));

    }

    @Override
    public UserDto update(UserDto userDto){
        if (userDto==null ||  userDto.getId()==null){
            throw new IllegalArgumentException(Constantes.USER_DTO_ID_MAY_HAVE_A_NON_NULL_VALUE);
        }

        return UserMapper.to(userRepository.save(UserMapper.to(userDto)));

    }

    @Override
    public void deleteById(Long id){
        if (id==null){
            throw new IllegalArgumentException(Constantes.ID_PARAM_MAY_HAVE_A_VALUE);
        }
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()){
            optionalUser.get().getSlogans().stream().forEach(slogan->{
                sloganRepository.deleteById(slogan.getId());
            });
            userRepository.deleteById(id);
        }
        else{
            throw new UserNotFoundRuntimeException(Constantes.EL_USARIO_QUE_DESA_ELIMINAR_NO_EXISTE_EN_BBDD);
        }
    }


}
