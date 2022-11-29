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
    public void printCampaignsInLastYear() {
        boolean isExist = false;
        int year = YearMonth.now().getYear();
        for (var item : campaigns) {
            if (item.getFinish().getYear() == year && item.getStart().getYear() == year) {
                System.out.println(item);
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.format("В %s году не было кампаний\n", year);
        }

    }

    //- найти лучшую кампанию по соотношеню бюджет/охват;
    public MarketCampaigns getBestCampaign() {
        MarketCampaigns best = campaigns.get(0);
        BigDecimal minimal = campaigns.get(0).getCorrelation();
        for (var campaign : campaigns) {
            if (campaign.getCorrelation().compareTo(minimal) == -1) {
                minimal = campaign.getCorrelation();
                best = campaign;
            }
        }
        return best;
    }

    public void setCampaignsRandom(int count) {
        for (int i = 0; i < count; i++) {
            MarketCampaigns campaign = new MarketCampaigns();
            campaign.setRandom();
            campaigns.add(campaign);
        }
    }

    void print() {
        for (var campaign : campaigns) {
            System.out.println(campaign.toString() + "\n");
        }
    }

    public boolean isEmpty() {
        return campaigns.size() == 0;
    }

    public int size() {
        return campaigns.size();
    }


}
