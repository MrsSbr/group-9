package campaign;

import java.math.BigDecimal;

import java.time.YearMonth;
import java.util.*;

public class Repository {
    List<MarketCampaigns> campaigns;

    public Repository(List<MarketCampaigns> campaigns) {
        this.campaigns = campaigns;
    }

    //среднюю длительность кампании
    public int avgCampaignDurationDays() {

        if (campaigns.size() != 0) {
            long days = 0;
            for (var campaign : campaigns) {
                days += campaign.getDurationDays();
            }
            return (int) days / campaigns.size();
        }
        System.out.println("Данных о камапаниях нет!");
        return 0;
    }

    //какие типы кампаний были проведены за последний год;
    public Set<TypeCampaign> getTypesCampaignsInLastYear()
    {
        Set<TypeCampaign> typesCampaignsInLastYer = new HashSet<>();
        int year = YearMonth.now().getYear();
        for (var campaign : campaigns) {
            if (campaign.getFinish().getYear() == year && campaign.getStart().getYear() == year) {
                typesCampaignsInLastYer.add(campaign.getType());
            }
        }
        return typesCampaignsInLastYer;
    }
    // найти лучшую кампанию по соотношеню бюджет/охват;
    public Set<MarketCampaigns> getBestCampaign() {
        Set<MarketCampaigns> bestCampaigns = new HashSet<>();
        MarketCampaigns best = campaigns.get(0);
        BigDecimal minimal = best.getCorrelation();
        for (var campaign : campaigns) {
            if (campaign.getCorrelation().compareTo(minimal) < 0) {
                minimal = campaign.getCorrelation();
                best = campaign;
            }
        }
        for (var campaign : campaigns) {
            if (campaign.getCorrelation().compareTo(best.getCorrelation()) == 0)
                bestCampaigns.add(campaign);
        }
        return bestCampaigns;
    }
    public void setCampaignsRandom(int count) {
        for (int i = 0; i < count; i++) {
            MarketCampaigns campaign = new MarketCampaigns();
            campaign.setRandom();
            campaigns.add(campaign);
        }
    }



    public boolean isEmpty() {
        return campaigns.size() == 0;
    }

    public int size() {
        return campaigns.size();
    }


}
