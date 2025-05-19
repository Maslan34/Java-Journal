package DesignPatterns.Structural.Decorator;

public class SignedReportDecorator extends ReportDecorator {
    public SignedReportDecorator(Report report) {
        super(report);
    }

    @Override
    public String getText() {
        String text = super.getText();
        String signedText = ReportUtil.signedText(text);
        return signedText;
    }
}
