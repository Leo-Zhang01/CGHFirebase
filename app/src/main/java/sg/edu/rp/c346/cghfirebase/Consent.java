package sg.edu.rp.c346.cghfirebase;

public class Consent {
    private String surgicalConsent, anaesthesiaConsent, others;

    public Consent(String surgicalConsent, String anaesthesiaConsent, String others) {
        this.surgicalConsent = surgicalConsent;
        this.anaesthesiaConsent = anaesthesiaConsent;
        this.others = others;
    }

    public Consent() {
    }

    public String getSurgicalConsent() {
        return surgicalConsent;
    }

    public void setSurgicalConsent(String surgicalConsent) {
        this.surgicalConsent = surgicalConsent;
    }

    public String getAnaesthesiaConsent() {
        return anaesthesiaConsent;
    }

    public void setAnaesthesiaConsent(String anaesthesiaConsent) {
        this.anaesthesiaConsent = anaesthesiaConsent;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
