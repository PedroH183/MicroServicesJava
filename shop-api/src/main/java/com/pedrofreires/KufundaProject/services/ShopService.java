package com.pedrofreires.KufundaProject.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrofreires.KufundaProject.domain.shop.Shop;
import com.pedrofreires.converter.dtos.ShopDTO;
import com.pedrofreires.converter.dtos.ShopReportDTO;
import com.pedrofreires.KufundaProject.repositories.ReportRepositoryImpl;
import com.pedrofreires.KufundaProject.repositories.ShopRepository;



@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ReportRepositoryImpl reportRepositoryImpl;

    public List<ShopDTO> getAll(){
        return shopRepository
                .findAll()
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier){
        return shopRepository
                .findAllByUserIdentifier(userIdentifier)
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO getById(Long id){
        Optional<Shop> shop = shopRepository.findById(id);

        if( shop.isPresent() ){
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDto){
        // calculo do total dos itens deve ser feito aqui !

        shopDto.setTotal((float) 0);
        shopDto.setTotal(shopDto
                            .getItems()
                            .stream()
                            .map(item -> item.getPrice())
                            .reduce((float) 0, Float::sum)
        );
        Shop shop = Shop.convert(shopDto);
        shop.setCreated_at(new Date());

        return ShopDTO.convert(shopRepository.save(shop));
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository
                            .findAllByDateGreaterThanEqual(shopDTO.getCreated_at());
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo){

        List<Shop> shops = reportRepositoryImpl.getShopByFilters(dataInicio, dataFim, valorMinimo);

        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date dateInicio, Date dateFim){
        List<Object[]> result  = shopRepository.getReportByDate(dateInicio, dateFim);

        // Para deduzir que era uma lista de listas, bastou ver o prefixo L no inicio 
        // do endereço printatdo

        if(result == null){
            System.out.println("Nenhum Registro foi encontrado !");
            return null;
        }
        Object[] resultado = result.get(0);

        Long totalRegistros =  ((Number) resultado[0]) != null ? ((Number) resultado[0]).longValue() : null;
        Long somaTotal      =  ((Number) resultado[1]) != null ? ((Number) resultado[1]).longValue() : null;
        Long mediaTotal     =  ((Number) resultado[2]) != null ? ((Number) resultado[2]).longValue() : null;

        System.out.println("Total de registros: " + totalRegistros);
        System.out.println("Soma total: " + somaTotal);
        System.out.println("Média total: " + mediaTotal);

        return new ShopReportDTO(totalRegistros, somaTotal, mediaTotal);
    }
}