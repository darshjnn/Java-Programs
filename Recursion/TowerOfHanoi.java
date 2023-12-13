public class TowerOfHanoi {

    public static void solveTower(int n, String Source, String Helper, String Destination){
        if (n == 1){
            System.out.println("Transferred Disk " +n+ " from " +Source+ " to " +Destination);
            return;
        }

        solveTower(n-1, Source, Destination, Helper);
        System.out.println("Transferred Disk " +n+ " from " +Source+ " to " +Destination);

        solveTower(n-1, Helper, Source, Destination);
    }
    public static void main(String args[]){
        int n = 3;
        solveTower(n, "S", "H", "D");
    }    
}
