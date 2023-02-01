package com.example.flowpre_assignment.application.controller;

import com.example.flowpre_assignment.domain.dto.BlockFileExtensionDto;
import com.example.flowpre_assignment.domain.dto.CreateBlockExtensionForm;
import com.example.flowpre_assignment.domain.service.BlockFileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public void addBlockFileExtension(@RequestBody CreateBlockExtensionForm createBlockExtensionForm) {
        System.out.println("keyword: " + createBlockExtensionForm.getExtensionKeyword());
        blockFileExtensionService.addBlockFileExtension(createBlockExtensionForm.getExtensionKeyword());
    }

}
