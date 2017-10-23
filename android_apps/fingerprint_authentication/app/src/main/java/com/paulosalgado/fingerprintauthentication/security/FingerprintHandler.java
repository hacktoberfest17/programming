package com.paulosalgado.fingerprintauthentication.security;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.paulosalgado.fingerprintauthentication.R;

/**
 * Created by Paulo on 22/05/2017.
 */
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    private CancellationSignal cancellationSignal;
    private Context appContext;

    private Dialog appDialog;

    public FingerprintHandler(Context context, Dialog dialog) {
        this.appContext = context;
        this.appDialog = dialog;
    }

    public void startAuth(FingerprintManager manager,
                          FingerprintManager.CryptoObject cryptoObject) {

        cancellationSignal = new CancellationSignal();

        if (ActivityCompat.checkSelfPermission(appContext,
                Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(appContext,
                    appContext.getString(R.string.fingerprint_error_no_permission),
                    Toast.LENGTH_LONG).show();

            return;
        }

        manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }

    @Override
    public void onAuthenticationFailed() {
        Toast.makeText(appContext, "Falha na autenticação", Toast.LENGTH_SHORT).show();
        appDialog.dismiss();
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        Toast.makeText(appContext, "Sucesso na autenticação!", Toast.LENGTH_SHORT).show();
        appDialog.dismiss();
    }

}
