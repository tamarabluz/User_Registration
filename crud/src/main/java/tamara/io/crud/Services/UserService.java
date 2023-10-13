package tamara.io.crud.Services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tamara.io.crud.Dtos.UserDto;
import tamara.io.crud.Models.UserModel;
import tamara.io.crud.Repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    public UserDto save(UserDto usuarioDto) {
        final var usuarioSalvo = userRepository.save(mapper.map(usuarioDto, UserModel.class));
        return mapper.map(usuarioSalvo, UserDto.class);
    }

    public List<UserDto> findAll(){
        if (userRepository.findAll().isEmpty()) throw new RuntimeException("Users not found");
        return userRepository.findAll().stream()
                .map(userModel -> mapper.map(userModel, UserDto.class))
                .toList();

    }


    public UserDto findById(Long id) {
        if (!userRepository.existsById(id)) throw new RuntimeException("User not found");
        return mapper.map(userRepository.findById(id), UserDto.class);
    }

    public UserDto update(UserDto userDto, Long id) {
        findById(id);
        userDto.setId(id);
        final var usuarioSalvo = userRepository.save(mapper.map(userDto, UserModel.class));
        return mapper.map(usuarioSalvo, UserDto.class);
    }

    public void delete(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
