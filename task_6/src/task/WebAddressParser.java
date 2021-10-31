package task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebAddressParser {

    private URL address;

    public WebAddressParser(String address){
        try {
            this.address = new URL(address);
        } catch (MalformedURLException e) {
            this.address = null;
        }
    }

    public String getLogin(){
        if(isValid()) {
            String[] auth = address.getAuthority().split("@");
            if(auth.length >= 2) {
                String[] logAndPas = auth[0].split(":");
                if (logAndPas.length >= 2) {
                    return logAndPas[0];
                }
            }
        }
        return "";
    }

    public String getPassword(){
        if(isValid()) {
            String[] auth = address.getAuthority().split("@");
            if(auth.length >= 2) {
                String[] logAndPas = auth[0].split(":");
                if (logAndPas.length >= 2) {
                    return logAndPas[1];
                }
            }
        }
        return "";
    }

    public String getScheme(){
        if(isValid()) {
            return address.getProtocol();
        }
        else {
            return "";
        }
    }

    public boolean isValid(){
        return address != null;
    }

    public String getHost(){
        if(isValid()) {
            return address.getHost();
        }
        else{
            return "";
        }
    }

    public String getPort(){
        if(isValid() && address.getPort() != -1) {
            return Integer.toString(address.getPort());
        }
        else {
            return "";
        }
    }

    public String getUrl(){
        if(isValid()) {
            return address.getPath().replaceFirst("/", "");
        }
        else {
            return "";
        }
    }

    public HashMap<String, String> getParameters(){
        HashMap<String, String> parameters = new HashMap<>();

        if(isValid() && address.getQuery() != null) {

            String[] allPar = address.getQuery().split("&");
            String eachPar[];

            for (int i = 0; i < allPar.length; i++) {
                eachPar = allPar[i].split("=");
                parameters.put(eachPar[0], eachPar[1]);
            }
        }
        return parameters;
    }

    public String getFragment(){
        if(isValid() && address.getRef() != null) {
            return address.getRef();
        }
        else {
            return "";
        }
    }
}