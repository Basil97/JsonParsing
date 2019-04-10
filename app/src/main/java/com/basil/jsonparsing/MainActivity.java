package com.basil.jsonparsing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String JSON_DATA = "{\"page\":1,\"total_results\":19760,\"total_pages\":988,\"results\":[{\"vote_count\":1316,\"id\":166428,\"video\":false,\"vote_average\":7.6,\"title\":\"How to Train Your Dragon: The Hidden World\",\"popularity\":516.82,\"poster_path\":\"\\/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg\",\"original_language\":\"en\",\"original_title\":\"How to Train Your Dragon: The Hidden World\",\"genre_ids\":[16,10751,12],\"backdrop_path\":\"\\/h3KN24PrOheHVYs9ypuOIdFBEpX.jpg\",\"adult\":false,\"overview\":\"As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.\",\"release_date\":\"2019-01-03\"},{\"vote_count\":3463,\"id\":299537,\"video\":false,\"vote_average\":7.2,\"title\":\"Captain Marvel\",\"popularity\":405.263,\"poster_path\":\"\\/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg\",\"original_language\":\"en\",\"original_title\":\"Captain Marvel\",\"genre_ids\":[28,12,878],\"backdrop_path\":\"\\/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg\",\"adult\":false,\"overview\":\"The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.\",\"release_date\":\"2019-03-06\"},{\"vote_count\":1960,\"id\":450465,\"video\":false,\"vote_average\":6.5,\"title\":\"Glass\",\"popularity\":364.902,\"poster_path\":\"\\/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg\",\"original_language\":\"en\",\"original_title\":\"Glass\",\"genre_ids\":[53,9648,18,14,878],\"backdrop_path\":\"\\/lvjscO8wmpEbIfOEZi92Je8Ktlg.jpg\",\"adult\":false,\"overview\":\"In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.\",\"release_date\":\"2019-01-16\"},{\"vote_count\":556,\"id\":329996,\"video\":false,\"vote_average\":6.8,\"title\":\"Dumbo\",\"popularity\":254.497,\"poster_path\":\"\\/iYwKQAO1LwLpInMMdvmYChrRlHN.jpg\",\"original_language\":\"en\",\"original_title\":\"Dumbo\",\"genre_ids\":[12,10751,14],\"backdrop_path\":\"\\/5tFt6iuGnKapHl5tw0X0cKcnuVo.jpg\",\"adult\":false,\"overview\":\"A young elephant, whose oversized ears enable him to fly, helps save a struggling circus, but when the circus plans a new venture, Dumbo and his friends discover dark secrets beneath its shiny veneer.\",\"release_date\":\"2019-03-27\"},{\"vote_count\":410,\"id\":287947,\"video\":false,\"vote_average\":7.4,\"title\":\"Shazam!\",\"popularity\":241.766,\"poster_path\":\"\\/xnopI5Xtky18MPhK40cZAGAOVeV.jpg\",\"original_language\":\"en\",\"original_title\":\"Shazam!\",\"genre_ids\":[28,35,12,14],\"backdrop_path\":\"\\/bi4jh0Kt0uuZGsGJoUUfqmbrjQg.jpg\",\"adult\":false,\"overview\":\"A boy is given the ability to become an adult superhero in times of need with a single magic word.\",\"release_date\":\"2019-03-23\"},{\"vote_count\":744,\"id\":458723,\"video\":false,\"vote_average\":7.3,\"title\":\"Us\",\"popularity\":226.851,\"poster_path\":\"\\/ux2dU1jQ2ACIMShzB3yP93Udpzc.jpg\",\"original_language\":\"en\",\"original_title\":\"Us\",\"genre_ids\":[53,27],\"backdrop_path\":\"\\/ADJ6V8W96It4KElY2SPZvkKPBR.jpg\",\"adult\":false,\"overview\":\"Husband and wife Gabe and Adelaide Wilson take their kids to their beach house expecting to unplug and unwind with friends. But as night descends, their serenity turns to tension and chaos when some shocking visitors arrive uninvited.\",\"release_date\":\"2019-03-14\"},{\"vote_count\":1769,\"id\":424783,\"video\":false,\"vote_average\":6.4,\"title\":\"Bumblebee\",\"popularity\":190.799,\"poster_path\":\"\\/fw02ONlDhrYjTSZV8XO6hhU3ds3.jpg\",\"original_language\":\"en\",\"original_title\":\"Bumblebee\",\"genre_ids\":[28,12,878],\"backdrop_path\":\"\\/wtZj5nn6hVwgakPdg6y6gm3eFXU.jpg\",\"adult\":false,\"overview\":\"On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken.  When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.\",\"release_date\":\"2018-12-15\"},{\"vote_count\":229,\"id\":500682,\"video\":false,\"vote_average\":7,\"title\":\"The Highwaymen\",\"popularity\":151.833,\"poster_path\":\"\\/4bRYg4l12yDuJvAfqvUOPnBrxno.jpg\",\"original_language\":\"en\",\"original_title\":\"The Highwaymen\",\"genre_ids\":[80,18,53],\"backdrop_path\":\"\\/pZ78ksjPlXf3q2EeONN8WdHE03Y.jpg\",\"adult\":false,\"overview\":\"In 1934, Frank Hamer and Manny Gault, two former Texas Rangers, are commissioned to put an end to the wave of vicious crimes perpetrated by Bonnie Parker and Clyde Barrow, a notorious duo of infamous robbers and cold-blooded killers who nevertheless are worshiped by the public.\",\"release_date\":\"2019-03-15\"},{\"vote_count\":12468,\"id\":299536,\"video\":false,\"vote_average\":8.3,\"title\":\"Avengers: Infinity War\",\"popularity\":142.74,\"poster_path\":\"\\/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg\",\"original_language\":\"en\",\"original_title\":\"Avengers: Infinity War\",\"genre_ids\":[12,28,14],\"backdrop_path\":\"\\/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg\",\"adult\":false,\"overview\":\"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\",\"release_date\":\"2018-04-25\"},{\"vote_count\":74,\"id\":157433,\"video\":false,\"vote_average\":5.9,\"title\":\"Pet Sematary\",\"popularity\":142.094,\"poster_path\":\"\\/7SPhr7Qj39vbnfF9O2qHRYaKHAL.jpg\",\"original_language\":\"en\",\"original_title\":\"Pet Sematary\",\"genre_ids\":[27,53],\"backdrop_path\":\"\\/n2aX63BmW7zIKgKJ58e6rKlSsdi.jpg\",\"adult\":false,\"overview\":\"Louis Creed, his wife Rachel and their two children Gage and Ellie move to a rural home where they are welcomed and enlightened about the eerie 'Pet Sematary' located nearby. After the tragedy of their cat being killed by a truck, Louis resorts to burying it in the mysterious pet cemetery, which is definitely not as it seems, as it proves to the Creeds that sometimes dead is better.\",\"release_date\":\"2019-04-04\"},{\"vote_count\":618,\"id\":522681,\"video\":false,\"vote_average\":6.4,\"title\":\"Escape Room\",\"popularity\":138.695,\"poster_path\":\"\\/8yZAx7tlKRZIg7pJfaPhl00yHIQ.jpg\",\"original_language\":\"en\",\"original_title\":\"Escape Room\",\"genre_ids\":[27,53,28,878,12,18,9648],\"backdrop_path\":\"\\/mWLljCmpqlcYQh7uh51BBMwCZwN.jpg\",\"adult\":false,\"overview\":\"Six strangers find themselves in circumstances beyond their control, and must use their wits to survive.\",\"release_date\":\"2019-01-03\"},{\"vote_count\":5127,\"id\":297802,\"video\":false,\"vote_average\":6.8,\"title\":\"Aquaman\",\"popularity\":134.097,\"poster_path\":\"\\/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg\",\"original_language\":\"en\",\"original_title\":\"Aquaman\",\"genre_ids\":[28,12,14,878],\"backdrop_path\":\"\\/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg\",\"adult\":false,\"overview\":\"Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.\",\"release_date\":\"2018-12-07\"},{\"vote_count\":1130,\"id\":504172,\"video\":false,\"vote_average\":6.5,\"title\":\"The Mule\",\"popularity\":130.753,\"poster_path\":\"\\/oeZh7yEz3PMnZLgBPhrafFHRbVz.jpg\",\"original_language\":\"en\",\"original_title\":\"The Mule\",\"genre_ids\":[80,18,53],\"backdrop_path\":\"\\/bTeRgkAavyw1eCtSkaww18wLYNP.jpg\",\"adult\":false,\"overview\":\"Earl Stone, a man in his 80s who is broke, alone, and facing foreclosure of his business when he is offered a job that simply requires him to drive. Easy enough, but, unbeknownst to Earl, he’s just signed on as a drug courier for a Mexican cartel. He does so well that his cargo increases exponentially, and Earl hit the radar of hard-charging DEA agent Colin Bates.\",\"release_date\":\"2018-12-14\"},{\"vote_count\":0,\"id\":299534,\"video\":false,\"vote_average\":0,\"title\":\"Avengers: Endgame\",\"popularity\":129.978,\"poster_path\":\"\\/dHjLaIUHXcMBt7YxK1TKWK1end9.jpg\",\"original_language\":\"en\",\"original_title\":\"Avengers: Endgame\",\"genre_ids\":[12,878,28],\"backdrop_path\":\"\\/orjiB3oUIsyz60hoEqkiGpy5CeO.jpg\",\"adult\":false,\"overview\":\"After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.\",\"release_date\":\"2019-04-24\"},{\"vote_count\":34,\"id\":390634,\"video\":false,\"vote_average\":4.8,\"title\":\"Fate\\/stay night: Heaven’s Feel II. lost butterfly\",\"popularity\":124.347,\"poster_path\":\"\\/4tS0iyKQBDFqVpVcH21MSJwXZdq.jpg\",\"original_language\":\"ja\",\"original_title\":\"劇場版「Fate\\/stay night [Heaven's Feel] ⅠⅠ. lost butterfly」\",\"genre_ids\":[16,28,14,12],\"backdrop_path\":\"\\/2zKusjJZd8b2Cdk2C5K9dGFNWiJ.jpg\",\"adult\":false,\"overview\":\"Theatrical-release adaptation of the visual novel \\\"Fate\\/stay night\\\", following the third and final route. (Part 2 of a trilogy.)\",\"release_date\":\"2019-01-12\"},{\"vote_count\":7177,\"id\":920,\"video\":false,\"vote_average\":6.7,\"title\":\"Cars\",\"popularity\":110.411,\"poster_path\":\"\\/5damnMcRFKSjhCirgX3CMa88MBj.jpg\",\"original_language\":\"en\",\"original_title\":\"Cars\",\"genre_ids\":[16,12,35,10751],\"backdrop_path\":\"\\/a1MlbLBk5Sy6YvMbSuKfwGlDVlb.jpg\",\"adult\":false,\"overview\":\"Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.\",\"release_date\":\"2006-06-08\"},{\"vote_count\":12,\"id\":485811,\"video\":false,\"vote_average\":5.4,\"title\":\"Redcon-1\",\"popularity\":109.57,\"poster_path\":\"\\/vVPrWngVJ2cfYAncBedQty69Dlf.jpg\",\"original_language\":\"en\",\"original_title\":\"Redcon-1\",\"genre_ids\":[28,27],\"backdrop_path\":\"\\/palbhPOSYf2g1p18vWd91dDhZLM.jpg\",\"adult\":false,\"overview\":\"After a zombie apocalypse spreads from a London prison, the UK is brought to its knees. The spread of the virus is temporarily contained but, without a cure, it’s only a matter of time before it breaks its boundaries and the biggest problem of all… any zombies with combat skills are now enhanced. With the South East of England quarantined from the rest of the world using fortified borders, intelligence finds that the scientist responsible for the outbreak is alive and well in London. With his recovery being the only hope of a cure, a squad of eight Special Forces soldiers is sent on a suicide mission to the city, now ruled by the undead, with a single task: get him out alive within 72 hours by any means necessary. What emerges is an unlikely pairing on a course to save humanity against ever-rising odds.\",\"release_date\":\"2018-09-28\"},{\"vote_count\":3092,\"id\":324857,\"video\":false,\"vote_average\":8.5,\"title\":\"Spider-Man: Into the Spider-Verse\",\"popularity\":106.611,\"poster_path\":\"\\/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg\",\"original_language\":\"en\",\"original_title\":\"Spider-Man: Into the Spider-Verse\",\"genre_ids\":[28,12,16,878,35],\"backdrop_path\":\"\\/uUiId6cG32JSRI6RyBQSvQtLjz2.jpg\",\"adult\":false,\"overview\":\"Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.\",\"release_date\":\"2018-12-07\"},{\"vote_count\":8,\"id\":576071,\"video\":false,\"vote_average\":7.4,\"title\":\"Unplanned\",\"popularity\":106.397,\"poster_path\":\"\\/hQvf3RHgmp4XXXl2y6zhMe4G4kg.jpg\",\"original_language\":\"en\",\"original_title\":\"Unplanned\",\"genre_ids\":[18],\"backdrop_path\":\"\\/tgjwS3oh53biNsNuzRKUjUVdXAE.jpg\",\"adult\":false,\"overview\":\"As one of the youngest Planned Parenthood clinic directors in the nation, Abby Johnson was involved in upwards of 22,000 abortions and counseled countless women on their reproductive choices. Her passion surrounding a woman's right to choose led her to become a spokesperson for Planned Parenthood, fighting to enact legislation for the cause she so deeply believed in. Until the day she saw something that changed everything.\",\"release_date\":\"2019-03-21\"},{\"vote_count\":4249,\"id\":338952,\"video\":false,\"vote_average\":6.9,\"title\":\"Fantastic Beasts: The Crimes of Grindelwald\",\"popularity\":99.393,\"poster_path\":\"\\/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg\",\"original_language\":\"en\",\"original_title\":\"Fantastic Beasts: The Crimes of Grindelwald\",\"genre_ids\":[10751,14,12],\"backdrop_path\":\"\\/wDN3FIcQQ1HI7mz1OOKYHSQtaiE.jpg\",\"adult\":false,\"overview\":\"Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.\",\"release_date\":\"2018-11-14\"}]}";

        String DATA_URL = "https://api.themoviedb.org/3/movie/popular?api_key=695b65f9b780614359f31b01a1b39b12&language=en-US&page=1";

        task.execute(DATA_URL);

        /*
        TextView titleTxt = findViewById(R.id.title);
        TextView overview = findViewById(R.id.overview);
        TextView vote = findViewById(R.id.vote);

        try {
            Movies movie = getDataFromJson(JSON_DATA);
            titleTxt.setText(movie.title);
            vote.setText(String.valueOf(movie.vote));
            overview.setText(movie.overview);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    AsyncTask<String, Void, Movies> task = new AsyncTask<String, Void, Movies>() {
        @Override
        protected Movies doInBackground(String... strings) {
            String data = makeURLConnection(strings[0]);
            if (TextUtils.isEmpty(data)) return null;

            try {
                return getDataFromJson(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Movies movie) {
            TextView titleTxt = findViewById(R.id.title);
            TextView overview = findViewById(R.id.overview);
            TextView vote = findViewById(R.id.vote);

            if (movie == null) return;
            titleTxt.setText(movie.title);
            vote.setText(String.valueOf(movie.vote));
            overview.setText(movie.overview);
        }
    };


    Movies getDataFromJson(String jsonData) throws JSONException {
        JSONObject root = new JSONObject(jsonData);
        JSONArray results = root.getJSONArray("results");
        JSONObject movie = results.getJSONObject(1);
        long id = movie.getLong("id");
        String title = movie.getString("title");
        String overview = movie.getString("overview");
        String imageURL = movie.getString("poster_path");
        float vote = (float) movie.getDouble("vote_average");
        return new Movies(title, overview,imageURL, id, vote);
    }

    String makeURLConnection(String URL_String){
        String JSONData = null;
        URL url = createURL(URL_String);
        if (url != null) {
            HttpURLConnection connection = null;
            InputStream stream = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(15000);
                connection.setReadTimeout(10000);
                connection.setRequestMethod("GET");
                connection.connect();

                stream = connection.getInputStream();
                JSONData = readDataFromStream(stream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return JSONData;
    }

    String readDataFromStream(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        if (stream != null) {
            InputStreamReader reader = new InputStreamReader(stream, Charset.forName("UTF-8"));
            BufferedReader buffered = new BufferedReader(reader);
            String line;
            while ((line = buffered.readLine()) != null) {
                builder.append(line);
            }
        }
        return builder.toString();
    }

    private URL createURL(String string_url) {
        URL url = null;
        try {
            url = new URL(string_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("URL", e.getMessage());
        }
        return url;
    }
}
