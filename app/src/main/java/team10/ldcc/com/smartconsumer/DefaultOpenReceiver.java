package team10.ldcc.com.smartconsumer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.laboratory.ldcc.wave.downstream.MessageEntity;
import com.laboratory.ldcc.wave.wave.Wave;

/**
 * Created by Gelgel on 2017. 8. 2..
 */
public class DefaultOpenReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        MessageEntity messageEntity = intent.getParcelableExtra("message");
        String docID = intent.getStringExtra("doc_id");
        Wave.getInstance().sendOpenResultToServer(context.getApplicationContext(),
                messageEntity.getDocId(),
                messageEntity.getCampaignName(),
                messageEntity.getCreateTime(),
                messageEntity.getAgentID());
    }
}
