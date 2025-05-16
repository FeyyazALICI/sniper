package com.sniper.fileandbatch.components.file.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "days_without_shooting") // Make sure to point to the correct view name
public class DaysWithoutShooting {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  
    private Long id;

    @Column(name = "date_of_rest")
    private Date dateOfRest;


    public DaysWithoutShooting(
        Long id,

        Date dateOfRest
    ){
        this.id = id;

        this.dateOfRest           = dateOfRest;
    }
}