package com.uet.hotelsystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "content")
    private String content;

    @Column(name = "price")
    private float price;
}
