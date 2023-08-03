/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.opap;

import jokerstats.model.Draw;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.gson.Gson;
import java.time.Month;
import java.time.YearMonth;

import jokerstats.opap.statistics.JokerStatistics;

public class OpapApiHandler {
    
    // HttpClient που χρησιμοποιείται για την επικοινωνία
    // της εφαρμογής με το API του ΟΠΑΠ.
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    
    // Χρησιμοποιείται για την μετατροπή του κειμένου(σε μορφή json),
    // που επιστρέφεται μετα απο μια κλήση στο API,
    // στο αντίστοιχο αντικειμενο που θα χρησιμοποιηθεί απο την εφαρμογή.
    private static final Gson GSON = new Gson();
   
    //==========================================================================
       
    /**
    * Πραγματοποιεί μια κλήση στο API του ΟΠΑΠ, συγκεκριμένα στο url:
    * "https://api.opap.gr/draws/v3.0/5104/draw-date/fromDate/toDate",
    * επιστρέφοντας πίσω ένα αντικέιμενο DrawsInDateRange, το οποίο περιέχει
    * τις κληρώσεις που πραγματοποιήθηκαν σε ένα εύρος ημερομηνιών. 
    * 
    * @return ενα Optional αντικείμενο με τιμή:
    *  - DrawsInDateRange εαν η κλήση ήταν επιτυχής
    *  - empty            σε περίπτωση αποτυχίας
    */
    public static Optional<DrawsInDateRange> getDrawsInDateRange(LocalDate fromDate, LocalDate toDate) {
        return 
            getOpapApiResponse(
                "https://api.opap.gr/draws/v3.0/5104/draw-date/"+fromDate+"/"+toDate+"?limit=100",
                DrawsInDateRange.class
            );         
    }
    
    /**
    * Πραγματοποιεί μια κλήση στο API του ΟΠΑΠ, συγκεκριμένα στο url:
    * "https://api.opap.gr/draws/v3.0/5104/drawId",
    * επιστρέφοντας πίσω ένα αντικέιμενο Draw, το οποίο περιέχει 
    * τις πληροφορίες για μία κλήρωση. 
    * 
    * @return ενα Optional αντικείμενο με τιμή:
    *  - Draw  εαν η κλήση ήταν επιτυχής
    *  - empty σε περίπτωση αποτυχίας
    */
    public static Optional<Draw> getDrawById(String drawId) { 
        return 
            getOpapApiResponse(
                "https://api.opap.gr/draws/v3.0/5104/"+drawId,
                Draw.class
            );     
    }
    
    /**
    * Πραγματοποιεί μια κλήση στο API του ΟΠΑΠ, συγκεκριμένα στο url:
    * "https://api.opap.gr/games/v1.0/5104/statistics",
    * επιστρέφοντας πίσω ένα αντικέιμενο JokerStatistics, το οποίο περιέχει 
    * στατιστικια στοιχεία για καθε πιθανο αριθμο του παιχνιδιου τζοκερ [1-45]
    * καθως και της σειρας μπονους [1-20]. 
    * 
    * @return ενα Optional αντικείμενο με τιμή:
    *  - JokerStatistics εαν η κλήση ήταν επιτυχής
    *  - empty σε περίπτωση αποτυχίας
    */
    public static Optional<JokerStatistics> getJokerStatistics() { 
        return 
            getOpapApiResponse(
                "https://api.opap.gr/games/v1.0/5104/statistics",
                JokerStatistics.class
            );     
    }
    
    //==========================================================================
    
    /**
    * Χρησιμοποιώντας την ηδη υπάρχουσα μεθοδο getDrawsInDateRange,
    * παιρνει ολες τις κληρώσεις που εγιναν για το τζοκερ τον μηνα
    * month και το έτος year, και επιστρέφει ενα αντικείμενο MonthlyStats
    * που αντιπροσωπεύει τα στατιστικα για τις κληρώσεις αυτές.
    * 
    * @return ενα Optional αντικείμενο με τιμή:
    *  - MonthlyStats εαν η κλήση ήταν επιτυχής
    *  - empty σε περίπτωση αποτυχίας
    */
    public static Optional<MonthlyStats> getStatsForMonth(int year, Month month) {
        
        Optional<DrawsInDateRange> drawsInMonth = 
                getDrawsInDateRange(
                    LocalDate.of(year, month, 1),
                    LocalDate.of(year, month, YearMonth.of(year, month).lengthOfMonth())
                );
        
        if(drawsInMonth.isPresent()) 
            return Optional.of(
                        new MonthlyStats(
                            year, 
                            month, 
                            drawsInMonth.get().getContent()
                        )
                    );
        else 
            return Optional.empty();
    }

    //==========================================================================

    /**
    * Πραγματοποιεί μια κλήση στο API του ΟΠΑΠ
    * στο url που δίνεται σαν παραμετρος.
    * Σε περιπτωση επιτυχούς κλήσης χρησιμοποιέι 
    * την βιβλιοθήκη gson και την κλάση Τ (δινεται ως παραμετρος),
    * για να δημιουργήσει ένα αντικείμενο τυπου Τ με τα στοιχεία απο 
    * το json της επιτυχούς κλησης.
    * 
    * @return ενα Optional αντικείμενο με τιμή:
    *  - Τ εαν η κλήση ήταν επιτυχής
    *  - empty σε περίπτωση αποτυχίας
    */
    private static <T> Optional<T> getOpapApiResponse(String url, Class<T> classOfT) {

        Optional<String> response = makeGETrequest(url);
        
        if(response.isPresent()) {
            String json = response.get();
            
            T result = GSON.fromJson(json, classOfT);
            
            return Optional.of(result);
        } else 
            return Optional.empty();               
    }
    
    /**
    * Πραγματοποιεί μια κλήση στο API του ΟΠΑΠ, 
    * συγκεκριμένα στο url που δίνεται σαν παραμετρος
    * επιστρέφοντας πίσω ενα Json ως String σε περίπτωση 
    * επιτυχούς κλήσης.
    * 
    * @return ενα Optional αντικείμενο με τιμή:
    *  - String εαν η κλήση ήταν επιτυχής (200)
    *  - empty σε περίπτωση αποτυχίας
    */
    private static Optional<String> makeGETrequest(String url) {
        
        Request request = 
            new Request.Builder()
                .url(url)
                .get()
                .build();
        
        try {
            Response response = HTTP_CLIENT.newCall(request).execute(); 
            
            if (response.code() == 200) {
                
                String responseBodyJSON = response.body().string();

                return Optional.of(responseBodyJSON);     
            }
            else 
                return Optional.empty();
        } 
        catch (IOException io) {
            return Optional.empty();
        }      
    }   
}