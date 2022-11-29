import campaign.Repository;
import campaign.MarketCampaigns;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Vector;


import static settings.RightInput.getIntInDiapason;

public class GasProm {
    public static final int COUNT_CAMPAIGNS = 100000;
    public static final int COUNT_TESTS = 20;

    public static void main(String[] args) {
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("Запустить программу в режиме:");
            System.out.println("Меню:");
            System.out.println("[1] Сравнение производительности ArrayList и LinkedList.");
            System.out.println("[2] Отображение информации о маркетинговых кампаниях.");
            System.out.println("[0] Выход.");
            int choice = getIntInDiapason(0, 2);
            switch (choice) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    showInfo(true);
                    break;
                case 2:
                    showInfo(false);
                    break;
                default:
                    System.out.println("Неверный ввод. Повторите");
            }
        }
    }


    public static void getInfo(Repository campaigns) {

        if(campaigns.isEmpty())
        { System.out.println("Данных о камапаниях нет!");
        }
        else {
            System.out.println("Число маркетинговых кампаний " + campaigns.size());
            System.out.println("Средняя длительность кампаний (в днях) " + campaigns.avgCampaignDurationDays());
            System.out.println("Кампании, которые были проведены за последний год ");
            campaigns.printCampaignsInLastYear();
            System.out.println("Лучшая кампания по соотношеню бюджет/охват");
            MarketCampaigns best = campaigns.getBestCampaign();
            System.out.println(best);
        }
    }

    public static void showInfo(boolean isComparison) {
        if (!isComparison) {
            var campaigns = new Repository(new ArrayList<MarketCampaigns>());
            campaigns.setCampaignsRandom(COUNT_CAMPAIGNS);
            getInfo(campaigns);
        } else {
            Long[] writeTestTime = new Long [] {0l,0l,0l};
            Long[] readTestTime = new Long [] {0l,0l,0l};
            for (int i = 0; i < COUNT_TESTS; i++) {

                long startTime = System.currentTimeMillis();
                var campaignsArray = new Repository(new ArrayList<MarketCampaigns>());
                campaignsArray.setCampaignsRandom(COUNT_CAMPAIGNS);

                writeTestTime[0] += System.currentTimeMillis() - startTime;

                startTime = System.currentTimeMillis();
                var campaignsVector = new Repository(new Vector<MarketCampaigns>());
                campaignsVector.setCampaignsRandom(COUNT_CAMPAIGNS);

                writeTestTime[1] += System.currentTimeMillis() - startTime;


                startTime = System.currentTimeMillis();
                var campaignsList = new Repository(new LinkedList<MarketCampaigns>());
                campaignsList.setCampaignsRandom(COUNT_CAMPAIGNS);
                writeTestTime[2] += System.currentTimeMillis() - startTime;


                startTime = System.currentTimeMillis();
                getInfo(campaignsArray);
                readTestTime[0] += System.currentTimeMillis() - startTime;

                startTime = System.currentTimeMillis();
                getInfo(campaignsVector);
                readTestTime[1] += System.currentTimeMillis() - startTime;

                startTime = System.currentTimeMillis();
                getInfo(campaignsList);
                readTestTime[2] += System.currentTimeMillis() - startTime;
            }

                System.out.println("Среднее время ЗАПИСИ в ArrayList "+writeTestTime[0]/COUNT_TESTS);
                System.out.println("Среднее время ЗАПИСИ в Vector "+writeTestTime[1]/COUNT_TESTS);
                System.out.println("Среднее время ЗАПИСИ в LinkedList "+writeTestTime[2]/COUNT_TESTS);
                System.out.println("----------------------------------");

                System.out.println("Среднее время РАБОТЫ с ArrayList "+ readTestTime[0]/COUNT_TESTS);
                System.out.println("Среднее время РАБОТЫ с Vector "+ readTestTime[1]/COUNT_TESTS);
                System.out.println("Среднее время РАБОТЫ с LinkedList "+ readTestTime[2]/COUNT_TESTS);

            }
        }
}
