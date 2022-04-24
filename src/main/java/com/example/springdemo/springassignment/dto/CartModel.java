package com.example.springdemo.springassignment.dto;

import com.example.springdemo.springassignment.dto.orders.OrderProductDto;
import com.example.springdemo.springassignment.entity.Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartModel implements Serializable {
    private List<OrderProductDto> orderProductDtoList;
    private Integer totalPrice;

    public CartModel() {
    }

    public void increment(int productId,Products products){
        String price=products.getPrice();
        if (orderProductDtoList == null){
            orderProductDtoList = new ArrayList<>();
        }
        for(OrderProductDto e:orderProductDtoList){
            if(e.getProductDto().getId()==productId){
                e.setQuantity(e.getQuantity()+1);
            }
        }
        totalPrice+= Integer.parseInt(price);
    }
    public void decrement(int productId,Products products){
        String price=products.getPrice();
        if (orderProductDtoList == null){
            orderProductDtoList = new ArrayList<>();
        }
        int index=-1;
        for(OrderProductDto e:orderProductDtoList){
            if(e.getProductDto().getId()==productId){
                if(e.getQuantity()==1){
                    index=orderProductDtoList.indexOf(e);
                }
                e.setQuantity(e.getQuantity()-1);
            }
        }
        if(index!=-1){
            orderProductDtoList.remove(index);
        }

        totalPrice-= Integer.parseInt(price);
    }
    public void addProduct(Products products){
        int flag=0;
        if (orderProductDtoList == null){
            orderProductDtoList = new ArrayList<>();
        }
        for(OrderProductDto prods:orderProductDtoList){
            if(prods.getProductDto().getId()==products.getId()){
                flag=1;
                increment(products.getId(),products);
            }
        }
        if(flag==0){
            orderProductDtoList.add(new OrderProductDto(1, products));
            if(totalPrice == null){
                totalPrice = 0;
            }
            totalPrice+= Integer.parseInt(products.getPrice());
        }

    }

    public CartModel(List<OrderProductDto> orderProductDtoList, Integer totalPrice) {
        this.orderProductDtoList = orderProductDtoList;
        this.totalPrice = totalPrice;
    }

    public List<OrderProductDto> getOrderProductDtoList() {
        return orderProductDtoList;
    }

    public void setOrderProductDtoList(List<OrderProductDto> orderProductDtoList) {
        this.orderProductDtoList = orderProductDtoList;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
