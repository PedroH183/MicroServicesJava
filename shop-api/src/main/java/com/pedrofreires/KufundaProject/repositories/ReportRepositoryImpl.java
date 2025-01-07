package com.pedrofreires.KufundaProject.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pedrofreires.KufundaProject.domain.shop.Shop;
import com.pedrofreires.KufundaProject.domain.shop.ShopReportDTO;
import com.pedrofreires.KufundaProject.repositories.ShopReport.IReportRepository;


public class ReportRepositoryImpl implements IReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {
        // TODO : MELHORAR ESSE CODIGO !! 

        StringBuilder s = new StringBuilder();

        s.append("select s" );
        s.append("from shops s" );
        s.append("where s.date >= :dataInicio");

        if(dataFim != null){
            s.append(" and s.date <= :dataFim");
        }
        if(valorMinimo != null){
            s.append(" and s.total >= :valorMinimo");
        }
        Query query = entityManager.createQuery(s.toString());

        query.setParameter("dataInicio", dataInicio);
        if (dataFim != null) {
            query.setParameter("dataFim", dataFim); 
        }
        if (valorMinimo != null) {
            query.setParameter("valorMinimo", valorMinimo);
        }
        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        StringBuilder s = new StringBuilder();

        s.append("select count(s.id), sum(s.total), avg(s.total) " );
        s.append(" from shopping.shop s" );
        s.append(" where s.date >= :dataInicio ");
        s.append(" and s.date <= :dataFim");

        Query query = entityManager.createNativeQuery(s.toString());
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        Object[] ob = (Object[]) query.getSingleResult();

        ShopReportDTO shopReportDTO = new ShopReportDTO();
        shopReportDTO.setMean((Double) ob[2]);
        shopReportDTO.setTotal((Double) ob[1]);
        shopReportDTO.setCount(((BigInteger) ob[0]).intValue());

        return shopReportDTO;
    }
}
