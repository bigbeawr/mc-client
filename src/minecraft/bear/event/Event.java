package bear.event;

import java.util.ArrayList;

public class Event {

	public Event call() {
		
		final ArrayList<EventData> datalist = EventManager.get(this.getClass());
		if(datalist != null) {
			for(EventData data : datalist) {
				try {
					data.target.invoke(data.source, this);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return this;
	}
	
	
}
