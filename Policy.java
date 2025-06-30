public class Policy {
   private int policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;
   private static int policyCount = 0;

   public Policy() {
      policyNumber = 0;
      providerName = "";
      policyHolder = new PolicyHolder("", "", 0, "non-smoker", 0.0, 0.0);
      policyCount++;
   }

   public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
      this.policyNumber = policyNumber;
      this.providerName = providerName;
      this.policyHolder = policyHolder;
      policyCount++;
   }

   public int getPolicyNumber() {
      return policyNumber;
   }

   public String getProviderName() {
      return providerName;
   }

   public PolicyHolder getPolicyHolder() {
      return policyHolder;
   }

   public static int getPolicyCount() {
      return policyCount;
   }

   public double calculatePolicyPrice() {
      double basePrice = 600.0;
      if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
         basePrice += 100.0;
      }
      if (policyHolder.calculateBMI() > 35) {
         basePrice += 75.0;
      }
      return basePrice;
   }

   public String toString() {
      return "Policy Number: " + policyNumber + "\n" +
             "Provider Name: " + providerName + "\n" +
             policyHolder.toString() + "\n" +
             "Policy Price: $" + String.format("%.2f", calculatePolicyPrice());
   }
}


