package com.pedrofreires.KufundaProject.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pedrofreires.KufundaProject.domain.shop.Shop;
import com.pedrofreires.KufundaProject.repositories.ShopReport.IReportRepository;


// A diferença entre o entityManager.createNativeQuery e entity.CreateQuery
// é que este ultimo opera sobre entidades do sistema, o outro opera diretamente no banco

@Repository
public class ReportRepositoryImpl implements IReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {

        StringBuilder s = new StringBuilder();

        s.append("select s ");
        s.append("from Shop s ");
        s.append("where s.date >= :dataInicio");

        if(dataFim != null){
            s.append(" and s.date <= :dataFim");
        }
        if(valorMinimo != null){
            s.append(" and s.total >= :valorMinimo");
        }
        Query query = entityManager.createQuery(s.toString());

        query.setParameter("dataInicio", dataInicio);
        this.setParameter(query, "dataFim", dataFim);
        this.setParameter(query, "valorMinimo", valorMinimo);

        return query.getResultList();
    }

    public <T> void setParameter(Query query, String field, T value){
        if (value != null) {
            query.setParameter(field, value);
        }
    }
}
