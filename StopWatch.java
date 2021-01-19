package stateandbehavior;

public class StopWatch {
	
	int ticks;
	int time;
	int lapTime;
	int lastLapTime;
	boolean isStarted = false;
	boolean isStopped = false;
	
	boolean isStarted() {
		return isStarted;
	}
	boolean isStopped() {
		return isStopped;
	}
	int getTicks() {
		return ticks;
	}
	int getTime() {
		if(!isStarted) {
			return -1;
		}
		return time;
	}
	int getLapTime() {
		if(!isStarted) {
			return -1;
		}
		return lapTime;
	}
	int getLastLapTime() {
		if(lastLapTime == 0) {
			return -1;
		}
		return lastLapTime;
	}
	void tick(int ticks) {
		this.ticks += ticks;
		if(isStarted && !isStopped) {
			time+=ticks;
			lapTime+=ticks;
		}
	}
	void start() {
		time=0;
		lapTime = 0;
		lastLapTime = 0;
		isStarted = true;
		isStopped = false;
	}
	void lap() {
		lastLapTime = lapTime;
		lapTime = 0;
	}
	void stop() {
		isStopped = true;
		lastLapTime = lapTime;
		lapTime = 0;
	}
	public static String toString(StopWatch sw) {
		return "Ticks: "+sw.ticks+" Time: "+sw.time+", Lap Time: "+sw.lapTime+", Last Lap Time: "+sw.lastLapTime;
	}
	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		System.out.println(toString(sw));
		sw.start();
		sw.tick(5);
		sw.stop();
		System.out.println(toString(sw));
		sw.start();
		sw.tick(10);
		sw.lap();
		System.out.println(toString(sw));
		sw.tick(3);
		sw.lap();
		System.out.println(toString(sw));
		sw.tick(4);
		sw.stop();
		System.out.println(toString(sw));
	}
}
