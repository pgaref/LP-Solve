package milp;

import lpsolve.LpSolve;
import lpsolve.LpSolveException;

/**
 * Created by pgaref on 7/20/16.
 */
public class GenericProblems {

    public GenericProblems(){}


    /**
     *  Objective Function
     *  min: x+y
     *
     *  Variable bounds
     *  a: 2x + y >=4;
     *  b: x + 2y >=4;
     *
     *  free x,y
     *  int x,y
     *
     */

    private LpSolve generateLP() throws LpSolveException{
        LpSolve problem = LpSolve.makeLp(0, 4);
        problem.strAddConstraint("3 2 2 1", LpSolve.LE, 4);
        problem.strAddConstraint("0 4 3 1", LpSolve.GE, 3);
        problem.strSetObjFn("2 3 -2 3");
        return problem;
    }

    /**
     * http://optlab-server.sce.carleton.ca/POAnimations2007/Graph.html
     * @param
     */

    private LpSolve generateLProblemOne() throws LpSolveException{
        LpSolve problem = LpSolve.makeLp(0, 2);
        problem.strAddConstraint("1 0", LpSolve.LE, 2);
        problem.strAddConstraint("0 1",LpSolve.LE, 3);
        problem.strAddConstraint("1 1", LpSolve.LE, 4);
        problem.strSetObjFn("15 10");
        problem.setMaxim();
        return problem;
    }

    public static void printSolutionArray(double [] array, String type){
        System.out.print("Solution "+ type) ;
        for(int i = 0 ; i < array.length; i++){
            System.out.print(" ["+i+"]="+ array[i]);
        }
        System.out.println();
    }




    public static void main(String[] args) {

        GenericProblems pt = new GenericProblems();

        try {
            LpSolve lps = pt.generateLProblemOne();
            lps.solve();
            printSolutionArray(lps.getPtrVariables(), "Variables");
            printSolutionArray(lps.getPtrConstraints(), "Constraints");

        }
        catch ( LpSolveException e){
            e.printStackTrace();
        }


    }

}
