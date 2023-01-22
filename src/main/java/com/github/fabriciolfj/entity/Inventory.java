package com.github.fabriciolfj.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "inventory")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventory {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String product;
    private Integer entrance;
    private Integer exit;
    private Integer balance;
    @Column(name = "date_registration")
    private LocalDateTime dateRegistration;
    @Version
    private Integer version;

    public Inventory updateExit(final Integer quantidade) {
        this.exit = quantidade;
        this.balance = this.balance - this.exit;
        this.entrance = 0;

        return this;
    }
}
