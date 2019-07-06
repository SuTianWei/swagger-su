package com.swagger.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @SequenceGenerator(name = "publisher_id_seq", sequenceName = "publisher_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "publisher_id_seq")
    private int id;
    private String name;
    private String address;
}
