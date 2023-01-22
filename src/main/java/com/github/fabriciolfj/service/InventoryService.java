package com.github.fabriciolfj.service;

import com.github.fabriciolfj.entity.Inventory;
import com.github.fabriciolfj.exceptions.InventoryNotFoundException;
import com.github.fabriciolfj.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@ApplicationScoped
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    @Transactional(value = Transactional.TxType.REQUIRED)
    public void saveInventory(final Inventory inventory) {
        repository.executePersist(inventory);
    }

    @Transactional(value = Transactional.TxType.REQUIRED)
    public void updateInventory(final String product, final Integer quantidadeExit) {
        var result = repository.findLast(product)
                .map(e -> {
                    e.setId(null);
                    e.setDateRegistration(LocalDateTime.now());
                    return e.updateExit(quantidadeExit);
                })
                .orElseThrow(() -> new InventoryNotFoundException());

        repository.executePersist(result);
    }
}
