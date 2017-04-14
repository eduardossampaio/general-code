package com.esampaio.apps.fingerprintExample.fingerprint;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.app.ActivityCompat;
import javax.crypto.Cipher;

import static android.content.Context.FINGERPRINT_SERVICE;

/**
 * Created by eduardo on 14/04/17.
 */
public class FingerprintService {
    private static final String KEY_NAME = "KEYSTORE_FINGERPRINT";
    private final FingerprintManager fingerprintManager;
    private FingerprintServiceCrypto fingerprintServiceCrypto;
    private FingerprintCallback callback;
    private Context context;
    private Cipher cipher;

    public FingerprintService(Context context){
        this.context = context;
        fingerprintManager = (FingerprintManager) context.getSystemService(FINGERPRINT_SERVICE);
        fingerprintServiceCrypto = new FingerprintServiceCrypto();
    }
    public boolean isServiceAvailable(){
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && fingerprintManager.isHardwareDetected() );
    }

    public void initFingerprintService(){
        if(cipher==null) {
            cipher = fingerprintServiceCrypto.createCipher(KEY_NAME);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void authenticate(){
        initFingerprintService();
        if(cipherInitialized()){
            CancellationSignal cancellationSignal = new CancellationSignal();
            FingerprintManager.CryptoObject cryptoObject = new FingerprintManager.CryptoObject(cipher);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, new Callback(), null);
        }
    }

    private boolean cipherInitialized() {
        return cipher!=null;
    }

    public void setCallback(FingerprintCallback callback) {
        this.callback = callback;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private class Callback extends FingerprintManager.AuthenticationCallback{
        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {

        }

        @Override
        public void onAuthenticationFailed() {
            if(callback!=null){
                callback.onFailed();
            }
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
            if(callback!=null){
                callback.onSucceeded();
            }
        }
    }

}
