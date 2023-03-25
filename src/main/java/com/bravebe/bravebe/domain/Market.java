package com.bravebe.bravebe.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Market {
    @Id
    private String marketId;
    private String name;
    private String category;
    private String url;
}
