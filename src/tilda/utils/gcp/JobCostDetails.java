package tilda.utils.gcp;

public class JobCostDetails
  {
    protected JobCostDetails(long bytes, double cost, double costModeling)
      {
        _bytes = bytes;
        _cost = cost;
        _costModeling = costModeling;
      }

    public final long   _bytes;
    public final double _cost;
    public final double _costModeling;
  }
