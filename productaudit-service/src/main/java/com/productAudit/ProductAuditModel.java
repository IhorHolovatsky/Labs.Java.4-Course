package com.productAudit;

import Enums.AuditStatus;
import Enums.Sizes;

public class ProductAuditModel {
    public Integer Id;

    public ProductModel Product;

    public String OwnerName;

    public Sizes Size;

    public AuditStatus AuditStatus;

    public boolean IsCheckSuccess;

    ProductAuditModel(Integer Id, ProductModel Product, String OwnerName,
                      Sizes Size, AuditStatus AuditStatus, boolean IsCheckSuccess) {
        this.Id = Id;
        this.Product = Product;
        this.OwnerName = OwnerName;
        this.Size = Size;
        this.AuditStatus = AuditStatus;
        this.IsCheckSuccess = IsCheckSuccess;
    }

    public void SetProductAudit(ProductModel Product) {
        this.Product = Product;
    }

    @Override
    public String toString() {
        return "Product №" + Product.Id + " Product Description: "
                + Product.ProductDescription + ", Amount: " + Product.Amount
                + " /n Audit №" + Id + ", Name: " + Product.ProductName + ", Size: "
                + Size + ", Status: " + AuditStatus + ", Check" + IsCheckSuccess;
    }
}