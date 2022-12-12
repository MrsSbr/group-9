import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer napkin = new StringBuffer();
        List<List<String>> poems = new ArrayList<>();
        poems.add(List.of(
                "Октябрь уж наступил — уж роща отряхает\n",
                "Последние листы с нагих своих ветвей;\n",
                "Дохнул осенний хлад — дорога промерзает.\n",
                "Журча еще бежит за мельницу ручей\n"
                ));
        poems.add(List.of(
                "Ты меня не любишь, не жалеешь,\n",
                "Разве я немного не красив?\n",
                "Не смотря в лицо, от страсти млеешь,\n",
                "Мне на плечи руки опустив.\n"));
        poems.add(List.of(
                "Засуетились те и эти,\n",
                "Набирают рейтинги.\n",
                "В интернете и в газете\n",
                "Спасу нет, ну хоть беги.\n"));
        poems.add(List.of(
                "Мне нравится, что вы больны не мной,\n",
                "Мне нравится, что я больна не вами,\n",
                "Что никогда тяжелый шар земной\n",
                "Не уплывет под нашими ногами.\n"));
        List<writer> writers = new ArrayList<>();
        for (int i = 0; i < 4; i++){

            writers.add(new writer(poems.get(i),napkin));
            writers.get(i).start();
        }
        for (int i = 0; i < 4; i++){

            writers.get(i).join();
        }

        System.out.println(napkin);

    }
}