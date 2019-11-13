package State;

import CostFunction.AbstractCostFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class represents an abstract state
 */
abstract class AbstractState implements IState {

    protected Map<IState, Double> stateToCost;//Key - the state, Value - The cost of preforming an operator from this state to the state in the key

    /**
     * The constructor of the class
     */
    public AbstractState() {
        this.stateToCost = new HashMap<>();
    }

    @Override
    public Set<IState> expand() {
        return this.stateToCost.keySet();
    }

    /**
     * This function add the given state to be one of the neighbors of this state
     *
     * @param state - The given state
     */
    public void addNeigbor(IState state) {
        stateToCost.put(state, AbstractCostFunction.getInstance().getCost(this, state));
    }

}
