package org.firstinspires.ftc.teamcode.Subsystems;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import android.app.Activity;
import android.view.KeyEvent;

public class Keyboard extends Activity{
    public boolean w, a, s, d = false;
    public Telemetry t;
    public Keyboard(Telemetry telemetry) {
        this.t = telemetry;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_W:
                t.addData("Keycode W: ", keyCode);
                return true;
            case KeyEvent.KEYCODE_A:
                t.addData("Keycode A: ", keyCode);
                return true;
            case KeyEvent.KEYCODE_S:
                t.addData("Keycode S: ", keyCode);
                return true;
            case KeyEvent.KEYCODE_D:
                t.addData("Keycode D: ", keyCode);
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }
}
