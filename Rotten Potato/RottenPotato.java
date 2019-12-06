import java.util.Scanner;

public class RottenPotato{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int movie = 0;
        int reviewer = 0;
        int[][] ratings = { {4,6,2,5},
                {7,9,4,8},
                {6,9,3,7} };
        System.out.println("choose movie(movies number 0,1,2):");           
        movie = sc.nextInt();
        System.out.println("choose reviewer(reviewers number 0,1,2):");
        reviewer = sc.nextInt();
        double avgrating = movieAvgRating(ratings, movie);
        System.out.println("average rating for your movie is: "+avgrating);
        double avgrating2 = reviewerAvgRating(ratings, reviewer);
        System.out.println("average rating for your reviewer is: "+avgrating2);
        double avgrating3 = avgRating2018(ratings);
        System.out.println("average movie rating in 2018 was: "+avgrating3);
        double hard = hardestRater2018(ratings);
        System.out.println("the hardest rater in 2018 was rater number "+hard);
        double worst = worstMovie2018(ratings);
        System.out.println("the worst movie of 2018 was movie number "+worst);
    }

    public static double movieAvgRating(int[][] ratings, int movie){
        double avgrating = 0;
        for(int i = 0; i<ratings.length; i++){
            avgrating += ratings[i][movie];
        }
        return avgrating/ratings.length;

    }

    public static double reviewerAvgRating(int[][] ratings, int reviewer){
        double avgrating = 0;
        for(int i = 0; i<ratings[0].length; i++){
            avgrating += ratings[reviewer][i];
        }
        return avgrating/ratings[0].length;
    }

    public static double avgRating2018(int[][] ratings){
        double avgrating = 0;
        int n = ratings.length * ratings[0].length;
        for(int r = 0; r<ratings.length; r++){
            for(int c = 0; c<ratings[0].length; c++){
                avgrating += ratings[r][c];
            }
        }
        return avgrating/n;
    }

    public static double hardestRater2018(int[][] ratings){
        double avgrating0 = 0;
        double avgrating1 = 0;
        double avgrating2 = 0;
        for(int i = 0; i<ratings[0].length; i++){
            avgrating0 += ratings[0][i];
        }
        avgrating0 = avgrating0/ratings[0].length;

        for(int i = 0; i<ratings[0].length; i++){
            avgrating1 += ratings[1][i];
        }
        avgrating1 = avgrating1/ratings[1].length;

        for(int i = 0; i<ratings[0].length; i++){
            avgrating2 += ratings[2][i];
        }
        avgrating2 = avgrating2/ratings[2].length;

        if(avgrating0 < avgrating1 && avgrating0 < avgrating2){
            return 0;
        }else if(avgrating1 < avgrating0 && avgrating1 < avgrating2){
            return 1;
        }else {
            return 2;
        }
    }

    public static int worstMovie2018(int[][] ratings){
        double movie0 = 0;
        double movie1 = 0;
        double movie2 = 0;
        for(int i = 0; i<ratings.length; i++){
            movie0 += ratings[i][0];
        }
        movie0 = movie0/3;

        for(int i = 0; i<ratings.length; i++){
            movie1 += ratings[i][1];
        }
        movie1 = movie1/3;

        for(int i = 0; i<ratings.length; i++){
            movie2 += ratings[i][2];
        }
        movie2 = movie2/3;
        
        
        
        if(movie0 < movie1 && movie0 < movie2){
            return 0;
        }else if(movie1 < movie0 && movie1 < movie2){
            return 1;
        }else {
            return 2;
        }
    }
}