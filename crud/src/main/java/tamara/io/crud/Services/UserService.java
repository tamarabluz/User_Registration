package tamara.io.crud.Services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tamara.io.crud.Dtos.UserDto;
import tamara.io.crud.Models.UserModel;
import tamara.io.crud.Repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    public UserDto save(UserDto usuarioDto) {
        final var usuarioSalvo = userRepository.save(mapper.map(usuarioDto, UserModel.class));
        return mapper.map(usuarioSalvo, UserDto.class);
    }
}
