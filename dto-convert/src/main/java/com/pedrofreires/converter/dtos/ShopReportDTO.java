package com.pedrofreires.converter.dtos;

import java.math.BigDecimal;

public class ShopReportDTO {
    private Long count;
    private Long total;
    private Long mean;

    public ShopReportDTO(Long count, Long total, Long mean){
        this.mean  = mean;
        this.count = count;
        this.total = total;
    }

    public Long getCount() {
        return count;
    }
    public Long getMean() {
        return mean;
    }
    public Long getTotal() {
        return total;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public void setMean(Long mean) {
        this.mean = mean;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
}