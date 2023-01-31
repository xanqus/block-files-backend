package com.example.flowpre_assignment.application.controller;

import com.example.flowpre_assignment.domain.dto.CreateBlockExtensionForm;
import com.example.flowpre_assignment.domain.service.BlockFileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/block-file-extension")
public class BlockFileExtensionController {

    private final BlockFileExtensionService blockFileExtensionService;

    @PostMapping("")
    public void addBlockFileExtension(@RequestBody CreateBlockExtensionForm createBlockExtensionForm) {
        blockFileExtensionService.addBlockFileExtension(createBlockExtensionForm.getExtensionName());
    }

}
