public class PhysicalPerson extends Client {

    @Override
    public void details() {
        System.out.println("Информация по счёту физического лица:" + System.lineSeparator() +
                "Состояние счёта: " + getAmount() + " руб." + System.lineSeparator() +
                "Снятие и пополнение счёта без комисии.");
    }

}
