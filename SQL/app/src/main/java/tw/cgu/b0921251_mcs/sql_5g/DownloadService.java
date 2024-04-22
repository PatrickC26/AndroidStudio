package tw.cgu.b0921251_mcs.sql_5g;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import tw.cgu.b0921251_mcs.sql_5g.SensorListHandler;
import tw.cgu.b0921251_mcs.sql_5g.SensorStruct;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class DownloadService extends Service {

    public static final String ACTION_START = "com.example.task1.START_DOWNLOAD";

    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "Download_Channel";

    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager;

    ArrayList<SensorStruct> query_data = new ArrayList<SensorStruct>();

    String IPAddress="";

    @Override
    public void onCreate() {

        System.out.println("Creating @ onCreate...");
        super.onCreate();
        IPAddress = (String) this.getResources().getText(R.string.url);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createNotification();

        System.out.println("Created");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Creating @ startCommand ...");
        if (intent != null && ACTION_START.equals(intent.getAction())) {
            startD();
        }
        return START_STICKY;
    }

    private void startD() {
        new DownloadTask().execute();
    }

    private void showCompleteNotification() {
        NotificationCompat.Builder completeNotificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Notify")
                .setContentText("You have a new file.")
                .setSmallIcon(R.drawable.ic_baseline_done_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification completeNotification = completeNotificationBuilder.build();
        notificationManager.notify(NOTIFICATION_ID + 1, completeNotification);
    }

    private void createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Notifiy",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Download Service")
                .setContentText("Downloading...")
                .setSmallIcon(R.drawable.ic_notification_placeholder)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification notification = notificationBuilder.build();
        startForeground(NOTIFICATION_ID, notification);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class DownloadTask extends AsyncTask<String, Integer, Void> {

        @Override
        protected Void doInBackground(String... params) {

            String uriAPI = IPAddress + "getlist.php";

            Log.i("TAG", uriAPI);

            URL url = null;
            try{
                url = new URL(uriAPI);

                SAXParserFactory spf = SAXParserFactory.newInstance();
                SAXParser sp = spf.newSAXParser();
                XMLReader xr = sp.getXMLReader();
                //Using login handler for xml
                SensorListHandler myHandler = new SensorListHandler();
                xr.setContentHandler(myHandler);
                //open connection
                xr.parse(new InputSource(url.openStream()));
                //verify OK
                query_data = myHandler.getContainer().getListItems();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            Log.i("TAG", "size: " + query_data.size());


            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
        }

        @Override
        protected void onPostExecute(Void result) {
            if (query_data.size() != 0 )
                showCompleteNotification();
            try {
                Thread.sleep(1000); // Simulate download delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new DownloadTask().execute()
            ;
        }
    }
}
