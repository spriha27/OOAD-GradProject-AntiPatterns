package code.godobject.utility;

public class UtilityMain {
    public static void main(String[] args) {
        DataParser parser = new DataParser();
        EmailService emailService = new EmailService();
        ReportGenerator reportGenerator = new ReportGenerator();

        parser.parseData();
        emailService.sendEmail();
        reportGenerator.generateReport();
    }
}