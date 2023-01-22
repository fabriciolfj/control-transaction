package com.github.fabriciolfj.repository;

import com.github.fabriciolfj.entity.Inventory;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.LockModeType;
import java.util.Optional;

@ApplicationScoped
public class InventoryRepository implements PanacheRepository<Inventory> {

    public void executePersist(final Inventory inventory) {
        this.persist(inventory);
    }

    public Optional<Inventory> findLast(final String product) {
        return this.find("Select e From Inventory e where e.product = ?" +
                        " and e.dateRegistration = (select max(a.dateRegistration) from Inventory a where a.product =?", product)
                .withLock(LockModeType.OPTIMISTIC)
                .stream().findAny();
    }
}
