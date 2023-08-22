package com.market.market.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String address;

    @ManyToMany
    @JoinTable(
        name = "branch_addresses",
        joinColumns = @JoinColumn(name = "address_id"),
        inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    List<Branch> branch;
}
