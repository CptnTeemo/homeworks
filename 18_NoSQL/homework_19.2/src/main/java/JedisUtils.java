import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JedisUtils {

    private static Jedis jedis = new Jedis("localhost", 6379);
    private static final List<String> USER_LIST = generateUsersList();
    private static final long USER_COUNT = 20L;

    public void jedisConnect() {

        System.out.println ("Подключение успешно");
        System.out.println ("Ping: " + jedis.ping());
        System.out.println ("Очистка данных: " + jedis.flushDB());
    }

    public void flightList() {
        Map<String, Double> townList = new HashMap<>();
        townList.put("Лондон", 25000.0);
        townList.put("Нью-Йорк", 50000.0);
        townList.put("Токио", 75000.0);
        townList.put("Амстердам", 55000.0);
        townList.put("Гонконг", 85000.0);
        townList.put("Санкт-Петербург", 8000.0);
        townList.put("Сиэтл", 46000.0);
        townList.put("Париж", 60000.0);
        townList.put("Стамбул", 35000.0);
        townList.put("Бангкок", 78000.0);
        townList.put("Рим", 43000.0);

        townList.forEach((key, value) -> jedis.zadd("town_list", value, key));
        System.out.println("Список всех билетов на рейсы из моего города: "
                + jedis.zrangeWithScores("town_list", 0, -1));
        System.out.println("ТОП-3 самых дешевых билетов из моего города: "
                + jedis.zrangeWithScores("town_list", 0, 2));
        System.out.println("ТОП-3 самых дорогих билетов из моего города: "
                + jedis.zrevrangeWithScores("town_list", 0, 2));
    }

    public void fillDataBase() {
        USER_LIST.forEach(e -> jedis.rpush("user#list", e));
    }

    public String datingSite(Long user) throws InterruptedException {
        Thread.sleep(600);
        return jedis.lindex("user#list", user);
    }

    public long randomUserPayForUp() {
        long min = 1L;
        long max = 20L;
        return Math.round((Math.random()*(max-min))+min);
    }

    public static List<String> generateUsersList() {
        List<String> userList = new ArrayList<>();
        for (int i = 1; i <= USER_COUNT; i++) {
            userList.add("Пользователь №" + i);
        }
        return userList;
    }

}
