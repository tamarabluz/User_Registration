package tamara.io.crud.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tamara.io.crud.Dtos.UserDto;
import tamara.io.crud.Services.UserService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("register")
public class UserController {

    private final UserService userService;
    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto userDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userService.save(userDto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
