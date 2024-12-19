package com.rb.surprise_backend;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wishes_from_friends")
@Data
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String wish;
}
