import org.hibernate.event.PostDeleteEvent
import org.hibernate.event.PostDeleteEventListener
import org.hibernate.event.PostInsertEvent
import org.hibernate.event.PostInsertEventListener
import org.hibernate.event.PostUpdateEvent
import org.hibernate.event.PostUpdateEventListener

class DBChangeListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {
	
	public void onPostInsert(final PostInsertEvent event) {
		println 'Insert'
		println event
	}
	
	public void onPostUpdate(final PostUpdateEvent event) {
		println 'Update'
		println event
	}
	
	public void onPostDelete(final PostDeleteEvent event) {
		println 'Delete'
		println event
	}
}