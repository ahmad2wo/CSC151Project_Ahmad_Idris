import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project_Ahmad_Idris {
   public static void main(String[] args) throws FileNotFoundException {
      File file = new File("PolicyInformation.txt");
      Scanner input = new Scanner(file);

      int smokerCount = 0;
      int nonSmokerCount = 0;

      while (input.hasNextLine()) {
         String line = input.nextLine().trim();
         if (line.isEmpty()) continue;

         int policyNumber = Integer.parseInt(line);
         String providerName = input.nextLine();
         String firstName = input.nextLine();
         String lastName = input.nextLine();
         int age = Integer.parseInt(input.nextLine());
         String smokingStatus = input.nextLine();
         double height = Double.parseDouble(input.nextLine());
         double weight = Double.parseDouble(input.nextLine());

         PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
         Policy policy = new Policy(policyNumber, providerName, holder);

         if (smokingStatus.equalsIgnoreCase("smoker")) {
            smokerCount++;
         } else {
            nonSmokerCount++;
         }

         System.out.println(policy.toString());
         System.out.println();
      }

      System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

      input.close();
   }
}