# Schedule
this is the first iteration of my school scheduling project. I am beginning by attacking the problem from a Reinforcement learning (of the temporal difference learning flavor bc this pain is very unlikely to ever end) standpoint. The agent starts with a randomly cobbled together scheduling state (scheduling state meaning a schedule for every student). from this state the agent takes an action, gauges the value of this new state and so on and so forth. the way it gauges this value is by calculating every error or conflict in the state. 
