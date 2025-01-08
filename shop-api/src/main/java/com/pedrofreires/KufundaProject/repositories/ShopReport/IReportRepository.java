package com.pedrofreires.KufundaProject.repositories.ShopReport;

import java.util.Date;
import java.util.List;

import com.pedrofreires.KufundaProject.domain.shop.Shop;


public interface IReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
}
