package com.market.market.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "market_id")
    @JsonBackReference
    Market market;

    @ManyToMany
    @JoinTable(
        name = "branch_addresses",
        joinColumns = @JoinColumn(name = "branch_id"),
        inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    List<Address> addresses;
}
