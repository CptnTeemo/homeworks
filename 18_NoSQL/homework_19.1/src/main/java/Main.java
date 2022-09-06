import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println ("Подключение успешно");
        System.out.println ("Ping: " + jedis.ping ());

        System.out.println ("Очистка данных: " + jedis.flushDB ());

        jedis.sadd("todo", "купить молока");
        jedis.sadd("todo", "заправить машину");
        jedis.sadd("todo", "покормить кота");
        jedis.sadd("todo", "покормить кота");
        jedis.sadd("todo", "купить молока");
        System.out.println ("Все дела:" + jedis.smembers("todo"));
        System.out.println("Запланированные дела выполнены");
        jedis.srem("todo", "заправить машину");
        jedis.srem("todo", "покормить кота");
        jedis.srem("todo", "купить молока");
        System.out.println ("Все дела:" + jedis.smembers("todo"));
        System.out.println("====================================");
        jedis.hincrBy("Иванов И.И.", "Веб-разработка. Выполнено заданий", 1);
        jedis.hincrBy("Иванов И.И.", "Data Science. Выполнено заданий", 4);
        System.out.println(jedis.hkeys("Иванов И.И."));
        System.out.println(jedis.hvals("Иванов И.И."));
        jedis.hincrBy("Иванов И.И.", "Data Science. Выполнено заданий", 1);
        System.out.println(jedis.hgetAll("Иванов И.И."));

    }
}
