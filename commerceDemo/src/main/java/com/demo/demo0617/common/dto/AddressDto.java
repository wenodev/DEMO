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
    private String addressMemberName;
    private String comment;
    @Setter
    private Member member;

    public Address toEntity(){
        return Address.builder()
                .id(id)
                .postalCode(postalCode)
                .address(address)
                .addressDetail(addressDetail)
                .addressMemberName(addressMemberName)
                .member(member)
                .build();
    }


    @Builder
    public AddressDto(Address address){
        this.id = address.getId();
        this.postalCode = address.getPostalCode();
        this.address = address.getAddress();
        this.addressDetail = address.getAddressDetail();
        this.comment = address.getComment();
        this.addressMemberName =address.getAddressMemberName();
        this.member = address.getMember();
    }



//    @Builder
//    public AddressDto(Long id, String postalCode, String address, String addressDetail, String comment, String addressMemberName, Member member){
//        this.id = id;
//        this.postalCode = postalCode;
//        this.address = address;
//        this.addressDetail = addressDetail;
//        this.comment = comment;
//        this.addressMemberName = addressMemberName;
//        this.member = member;
//    }




}
