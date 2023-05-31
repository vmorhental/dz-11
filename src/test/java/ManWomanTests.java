import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ManWomanTests {

    /*
    Man methods:
    1 isRetired
    2 deregisterPartnership
    3 getJob - getter
    4 setJob - setter

    Woman methods:
    1 isRetired
    2 deregisterPartnership
    3 setGirlSurname - setter
    4 getGirlSurname - getter

    Person methods:
    1 registerPartnership
    2 getFirstName - getter
    3 setFirstName - setter
    4 getLastName  - getter
    5 setLastName - setter
    6 getAge - getter
    7 setAge - setter
    8 getHasPartner - getter
    9 setHasPartner - setter
    10 getGender - getter
    11 setGender - setter
    12 getPartnerSurname - getter
    13 setPartnerSurname - setter
    14 setHasPartnerDivorsed - setter - this is service setter , it is used in other methods that will be tested.

     */
    private Woman slavka;
    private Man valera;
    @BeforeClass (groups = "setter and getter")
            public void createTestData(){
        slavka = new Woman("Slavka", "Loia", 61, null,"Female");
        valera = new Man("Valera", "Morhental", 67, null, "Male", "QA");
    }
/*
                                                        Man methods tests
 */
    @Test
    public void testIsManOlderThanSixtyFiveRetired(){
        assertTrue(valera.isRetired());
    }

    @Test
    public void testDeregisterPartnershipForMan (){
        valera.registerPartnership(slavka,valera);
        valera.deregisterPartnership(true);
        assertFalse(valera.getHasPartner(),"Man is not divorsed");
    }

    @Test
    public void testRegisterPartnershipMan(){
        valera.registerPartnership(slavka,valera);
        assertEquals(valera.getPartnerSurname(),"Loia", "man is not in marriage");
    }
    @Test (groups = "setter and getter")
    public void testGetJobMan(){
        String job = valera.getJob();
        assertEquals(job,"QA","Man has incorrect job");
    }

    @Test (groups = "setter and getter")
    public void testSetJobMan(){
        valera.setJob("AQA");
        String newJob = valera.getJob();
        assertEquals(newJob,"AQA","Job is not updated");
    }

    @Test (groups = "setter and getter")
    public void testGetFirstNameMan(){
        String firstName = valera.getFirstName();
        String message = String.format("First name is [%s]", firstName);
        assertEquals(firstName, "Valera", message);
    }

    @Test (groups = "setter and getter")
    public void testSetFirstNameMan(){
        valera.setFirstName("Slavik");
        String firstName = valera.getFirstName();
        String message = String.format("First name is [%s]", firstName);
        assertEquals(firstName, "Slavik", message);
    }

    @Test (groups = "setter and getter")
    public void testGetLastNameMan(){
        String lastName = valera.getLastName();
        String message = String.format("Last name is [%s]", lastName);
        assertEquals(lastName, "Morhental", message);
    }

    @Test (groups = "setter and getter")
    public void testSetLastNameMan(){
        valera.setLastName("Petrov");
        String lastName = valera.getLastName();
        String message = String.format("Last name is [%s]", lastName);
        assertEquals(lastName, "Petrov", message);
    }

    @Test (groups = "setter and getter")
    public void testGetAgeMan(){
        int age = valera.getAge();
        String message = "Age is " + age + " years";
        assertEquals(age, 67, message);
    }

    @Test (groups = "setter and getter")
    public void testSetAgeMan(){
        valera.setAge(55);
        int age = valera.getAge();
        String message = "Age is " + age + " years";
        assertEquals(age, 55, message);
    }

    @Test (groups = "setter and getter")
    public void testGetHasPartnerMan(){
        boolean hasPartner = valera.getHasPartner();
        String message = "Person has partner";
        assertFalse(hasPartner, message);
    }

    @Test (groups = "setter and getter")
    public void testSetHasPartnerMan(){
        valera.setHasPartner("Slavka");
        boolean hasPartner = valera.getHasPartner();
        String message = "Person has no partner";
        assertTrue(hasPartner, message);
    }

    @Test (groups = "setter and getter")
    public void testGetGenderMan(){
        String gender = valera.getGender();
        String message = String.format("Gender is [%s]",gender);
        assertEquals(gender, "Male", message);
    }

    @Test (groups = "setter and getter")
    public void testSetGender(){
        valera.setGender("Female");
        String gender = valera.getGender();
        String message = String.format("Gender is [%s]",gender);
        assertEquals(gender, "Female", message);
    }

    @Test (groups = "setter and getter")
    public void testGetPartnerSurname(){
        valera.registerPartnership(slavka,valera);
        String partnerSurname = valera.getPartnerSurname();
        String message = String.format("Partner surname is [%s]",partnerSurname);
        assertEquals(partnerSurname, "Loia", message);
    }

    @Test (groups = "setter and getter")
    public void testSetPartnerSurname(){
        valera.registerPartnership(slavka,valera);
        valera.setPartnerSurname("Nothing");
        String partnerSurname = valera.getPartnerSurname();
        String message = String.format("Partner surname is [%s]",partnerSurname);
        assertEquals(partnerSurname, "Nothing", message);
    }

/*
                                                        Woman methods tests
 */
    @Test
    public void testIsWomanOlderThanSixtyRetired(){
        assertTrue(slavka.isRetired(), "Woman is not retired");
    }

    @Test
    public void testDeregisterPartnershipForWoman (){
        slavka.registerPartnership(slavka,valera);
        slavka.deregisterPartnership(true);
        assertFalse(slavka.getHasPartner(),"Woman is not divorsed");
    }

    @Test
    public void testRegisterPartnershipWoman(){
        slavka.registerPartnership(slavka,valera);
        assertEquals(slavka.getPartnerSurname(),"Morhental", "woman is not in marriage");
    }

    @Test (groups = "setter and getter")
    public void testGetGirlSurname(){
        String girlSurname = slavka.getGirlSurname();
        assertEquals(girlSurname,"Loia","Surname is incorrect");
    }

    @Test (groups = "setter and getter")
    public void testSetGirlSurname(){
        slavka.setGirlSurname("Gladun");
        String girlSurname = slavka.getGirlSurname();
        assertEquals(girlSurname,"Gladun","Surname is incorrect");
    }

    @Test (groups = "setter and getter")
    public void testGetFirstNameWoman(){
        String firstName = slavka.getFirstName();
        String message = String.format("First name is [%s]", firstName);
        assertEquals(firstName, "Slavka", message);
    }

    @Test (groups = "setter and getter")
    public void testSetFirstNameWoman(){
        slavka.setFirstName("Slavik");
        String firstName = slavka.getFirstName();
        String message = String.format("First name is [%s]", firstName);
        assertEquals(firstName, "Slavik", message);
    }

    @Test (groups = "setter and getter")
    public void testGetLastNameWoman(){
        String lastName = slavka.getLastName();
        String message = String.format("Last name is [%s]", lastName);
        assertEquals(lastName, "Loia", message);
    }

    @Test (groups = "setter and getter")
    public void testSetLastNameWoman(){
        slavka.setLastName("Petrova");
        String lastName = slavka.getLastName();
        String message = String.format("Last name is [%s]", lastName);
        assertEquals(lastName, "Petrova", message);
    }

    @Test (groups = "setter and getter")
    public void testGetAgeWoman(){
        int age = slavka.getAge();
        String message = "Age is " + age + " years";
        assertEquals(age, 61, message);
    }

    @Test (groups = "setter and getter")
    public void testSetAgeWoman(){
        slavka.setAge(55);
        int age = slavka.getAge();
        String message = "Age is " + age + " years";
        assertEquals(age, 55, message);
    }

    @Test (groups = "setter and getter")
    public void testGetHasPartnerWoman(){
        boolean hasPartner = slavka.getHasPartner();
        String message = "Person has partner";
        assertFalse(hasPartner, message);
    }

    @Test (groups = "setter and getter")
    public void testSetHasPartnerWoman(){
        slavka.setHasPartner("Valera");
        boolean hasPartner = slavka.getHasPartner();
        String message = "Person has no partner";
        assertTrue(hasPartner, message);
    }

    @Test (groups = "setter and getter")
    public void testGetGenderWoman(){
        String gender = slavka.getGender();
        String message = String.format("Gender is [%s]",gender);
        assertEquals(gender, "Female", message);
    }

    @Test (groups = "setter and getter")
    public void testSetGenderWoman(){
        slavka.setGender("Male");
        String gender = slavka.getGender();
        String message = String.format("Gender is [%s]",gender);
        assertEquals(gender, "Male", message);
    }

    @Test (groups = "setter and getter")
    public void testGetPartnerSurnameWoman(){
        slavka.registerPartnership(slavka,valera);
        String partnerSurname = slavka.getPartnerSurname();
        String message = String.format("Partner surname is [%s]",partnerSurname);
        assertEquals(partnerSurname, "Morhental", message);
    }

    @Test (groups = "setter and getter")
    public void testSetPartnerSurnameWoman(){
        slavka.registerPartnership(slavka,valera);
        slavka.setPartnerSurname("Nothing");
        String partnerSurname = slavka.getPartnerSurname();
        String message = String.format("Partner surname is [%s]",partnerSurname);
        assertEquals(partnerSurname, "Nothing", message);
    }
}
