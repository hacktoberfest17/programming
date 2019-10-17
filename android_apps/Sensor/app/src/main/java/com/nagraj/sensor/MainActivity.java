package com.nagraj.sensor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Calendar;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;
    BluetoothAdapter bta;
    Button wifi, mobiledata, hotspot, location, camera, play, pause, record, stopr;
    ContentResolver cResolver;
    CameraManager cm;
    Context context;
    DataHandler myDataHandler;
    File root = new File(Environment.getRootDirectory().getParent());
    ImageView cameraIV, left, right, top, down;
    IntentFilter ifilter;
    Intent batteryStatus;
    LinearLayout linearLayout;
    MyHandlerThread myHandlerThread;
    MediaMetadataRetriever metaRetriever;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    NotificationManager mNotificationManager;
    ProgressBar battery, ram, audio, internal, external;
    RelativeLayout.LayoutParams params1, params2;
    TextView wifispeed, dataspeed, mobiledatastate, center, batper, totalram,lightintensty;
    TextView ramper, accx, accy, accz, acct, datentime, proximiti, playtime, totalSD, totalexternal;
    TextView light, proximity, gps, fingure, face, magnetometer, gyroscope, accelerometer;
    ScrollView scrollView;
    SensorManager mySensorManager;
    Sensor myProximitySensor, acceleratorSensor,mlightSensor;
    SeekBar brightness, volume;
    Switch torch, bluetooth, dnd, auto, aeroplane, touch, vibrate;
    Vibrator vibrator;
    Window window;

    int brigh, vol;
    boolean wifistatus,mobiledatastatus;
    final String uri = root.getPath() + "sdcard/Music/perfect.mp3";
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        wifispeed = findViewById(R.id.wifispeed);
        wifi = findViewById(R.id.wifi);
        mobiledata = findViewById(R.id.mobiledata);
        dataspeed = findViewById(R.id.dataspeed);
        mobiledatastate = findViewById(R.id.mobiledatastate);
        torch = findViewById(R.id.torch);
        battery = findViewById(R.id.battery);
        hotspot = findViewById(R.id.hotspot);
        bluetooth = findViewById(R.id.bluetooth);
        location = findViewById(R.id.location);
        batper = findViewById(R.id.batper);
        ramper = findViewById(R.id.ramper);
        ram = findViewById(R.id.ram);
        totalram = findViewById(R.id.totalram);
        brightness = findViewById(R.id.brightness);
        dnd = findViewById(R.id.dnd);
        volume = findViewById(R.id.volume);
        auto = findViewById(R.id.auto);
        aeroplane = findViewById(R.id.aeroplane);
        datentime = findViewById(R.id.datentime);
        linearLayout = findViewById(R.id.linearLayout);
        scrollView = findViewById(R.id.scrollView);
        touch = findViewById(R.id.touch);
        vibrate = findViewById(R.id.vibrate);
        camera = findViewById(R.id.camera);
        cameraIV = findViewById(R.id.cameraIV);
        playtime = findViewById(R.id.playtime);
        audio = findViewById(R.id.audio);
        record = findViewById(R.id.record);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stopr = findViewById(R.id.stopr);
        internal = findViewById(R.id.internal);
        external = findViewById(R.id.external);
        totalexternal = findViewById(R.id.totalexternal);
        totalSD = findViewById(R.id.totalSD);
        light = findViewById(R.id.light);
        proximity = findViewById(R.id.proximity);
        gps = findViewById(R.id.gps);
        magnetometer = findViewById(R.id.magnetometer);
        accelerometer = findViewById(R.id.accelerometer);
        gyroscope = findViewById(R.id.gyroscope);
        face = findViewById(R.id.face);
        fingure = findViewById(R.id.fingure);
        proximiti = findViewById(R.id.proximiti);
        accx = findViewById(R.id.accx);
        accy = findViewById(R.id.accy);
        accz = findViewById(R.id.accz);
        acct = findViewById(R.id.acct);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        top = findViewById(R.id.top);
        down = findViewById(R.id.down);
        center = findViewById(R.id.center);
        lightintensty=findViewById(R.id.lightintenstity);


        systemWritePermission();
        wifiSection();
        hotspotSection();
        mobiledataSection();
        torchSection();
        batterySection();
        bluetoothSection();
        locationSection();
        ramSection();
        brightnessSection();
        dndSection();
        volumeSection();
        autoSection();
        aeroplaneSection();
        datentimeSection();
        touchSection();
        powerSection();
        cameraSection();
        recordnplaySection();
        memorySection();
        sensorsSection();
        proximitiSection();
        gravitySection();
        updateAllSection();
        lightintenstySection();

    }

    public void wifiSection() {
        final WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifistatus = wifiManager.isWifiEnabled();
        if (wifistatus == true) {
            wifiManager.setWifiEnabled(false);
            wifistatus = false;
            wifi.setText("Enable Wifi");
        } else {
            wifiManager.setWifiEnabled(true);
            wifistatus = true;
            wifi.setText("Disable Wifi");

        }
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wifistatus == true) {
                    wifiManager.setWifiEnabled(false);
                    wifistatus = false;
                    wifi.setText("Enable Wifi");
                } else {
                    wifiManager.setWifiEnabled(true);
                    wifistatus = true;
                    wifi.setText("Disable Wifi");
                }
            }
        });

    }

    public void hotspotSection() {
        hotspot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity"));
                startActivity(intent);

            }
        });
    }

    public void mobiledataSection() {
        mobiledatastatus = isMobileDataEnabled();
        if (mobiledatastatus == true) {
            mobiledatastate.setText("ON");
        } else {
            mobiledatastate.setText("OFF");
        }
        mobiledata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobiledatastatus = isMobileDataEnabled();
                if (mobiledatastatus == true) {
                    mobiledatastate.setText("ON");
                } else {
                    mobiledatastate.setText("OFF");
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                startActivity(intent);
            }
        });

    }

    public Boolean isMobileDataEnabled() {
        Object connectivityService = getSystemService(CONNECTIVITY_SERVICE);
        ConnectivityManager cm = (ConnectivityManager) connectivityService;

        try {
            Class<?> c = Class.forName(cm.getClass().getName());
            Method m = c.getDeclaredMethod("getMobileDataEnabled");
            m.setAccessible(true);
            return (Boolean) m.invoke(cm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void torchSection() {
        cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        torch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    String cameraId = cm.getCameraIdList()[0];
                    cm.setTorchMode(cameraId, isChecked);
                } catch (Exception e) {
                }
            }
        });

    }

    public void batterySection() {
        ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        batteryStatus = context.registerReceiver(null, ifilter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        int rem = (int) ((level * 100) / (float) scale);
        battery.setProgress(rem);
        params1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params1.setMarginStart((int) (rem * 4.4) + 120);
        batper.setText(rem + "%");
        batper.setLayoutParams(params1);

    }


    public void bluetoothSection() {
        bta = BluetoothAdapter.getDefaultAdapter();
        bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    bta.enable();
                } else {
                    bta.disable();
                }
            }
        });
    }


    public void locationSection() {
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$LocationSettingsActivity"));
                startActivity(intent);
            }
        });
    }

    public void ramSection() {
        ActivityManager actManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        long totalMemory = memInfo.totalMem;
        long freeMem = memInfo.availMem;
        long usedMem = totalMemory - freeMem;
        totalram.setText(totalMemory / (1024 * 1024) + "MB");
        int rem = (int) ((usedMem * 100) / (float) totalMemory);
        ram.setProgress(rem);
        params2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params2.setMarginStart((int) (rem * 3.3) + 230);
        ramper.setText(rem + "%");
        ramper.setLayoutParams(params2);

    }

    public void brightnessSection() {

        cResolver = getContentResolver();
        window = getWindow();

        try {
            Settings.System.putInt(cResolver,Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            brigh = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
            brightness.setProgress((brigh * 100) / 255);
        } catch (Exception e) {

        }

        brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Settings.System
                        .putInt(getApplicationContext().getContentResolver(),
                                Settings.System.SCREEN_BRIGHTNESS, (i * 255) / 100);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void systemWritePermission() {

        final Context context = getApplicationContext();
        boolean settingsCanWrite = Settings.System.canWrite(context);

        if (!settingsCanWrite) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            startActivity(intent);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setMessage("You have system write settings permission now.");
            alertDialog.show();
        }
    }

    public void dndSection() {

        cResolver = getContentResolver();
        window = getWindow();
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        dnd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE);
                } else {
                    mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_ALL);

                }
            }
        });
    }

    public void volumeSection() {
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        volume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        vol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volume.setProgress(vol);


        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int newVolume, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, newVolume, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void autoSection() {

        cResolver = getContentResolver();
        window = getWindow();
        auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean enabled) {
                Settings.System.putInt(getApplicationContext().getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, enabled ? 1 : 0);

            }
        });
    }

    public void aeroplaneSection() {
        cResolver = getContentResolver();
        window = getWindow();
        aeroplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean enabled) {
                try {
                    android.provider.Settings.Global.putInt(getApplicationContext().getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, enabled ? 1 : 0);
                }catch(Exception e){
                    Toast.makeText(context,e+"",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void datentimeSection() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        int yyyy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int m = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
        String dnt = "Time : " + h + " : " + m + " : " + s + "    |   Date : " + dd + " / " + mm + " / " + yyyy;
        datentime.setText(dnt);
    }

    public void touchSection() {
        touch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                } else {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                }
            }
        });
    }

    public void powerSection() {
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    long pattern[] = {60, 120, 180, 240, 300, 360, 420, 480};

                    vibrator.vibrate(pattern, 5);
                } else {
                    vibrator.cancel();
                }
            }
        });

    }

    public void cameraSection() {
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent.putExtra("android.provider.extras.CAMERA_FACING", 1);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            cameraIV.setImageBitmap(photo);
        }
    }

    public void recordnplaySection() {
        stopr.setEnabled(false);
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE}, 101);
        metaRetriever = new MediaMetadataRetriever();
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(uri);
            mediaPlayer.prepare();
            metaRetriever.setDataSource(uri);
            String duration = metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            long dur = Long.parseLong(duration);
            long num = (dur % 60000) / 1000;
            String seconds = String.format("%02d", num);
            String minutes = String.valueOf(dur / 60000);
            playtime.setText("PT/" + minutes + ":" + seconds);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    stopr.setEnabled(false);
                    record.setEnabled(false);
                    play.setEnabled(false);
                    pause.setEnabled(true);

                    mediaPlayer.start();
                }
            });
            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stopr.setEnabled(false);
                    record.setEnabled(true);
                    play.setEnabled(true);
                    pause.setEnabled(false);

                    mediaPlayer.pause();
                    int td = mediaPlayer.getDuration();
                    int cd = mediaPlayer.getCurrentPosition();
                    int rem = (int) ((cd * 100) / (double) td);
                    audio.setProgress(rem);
                    String duration = metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                    long dur1 = Long.parseLong(duration);
                    long cdur = (rem * dur1) / 100;
                    int num = (int) (cdur % 60000) / 1000;
                    String seconds = String.format("%02d", num);
                    String minutes = String.valueOf(cdur / 60000);
                    String string = playtime.getText().toString();
                    string = string.substring(string.length() - 5);
                    playtime.setText(minutes + ":" + seconds + string);

                }
            });
        } catch (Exception e) {
            Toast.makeText(this, "Error=" + e, Toast.LENGTH_LONG).show();

        }


        mediaRecorder = new MediaRecorder();
        boolean per = checkPermission();
        if (per) {
        } else {
            requestPermission();
        }

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
                    mediaRecorder.setOutputFile(uri);


                    stopr.setEnabled(true);
                    record.setEnabled(false);
                    play.setEnabled(false);
                    pause.setEnabled(false);
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                    Toast.makeText(context, "Recording started", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e + "", Toast.LENGTH_LONG).show();

                }
            }
        });

        stopr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    stopr.setEnabled(false);
                    record.setEnabled(true);
                    play.setEnabled(true);
                    pause.setEnabled(false);

                    mediaRecorder.stop();


                    metaRetriever.setDataSource(uri);
                    String duration = metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                    long dur = Long.parseLong(duration);
                    long num = (dur % 60000) / 1000;
                    String tseconds = String.format("%02d", num);
                    String tminutes = String.valueOf(dur / 60000);
                    int td = mediaPlayer.getDuration();
                    int cd = mediaPlayer.getCurrentPosition();
                    int rem4 = (int) ((cd * 100) / (double) td);
                    long cdur = (rem4 * dur) / 100;
                    int cnum = (int) (cdur % 60000) / 1000;
                    String cseconds = String.format("%02d", cnum);
                    String cminutes = String.valueOf(cdur / 60000);
                    String time = cminutes + ":" + cseconds + "/" + tminutes + ":" + tseconds;
                    playtime.setText(time);
                } catch (Exception e) {
                    Toast.makeText(context, "Error=" + e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, 1);
    }

    public void memorySection() {
        try {
            StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long bytesT = stat.getBlockSizeLong() * stat.getBlockCountLong();
            long megasT = bytesT / 1048576;
            float gigaT = ((float) megasT) / 1024;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            float fT = Float.valueOf(decimalFormat.format(gigaT));
            totalSD.setText(fT + "GB");
            long bytesA = stat.getBlockSizeLong() * stat.getAvailableBlocksLong();
            long bytesC = bytesT - bytesA;
            int rem = (int) ((bytesC * 100) / (double) bytesT);
            internal.setProgress(rem);

            File[] roots = context.getExternalFilesDirs(null);
            // String path = roots[0].getAbsolutePath(); // PhoneMemory
            String path1 = roots[1].getAbsolutePath(); // SCCard (if available)
            // String path2 = roots[2].getAbsolutePath(); // USB (if available)

            StatFs stat2 = new StatFs(path1);
            long ebytesT = stat2.getBlockSizeLong() * stat2.getBlockCountLong();
            long emegasT = ebytesT / 1048576;
            float egigaT = ((float) emegasT) / 1024;
            float efT = Float.valueOf(decimalFormat.format(egigaT));
            totalexternal.setText(efT + "GB");
            long ebytesA = stat2.getBlockSizeLong() * stat2.getAvailableBlocksLong();
            long ebytesC = ebytesT - ebytesA;
            int erem = (int) ((ebytesC * 100) / (double) ebytesT);
            external.setProgress(erem);

        } catch (Exception e) {
            Toast.makeText(this, "Error+" + e, Toast.LENGTH_LONG).show();
        }


    }

    public void sensorsSection() {
        String string = "P";
        PackageManager PM = this.getPackageManager();
        boolean loc = PM.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
        boolean acc = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
        boolean pro = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_PROXIMITY);
        boolean lig = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_LIGHT);
        boolean gyr = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
        boolean fig = PM.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT);
        boolean fac = PM.hasSystemFeature(PackageManager.FEATURE_FACE);
        boolean mag = PM.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS);
        string = loc ? "Yes" : "No";
        gps.setText(string);
        string = "P";
        string = acc ? "Yes" : "No";
        accelerometer.setText(string);
        string = "P";
        string = pro ? "Yes" : "No";
        proximity.setText(string);
        string = "P";
        string = lig ? "Yes" : "No";
        light.setText(string);
        string = "P";
        string = gyr ? "Yes" : "No";
        gyroscope.setText(string);
        string = "P";
        string = fig ? "Yes" : "No";
        fingure.setText(string);
        string = "P";
        string = fac ? "Yes" : "No";
        face.setText(string);
        string = "P";
        string = mag ? "Yes" : "No";
        magnetometer.setText(string);
    }


    public void proximitiSection() {
        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        acceleratorSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (myProximitySensor == null) {
            Toast.makeText(this, "No proximity", Toast.LENGTH_LONG).show();
        } else {
            mySensorManager.registerListener(proximitiSensorsEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (acceleratorSensor == null) {
            Toast.makeText(this, "No accelerator", Toast.LENGTH_LONG).show();
        } else {
            mySensorManager.registerListener(acceleratorsSensorsEventListener, acceleratorSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void gravitySection() {
        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acceleratorSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensorManager.registerListener(proximitiSensorsEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        if (acceleratorSensor == null) {
            Toast.makeText(this, "No accelerator", Toast.LENGTH_LONG).show();
        } else {
            mySensorManager.registerListener(acceleratorsSensorsEventListener, acceleratorSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }


    SensorEventListener proximitiSensorsEventListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                proximiti.setText(event.values[0] + "");
            }
        }
    };
    SensorEventListener acceleratorsSensorsEventListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = -event.values[0];
            float y = -event.values[1];
            float z = -event.values[2];
            double t = Math.sqrt(x * x + y * y + z * z);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            x = Float.valueOf(decimalFormat.format(x));
            y = Float.valueOf(decimalFormat.format(y));
            z = Float.valueOf(decimalFormat.format(z));
            t = Double.valueOf(decimalFormat.format(t));
            accx.setText(x + "");
            accy.setText(y + "");
            accz.setText(z + "");
            acct.setText(t + "");
            if (z < -7.00) {
                center.setText("Face Up");
                center.setBackgroundResource(R.drawable.redcircle);
                left.setBackgroundResource(R.drawable.transparenttriangle);
                right.setBackgroundResource(R.drawable.transparenttriangle);
                top.setBackgroundResource(R.drawable.transparenttriangle);
                down.setBackgroundResource(R.drawable.transparenttriangle);
            }
            if (z > 7.00) {
                center.setText("Face Down");
                center.setBackgroundResource(R.drawable.transparentcircle);
                left.setBackgroundResource(R.drawable.transparenttriangle);
                right.setBackgroundResource(R.drawable.transparenttriangle);
                top.setBackgroundResource(R.drawable.transparenttriangle);
                down.setBackgroundResource(R.drawable.transparenttriangle);
            }
            if (x > 7.00) {
                center.setText("Left Up");
                center.setBackgroundResource(R.drawable.transparentcircle);
                left.setBackgroundResource(R.drawable.redsolidtriangle);
                right.setBackgroundResource(R.drawable.transparenttriangle);
                top.setBackgroundResource(R.drawable.transparenttriangle);
                down.setBackgroundResource(R.drawable.transparenttriangle);
            }
            if (x < -7.00) {
                center.setText("Right Up");
                center.setBackgroundResource(R.drawable.transparentcircle);
                left.setBackgroundResource(R.drawable.transparenttriangle);
                right.setBackgroundResource(R.drawable.redsolidtriangle);
                top.setBackgroundResource(R.drawable.transparenttriangle);
                down.setBackgroundResource(R.drawable.transparenttriangle);
            }
            if (y < -7.00) {
                center.setText("Top Up");
                center.setBackgroundResource(R.drawable.transparentcircle);
                left.setBackgroundResource(R.drawable.transparenttriangle);
                right.setBackgroundResource(R.drawable.transparenttriangle);
                top.setBackgroundResource(R.drawable.redsolidtriangle);
                down.setBackgroundResource(R.drawable.transparenttriangle);
            }
            if (y > 7.00) {
                center.setText("Bottom Up");
                center.setBackgroundResource(R.drawable.transparentcircle);
                left.setBackgroundResource(R.drawable.transparenttriangle);
                right.setBackgroundResource(R.drawable.transparenttriangle);
                top.setBackgroundResource(R.drawable.transparenttriangle);
                down.setBackgroundResource(R.drawable.redsolidtriangle);
            }
        }
    };


    public void updateAllSection() {
        try {
            final Handler handler = new Handler() {

                @Override
                public void handleMessage(@NonNull Message msg) {
                    switch (msg.what) {
                        case 1:
                            int rem1 = Integer.valueOf((int) msg.obj);
                            battery.setProgress(rem1);
                            params1.setMarginStart((int) (rem1 * 4.4) + 120);
                            batper.setText(rem1 + "%");
                            batper.setLayoutParams(params1);
                            break;
                        case 2:
                            int rem2 = Integer.valueOf((int) msg.obj);
                            ram.setProgress(rem2);
                            params2.setMarginStart((int) (rem2 * 3.3) + 230);
                            ramper.setText(rem2 + "%");
                            ramper.setLayoutParams(params2);
                            break;
                        case 3:
                            String rem3 = String.valueOf(msg.obj);
                            datentime.setText(rem3);
                        case 4:
                            try {
                                long rem4 = Long.valueOf((long) msg.obj);
                                wifispeed.setText(rem4 + "");

                            } catch (Exception e) {
                            }
                        case 5:
                            try {
                                long rem5 = Long.valueOf((long) msg.obj);
                                dataspeed.setText(rem5 + "");
                                mobiledatastatus = isMobileDataEnabled();
                                if (mobiledatastatus == true) {
                                    mobiledatastate.setText("ON");
                                } else {
                                    mobiledatastate.setText("OFF");
                                }

                            } catch (Exception e) {
                            }


                    }
                    super.handleMessage(msg);
                }
            };
            myHandlerThread = new MyHandlerThread(handler, this);
            myDataHandler = new DataHandler(handler, this);
        } catch (Exception e) {
        }
    }


    @Override
    protected void onDestroy() {
        myHandlerThread.quit();
        super.onDestroy();
    }

    public void lightintenstySection() {
        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mlightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mySensorManager.registerListener(lightintenstySensorsEventListener, mlightSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }


    SensorEventListener lightintenstySensorsEventListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                lightintensty.setText(event.values[0] + "Lux");
            }
        }
    };


}

