// 2353. Design a Food Rating System - Medium

class FoodRatings {

    class CR{
        String cuisine;
        int rating;
        public CR(String c,int r){
            cuisine = c;
            rating = r;
        }
    }

    class FR{
        String food;
        int rating;
        public FR(String f,int r){
            food = f;
            rating = r;
        }
    }

    public static Map<String,CR> foodToRatings;
    public static Map<String,PriorityQueue<FR>> maxRatings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRatings = new HashMap<>();
        maxRatings = new HashMap<>();
        for(int i=0;i<foods.length;i++){
            foodToRatings.put(foods[i],new CR(cuisines[i],ratings[i]));
            if(!maxRatings.containsKey(cuisines[i])){
                PriorityQueue<FR> pq = new PriorityQueue<>(new Comparator<FR>(){
                    @Override
                    public int compare(FR pair1,FR pair2){
                        if(pair1.rating == pair2.rating){
                            return pair1.food.compareTo(pair2.food);
                        }
                        return pair2.rating - pair1.rating;
                    }
                });
                maxRatings.put(cuisines[i],pq);
            }
            maxRatings.get(cuisines[i]).add(new FR(foods[i],ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodToRatings.get(food).rating = newRating;
        maxRatings.get(foodToRatings.get(food).cuisine).add(new FR(food,newRating));
    }
    
    public String highestRated(String cuisine) {
        while(foodToRatings.get(maxRatings.get(cuisine).peek().food).rating != maxRatings.get(cuisine).peek().rating){
            maxRatings.get(cuisine).poll();
        }
        return maxRatings.get(cuisine).peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
