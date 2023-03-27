package business;

public class BaseProduct extends MenuItem{
    private double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;

    public BaseProduct(String title,double rating, int calories, int protein, int fat, int sodium, int price) throws AssertionError {
        this.title=title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        validate();
    }
    public BaseProduct(){
    }

    @Override
    public int computePrice() {
        return price;
    }

    @Override
    public void validate() throws AssertionError{
        assert title!=null&&title.length()>0:"Invalid title.";
        assert rating>=0&&rating<=5:"Invalid rating.";
        assert calories>=0:"Invalid calories.";
        assert protein>=0:"Invalid proteins.";
        assert fat>=0:"Invalid fats.";
        assert sodium>=0:"Invalid sodium.";
        assert price>=0:"Invalid price.";
    }

    public String toString(){
        return title+", "+rating+" stars, "+calories+" calories, "+protein+" protein, "+fat+" fat, "+sodium+" sodium, $"+price+".";
    }

    public double getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
