package com.pedrofreires.KufundaProject.repositories.ShopReport;

import java.util.Date;
import java.util.List;
import com.pedrofreires.KufundaProject.domain.shop.Shop;
import com.pedrofreires.KufundaProject.domain.shop.ShopReportDTO;


public interface IReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);
    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
