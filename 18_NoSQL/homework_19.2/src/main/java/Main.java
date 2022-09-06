public class Main {
    public static void main(String[] args) throws InterruptedException {
        JedisUtils jedis = new JedisUtils();
        jedis.jedisConnect();
        jedis.flightList();
        
        jedis.jedisConnect();
        jedis.fillDataBase();
        long user = 0L;
        long randomUser = 0L;
        while (true) {
            System.out.println(jedis.datingSite(user));
            user++;
            if (user % 10 == 0) {
                randomUser = jedis.randomUserPayForUp();
                System.out.println(jedis.datingSite(randomUser) +
                        " оплатил платную услуга для показа");
            }
            if (user == randomUser) {
                user++;
            }
            if (user == 20) {
                user = 0L;
            }
        }
    }
}
