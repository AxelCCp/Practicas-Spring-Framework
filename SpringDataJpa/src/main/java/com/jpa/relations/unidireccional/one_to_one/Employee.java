package com.jpa.relations.unidireccional.one_to_one;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="uni_employee_one_to_one")
@Table(name="uni_employee_one_to_one")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="parking_spot_id")
    private ParkingSpot parkingSpot;

}
