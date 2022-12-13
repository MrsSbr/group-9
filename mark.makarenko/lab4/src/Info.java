import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Info {
    private final static int overall = 3;
    private final List<CoffeeType> list;

    public Info(List<CoffeeType> value) {
        list = value;
    }

    static int getOverall() {
        return overall;
    }

    void printList() {
        for (int i = 0; i < overall; i++) {
            System.out.print(list.get(i).getType() + ' ' + list.get(i).getCountry() + ' '
                    + list.get(i).getFarm() + ' ' + list.get(i).getProcessing() + ' ' + list.get(i).getGrowthHight());
            System.out.println();
        }
    }

    void everyTypeForProcessing() {
        for (int i = 0; i < overall - 1; i++) {
            String tmpProcessing;
            tmpProcessing = list.get(i).getProcessing();
            for (int j = i; j < overall; j++) {
                if (list.get(j).getProcessing() == tmpProcessing) {
                    System.out.println(list.get(j).getType());
                }
            }
        }
    }

    void countriesWithGrowthHight() {

        for (int i = 0; i < overall; i++) {

            if (list.get(i).getGrowthHight() > 1500) {

                System.out.println(list.get(i).getCountry());
            }
        }
    }

    void farmTypeCount() {
        for (int i = 0; i < overall; i++) {
            List<String> tmpList = new LinkedList<>();
            int typeCount = 0;
            String tmpFarm = list.get(i).getFarm();
            for (int j = 0; j < overall; j++) {
                boolean flag = true;
                if (Objects.equals(list.get(j).getFarm(), tmpFarm)) {
                    for (String s : tmpList) {
                        if (Objects.equals(list.get(j).getFarm(), s)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        typeCount++;
                        tmpList.add(list.get(j).getFarm());
                    }
                }
            }
            System.out.print(list.get(i).getFarm() + ' ' + typeCount);
            System.out.println();
        }
    }
}

