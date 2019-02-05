package org.firstinspires.ftc.robotcontroller.internal;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import android.app.Activity;
import android.view.KeyEvent;

public class Yeetboard extends Activity{
    public static boolean w, a, s, d = false;
    public Telemetry t;
    public Yeetboard(Telemetry telemetry) {
        this.t = telemetry;
    }
    public static boolean keyAct(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                w = true;
                return true;
            case KeyEvent.KEYCODE_A:
                a = true;
                return true;
            case KeyEvent.KEYCODE_S:
                s = true;
                return true;
            case KeyEvent.KEYCODE_D:
                d = true;
                return true;
            default:
                w = false;
                a = false;
                s = false;
                d = false;
                return true;
        }
    }
}
