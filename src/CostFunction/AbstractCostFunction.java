package CostFunction;

import State.IState;

/**
 * This class represents a cost function in a generic domain
 * This class will use the Singleton design pattern
 */
public abstract class AbstractCostFunction {

    private static AbstractCostFunction instance;//The singleton


    /**
     * The private constructor of the class
     */
    protected AbstractCostFunction(){
    }

    /**
     * This function will return the instance of the class
     * @return - The instance of the class
     */
    public static AbstractCostFunction getInstance()
    {
        if(instance == null)
            instance = CostFunctionFactory.getCostFunction(1);
        return instance;
    }

    /**
     * This function will return the cost of moving from the "from" state
     * to the "to" state (in a single operator).
     * If there is no operator that can get the agent from the "from" state to the  "to" state then the function will return infinity
     * @param from - The start state
     * @param to - The state the we want to get to
     * @return - The cost from getting from the "fom" state to the "to" state
     */
    public abstract double getCost(IState from, IState to);


    /**
     * This class will manage the creation of the costFunctions (Factory DP)
     */
    private static class CostFunctionFactory{
        /**
         * The constructor of the class
         */
        public CostFunctionFactory()
        {

        }

        /**
         * This function will return a new CostFunction depending on the given type
         * @param type - The given type
         * @return - a new CostFunction depending on the given type
         */
        public static AbstractCostFunction getCostFunction(int type)
        {
            return new GridCostFunction();
        }
    }
}
