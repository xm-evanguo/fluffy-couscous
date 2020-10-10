import java.util.*;

public class ProblemMissionariesCannibals extends Problem {

    boolean goal_test(Object state) {
        StateMissionariesCannibals problemState = (StateMissionariesCannibals) state;
        int[][] successfulState = {{0, 0}, {0, 0}, {3, 3}};
        if(Arrays.deepEquals(successfulState, problemState.stateArray)){
            return true;
        }
        return false;
    }

    Set<Object> getSuccessors(Object state) {

        Set<Object> set = new HashSet<Object>();
        StateMissionariesCannibals s = (StateMissionariesCannibals) state;
        StateMissionariesCannibals ss = new StateMissionariesCannibals(s);
        List<StateMissionariesCannibals> listState = new ArrayList<>();
        listState.add(ss);

        //offload one missionary on boat
        ss = new StateMissionariesCannibals(s);
        if(ss.stateArray[1][0] > 0){
            ss.stateArray[1][0] -= 1;
            if(!ss.boat){
                ss.stateArray[0][0] += 1;
            }else{
                ss.stateArray[2][0] += 1;
            }
            listState.add(new StateMissionariesCannibals(ss));
            if(isStateAllow(ss)){
                set.add(new StateMissionariesCannibals(ss));
            }
            if(ss.stateArray[1][0] + ss.stateArray[1][1] > 0){
                ss.boat = !ss.boat;
                if(isStateAllow(ss)){
                    set.add(ss);
                }
            }
        }

        //offload two missionaries on boat
        ss = new StateMissionariesCannibals(s);
        if(ss.stateArray[1][0] == 2){
            ss.stateArray[1][0] -= 2;
            if(!ss.boat){
                ss.stateArray[0][0] += 2;
            }else{
                ss.stateArray[2][0] += 2;
            }
            listState.add(ss);
            if(isStateAllow(ss)){
                set.add(ss);
            }
        }

        //offload one cannibal on boat
        ss = new StateMissionariesCannibals(s);
        if(ss.stateArray[1][1] > 0){
            ss.stateArray[1][1] -= 1;
            if(!ss.boat){
                ss.stateArray[0][1] += 1;
            }else{
                ss.stateArray[2][1] += 1;
            }
            listState.add(new StateMissionariesCannibals(ss));
            if(isStateAllow(ss)){
                set.add(new StateMissionariesCannibals(ss));
            }
            if(ss.stateArray[1][0] + ss.stateArray[1][1] > 0){
                ss.boat = !ss.boat;
                if(isStateAllow(ss)){
                    set.add(ss);
                }
            }
        }

        //offload two cannibals on boat
        ss = new StateMissionariesCannibals(s);
        if(ss.stateArray[1][1] == 2){
            ss.stateArray[1][1] -= 2;
            if(!ss.boat){
                ss.stateArray[0][1] += 2;
            }else{
                ss.stateArray[2][1] += 2;
            }
            listState.add(ss);
            if(isStateAllow(ss)){
                set.add(ss);
            }
        }

        //offload one cannibal and one missionary on boat
        ss = new StateMissionariesCannibals(s);
        if(ss.stateArray[1][0] > 0 && ss.stateArray[1][1] > 0){
            ss.stateArray[1][0] -= 1;
            ss.stateArray[1][1] -= 1;
            if(!ss.boat){
                ss.stateArray[0][0] += 1;
                ss.stateArray[0][1] += 1;
            }else{
                ss.stateArray[2][0] += 1;
                ss.stateArray[2][1] += 1;
            }
            listState.add(ss);
            if(isStateAllow(ss)){
                set.add(ss);
            }
        }

        //two missionaries get on boat
        for(StateMissionariesCannibals tmpState: listState) {
            ss = new StateMissionariesCannibals(tmpState);
            if (!ss.boat && ss.stateArray[0][0] > 1) {
                ss.stateArray[0][0] -= 2;
                ss.stateArray[1][0] += 2;
                ss.boat = true;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }else if (ss.boat && ss.stateArray[2][0] > 1) {
                ss.stateArray[2][0] -= 2;
                ss.stateArray[1][0] += 2;
                ss.boat = false;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }

            //one missionary get on boat
            ss = new StateMissionariesCannibals(tmpState);
            if (!ss.boat && ss.stateArray[0][0] > 0) {
                ss.stateArray[0][0] -= 1;
                ss.stateArray[1][0] += 1;
                ss.boat = true;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }else if (ss.boat && ss.stateArray[2][0] > 0) {
                ss.stateArray[2][0] -= 1;
                ss.stateArray[0][0] += 1;
                ss.boat = false;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }

            //one missionary and one cannibal get on boat
            ss = new StateMissionariesCannibals(tmpState);
            if (!ss.boat && ss.stateArray[0][0] > 0 && ss.stateArray[0][1] > 0) {
                ss.stateArray[0][0] -= 1;
                ss.stateArray[0][1] -= 1;
                ss.stateArray[1][0] += 1;
                ss.stateArray[1][1] += 1;
                ss.boat = true;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }else if (ss.boat && ss.stateArray[2][0] > 0 && ss.stateArray[2][1] > 0) {
                ss.stateArray[2][0] -= 1;
                ss.stateArray[2][1] -= 1;
                ss.stateArray[1][0] += 1;
                ss.stateArray[1][1] += 1;
                ss.boat = false;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }

            //two cannibals get on boat
            ss = new StateMissionariesCannibals(tmpState);
            if (!ss.boat && ss.stateArray[0][1] > 1) {
                ss.stateArray[0][1] -= 2;
                ss.stateArray[1][1] += 2;
                ss.boat = true;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }else if (ss.boat && ss.stateArray[2][1] > 1) {
                ss.stateArray[2][1] -= 2;
                ss.stateArray[1][1] += 2;
                ss.boat = false;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }

            //one cannibal get on boat
            ss = new StateMissionariesCannibals(tmpState);
            if (!ss.boat && ss.stateArray[0][1] > 0) {
                ss.stateArray[0][1] -= 1;
                ss.stateArray[1][1] += 1;
                ss.boat = true;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }else if (ss.boat && ss.stateArray[2][1] > 0) {
                ss.stateArray[2][1] -= 1;
                ss.stateArray[1][1] += 1;
                ss.boat = false;
                if (isStateAllow(ss)) {
                    set.add(ss);
                }
            }
            System.out.println(set.toString());
        }

        return set;
    }

