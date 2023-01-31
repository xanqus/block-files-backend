package com.example.flowpre_assignment.domain.service;

import com.example.flowpre_assignment.domain.entity.BlockFileExtension;
import com.example.flowpre_assignment.domain.repository.BlockFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BlockFileExtensionService {

    private final BlockFileExtensionRepository blockFileExtensionRepository;
    public void addBlockFileExtension(String extensionName) {

        BlockFileExtension blockFileExtension = BlockFileExtension
                .builder()
                .extensionName(extensionName)
                .createdAt(LocalDateTime.now())
                .build();

        blockFileExtensionRepository.save(blockFileExtension);

    }
}
