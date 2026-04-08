package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // 내장타입 -> 다른 Entity 안에 포함되는 값 객체
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {} // 임베디드 타입은 이렇게 해줘야함

    // 이렇게 하는게 실무 권장
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
