package com.ambwene.CRUD_AMBWENE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "speaker_info")
public class SpeakerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "speakerID")
    int speakerID;
    @Column(name = "firstName")
    String speakerFirstName;
    @Column(name = "secondName")
    String speakerSecondName;
    @Column(name = "email")
    String speakerEmail;
    @Column(name = "phoneNo")
    int phoneNo;
    @Column(name = "address")
    String address;
}
