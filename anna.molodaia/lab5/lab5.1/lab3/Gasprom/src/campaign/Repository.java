package campaign;

import java.math.BigDecimal;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Repository {
    private final List<MarketCampaigns> campaigns;

    public Repository(List<MarketCampaigns> campaigns) {
        this.campaigns = campaigns;
    }

    //среднюю длительность кампании
    public int avgCampaignDurationDays() {
        int size = campaigns.size();
        if (size != 0) {
            return campaigns.stream()
                    .mapToInt(MarketCampaigns::getDurationDays)
                    .sum() / size;
        }
        System.out.println("Данных о камапаниях нет!");
        return 0;
    }

    //какие типы кампаний были проведены за последний год;

    public Set<TypeCampaign> getTypesCampaignsInLastYear() {
        int year = YearMonth.now().getYear();
        return campaigns.stream()
                .filter(e -> e.getFinish().getYear() == year && e.getStart().getYear() == year)
                .map(MarketCampaigns::getType)
                .collect(Collectors.toSet());
    }

    // найти лучшую кампанию по соотношеню бюджет/охват;
    public Set<MarketCampaigns> getBestCampaign() {

        var minimal = campaigns.stream()
                .map(MarketCampaigns::getCorrelation)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        return campaigns.stream()
                .filter(e -> e.getCorrelation().compareTo(minimal) == 0)
                .collect(Collectors.toSet());

    }

    public void setCampaignsRandom(int count) {
        IntStream.range(0, count).forEach(i -> {
                    var campaign = new MarketCampaigns();
                    campaign.setRandom();
                    campaigns.add(campaign);
                }
        );

/*        for (int i = 0; i < count; i++) {
            MarketCampaigns campaign = new MarketCampaigns();
            campaign.setRandom();
            campaigns.add(campaign);
        }*/
    }


    public boolean isEmpty() {
        return campaigns.size() == 0;
    }

    public int size() {
        return campaigns.size();
    }


}
