package com.example.sale.Services;

import com.example.sale.Model.Campaign;
import com.example.sale.Model.Dto.CamDto;
import com.example.sale.Model.Dto.ProSale;
import com.example.sale.Model.PriceHist;
import com.example.sale.Model.Product;
import com.example.sale.SaleRepo.CamRepo;
import com.example.sale.SaleRepo.PriceHistRepo;
import com.example.sale.SaleRepo.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@EnableScheduling
public class CamServ<S> {

    @Autowired
    public CamRepo camRepo;

    @Autowired
    public ProRepo proRepo;

    @Autowired
    public PriceHistRepo priceHistRepo;

    public <S> Campaign createcampaign(CamDto campaign) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date currentDate = new Date();
        String formattedDate = sdf.format(currentDate);

        Date current = sdf.parse(formattedDate);
        Date startDate = sdf.parse(campaign.getStartDate());
        Date endDate = sdf.parse(campaign.getEndDate());

        Campaign campaign1 = new Campaign();
        List<ProSale> proList = campaign.getDiscount();

        for(ProSale proSale : proList){
            campaign1 = new Campaign();
            campaign1.setTitle(campaign.getTitle());
            campaign1.setStartDate(campaign.getStartDate());
            campaign1.setEndDate(campaign.getEndDate());
            long productId = proSale.getProductdid();
            Optional<Product>productOptional = proRepo.findById(productId);

            if(productOptional.isPresent()){
                Product product = productOptional.get();
                campaign1.setDiscount(proSale.getDiscount());
                campaign1.setProductId(productId);
                campaign1.setOldprice(product.getCp());
                camRepo.save(campaign1);

                PriceHist priceHist = new PriceHist();
                priceHist.setPrice(product.getCp());
                priceHist.setProductId(product.getId());
                double disc = product.getCp() - (product.getCp() * proSale.getDiscount() / 100);
                product.setCp(disc);
                proRepo.save(product);
                priceHistRepo.save(priceHist);
                
            }else{
                System.out.print("Product Is Not Found.");
            }
        }
        return campaign1;
    }

    @Scheduled(fixedRate = 1000)

    public void updateProductPrice(){
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String formattedDate = sdf.format(currentDate);
        List<Campaign> activeCampaign = camRepo.findActiveCampaign("2024-03-01");

        for(Campaign campaign : activeCampaign){
            double currentPrice = campaign.getOldprice();

            Optional<Product> productOptional =proRepo.findById(campaign.getProductId());
            if(productOptional.isPresent()){
                Product product = productOptional.get();
                product.setCp(currentPrice);
                proRepo.save(product);
            }
        }
    }
}
