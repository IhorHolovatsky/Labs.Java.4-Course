package com.supplyProduct;

import java.math.BigInteger;

public class SupplyProductModel {

    public SupplyProductModel() {}
    public SupplyProductModel(Integer id, Integer amount, String pName, String pDesc){
        this.Id = id;
        this.Amount = amount;
        this.ProductName = pName;
        this.ProductDescription = pDesc;
    }

    public Integer Id;

    public Integer Amount;

    public String ProductName;

    public String ProductDescription;

}
