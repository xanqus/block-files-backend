package com.example.flowpre_assignment.application.controller;

import com.example.flowpre_assignment.domain.dto.BlockFileExtensionDto;
import com.example.flowpre_assignment.domain.dto.CreateBlockExtensionForm;
import com.example.flowpre_assignment.domain.service.BlockFileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/block-file-extension")
public class BlockFileExtensionController {

    private final BlockFileExtensionService blockFileExtensionService;

    @GetMapping("")
    public List<BlockFileExtensionDto> getAllBlockFileExtensions() {
        return blockFileExtensionService.getAllBlockFileExtension();
    }

    @PostMapping("")
    public void addBlockFileExtension(@Valid @RequestBody CreateBlockExtensionForm createBlockExtensionForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        blockFileExtensionService.addBlockFileExtension(createBlockExtensionForm.getExtensionKeyword());
    }

    @PostMapping("/toggle")
    public void toggleBlockFileExtension(@RequestBody CreateBlockExtensionForm createBlockExtensionForm) {
        blockFileExtensionService.toggleBlockFileExtension(createBlockExtensionForm.getExtensionKeyword());
    }

    @DeleteMapping("/{id}")
    public void deleteBlockFileExtensionById(@PathVariable Long id) {
        blockFileExtensionService.deleteBlockFileExtensionById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllBlockFileExtensions() {
        blockFileExtensionService.deleteAllBlockFileExtensions();
    }

}
