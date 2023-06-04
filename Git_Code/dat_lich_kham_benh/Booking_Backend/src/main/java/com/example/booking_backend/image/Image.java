package com.example.booking_backend.image;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @Column(columnDefinition = "longtext")
    private String url;

}
