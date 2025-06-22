package com.sachinmukharjee.concepts.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemId  implements Serializable {
    private Integer orderId;
    private Integer itemId;
}
