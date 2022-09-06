public class Main {

    public static void main(String[] args) {

        PhysicalPerson physicalPerson = new PhysicalPerson();
        physicalPerson.put(100);
        physicalPerson.put(-100);
        physicalPerson.take(-100);
        physicalPerson.take(200);
        physicalPerson.take(20);
        physicalPerson.details();

        LegalPerson legalPerson = new LegalPerson();
        legalPerson.put(20);
        legalPerson.put(-20);
        legalPerson.take(-20);
        legalPerson.take(200);
        legalPerson.take(5);
        legalPerson.details();

        IndividualBusinessman individualBusinessman = new IndividualBusinessman();
        individualBusinessman.put(50);
        individualBusinessman.put(-50);
        individualBusinessman.put(1000);
        individualBusinessman.take(30);
        individualBusinessman.take(-30);
        individualBusinessman.take(35);
        individualBusinessman.take(1000);
        individualBusinessman.details();

    }

}
