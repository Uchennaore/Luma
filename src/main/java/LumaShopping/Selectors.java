package LumaShopping;

import java.security.SecureRandom;

public interface Selectors {
    String url = "https://magento.softwaretestingboard.com/";
    SecureRandom rand = new SecureRandom();
    String[] fnameChoices = {"jude", "shalewa", "ajayi", "okuribido"};
    String[] lnameChoices = {"adebowale", "omotoyosi", "agbami", "olusola", "adeboyega"};
    int pickName = rand.nextInt(fnameChoices.length);
    int pickName1 = rand.nextInt(lnameChoices.length);
    int num = rand.nextInt(200);
    int num1 = rand.nextInt(500);

    String firstName = fnameChoices[pickName];
    String lastName = lnameChoices[pickName1];

    String email = String.format("%s%s%d@gmail.com", firstName, lastName, num);

    public class GeneratePassword {
        public String passwordGen() {
            StringBuilder x = new StringBuilder();
            for (int i = 0; i < firstName.length(); i++) {
                if (i > 0) {
                    x.append(Character.toUpperCase(firstName.charAt(i)));
                    x.append(lastName.charAt(i));
                }


            }
            return x.toString();
        }
    }
    GeneratePassword y = new GeneratePassword();
    String password = String.format("%s%d%d#$*",y.passwordGen(),num,num1);
    String passwordConfirm = password;

    String fetchedText = String.format("Welcome, %s %s!",firstName,lastName);
    String LocateElement = ".logged-in";
}
