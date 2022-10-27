package com.mango.services;

import com.mango.dtos.SloganDto;
import com.mango.exceptions.SloganNotFoundRuntimeException;
import com.mango.exceptions.TooMuchSlogansRuntimeException;
import com.mango.exceptions.UserNotFoundRuntimeException;
import com.mango.mappers.SloganMapper;
import com.mango.model.Slogan;
import com.mango.model.User;
import com.mango.repositories.SloganRepository;
import com.mango.repositories.UserRepository;
import com.mango.utils.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SloganServiceImpl implements SloganService{

	private final SloganRepository sloganRepository;
    private final UserRepository userRepository;

    @Override
    public List<SloganDto> finalAll(){
        List<SloganDto> usersDto =sloganRepository.findAll().stream()
                .map(slogan -> SloganMapper.to(slogan))
                .collect(Collectors.toList());

        return usersDto;
    }

    @Override
    public SloganDto findById(Long id){
        if (id==null){
            throw new IllegalArgumentException(Constantes.ID_PARAM_MAY_HAVE_A_VALUE);
        }
        Optional<Slogan> slogan = sloganRepository.findById(id);

        if (slogan.isPresent()){
            return SloganMapper.to(slogan.get());
        }
        else{
            throw new SloganNotFoundRuntimeException(Constantes.ID_PARAM_MAY_HAVE_A_VALUE);
        }
    }

    @Override
    public SloganDto create(SloganDto sloganDto){
        if (sloganDto==null ||  sloganDto.getId()!=null){
            throw new IllegalArgumentException(Constantes.SLOGAN_DTO_GET_ID_TIENE_QUE_SER_DISTINTO_DE_NULO);
        }

        if (sloganDto.getUser()==null ||  sloganDto.getUser().getId() ==null){
            throw new IllegalArgumentException(Constantes.SLOGAN_DTO_USER_DTO_ID_HAS_NOT_TO_BE_NULL);
        }

        Optional<User> optionalUser = userRepository.findById(sloganDto.getUser().getId());

        if (optionalUser.isPresent()) {
            if (optionalUser.get().getSlogans().size() < Constantes.LIMIT_SLOGANS_PER_USER) {
                return SloganMapper.to(sloganRepository.save(SloganMapper.to(sloganDto)));
            } else {
                throw new TooMuchSlogansRuntimeException(Constantes.LIMIT_SLOGANS_HAS_BEEN_EXCEEDED);
            }
        }
        else{
            throw new UserNotFoundRuntimeException(Constantes.USUARIO_NO_ENCONTRADO);
        }

    }

    @Override
    public SloganDto update(SloganDto sloganDto) {
        if (sloganDto==null ||  sloganDto.getId()==null){
            throw new IllegalArgumentException(Constantes.SLOGAN_DTO_GET_ID_TIENE_QUE_SER_DISTINTO_DE_NULO);
        }

        if (sloganDto.getUser()==null ||  sloganDto.getUser().getId() ==null){
            throw new IllegalArgumentException(Constantes.SLOGAN_DTO_USER_DTO_ID_HAS_NOT_TO_BE_NULL);
        }

        return SloganMapper.to(sloganRepository.save(SloganMapper.to(sloganDto)));

    }

    @Override
    public void deleteById(Long id){
        if (id==null){
            throw new IllegalArgumentException(Constantes.ID_PARAM_MAY_HAVE_A_VALUE);
        }
        sloganRepository.deleteById(id);
    }
}
