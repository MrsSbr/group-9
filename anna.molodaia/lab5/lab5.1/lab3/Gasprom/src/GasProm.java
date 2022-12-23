import campaign.Repository;
import campaign.MarketCampaigns;
import campaign.TypeCampaign;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Set;
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
            System.out.println("[1] Сравнение производительности ArrayList, Vector и  LinkedList.");
            System.out.println("[2] Отображение информации о маркетинговых кампаниях.");
            System.out.println("[0] Выход.");
            int choice = getIntInDiapason(0, 2);
            switch (choice) {
                case 0 -> isEnd = true;
                case 1 -> showInfo(true);
                case 2 -> showInfo(false);
                default -> System.err.println("Неверный ввод. Повторите");
            }
        }
    }


    public static void getInfo(Repository campaigns) {
        if (campaigns.isEmpty()) {
            System.out.println("Данных о камапаниях нет!");
        } else {
            System.out.println("Число маркетинговых кампаний " + campaigns.size());
            System.out.println("Средняя длительность кампаний (в днях) " + campaigns.avgCampaignDurationDays());
            Set<TypeCampaign> types = campaigns.getTypesCampaignsInLastYear();
            if (types.isEmpty()) {
                System.out.println("За последний год не было проведено ни одной кампании");
            } else {
                System.out.println("Типы кампаний, которые были проведены за последний год:");
                types.forEach(type -> System.out.println("Тип кампании " + type));
            }
        }

        System.out.println("Лучшие кампании по соотношеню бюджет/охват");
        Set<MarketCampaigns> bests = campaigns.getBestCampaign();
        bests.forEach(System.out::println);
    }

    public static void showInfo(boolean isComparison) {
        if (!isComparison) {
            var campaigns = new Repository(new ArrayList<>());
            campaigns.setCampaignsRandom(COUNT_CAMPAIGNS);
            getInfo(campaigns);

        } else {
            Long[] writeTestTime = {0L, 0L, 0L};
            Long[] readTestTime = {0L, 0L, 0L};
            for (int i = 0; i < COUNT_TESTS; i++) {

                long startTime = System.currentTimeMillis();
                var campaignsArray = new Repository(new ArrayList<>());
                campaignsArray.setCampaignsRandom(COUNT_CAMPAIGNS);

                writeTestTime[0] += System.currentTimeMillis() - startTime;

                startTime = System.currentTimeMillis();
                var campaignsVector = new Repository(new Vector<>());
                campaignsVector.setCampaignsRandom(COUNT_CAMPAIGNS);

                writeTestTime[1] += System.currentTimeMillis() - startTime;

                startTime = System.currentTimeMillis();
                var campaignsList = new Repository(new LinkedList<>());
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

            System.out.println("Среднее время ЗАПИСИ в ArrayList " + writeTestTime[0] / COUNT_TESTS);
            System.out.println("Среднее время ЗАПИСИ в Vector " + writeTestTime[1] / COUNT_TESTS);
            System.out.println("Среднее время ЗАПИСИ в LinkedList " + writeTestTime[2] / COUNT_TESTS);
            System.out.println("----------------------------------");

            System.out.println("Среднее время РАБОТЫ с ArrayList " + readTestTime[0] / COUNT_TESTS);
            System.out.println("Среднее время РАБОТЫ с Vector " + readTestTime[1] / COUNT_TESTS);
            System.out.println("Среднее время РАБОТЫ с LinkedList " + readTestTime[2] / COUNT_TESTS);

        }
    }
}
