package com.gozdesy.repository.entity;

import javax.persistence.Embeddable;

@Embeddable
public class CommonData {

    /**
     * ortak olması gereken
     * alanları bu classsta tanımlayarak
     * embeddable etiketiyle bunun gömülebilir olduğunu
     * belirtiyoruz
     */

    Long createdDate;
    Long updatedDate;



}
