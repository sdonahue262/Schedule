public class Schedule{
  private double wrongness;
  public Schedule(){
    wrongness = generate();
  }
  public double generate(){
    return 1; 
  }
  public double getWrongness(){
    return wrongness;
  }
}
