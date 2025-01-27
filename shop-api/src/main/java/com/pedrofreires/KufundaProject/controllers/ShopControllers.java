package com.pedrofreires.KufundaProject.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedrofreires.KufundaProject.domain.shop.ShopDTO;
import com.pedrofreires.KufundaProject.services.ShopService;
import com.pedrofreires.KufundaProject.domain.shop.ShopReportDTO;


@RestController
public class ShopControllers {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shop/all")
    public List<ShopDTO> getAll(){
        return shopService.getAll();
    }

    @GetMapping("/shop/user/{userIdentifier}")
    public List<ShopDTO> getAllByUserIdentifier(@PathVariable String userIdentifier){
        return shopService.getByUser(userIdentifier);
    }

    @GetMapping("/shop/{id}")
    public ShopDTO getShopById(@PathVariable Long id){
        return shopService.getById(id);
    }

    @PostMapping("/shop/create")
    public ShopDTO creteShop(@RequestBody ShopDTO shopDTO){
        return shopService.save(shopDTO);
    }

    @GetMapping("/shop/date")
    public List<ShopDTO> getShoppingsByDateGreaterThanEquals(@Valid @RequestBody ShopDTO shopDTO){
        // ao fazer um filtro com um tipo elaborado como Datas, podemos usar o DTO diretamente
        return shopService.getByDate(shopDTO);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopsByFilter(
        @RequestParam(name = "dataInicio", required = true)
        @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
        @RequestParam(name = "dataFim", required = false)
        @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
        @RequestParam(name = "valorMinimo", required = false) Float valorMinimo
    ){
        return shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportDotByDate(
        @RequestParam(name = "dataInicio")
        @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
        @RequestParam(name = "dataFim")
        @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim
    ){
        return shopService.getReportByDate(dataInicio, dataFim);
    }
}
