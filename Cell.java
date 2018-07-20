public class Cell{
  //this value is the qtable score for this state,action
  private double value;
  //sPrime is the row in "table" which the agent will move to after action represented by the col
  private int sPrime;

  private Schedule sched;
  //from inside the cell i dont know the state and action so
  //value and sPrime need to be set from the outside
  //however i dont know if i want to do this in the constructor or later
  //so im going to cover all my bases
  public Cell(){
    value = 0;
    sPrime = -1;
    sched = new Schedule(); 
  }
  public Cell(double _value, int _sPrime){
    value = _value;
    sPrime = _sPrime;
    sched = new Schedule();
  }

  //i need to be able to interact with both variables from the outside
  //so commence getters and setters
  public double getValue(){
    return value;
  }
  public int getSPrime(){
    return sPrime;
  }
  public void setValue(double newValue){
    value = newValue;
  }
  public void setSPrime(int _sPrime){
    sPrime = _sPrime;
  }
  public Schedule getSchedule(){
    return sched;
  }
}
