package com.esampaio.apps.fingerprintExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.esampaio.apps.fingerprint.R;
import com.esampaio.apps.fingerprintExample.fingerprint.FingerprintCallback;
import com.esampaio.apps.fingerprintExample.fingerprint.FingerprintService;

/**
 * Referencias
 * http://www.androidhive.info/2016/11/android-add-fingerprint-authentication/
 * http://www.survivingwithandroid.com/2016/12/android-fingerprint-authentication-tutorial.html
 * https://www.sitepoint.com/securing-your-android-apps-with-the-fingerprint-api/
 * https://developer.android.com/about/versions/marshmallow/android-6.0.html
 */
public class MainActivity extends AppCompatActivity {
    private FingerprintService fingerprintService;
    private TextView descTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fingerprintService = new FingerprintService(this);
        descTextView = (TextView) findViewById(R.id.desc);
        if(fingerprintService.isServiceAvailable()){
            fingerprintService.initFingerprintService();
            fingerprintService.setCallback(callback);
            fingerprintService.authenticate();
        }
    }

    private FingerprintCallback callback = new FingerprintCallback() {
        @Override
        public void onSucceeded() {
            descTextView.setText(R.string.autentication_success);
            descTextView.setTextColor(getResources().getColor(R.color.successText));
        }

        @Override
        public void onFailed() {
            descTextView.setText(R.string.autentication_failed);
            descTextView.setTextColor(getResources().getColor(R.color.errorText));
        }
    };

}
