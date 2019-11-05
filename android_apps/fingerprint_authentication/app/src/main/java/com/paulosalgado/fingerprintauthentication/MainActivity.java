package com.paulosalgado.fingerprintauthentication;

import android.Manifest;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paulosalgado.fingerprintauthentication.security.AndroidKeystoreManager;
import com.paulosalgado.fingerprintauthentication.security.FingerprintHandler;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_NAME = "fingerprint-authentication-app-key";

    private Button btnLerDigital;

    private AlertDialog alertDialog;

    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;

    private AndroidKeystoreManager keystoreManager;

    private FingerprintManager.CryptoObject cryptoObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicializarComponentesTela();
        inicializarSeguranca();
    }

    private void inicializarComponentesTela() {

        btnLerDigital = (Button) findViewById(R.id.btn_ler_digital);
        btnLerDigital.setOnClickListener(btnLerDigitalSistema_OnClickListener());
    }

    private void inicializarSeguranca() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this,
                    getString(R.string.fingerprint_error_no_permission),
                    Toast.LENGTH_LONG).show();

            return;
        }

        keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
        fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);

        keystoreManager = new AndroidKeystoreManager(KEY_NAME);
        keystoreManager.generateKey();

        if (keystoreManager.cipherInit()) {
            cryptoObject = new FingerprintManager.CryptoObject(keystoreManager.getCipher());
        }
    }

    private View.OnClickListener btnLerDigitalSistema_OnClickListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(MainActivity.this,
                            getString(R.string.fingerprint_error_no_permission),
                            Toast.LENGTH_LONG).show();

                    return;
                }

                if (!fingerprintManager.hasEnrolledFingerprints()) {

                    Toast.makeText(MainActivity.this,
                            getString(R.string.fingerprint_error_no_fingerprints),
                            Toast.LENGTH_LONG).show();

                    return;
                }

                alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(R.layout.fingerprint_dialog)
                        .setNegativeButton(R.string.dialog_fingerprint_cancel,
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }

                                })
                        .create();

                FingerprintHandler helper = new FingerprintHandler(MainActivity.this, alertDialog);
                helper.startAuth(fingerprintManager, cryptoObject);

                alertDialog.show();
            }

        };
    }

}
