package com.jessicathornsby.datalayer;

import android.content.Intent;
import com.google.android.gms.wearable.MessageEvent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.android.gms.wearable.WearableListenerService;

public class MessageService extends WearableListenerService {

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        if (messageEvent.getPath().equals("/my_path")) {
            final String message = new String(messageEvent.getData());

//Broadcast the received data layer messages//

            Intent messageIntent = new Intent();
            messageIntent.setAction(Intent.ACTION_SEND);
            messageIntent.putExtra("message", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(messageIntent);
        }
        else {
            super.onMessageReceived(messageEvent);
        }
    }

}
