package com.pedrofreires.KufundaProject.domain.shop;


public class ShopReportDTO {
    private Integer count;
    private Double total;
    private Double mean;

    public ShopReportDTO(Integer count, Double total, Double mean){
        this.mean  = mean;
        this.count = count;
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }
    public Double getMean() {
        return mean;
    }
    public Double getTotal() {
        return total;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public void setMean(Double mean) {
        this.mean = mean;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
}
