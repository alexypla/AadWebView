package org.izv.aad.aadwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActividadPrincipal extends AppCompatActivity {

    static final String TAG = "MITAG";
    private WebView webView;
    private InterfaceAplicacionWeb iaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
        webView = findViewById(R.id.wvMoodle);
        webView.getSettings().setJavaScriptEnabled(true);

          iaw = new InterfaceAplicacionWeb();

        webView.addJavascriptInterface(iaw, "puente");
        webView.loadUrl("http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/");

        webView.setWebViewClient(new WebViewClient() {
            int contador = 0;
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.v(TAG, url);
                if(contador == 0) {
                    Log.v(TAG, "on page finished");

                    final String javaScript = "" +
                            "var boton = document.getElementById('btEnviar');" +
                            "boton.addEventListener('click', function() {" +
                            "    var nombre = document.getElementById('nombre').value;" +
                            "    var clave  = document.getElementById('clave').value;" +
                            "    puente.sendData(nombre, clave);" +
                            "});";
                    webView.loadUrl("javascript: " + javaScript);

                }

                contador++;
            }
        });

    }
}
