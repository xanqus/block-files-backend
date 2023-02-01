package com.example.flowpre_assignment.domain.repository;

import com.example.flowpre_assignment.domain.entity.BlockFileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlockFileExtensionRepository extends JpaRepository<BlockFileExtension, Long> {
    Optional<BlockFileExtension> findByExtensionKeyword(String extensionKeyword);

    void deleteByExtensionKeyword(String extensionKeyword);

    Long countByType(String type);
}
