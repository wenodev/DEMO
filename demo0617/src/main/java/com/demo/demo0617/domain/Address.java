package com.demo.demo0617.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String postalCode;

    @Column
    private String address;

    @Column
    private String addressDetail;

    @Column
    private String comment;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @Builder
    public Address(Long id, String postalCode, String address, String addressDetail, String comment, Member member){
        this.id = id;
        this.postalCode = postalCode;
        this.address = address;
        this.addressDetail = addressDetail;
        this.comment = comment;
        this.member = member;
    }

}
