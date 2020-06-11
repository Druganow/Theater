package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab_1.adapter.ActorAdapter;
import com.example.lab_1.model.Actor;
import com.example.lab_1.model.Theater;
import com.example.lab_1.service.JSoupActorService;
import com.example.lab_1.service.JSoupService;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ActorsActivity extends AppCompatActivity {

    TextView toolbarTextView;
    RecyclerView actorRecyclerView;
    ActorAdapter actorAdapter;
    ArrayList<Actor> actors;
    Theater theater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        Bundle intent = getIntent().getExtras();
        theater = (Theater)intent.getSerializable("theater");
        toolbarTextView = findViewById(R.id.toolbar_text_view);
        actorRecyclerView = findViewById(R.id.actors_recycler_view);


        toolbarTextView.setText(theater.getName());
        ActorTask task = new ActorTask();
        task.execute();

    }
    class ActorTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String[] theaterSite = getResources().getStringArray(R.array.theater_site);
                if(theater.getSite().equals(theaterSite[0])) {
                    Document document= JSoupService.goToHref("https://ekvus-kirov.ru/truppa");
                    actors = JSoupActorService.getTUZTheaterActorsList(document,"https://ekvus-kirov.ru/");
                }
                else if(theater.getSite().equals(theaterSite[1])){
                    Document document= JSoupService.goToHref("https://kirovdramteatr.ru/truppa");
                    actors = JSoupActorService.getDramaTheaterActorsList(document,"https://kirovdramteatr.ru/");
                }
                else {
                    Document document= JSoupService.goToHref("https://kirovkukla.ru/truppa");
                    actors =  JSoupActorService.getDollTheaterActorsList(document,"http://kirovkukla.ru/");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }
        protected void onPostExecute(Void aVoid){
            actorAdapter = new ActorAdapter(actors);
            actorRecyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(),2));
            actorRecyclerView.setAdapter(actorAdapter);
        }
    }
}
