package com.demo.demo0617.common.dto;


import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String postalCode;
    private String address;
    private String addressDetail;
    private String comment;
    @Setter
    private Member member;

    public Address toEntity(){
        return Address.builder()
                .id(id)
                .postalCode(postalCode)
                .address(address)
                .addressDetail(addressDetail)
                .member(member)
                .build();
    }

    @Builder
    public AddressDto(Long id, String postalCode, String address, String addressDetail, String comment, Member member){
        this.id = id;
        this.postalCode = postalCode;
        this.address = address;
        this.addressDetail = addressDetail;
        this.comment = comment;
        this.member = member;
    }




}
