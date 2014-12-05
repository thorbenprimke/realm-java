package io.realm.memoryleak;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.myapplication.R;


public class MainActivity extends ActionBarActivity {

    private Realm realm;
    private RealmResults<Dummy> results;
    private Thread backgroundThread;
    private RealmChangeListener realmChangeListener = new RealmChangeListener() {
        @Override
        public void onChange() {
            refreshUI();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getInstance(this);
        results = realm.allObjects(Dummy.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        realm.addChangeListener(realmChangeListener);

        backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Realm backgroundRealm = Realm.getInstance(MainActivity.this, false);
                int i = 0;
                while(!backgroundThread.isInterrupted()) {

                    backgroundRealm.beginTransaction();
                    Dummy dummy = backgroundRealm.createObject(Dummy.class);
                    dummy.setName("Name " + i);
                    dummy.setId(i);
                    backgroundRealm.commitTransaction();

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                backgroundRealm.close();
            }
        });
        backgroundThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        realm.removeChangeListener(realmChangeListener);
        backgroundThread.interrupt();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private void refreshUI() {
        // Refresh UI which entails looping the query
        long sum = 0;
        for (Dummy obj : results) {
            // Do interesting stuff with the objects
            sum += obj.getId();
        }
    }
}
