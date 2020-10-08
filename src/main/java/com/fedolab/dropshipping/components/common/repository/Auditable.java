package com.fedolab.dropshipping.components.common.repository;

import com.fedolab.dropshipping.components.common.exception.ResponseDefault;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;

@Data
@MappedSuperclass
public class Auditable extends ResponseDefault {

    @Column(name = "status")
    private Integer status;

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "createddate")
    private Date createddate;

    @Column(name = "modifiedby")
    private String modifiedby;

    @Column(name = "modifieddate")
    private Date modifieddate;

    @Transient
    private String userId;

    public void fillCompulsory(String userName) {
        Date now = new Date();
        this.createdby = userName;
        this.modifiedby = userName;
        this.createddate = now;
        this.modifieddate = now;
    }
}
