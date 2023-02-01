package com.example.flowpre_assignment.domain.service;

import com.example.flowpre_assignment.domain.dto.BlockFileExtensionDto;
import com.example.flowpre_assignment.domain.entity.BlockFileExtension;
import com.example.flowpre_assignment.domain.repository.BlockFileExtensionRepository;
import com.example.flowpre_assignment.standard.exception.ErrorCode;
import com.example.flowpre_assignment.standard.exception.MyCustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BlockFileExtensionService {

    private final BlockFileExtensionRepository blockFileExtensionRepository;

    enum DefaultBlockFileExtensionList {
        bat, cmd, com, cpl, exe, scr, js;
        private static final Map<String, DefaultBlockFileExtensionList> nameToValueMap =
                new HashMap<String, DefaultBlockFileExtensionList>();

        static {
            for (DefaultBlockFileExtensionList value : EnumSet.allOf(DefaultBlockFileExtensionList.class)) {
                nameToValueMap.put(value.name(), value);
            }
        }

        public static boolean hasExtensionKeyword(String keyword) {
            return nameToValueMap.get(keyword) != null;
        }
    };


    public List<BlockFileExtensionDto> getAllBlockFileExtension() {


        return blockFileExtensionRepository
                .findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }
    public void addBlockFileExtension(String extensionName) {


        if(DefaultBlockFileExtensionList.hasExtensionKeyword(extensionName)) {
            throw new MyCustomException(ErrorCode.DEFAULT_EXTENSION_ERROR);
        }

        BlockFileExtension blockFileExtension = BlockFileExtension
                .builder()
                .extensionKeyword(extensionName)
                .type("custom")
                .createdAt(LocalDateTime.now())
                .build();

        blockFileExtensionRepository.save(blockFileExtension);

    }

    private BlockFileExtensionDto toDto(BlockFileExtension blockFileExtension) {
        return new BlockFileExtensionDto(
                blockFileExtension.getId(),
                blockFileExtension.getExtensionKeyword(),
                blockFileExtension.getType(),
                blockFileExtension.getCreatedAt()
        );
    }



    @Transactional
    public void toggleBlockFileExtension(String extensionKeyword) {
        Optional<BlockFileExtension> _blockFileExtension = blockFileExtensionRepository.findByExtensionKeyword(extensionKeyword);
        if(_blockFileExtension.isPresent()) {
            blockFileExtensionRepository.deleteByExtensionKeyword(extensionKeyword);
        } else {
            BlockFileExtension blockFileExtension = BlockFileExtension.builder()
                    .extensionKeyword(extensionKeyword)
                    .type("default")
                    .createdAt(LocalDateTime.now())
                    .build();
            blockFileExtensionRepository.save(blockFileExtension);
        }

    }
}
