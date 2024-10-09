package main;

import dao.IPolicyService;
import dao.InsuranceServiceImpl;
import entity.Policy;
import exception.PolicyNotFoundException;

import java.util.Collection;
import java.util.Scanner;

public class MainModule {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException , PolicyNotFoundException  {
        IPolicyService insurance = new InsuranceServiceImpl();
        System.out.println("-------Insurance Management System------------");
        while(true) {
            System.out.println("1. Create Policy");
            System.out.println("2. Get Policy");
            System.out.println("3. Get All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        createPolicy(insurance);
                        break;
                    case 2:
                        getPolicy(insurance);
                        break;
                    case 3:
                        getAllPolicies(insurance);
                        break;
                    case 4:
                        updatePolicy(insurance);
                        break;
                    case 5:
                        deletePolicy(insurance);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again :).");

                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void deletePolicy(IPolicyService insurance) throws PolicyNotFoundException {
        System.out.println("Enter Policy ID to delete: ");
        int policyIdToDelete = scanner.nextInt();

        if (insurance.deletePolicy(policyIdToDelete)) {
            System.out.println("Policy deleted successfully!");
        } else {
            System.out.println("Policy with ID " + policyIdToDelete + " not found. Please Enter the valid Policy ID");
        }
    }

    private static void updatePolicy(IPolicyService insurance) throws PolicyNotFoundException {
        System.out.println("Enter Policy ID to update: ");
        int policyIdToUpdate = scanner.nextInt();
        Policy policyToUpdate = insurance.getPolicy(policyIdToUpdate);

        if (policyToUpdate != null) {
            System.out.println("Enter updated Policy Name: ");
            scanner.nextLine();
            String updatedPolicyName = scanner.nextLine();
            policyToUpdate.setPolicyName(updatedPolicyName);
            System.out.println("Enter Updated policy type ");
            String updatedPolicyType= scanner.nextLine();
            policyToUpdate.setPolicyType(updatedPolicyType);
            System.out.println("Enter updated Coverage Amount: ");
            double updatedCoverageAmount = scanner.nextDouble();
            policyToUpdate.setCoverageAmount(updatedCoverageAmount);

            if (insurance.updatePolicy(policyToUpdate)) {
                System.out.println("Policy updated successfully!");
            } else {
                System.out.println("Policy update failed!");
            }
        } else {
            throw new PolicyNotFoundException("Policy with ID " + policyIdToUpdate + " not found. Please try again with valid Policy ID");
        }

    }

    private static void getAllPolicies(IPolicyService insurance) throws PolicyNotFoundException {
        Collection<Policy> allPolicies = insurance.getAllPolicies();

        if (allPolicies != null && !allPolicies.isEmpty()) {
            System.out.println("All Policies are : ");
            for (Policy policy : allPolicies) {
                System.out.println(policy);
            }
        } else {
            System.out.println("No policies found.");
        }

    }

    private static void getPolicy(IPolicyService insurance) throws PolicyNotFoundException {
        System.out.println("Enter Policy ID to retrieve: ");
        int policyIdToRetrieve = scanner.nextInt();
        Policy retrievedPolicy = insurance.getPolicy(policyIdToRetrieve);

        if (retrievedPolicy != null) {
            System.out.println("Retrieved Policy: " + retrievedPolicy);
        } else {
            System.out.println("Policy with ID " + policyIdToRetrieve + " not found. Please try again with valid Policy ID");
        }

    }

    private static void createPolicy(IPolicyService insurance) {
        System.out.println("Enter Policy ID: ");
        int policyId = scanner.nextInt();
        System.out.println("Enter Policy Name: ");
        scanner.nextLine();
        String policyName = scanner.nextLine();
        System.out.println("Enter Policy Type: ");
        String policyType = scanner.nextLine();
        System.out.println("Enter Coverage Amount: ");
        double CoverageAmount = scanner.nextDouble();

        Policy newPolicy = new Policy(policyId, policyName, policyType, CoverageAmount);

        if (insurance.createPolicy(newPolicy)) {
            System.out.println("Policy created successfully!");
        } else {
            System.out.println("Policy creation failed!");
        }

    }

}
