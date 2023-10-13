package tamara.io.crud.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tamara.io.crud.Dtos.UserDto;
import tamara.io.crud.Services.UserService;

import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("register")
public class UserController {

    public static final String ID = "/{id}";    private final UserService userService;
    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto userDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userService.save(userDto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(produces="application/json")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(value = ID, produces="application/json")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }
}
