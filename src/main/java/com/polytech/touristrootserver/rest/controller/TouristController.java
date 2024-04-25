package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.domain.Tourist;
import com.polytech.touristrootserver.exception.TouristAlreadyExists;
import com.polytech.touristrootserver.exception.TouristNotFound;
import com.polytech.touristrootserver.rest.dto.TouristDto;
import com.polytech.touristrootserver.service.TouristService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TouristController {

    private final TouristService touristService;

    @GetMapping("/tourist/login")
    public TouristDto login(@RequestParam String email, @RequestParam String password) {
        System.out.println("======== login ========");
        return TouristDto.toDto(touristService.login(email, password));
    }

    @PostMapping("/tourist/register")
    public TouristDto register(@RequestBody TouristDto touristDto) {
        return TouristDto.toDto(touristService.register(TouristDto.fromDto(touristDto)));
    }

    @PutMapping("/tourist/update")
    public TouristDto update(@RequestBody TouristDto touristDto) {
        return TouristDto.toDto(touristService.update(TouristDto.fromDto(touristDto)));
    }

    @PatchMapping("/tourist/update/password/{id}")
    public TouristDto updatePassword(@PathParam (value = "id") long id, @RequestParam (value = "password") String password) {
        return TouristDto.toDto(touristService.updatePassword(password, id));
    }
    @ExceptionHandler({TouristNotFound.class, TouristAlreadyExists.class})
    public ResponseEntity<String> handlerBookException(Exception e){
        System.out.println(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
