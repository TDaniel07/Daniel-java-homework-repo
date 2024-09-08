public class Ex8 {

    //The exercise did not specify if a movie title repeats itself wether or not the function should return just the first index or all of them so I asumed it just wants the first.
    public static void getMovieTitleIndex(String[] moviesArray, String movieTitle){
        for(int i = 0; i < moviesArray.length; i++){
            if(moviesArray[i].equals(movieTitle)){
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        String[] movies = {"Oppenheimer", "Mission Impossible", "Barry Seal", "Forrest Gump", "The Avengers"};

        getMovieTitleIndex(movies, "Forrest Gump");
    }
}
