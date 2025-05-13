package com.sniper.def.components.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "weapon")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "bore_size")
    private String boreSize;
    @Column(name = "bore_unit")
    private String boreUnit;
    @Column(name = "type")
    private String type;

    @Column(name = "photo_qr")
    private String photoQr;

    public Weapon(
        Long id,

        String brand,
        String serialNumber,
        String boreSize,
        String boreUnit,
        String type,

        String photoQr
    ){
        this.id = id;

        this.brand = brand;
        this.serialNumber = serialNumber;
        this.boreSize = boreSize;
        this.boreUnit = boreUnit;
        this.type = type;

        this.photoQr = photoQr;
    }
}



