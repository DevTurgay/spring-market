package com.market.market.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "markets")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "market")
    @JsonManagedReference
    List<Branch> branches;
}
