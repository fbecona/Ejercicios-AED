package dispositivosip;

public class Dispositivo {
    
    String dispositivo;
    
    String ip;
    
    public Dispositivo(String ip, String dispositivo){
        this.ip = ip;
        this.dispositivo = dispositivo;
    }
    
    public String getDispositivo() {
        return dispositivo;
    }

    public String getIp() {
        return ip;
    }
    
    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
}
