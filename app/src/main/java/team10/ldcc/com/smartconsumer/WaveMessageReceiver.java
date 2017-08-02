package team10.ldcc.com.smartconsumer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.laboratory.ldcc.wave.wave.WaveMessage;

/**
 * Created by Gelgel on 2017. 8. 2..
 */
public class WaveMessageReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        WaveMessage message = intent.getParcelableExtra("wavedate");
    }
}
