import java.util.Arrays;

public class StateMissionariesCannibals {
    int[][] stateArray;
    boolean boat;
    //stateArray[0] = left bank
    //stateArray[1] = right bank
    //stateArray[x][0] = missionary
    //stateArray[x][1] = cannibal
    //boat = true: left bank
    //boat = false: right bank

    public StateMissionariesCannibals(int[][] stateArray) {
        this.stateArray = stateArray;
        this.boat = false;
    }

    public StateMissionariesCannibals(StateMissionariesCannibals state){
        int[][] copyArray = new int[2][2];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                copyArray[i][j] = state.stateArray[i][j];
            }
        }
        this.stateArray = copyArray;
        this.boat = state.boat;
    }

    public boolean equals(Object o) {
        return Arrays.deepEquals( stateArray, ((StateMissionariesCannibals) o).stateArray )
                && boat == ((StateMissionariesCannibals) o).boat;
    }

    public int hashCode() {
        return Arrays.deepHashCode( stateArray );
    }

    public String toString() {
        return Arrays.deepToString( stateArray );
    }
}