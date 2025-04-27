import java.util.*;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getRole();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRole() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRole() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRole() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void display() {
        System.out.println("Candidate: " + jobRole.getCandidateName() + " | Role: " + jobRole.getRole());
    }
}

class ResumeScreening {

    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing Resume for: " + resume.getJobRole().getCandidateName() + " (" + resume.getJobRole().getRole() + ")");
    }

    public static void screenResumes(List<? extends JobRole> resumes) {
        System.out.println("\n--- Screening Resumes ---");
        for (JobRole role : resumes) {
            System.out.println("Screening " + role.getCandidateName() + " for " + role.getRole() + " position.");
        }
    }
}

public class resumescreeningsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<JobRole> allResumes = new ArrayList<>();

        System.out.print("Enter number of resumes to add: ");
        int n = sc.nextInt();
        sc.nextLine();  

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter candidate name:");
            String name = sc.nextLine();
            System.out.println("Choose Role: 1-Software Engineer, 2-Data Scientist, 3-Product Manager");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    allResumes.add(new SoftwareEngineer(name));
                    break;
                case 2:
                    allResumes.add(new DataScientist(name));
                    break;
                case 3:
                    allResumes.add(new ProductManager(name));
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }

        ResumeScreening.screenResumes(allResumes);

        if (!allResumes.isEmpty()) {
            Resume<JobRole> sampleResume = new Resume<>(allResumes.get(0));
            System.out.println("\nExample Resume:");
            sampleResume.display();
            ResumeScreening.processResume(sampleResume);
        }

        sc.close();
    }
}
