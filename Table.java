public class Table{
  private int[] dimensions;
  private Cell[][] table;
  private double epsilon;
  private double epsilonDecayRate;
  //learning rate
  private double lr;
  //discount rate
  private double discountRate;
  //dimensions of the solution space
  //constructor assuming a rectangular table
  //ill make another one later that accounts for an irregular table
  public Table(int[] _dimensions){
    dimensions = _dimensions;
    int area = 1;
    for(int i = 0; i < dimensions.length; i++){
      area *= dimensions[i];
    }
    table = new Cell[area][2*dimensions.length];
    for(int state = 0; state < table.length; state++){
      for(int action = 0; action < table[state].length; action += 2){
        table[state][action] = new Cell(0, state-dimensions[action/2]);
        table[state][action+1] = new Cell(0, state+dimensions[action/2]);
      }
    }
    epsilon = 1;
    epsilonDecayRate = .1;
    lr = .01;
    discountRate = .99;
  }
  public void go(){
    int currState = 0;
    double rand = Math.random();
    if(rand > epsilon){
      //exploit
      int maxAction = maxAction(table[currState]);
      currState = table[currState][maxAction].getSPrime();
    }else{
      //explore
      int randAction = (int)(Math.random()*table[currState].length);
      double reward = table[currState][randAction].getSchedule().getWrongness();
      reward = 1 / reward;
      int sPrime = table[currState][randAction].getSPrime();

      //bellman equation
      double deltaQ = reward + (discountRate * maxAction(table[sPrime])) - table[currState][randAction].getValue();
      deltaQ *= lr;
      deltaQ += table[currState][randAction].getValue();
      table[currState][randAction].setValue(deltaQ);
      currState = sPrime;
    }
    epsilon -= epsilonDecayRate;
  }
  public int maxAction(Cell[] actions){
    int maxAction = 0;
    for(int action = 0; action < actions.length; action++){
      if(actions[action].getValue() > actions[maxAction].getValue()){
        maxAction = action;
      }
    }
    return maxAction;
  }
}
