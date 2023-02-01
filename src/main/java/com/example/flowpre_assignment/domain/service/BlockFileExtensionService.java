package com.example.flowpre_assignment.domain.service;

import com.example.flowpre_assignment.domain.dto.BlockFileExtensionDto;
import com.example.flowpre_assignment.domain.entity.BlockFileExtension;
import com.example.flowpre_assignment.domain.repository.BlockFileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockFileExtensionService {

    private final BlockFileExtensionRepository blockFileExtensionRepository;

    public List<BlockFileExtensionDto> getAllBlockFileExtension() {
        return blockFileExtensionRepository
                .findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }
    public void addBlockFileExtension(String extensionName) {

        BlockFileExtension blockFileExtension = BlockFileExtension
                .builder()
                .extensionKeyword(extensionName)
                .createdAt(LocalDateTime.now())
                .build();

        blockFileExtensionRepository.save(blockFileExtension);

    }

    private BlockFileExtensionDto toDto(BlockFileExtension blockFileExtension) {
        return new BlockFileExtensionDto(
                blockFileExtension.getId(),
                blockFileExtension.getExtensionKeyword(),
                blockFileExtension.getCreatedAt()
        );
    }

}
