package com.polytech.touristrootserver.rest.controller;

import com.polytech.touristrootserver.exception.EntryNotFound;
import com.polytech.touristrootserver.rest.dto.EntryDto;
import com.polytech.touristrootserver.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EntryController {

    private final EntryService entryService;

    @GetMapping("/entry/tourist/{id}")
    public List<EntryDto> getEntriesByTouristId(@PathVariable(name = "id") long id) {
        return entryService.findEntriesByTouristId(id).stream().map(EntryDto::toDto).toList();
    }

    @PostMapping("/entry/insert")
    public EntryDto insert(@RequestBody EntryDto entryDto) {
        return EntryDto.toDto(entryService.insert(EntryDto.fromDto(entryDto)));
    }

    @PutMapping("/entry/update")
    public EntryDto update(@RequestBody EntryDto entryDto) {
        return EntryDto.toDto(entryService.updateStatus(EntryDto.fromDto(entryDto)));
    }

    @DeleteMapping("/entry/delete/{id}")
    public void deleteById(@PathVariable(name = "id") long id) {
        entryService.deleteById(id);
    }

    @ExceptionHandler({EntryNotFound.class})
    public ResponseEntity<String> handlerBookException(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