    private boolean isStateAllow(StateMissionariesCannibals state){
        if((state.stateArray[0][0] != 0 && state.stateArray[0][1] > state.stateArray[0][0])
            || (state.stateArray[2][0] != 0 && state.stateArray[2][1] > state.stateArray[2][0])
        )
            return false;
        if((!state.boat
            && state.stateArray[0][0] + state.stateArray[1][0] != 0
            && state.stateArray[0][0] + state.stateArray[1][0] < state.stateArray[0][1] + state.stateArray[1][1])
            || (state.boat
                && state.stateArray[1][0] + state.stateArray[2][0] != 0
                && state.stateArray[1][0] + state.stateArray[2][0] < state.stateArray[2][1] + state.stateArray[1][1])
            || state.stateArray[1][0] + state.stateArray[1][1] > 2
        )
            return false;
        return true;
    }

    double step_cost(Object fromState, Object toState) { return 1; }

    public double h(Object state) {
        StateMissionariesCannibals s = (StateMissionariesCannibals) state;
        double sum = 0;
        for(int i = 0; i < 2; i++){
            sum += s.stateArray[i][0];
            sum += s.stateArray[i][1];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        ProblemMissionariesCannibals problem = new ProblemMissionariesCannibals();
        int[][] initArray = {{3, 3}, {0, 0}, {0, 0}};
        problem.initialState = new StateMissionariesCannibals(initArray);

        Search search  = new Search(problem);

        System.out.println("TreeSearch------------------------");
        //System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
        //System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
        //System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
        //System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
        //System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());

        System.out.println("\n\nGraphSearch----------------------");
        //System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
        //System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
        //System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
        //System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
        System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());

        System.out.println("\n\nIterativeDeepening----------------------");
        //System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
        //System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
    }

}
