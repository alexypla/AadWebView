package org.izv.aad.aadwebview;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

import static org.izv.aad.aadwebview.ActividadPrincipal.TAG;

public  class InterfaceAplicacionWeb {

    private String usuario, clave;

    public InterfaceAplicacionWeb() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @JavascriptInterface
    public void sendData(String usuario, String clave) {
        setUsuario(usuario);
        setClave(clave);
        Log.v(TAG, usuario + " " + clave);
    }
}
