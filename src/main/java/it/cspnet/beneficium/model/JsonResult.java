package it.cspnet.beneficium.model;

public class JsonResult {

    private Object oggetto;

    private String messaggio;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getOggetto() {
        return oggetto;
    }

    public void setOggetto(Object oggetto) {
        this.oggetto = oggetto;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;

    }

}
